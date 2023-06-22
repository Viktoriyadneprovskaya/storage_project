package com.example.storage_project.dao;

import com.example.storage_project.Contractors;
import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.dao.impl.ContractorsDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ContractorsDaoImpl implements ContractorsDao {
    private final SessionFactory sessionFactory;

    public ContractorsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Contractors> getAllContractors(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Query<Contractors> query = session.createQuery("""
//                select c from Contractors c
//                join fetch c.contractorType
//                join fetch c.priceType
//                """, Contractors.class);

        Query<Contractors> query = session.createNamedQuery("Contractors.findByContractorTypeId", Contractors.class);
        query.setParameter("id", id);
        List<Contractors> contractors = query.getResultList();
        transaction.commit();
        session.close();
        return contractors;
    }

    @Override
    public void deleteContractorById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Contractors contractor = session.get(Contractors.class, id);//доработать валидацию на несуществующий id
        session.remove(contractor);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateContractorById(Long id, ContractorUpdateCommand command) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Contractors contractor = session.get(Contractors.class, id);//доработать валидацию на несуществующий id
        contractor.setContractorName(command.getContractorName());
        contractor.setContractNumber(command.getContractNumber());
        contractor.setContractorType(command.getContractorType());
        contractor.setPriceType(command.getPriceType());
        transaction.commit();
        session.close();
    }
}
