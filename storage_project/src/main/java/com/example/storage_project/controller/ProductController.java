package com.example.storage_project.controller;

import com.example.storage_project.command.ProductCommand;
import com.example.storage_project.command.ProductUpdateCommand;
import com.example.storage_project.dao.MeasureUnitDao;
import com.example.storage_project.model.MeasureUnit;
import com.example.storage_project.model.Product;
import com.example.storage_project.service.MeasureUnitService;
import com.example.storage_project.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    private final MeasureUnitService measureUnitService;

    public ProductController(ProductService productService, MeasureUnitDao measureUnitDao, MeasureUnitService measureUnitService) {
        this.productService = productService;
        this.measureUnitService = measureUnitService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        List<MeasureUnit> measureUnits = measureUnitService.getAllMeasureUnits();
        model.addAttribute("products", products);
        model.addAttribute("measureUnits", measureUnits);
        return "products";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") ProductCommand productCommand) {
        MeasureUnit measureUnit = measureUnitService.getMeasureUnitById(productCommand.getMeasureUnit());
        Product product = productCommand.commandToProduct(productCommand, measureUnit);
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") ProductUpdateCommand command) {
        productService.updateProductById(command);
        return "redirect:/products";
    }
}
