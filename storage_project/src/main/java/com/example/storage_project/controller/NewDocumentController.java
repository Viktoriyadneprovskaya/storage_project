package com.example.storage_project.controller;

import com.example.storage_project.model.*;
import com.example.storage_project.service.ContractorService;
import com.example.storage_project.service.MeasureUnitService;
import com.example.storage_project.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/new_document")
public class NewDocumentController {
    private final ContractorService contractorService;
    private final ProductService productService;
    private  final MeasureUnitService measureUnitService;

    public NewDocumentController(ContractorService contractorService, ProductService productService, MeasureUnitService measureUnitService) {
        this.contractorService = contractorService;
        this.productService = productService;
        this.measureUnitService = measureUnitService;
    }

    @GetMapping
    public String getNewDocumentPage(Model model, @RequestParam("invoice_type") Long invoiceType) {
        List<Contractors> contractors = contractorService.getAllContractors(invoiceType);
        MyOrganization myOrganization = contractorService.getMyOrganization();
        List<Product> products = productService.getAllProducts();
        List<MeasureUnit> measureUnits = measureUnitService.getAllMeasureUnits();
        model.addAttribute("contractors", contractors);
        model.addAttribute("myOrganization", myOrganization);
        model.addAttribute("products", products);
        model.addAttribute("measureUnits",measureUnits);
        return "new_document";
    }
}
