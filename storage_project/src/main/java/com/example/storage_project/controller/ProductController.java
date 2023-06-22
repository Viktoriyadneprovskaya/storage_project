package com.example.storage_project.controller;

import com.example.storage_project.Product;
import com.example.storage_project.command.ProductUpdateCommand;
import com.example.storage_project.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("user") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") Long id) {
       productService.deleteProductById(id);
        return "redirect:/products";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("product") Product product) {
        ProductUpdateCommand command = ProductUpdateCommand.builder()
                .name(product.getName())
                .measureUnit(product.getMeasureUnit())
                .shelfLife(product.getShelfLife())
                .basicPrice(product.getBasicPrice())
                .build();
       productService.updateProductById(product.getProductId(), command);
        return "redirect:/products";
    }
}
