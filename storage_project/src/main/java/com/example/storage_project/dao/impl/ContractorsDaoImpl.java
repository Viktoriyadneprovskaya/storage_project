package com.example.storage_project.dao.impl;

import com.example.storage_project.model.*;
import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.dao.ContractorsDao;
import com.example.storage_project.service.AddressService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ContractorsDaoImpl implements ContractorsDao {
    private final SessionFactory sessionFactory;
    private final AddressService addressService;

    public ContractorsDaoImpl(SessionFactory sessionFactory, AddressService addressService) {
        this.sessionFactory = sessionFactory;
        this.addressService = addressService;
    }
    @Override
    public List<Contractors> getAllContractors(Long contrTypeId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Contractors> query = session.createNamedQuery("Contractors.findByContractorTypeId", Contractors.class);
        query.setParameter("contrTypeId", contrTypeId);
        List<Contractors> contractors = query.getResultList();
        transaction.commit();
        session.close();
        return contractors;
    }

    @Override
    public void saveContractor(Contractors contractor) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(contractor);
        transaction.commit();
        session.close();
    }
    @Override
    public void setContractorToAddress(Long id,Contractors contractor){
//        Address address = addressService.getAddressById(id);

    }

    @Override
    public void deleteContractorById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Contractors contractor = session.get(Contractors.class, id);
        session.remove(contractor);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateContractorById(Long id, ContractorUpdateCommand command) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Contractors contractor = session.get(Contractors.class, id);
        contractor.setCode(command.getCode());
        contractor.setContractorName(command.getContractorName());
        contractor.setContractNumber(command.getContractNumber());
        contractor.setContractorType(command.getContractorType());
        contractor.setPriceType(command.getPriceType());
        transaction.commit();
        session.close();
    }

    @Override
    public Contractors getContractorById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Contractors contractor = session.get(Contractors.class, id);
        transaction.commit();
        session.close();
        return contractor;
    }
}
