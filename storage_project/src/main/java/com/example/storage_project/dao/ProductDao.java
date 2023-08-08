package com.example.storage_project.dao;

import com.example.storage_project.model.product.Product;
import com.example.storage_project.command.product.ProductUpdateCommand;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void saveProduct(Product product);
    void deleteProductById(Long id);
    void updateProductById(ProductUpdateCommand command);
}
