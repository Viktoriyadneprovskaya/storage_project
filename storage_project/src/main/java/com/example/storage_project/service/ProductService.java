package com.example.storage_project.service;

import com.example.storage_project.Product;
import com.example.storage_project.command.ProductUpdateCommand;
import com.example.storage_project.dao.impl.ProductDao;
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
    public void saveProduct(Product product){
        productDao.saveProduct(product);
    }
    public void deleteProductById(Long id){
        productDao.deleteProductById(id);
    }
    public void updateProductById(Long id, ProductUpdateCommand command){
        productDao.updateProductById(id,command);
    }
}
