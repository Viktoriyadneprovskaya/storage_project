package com.example.storage_project.dao.impl;

import com.example.storage_project.dao.InvoiceTypeDao;
import com.example.storage_project.model.Employee;
import com.example.storage_project.model.InvoiceType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class InvoiceTypeDaoImpl implements InvoiceTypeDao {
    private final SessionFactory sessionFactory;

    public InvoiceTypeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public InvoiceType getInvoiceTypeById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        InvoiceType invoiceType = session.get(InvoiceType.class, id);
        transaction.commit();
        session.close();
        return invoiceType;
    }
}
