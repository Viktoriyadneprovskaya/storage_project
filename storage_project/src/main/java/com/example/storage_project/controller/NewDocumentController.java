package com.example.storage_project.controller;

import com.example.storage_project.command.document.DocDetailsModel;
import com.example.storage_project.command.document.DocDetailsRow;
import com.example.storage_project.command.document.DocumentCommand;
import com.example.storage_project.command.document.DocumentModel;
import com.example.storage_project.model.*;
import com.example.storage_project.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/new_document")
public class NewDocumentController {
    private final ContractorService contractorService;
    private final ProductService productService;
    private final MeasureUnitService measureUnitService;
    private final InvoiceTypeService invoiceTypeService;
    private final DocDetailsService docDetailsService;
    private final DocumentsService documentsService;

    public NewDocumentController(ContractorService contractorService, ProductService productService, MeasureUnitService measureUnitService, PriceTypeService priceTypeService, InvoiceTypeService invoiceTypeService, DocDetailsService docDetailsService, DocumentsService documentsService) {
        this.contractorService = contractorService;
        this.productService = productService;
        this.measureUnitService = measureUnitService;
        this.invoiceTypeService = invoiceTypeService;
        this.docDetailsService = docDetailsService;
        this.documentsService = documentsService;
    }

    @GetMapping
    public String getNewDocumentPage(Model model, @RequestParam("invoice_type") Long invoiceType) {
        List<Contractors> contractors = contractorService.getAllContractors(invoiceType);
        MyOrganization myOrganization = contractorService.getMyOrganization();
        List<Product> products = productService.getAllProducts();
        List<MeasureUnit> measureUnits = measureUnitService.getAllMeasureUnits();
        DocDetailsRow docDetailsRow = DocDetailsRow.builder()
                .products(products)
                .measureUnits(measureUnits)
                .build();
        List<DocDetailsRow> docDetailsRows = List.of(docDetailsRow);
        DocumentCommand documentCommand = DocumentCommand.builder()
                .contractors(contractors)
                .myOrganization(myOrganization)
                .docDetailsRows(docDetailsRows)
                .build();
        model.addAttribute("documentCommand", documentCommand);
        return "new_document";
    }

    @PostMapping("/save")
    public String saveDocument(@ModelAttribute("documentCommand") DocumentModel documentModel, @RequestParam Long invoice_type) {
        Contractors contractor = contractorService.getContractorById(documentModel.getContractor());
        LocalDate date = LocalDate.now();
        MyOrganization myOrganization = contractorService.getMyOrganization();
        InvoiceType invoiceType = invoiceTypeService.getInvoiceTypeById(invoice_type);

        Document document = Document.builder()
                .creationDate(date)
                .contractor(contractor)
                .priceType(contractor.getPriceType())
                .myOrganization(myOrganization)
                .invoiceType(invoiceType)
                .build();
        documentsService.saveDocument(document);
        Document savedDocument = documentsService.getDocumentById(document.getDocumentId());

        List<DocumentDetails> documentsDetails = new ArrayList<>();
        List<DocDetailsModel> docDetailsModels = documentModel.getDocDetailsRows();
        for (DocDetailsModel docDetailsModel : docDetailsModels) {

            Product product = productService.getProductById(docDetailsModel.getProducts());
            double price = product.getBasicPrice() - (product.getBasicPrice() * contractor.getPriceType().getChargePercent() / 100);
            double sum = price * docDetailsModel.getQuantities();
            MeasureUnit measureUnit = measureUnitService.getMeasureUnitById(docDetailsModel.getMeasureUnits());
            DocumentDetails documentDetails = DocumentDetails.builder()
                    .product(product)
                    .unit(measureUnit)
                    .quantity(docDetailsModel.getQuantities())
                    .price(price)
                    .sum(sum)
                    .document(savedDocument)
                    .build();
            documentsDetails.add(documentDetails);
        }
        for (DocumentDetails documentDetails : documentsDetails) {
            docDetailsService.saveDocumentDetails(documentDetails);
        }
        return "redirect:/entire_document/"+document.getDocumentId();
    }

}
