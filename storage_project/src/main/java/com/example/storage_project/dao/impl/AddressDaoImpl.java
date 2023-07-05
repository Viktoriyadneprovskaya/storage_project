package com.example.storage_project.dao.impl;

import com.example.storage_project.command.AddressUpdateCommand;
import com.example.storage_project.dao.AddressDao;
import com.example.storage_project.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AddressDaoImpl implements AddressDao {
    private final SessionFactory sessionFactory;

    public AddressDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveAddress(Address address) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(address);
        transaction.commit();
        session.close();
    }

    @Override
    public Address getAddressById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Address address = session.get(Address.class, id);
        transaction.commit();
        session.close();
        return address;
    }


    @Override
    public void deleteAddressById(Long id) {

    }

    @Override
    public void updateAddressById(Long id, AddressUpdateCommand command) {

    }

    @Override
    public List<Address> findAddressesByContractorId(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Address> query = session.createNamedQuery("Address.findAddressesByContractorId", Address.class);
        query.setParameter("id", id);
        List<Address> addresses = query.getResultList();
        transaction.commit();
        session.close();
        return addresses;
    }

    @Override
    public List<Country> getAllCountries() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Country> query = session.createQuery("""
                select c from Country c
                """, Country.class);
        List<Country> countries = query.getResultList();
        transaction.commit();
        session.close();
        return countries;
    }

    @Override
    public List<City> getAllCities() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<City> query = session.createQuery("""
                select c from City c
                """, City.class);
        List<City> cities = query.getResultList();
        transaction.commit();
        session.close();
        return cities;
    }

    @Override
    public Country getCountryById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Country> query = session.createQuery("""
               select c from Country c where c.id = :id""",Country.class);
        query.setParameter("id", id);
        Country country = query.uniqueResult();
        transaction.commit();
        session.close();
        return country;
    }

    @Override
    public City getCityById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<City> query = session.createQuery("""
               select c from City c where c.id = :id""",City.class);
        query.setParameter("id", id);
        City city = query.uniqueResult();
        transaction.commit();
        session.close();
        return city;
    }

}
