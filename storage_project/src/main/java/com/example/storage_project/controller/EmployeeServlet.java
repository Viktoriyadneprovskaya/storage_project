//package com.example.storage_project.controller;
//
//import com.example.storage_project.Employee;
//import com.example.storage_project.command.EmployeeCommand;
//import com.example.storage_project.dao.EmployeeDaoImpl;
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/employees")
//public class EmployeeServlet extends HttpServlet {
//    private final EmployeeDaoImpl employeeDao;
//
//    public EmployeeServlet(){
//        this.employeeDao = new EmployeeDaoImpl();
//    }
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Employee> dbemployees = employeeDao.getAllEmployees();
//        List<EmployeeCommand> employeesCommand = EmployeeCommand.employeesToCommand(dbemployees);
//
//        request.setAttribute("employees", employeesCommand);
//        request.getRequestDispatcher("employees.jsp").forward(request,response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
