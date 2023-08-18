package com.example.storage_project.service;

import com.example.storage_project.dao.documents.InvoiceTypeDao;
import com.example.storage_project.model.document.InvoiceType;
import org.springframework.stereotype.Service;

@Service
public class InvoiceTypeService {
    private  final InvoiceTypeDao invoiceTypeDao;

    public InvoiceTypeService(InvoiceTypeDao invoiceTypeDao) {
        this.invoiceTypeDao = invoiceTypeDao;
    }

    public InvoiceType getInvoiceTypeById(Long id){
        return invoiceTypeDao.getInvoiceTypeById(id);
    }
}
