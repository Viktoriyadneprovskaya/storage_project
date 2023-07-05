package com.example.storage_project.dao.impl;


import com.example.storage_project.model.DocumentDetails;
import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.dao.DocDetailsDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DocDetailsDaoImpl implements DocDetailsDao {
    private final SessionFactory sessionFactory;

    public DocDetailsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<DocumentDetails> getAllDocDetailsByDocumentId(Long document_id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<DocumentDetails> query = session.createQuery("""
                select dd from DocumentDetails dd
                join fetch dd.product
                join fetch dd.unit
                where dd.document.documentId = :document_id
                """, DocumentDetails.class);
        List<DocumentDetails> documentDetails = query.getResultList();
        transaction.commit();
        session.close();
        return documentDetails;
    }


}
