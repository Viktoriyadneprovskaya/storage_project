package com.example.storage_project.dao.impl;

import com.example.storage_project.dao.PriceTypeDao;
import com.example.storage_project.model.PriceType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PriceTypeDaoImpl implements PriceTypeDao {
    private final SessionFactory sessionFactory;

    public PriceTypeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PriceType> getAllPriceTypes() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<PriceType> query = session.createQuery("""
                select pt from PriceType pt
                """, PriceType.class);
        List<PriceType> priceTypes =query.getResultList();
        transaction.commit();
        session.close();
        return priceTypes;
    }

    @Override
    public PriceType getPriceTypeById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        PriceType priceType = session.get(PriceType.class, id);
        transaction.commit();
        session.close();
        return priceType;
    }
}
