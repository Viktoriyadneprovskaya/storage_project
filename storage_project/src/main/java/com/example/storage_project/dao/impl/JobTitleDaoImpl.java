package com.example.storage_project.dao.impl;

import com.example.storage_project.dao.JobTitleDao;
import com.example.storage_project.model.JobTitle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class JobTitleDaoImpl implements JobTitleDao {
    private final SessionFactory sessionFactory;

    public JobTitleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<JobTitle> getAllJobTitles() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<JobTitle> query = session.createQuery("""
                select jt from JobTitle jt
                """,JobTitle.class);
        List<JobTitle> jobTitles = query.getResultList();
        transaction.commit();
        session.close();
        return jobTitles;
    }

    @Override
    public JobTitle getJobTitleById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        JobTitle jobTitle = session.get(JobTitle.class, id);
        transaction.commit();
        session.close();
        return jobTitle;
    }
}
