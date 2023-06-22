package com.example.storage_project.dao.impl;

import com.example.storage_project.Contractors;
import com.example.storage_project.Product;
import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.command.ProductUpdateCommand;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();
    void saveProduct(Product product);
    void deleteProductById(Long id);
    void updateProductById(Long id, ProductUpdateCommand command);
}
