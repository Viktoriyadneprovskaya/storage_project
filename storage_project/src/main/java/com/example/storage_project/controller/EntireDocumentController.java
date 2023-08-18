package com.example.storage_project.controller;

import com.example.storage_project.command.document.DocDetailsUpdateModel;
import com.example.storage_project.command.document.DocumentUpdateCommand;
import com.example.storage_project.command.document.DocumentUpdateModel;
import com.example.storage_project.model.contractor.Contractors;
import com.example.storage_project.model.document.Document;
import com.example.storage_project.model.document.DocumentDetails;
import com.example.storage_project.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/entire_document")
public class EntireDocumentController {
    private final DocumentsService documentsService;
    private final DocDetailsService docDetailsService;

    public EntireDocumentController(DocumentsService documentsService, DocDetailsService docDetailsService, ContractorService contractorService, ProductService productService, MeasureUnitService measureUnitService, InvoiceTypeService invoiceTypeService) {
        this.documentsService = documentsService;
        this.docDetailsService = docDetailsService;
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
        return "documents/entire_document";
    }

    @GetMapping("/update")
    public String getDocumentForUpdate(Model model, @RequestParam("document_id") Long document_id) {
        Document document = documentsService.getDocumentById(document_id);
        DocumentUpdateCommand documentUpdateCommand = documentsService.documentToDocumentUpdateCommand(document_id);
        model.addAttribute("document", documentUpdateCommand);
        if (document.getInvoiceType().getInvoiceTypeId() == 2) {
            return "documents/update_input_document";
        } else {
            return "documents/update_document";
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
