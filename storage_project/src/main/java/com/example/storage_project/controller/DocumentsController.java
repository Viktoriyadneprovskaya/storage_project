package com.example.storage_project.controller;

import com.example.storage_project.command.document.DocDetailsModel;
import com.example.storage_project.command.document.DocDetailsRow;
import com.example.storage_project.command.document.DocumentCommand;
import com.example.storage_project.command.document.DocumentModel;
import com.example.storage_project.model.MyOrganization;
import com.example.storage_project.model.contractor.Contractors;
import com.example.storage_project.model.document.Document;
import com.example.storage_project.model.document.DocumentDetails;
import com.example.storage_project.model.document.InvoiceType;
import com.example.storage_project.model.product.MeasureUnit;
import com.example.storage_project.model.product.Product;
import com.example.storage_project.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/documents")
public class DocumentsController {
    private final DocumentsService documentsService;

    public DocumentsController(DocumentsService documentsService, DocDetailsService docDetailsService, ContractorService contractorService, ProductService productService, MeasureUnitService measureUnitService, InvoiceTypeService invoiceTypeService, DocDetailsService docDetailsService1) {
        this.documentsService = documentsService;
    }

    @GetMapping
    public String getAllDocuments(Model model, @RequestParam("invoice_type") Long invoiceType) {
        List<Document> documents = documentsService.getAllDocuments(invoiceType);
        model.addAttribute("documents", documents);
        return "documents";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") Long id) {
        Long invoiceType = documentsService.getDocumentById(id).getInvoiceType().getInvoiceTypeId();
        documentsService.deleteDocumentById(id);
        return "redirect:/documents?invoice_type=" + invoiceType;
    }
    @GetMapping("/new_document")
    public String getNewDocumentPage(Model model, @RequestParam("invoice_type") Long invoiceType) {
        DocumentCommand documentCommand = documentsService.loadNewDocument(invoiceType);
        model.addAttribute("documentCommand", documentCommand);
       if(invoiceType == 2){
           return "new_document";
       }else {
           return "new_input_document";
       }
    }
    @PostMapping("/new_document/save")
    public String saveDocument(@ModelAttribute("documentCommand") DocumentModel documentModel, @RequestParam Long invoice_type) {
        Document document = documentsService.savaNewSalesDocument(invoice_type,documentModel);
        return "redirect:/entire_document/" + document.getDocumentId();
    }
    @PostMapping("/new_input_document/save")
    public String saveInputDocument(@ModelAttribute("documentCommand") DocumentModel documentModel, @RequestParam Long invoice_type) {
        Document document = documentsService.savaNewInputDocument(invoice_type,documentModel);
        return "redirect:/entire_document/"+document.getDocumentId();
    }

}
