//package com.example.storage_project.controller;
//
//import com.example.storage_project.DocumentDetails;
//import com.example.storage_project.command.DocDetailsCommand;
//import com.example.storage_project.dao.DocDetailsDaoImpl;
//import com.example.storage_project.dao.impl.DocDetailsDao;
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/outDocServlet")
//public class OutDocServlet extends HttpServlet {
//
//    private final DocDetailsDao docDetailsDao;
//
//    public OutDocServlet() {
//        this.docDetailsDao = new DocDetailsDaoImpl();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<DocumentDetails> dbDocumentDetails = docDetailsDao.getAllDocDetails();//id
//        List<DocDetailsCommand> docDetailsCommands = DocDetailsCommand.DocDetailsToCommand(dbDocumentDetails);
//        request.setAttribute("doc_details", docDetailsCommands);
//        request.getRequestDispatcher("output_document.jsp").forward(request,response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
