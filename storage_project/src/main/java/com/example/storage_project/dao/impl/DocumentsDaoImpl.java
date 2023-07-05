package com.example.storage_project.dao.impl;

import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.dao.DocumentsDao;
import com.example.storage_project.model.Contractors;
import com.example.storage_project.model.Document;
import com.example.storage_project.model.DocumentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentsDaoImpl implements DocumentsDao {
    private final SessionFactory sessionFactory;

    public DocumentsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Document> getAllDocuments(Long invoiceType) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Document> query = session.createNamedQuery("Document.findByInvoiceTypeId", Document.class);
        query.setParameter("invoice_type", invoiceType);
        List<Document> contractors = query.getResultList();
        transaction.commit();
        session.close();
        return contractors;
    }

    @Override
    public void saveDocument(Document document) {

    }

    @Override
    public void deleteDocumentById(Long id) {

    }

    @Override
    public Document getDocumentById(Long docId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Document document = session.get(Document.class, docId);
        transaction.commit();
        session.close();
        return document;
    }

}
