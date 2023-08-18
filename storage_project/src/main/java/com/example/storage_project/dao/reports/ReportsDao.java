package com.example.storage_project.dao.reports;

import com.example.storage_project.command.reports.ProductSales;
import com.example.storage_project.command.reports.ProductsBalance;
import java.time.LocalDate;
import java.util.List;

public interface ReportsDao {
    List<ProductsBalance> getProductBalanceReport();
    List<ProductSales> getProductSalesByDate(LocalDate startDate, LocalDate endDate);
    List<ProductSales> getSalesProductsByContractor(LocalDate startDate, LocalDate endDate, int contractorId);
}
