//package com.example.storage_project.controller;
//
//import java.io.*;
//import java.time.LocalDate;
//import java.util.List;
//
//import com.example.storage_project.Contractors;
//import com.example.storage_project.command.ContractorCommand;
//import com.example.storage_project.dao.ContractorsDaoImpl;
//import javax.servlet.ServletException;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//
//
//import static java.lang.Long.parseLong;
//
//@WebServlet("/contractors")
//public class ContractorServlet extends HttpServlet {
//    private final ContractorsDaoImpl contractorDao;
//
//    public ContractorServlet() {
//
//        this.contractorDao = new ContractorsDaoImpl();
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {//Long id
//        String id = request.getParameter("id");
//        Long idLong = parseLong(id);
//        List<Contractors> dbcontractors = contractorDao.getAllContractors(idLong);//id
//        List<ContractorCommand> contractorsCommand = ContractorCommand.contractorsToCommand(dbcontractors);
//
//        request.setAttribute("contractors", contractorsCommand);
//        request.getRequestDispatcher("contractors.jsp").forward(request, response);
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
////        String username=request.getParameter("username");
////        String password =request.getParameter("password");
////        String firstName = request.getParameter("firstname");
////        String lastName = request.getParameter("lastname");
////        String email = request.getParameter("email");
////        String address = request.getParameter("address");
////        String phoneNumber = request.getParameter("phonenumber");
////        LocalDate birthDate = LocalDate.ofEpochDay(request.getDateHeader("date"));
////        User user = User.builder()
////                .username(username)
////                .password(password)
////                .firstName(firstName)
////                .lastName(lastName)
////                .email(email)
////                .address(address)
////                .phoneNumber(phoneNumber)
////                .date(birthDate)
////                .build();
////
////        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
////        Session session = sessionFactory.openSession();
////        Transaction transaction = session.beginTransaction();
////        session.save(user);
////        transaction.commit();
////        session.close();
////        response.sendRedirect("users");
//    }
//
//
//}