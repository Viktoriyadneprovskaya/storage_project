package com.example.storage_project.dao.impl;

import com.example.storage_project.model.*;
import com.example.storage_project.command.ContractorUpdateCommand;
import com.example.storage_project.dao.ContractorsDao;
import com.example.storage_project.service.AddressService;
import com.example.storage_project.service.ContractorTypeService;
import com.example.storage_project.service.PriceTypeService;
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
    private final ContractorTypeService contractorTypeService;
    private final PriceTypeService priceTypeService;

    public ContractorsDaoImpl(SessionFactory sessionFactory, AddressService addressService, ContractorTypeService contractorTypeService, PriceTypeService priceTypeService) {
        this.sessionFactory = sessionFactory;
        this.addressService = addressService;
        this.contractorTypeService = contractorTypeService;
        this.priceTypeService = priceTypeService;
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
    public void deleteContractorById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Contractors contractor = session.get(Contractors.class, id);
        session.remove(contractor);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateContractorById(ContractorUpdateCommand command) {
        ContractorType contractorType = contractorTypeService.getContractorTypeById(command.getContractorType());
        PriceType priceType = priceTypeService.getPriceTypeById(command.getPriceType());
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Contractors contractor = session.get(Contractors.class, command.getContractorId());
        contractor.setCode(command.getCode());
        contractor.setContractorName(command.getContractorName());
        contractor.setContractNumber(command.getContractNumber());
        contractor.setContractorType(contractorType);
        contractor.setPriceType(priceType);
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

    @Override
    public MyOrganization getMyOrganization() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        MyOrganization myOrganization = session.get(MyOrganization.class,1L);
        transaction.commit();
        session.close();
        return myOrganization;
    }
}
