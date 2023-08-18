package com.example.storage_project.service;

import com.example.storage_project.model.product.Product;
import com.example.storage_project.command.product.ProductUpdateCommand;
import com.example.storage_project.dao.products.ProductDao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }
    public List<Product> getAllProducts(){
        List<Product> products = productDao.getAllProducts();
        return products;
    }
    public Product getProductById(Long id){
        return productDao.getProductById(id);
    }

    public void saveProduct(Product product){
        productDao.saveProduct(product);
    }
    public void deleteProductById(Long id){
        productDao.deleteProductById(id);
    }
    public void updateProductById(ProductUpdateCommand command){
        productDao.updateProductById(command);
    }
}
