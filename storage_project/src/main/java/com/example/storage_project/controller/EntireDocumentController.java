package com.example.storage_project.controller;

import com.example.storage_project.model.Document;
import com.example.storage_project.model.DocumentDetails;
import com.example.storage_project.service.DocDetailsService;
import com.example.storage_project.service.DocumentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/entire_document")
public class EntireDocumentController {
    private final DocumentsService documentsService;
    private final DocDetailsService docDetailsService;

    public EntireDocumentController(DocumentsService documentsService, DocDetailsService docDetailsService) {
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
        model.addAttribute("document",document);
        model.addAttribute("doc_details",documentDetails);
        model.addAttribute("sum",sum);
        return "/entire_document";
    }

}
