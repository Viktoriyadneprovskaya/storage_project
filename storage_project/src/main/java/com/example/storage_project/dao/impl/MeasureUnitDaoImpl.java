package com.example.storage_project.dao.impl;

import com.example.storage_project.dao.MeasureUnitDao;
import com.example.storage_project.model.MeasureUnit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MeasureUnitDaoImpl implements MeasureUnitDao {
    private final SessionFactory sessionFactory;

    public MeasureUnitDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public MeasureUnit getMeasureUnitById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        MeasureUnit measureUnit = session.get(MeasureUnit.class, id);
        transaction.commit();
        session.close();
        return measureUnit;
    }

    @Override
    public List<MeasureUnit> getAllMeasureUnits() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<MeasureUnit> query = session.createQuery("""
                select m from MeasureUnit m
                """, MeasureUnit.class);
        List<MeasureUnit> measureUnits = query.getResultList();
        transaction.commit();
        session.close();
        return measureUnits;
    }
}
