package com.example.storage_project.service;

import com.example.storage_project.command.reports.ProductSales;
import com.example.storage_project.command.reports.ProductsBalance;
import com.example.storage_project.dao.reports.ReportsDao;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportsService {
    private final ReportsDao reportsDao;

    public ReportsService(ReportsDao reportsDao) {
        this.reportsDao = reportsDao;
    }
    public List<ProductsBalance> getProductBalanceReport(){
        return reportsDao.getProductBalanceReport();
    }
    public List<ProductSales> getProductSalesByDate(LocalDate startDate, LocalDate endDate){
        return reportsDao.getProductSalesByDate(startDate, endDate);
    }
    public List<ProductSales> getSalesProductsByContractor(LocalDate startDate, LocalDate endDate, int contractorId) {
        return reportsDao.getSalesProductsByContractor(startDate,endDate,contractorId);
    }
}
