package com.example.storage_project.dao;

import com.example.storage_project.command.reports.ProductSales;
import com.example.storage_project.command.reports.ProductsBalance;
import org.springframework.security.access.method.P;

import java.time.LocalDate;
import java.util.List;

public interface ReportsDao {
    List<ProductsBalance> getProductBalanceReport();
    List<ProductSales> getProductSalesByDate(LocalDate startDate, LocalDate endDate);
    List<ProductSales> getSalesProductsByContractor(LocalDate startDate, LocalDate endDate, int contractorId);
}
