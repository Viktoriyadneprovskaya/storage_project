package com.example.storage_project.controller;

import com.example.storage_project.command.document.DocDetailsSelected;
import com.example.storage_project.command.document.DocDetailsUpdateModel;
import com.example.storage_project.command.document.DocumentUpdateCommand;
import com.example.storage_project.command.document.DocumentUpdateModel;
import com.example.storage_project.model.contractor.Contractors;
import com.example.storage_project.model.document.Document;
import com.example.storage_project.model.document.DocumentDetails;
import com.example.storage_project.model.product.MeasureUnit;
import com.example.storage_project.model.product.Product;
import com.example.storage_project.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/entire_document")
public class EntireDocumentController {
    private final DocumentsService documentsService;
    private final DocDetailsService docDetailsService;
    private final ContractorService contractorService;
    private final ProductService productService;
    private final MeasureUnitService measureUnitService;
    private final InvoiceTypeService invoiceTypeService;

    public EntireDocumentController(DocumentsService documentsService, DocDetailsService docDetailsService, ContractorService contractorService, ProductService productService, MeasureUnitService measureUnitService, InvoiceTypeService invoiceTypeService) {
        this.documentsService = documentsService;
        this.docDetailsService = docDetailsService;
        this.contractorService = contractorService;
        this.productService = productService;
        this.measureUnitService = measureUnitService;
        this.invoiceTypeService = invoiceTypeService;
    }

    @GetMapping("/{document_id}")
    public String getAllDocDetailsByDocumentId(Model model, @PathVariable Long document_id) {
        Document document = documentsService.getDocumentById(document_id);
        List<DocumentDetails> documentDetails = docDetailsService.getAllDocDetailsByDocumentId(document_id);
        double sum = documentDetails.stream()
                .mapToDouble(DocumentDetails::getSum)
                .sum();
        model.addAttribute("document", document);
        model.addAttribute("doc_details", documentDetails);
        model.addAttribute("sum", sum);
        return "/entire_document";
    }

    @GetMapping("/update")
    public String getDocumentForUpdate(Model model, @RequestParam("document_id") Long document_id) {
        Document document = documentsService.getDocumentById(document_id);
        List<DocumentDetails> documentDetails = docDetailsService.getAllDocDetailsByDocumentId(document_id);
        List<Product> products = productService.getAllProducts();
        List<MeasureUnit> measureUnits = measureUnitService.getAllMeasureUnits();
        List<DocDetailsSelected> docDetailsSelectedList = new ArrayList<>();
        for (DocumentDetails documentDetails1 : documentDetails) {
            DocDetailsSelected docDetailsSelected = new DocDetailsSelected();
            docDetailsSelected.setId(documentDetails1.getId());
            docDetailsSelected.setSelectedMeasureUnit(documentDetails1.getUnit());
            docDetailsSelected.setSelectedProduct(documentDetails1.getProduct());
            docDetailsSelected.setSelectedQuantity(documentDetails1.getQuantity());
            docDetailsSelected.setPrice(documentDetails1.getPrice());
            docDetailsSelectedList.add(docDetailsSelected);
        }
        DocumentUpdateCommand documentUpdateCommand = DocumentUpdateCommand.builder()
                .id(document.getDocumentId())
                .contractor(document.getContractor())
                .myOrganization(contractorService.getMyOrganization())
                .docDetailsSelected(docDetailsSelectedList)
                .products(products)
                .measureUnits(measureUnits)
                .creationDate(document.getCreationDate())
                .invoiceType(document.getInvoiceType())
                .documentId(document.getDocumentId())
                .build();
        model.addAttribute("document", documentUpdateCommand);
        if (document.getInvoiceType().getInvoiceTypeId() == 2) {
            return "/update_input_document";
        } else {
            return "/update_document";
        }
    }

    @PostMapping("/update")
    public String updateDocumentByDocumentId(@ModelAttribute("document") DocumentUpdateModel documentUpdateModel, @RequestParam("document_id") Long document_id) {
        Document document = documentsService.getDocumentById(document_id);
        Long invoiceType = document.getInvoiceType().getInvoiceTypeId();
        Contractors contractor = document.getContractor();
        List<DocDetailsUpdateModel> docDetailsModels = documentUpdateModel.getDocDetailsSelected();
        for (DocDetailsUpdateModel docDetailsUpdateModel : docDetailsModels) {
            docDetailsService.updateDocDetailsById(docDetailsUpdateModel, contractor, invoiceType);
        }
        return "redirect:/entire_document/" + document_id;
    }

    @GetMapping("/delete")
    public String deleteDocumentRow(@RequestParam("id") Long id, @RequestParam("document_id") Long documentId) {
        docDetailsService.deleteDocDetailsById(id);
        return "redirect:/entire_document/update?document_id=" + documentId;
    }
}
