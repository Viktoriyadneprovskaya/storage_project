//package com.example.storage_project.controller;
//
//import com.example.storage_project.Contractors;
//import com.example.storage_project.Product;
//import com.example.storage_project.command.ContractorCommand;
//import com.example.storage_project.command.ProductCommand;
//import com.example.storage_project.dao.ContractorsDaoImpl;
//import com.example.storage_project.dao.ProductDaoImpl;
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/products")
//public class ProductServlet extends HttpServlet {
//    private final ProductDaoImpl productDao;
//
//    public ProductServlet() {
//
//        this.productDao = new ProductDaoImpl();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Product> dbproducts = productDao.getAllProducts();
//        List<ProductCommand> productsCommand = ProductCommand.productsToCommand(dbproducts);
//
//        request.setAttribute("products", productsCommand);
//        request.getRequestDispatcher("products.jsp").forward(request,response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
