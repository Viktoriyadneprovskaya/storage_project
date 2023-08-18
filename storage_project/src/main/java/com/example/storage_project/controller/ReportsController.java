package com.example.storage_project.controller;

import com.example.storage_project.command.reports.ProductSales;
import com.example.storage_project.command.reports.ProductsBalance;
import com.example.storage_project.command.reports.ReportDatesCommand;
import com.example.storage_project.model.contractor.Contractors;
import com.example.storage_project.service.ContractorService;
import com.example.storage_project.service.ReportsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/reports")
public class ReportsController {

    private static final Long INVOICE_CONTRACTOR_TYPE = 2L;

    private final ReportsService reportsService;
    private final ContractorService contractorService;

    public ReportsController(ReportsService reportsService, ContractorService contractorService) {
        this.reportsService = reportsService;
        this.contractorService = contractorService;
    }

    @GetMapping("/product_balance")
    public String getProductsBalance(Model model) {
        LocalDate currentDate = LocalDate.now();
        List<ProductsBalance> productsBalanceList = reportsService.getProductBalanceReport();
        model.addAttribute("productBalanceList", productsBalanceList);
        model.addAttribute("dateNow",currentDate);
        return "reports/product_balance";
    }

    @GetMapping("/sales_by_product")
    public String getProductsSalesPage(Model model) {
        LocalDate currentDate = LocalDate.now();
        ReportDatesCommand reportDatesCommand = ReportDatesCommand.builder()
                .startDate(currentDate.withDayOfMonth(1))
                .endDate(currentDate.withDayOfMonth(currentDate.lengthOfMonth()))
                .build();
        model.addAttribute("reportDates", reportDatesCommand);
        return "reports/product_sales_report";
    }

    @PostMapping("/sales_by_product")
    public String getProductsSales(Model model, @ModelAttribute("reportDates") ReportDatesCommand reportDatesCommand) {
        List<ProductSales> productsSales = reportsService.getProductSalesByDate(reportDatesCommand.getStartDate(), reportDatesCommand.getEndDate());
        model.addAttribute("productSales", productsSales);
        return "reports/product_sales_report";
    }

    @GetMapping("/product_sales_by_contractor")
    public String getProductSalesByContractorPage(Model model) {
        LocalDate currentDate = LocalDate.now();
        ReportDatesCommand reportDatesCommand = ReportDatesCommand.builder()
                .startDate(currentDate.withDayOfMonth(1))
                .endDate(currentDate.withDayOfMonth(currentDate.lengthOfMonth()))
                .build();
        List<Contractors> contractors = contractorService.getAllContractors(INVOICE_CONTRACTOR_TYPE);
        model.addAttribute("contractors", contractors);
        model.addAttribute("reportDates", reportDatesCommand);
        return "reports/product_sales_by_contractor_report";
    }

    @PostMapping("product_sales_by_contractor")
    public String getProductSalesByContractor(Model model, @ModelAttribute("contractors") int contractorID,@ModelAttribute("reportDates") ReportDatesCommand reportDatesCommand) {
        Contractors contractor = contractorService.getContractorById(Long.valueOf(contractorID));
        List<ProductSales> productSales = reportsService.getSalesProductsByContractor(reportDatesCommand.getStartDate(),reportDatesCommand.getEndDate(),contractorID);
        List<Contractors> contractors = contractorService.getAllContractors(INVOICE_CONTRACTOR_TYPE);
        Long contractorId = contractor.getContractorId();
        model.addAttribute("contractors", contractors);
        model.addAttribute("productSales", productSales);
        model.addAttribute("contractor",contractor);
        model.addAttribute("contractor_id",contractorId);
        return "reports/product_sales_by_contractor_report";
    }
}
