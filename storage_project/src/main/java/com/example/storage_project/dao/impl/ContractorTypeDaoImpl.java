package com.example.storage_project.dao.impl;

import com.example.storage_project.dao.ContractorTypeDao;
import com.example.storage_project.model.ContractorType;
import com.example.storage_project.model.MeasureUnit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ContractorTypeDaoImpl implements ContractorTypeDao {
    private final SessionFactory sessionFactory;

    public ContractorTypeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ContractorType> getAllContractorTypes() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<ContractorType> query = session.createQuery("""
                select ct from ContractorType ct
                """, ContractorType.class);
        List<ContractorType> contractorTypes =query.getResultList();
        transaction.commit();
        session.close();
        return contractorTypes;
    }

    @Override
    public ContractorType getContractorTypeById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        ContractorType contractorType = session.get(ContractorType.class, id);
        transaction.commit();
        session.close();
        return contractorType;
    }

}
