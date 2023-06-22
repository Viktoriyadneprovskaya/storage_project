package com.example.storage_project.dao;


import com.example.storage_project.DocumentDetails;
import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.dao.impl.DocDetailsDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DocDetailsDaoImpl implements DocDetailsDao {
    private final SessionFactory sessionFactory;

    public DocDetailsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<DocumentDetails> getAllDocDetails() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<DocumentDetails> query = session.createQuery("""
                select dd from DocumentDetails dd
                join fetch dd.product
                join fetch dd.unit
                join fetch dd.document
                """, DocumentDetails.class);

        List<DocumentDetails> documentDetails = query.getResultList();
        transaction.commit();
        session.close();
        return documentDetails;
    }

    @Override
    public void deleteDocDetailsById(Long id) {

    }

    @Override
    public void updateDocDetailsById(Long id, ContractorUpdateCommand command) {

    }
}
