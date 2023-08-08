package com.example.storage_project.dao.impl;

import com.example.storage_project.command.reports.ProductSales;
import com.example.storage_project.dao.ReportsDao;
import com.example.storage_project.command.reports.ProductsBalance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReportsDaoDaoImpl implements ReportsDao {
    private final SessionFactory sessionFactory;
    private final EntityManagerFactory entityManagerFactory;

    public ReportsDaoDaoImpl(SessionFactory sessionFactory, EntityManagerFactory entityManagerFactory) {
        this.sessionFactory = sessionFactory;
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<ProductsBalance> getProductBalanceReport() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StoredProcedureQuery storedProcedure = session.createStoredProcedureQuery("getProductQuantities");
        List<Object[]> resultList = storedProcedure.getResultList();

        List<ProductsBalance> productQuantities = resultList.stream()
                .map(result -> new ProductsBalance((String)result[0], (Double) result[1])
//                    String product = (String) result[0];
//                    double quantity = (Double) result[1];
//                    ProductsBalance productQuantity = new ProductsBalance();
//                    productQuantity.setProduct(product);
//                    productQuantity.setQuantity(quantity);
//                    return productQuantity;
                )
                .collect(Collectors.toList());
        transaction.commit();
        session.close();
        return productQuantities;
    }



    @Override
    public List<ProductSales> getProductSalesByDate(LocalDate startDate, LocalDate endDate) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StoredProcedureQuery storedProcedure = session.createStoredProcedureQuery("getProductSalesByDate");
        storedProcedure.registerStoredProcedureParameter("start_date", LocalDate.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("end_date", LocalDate.class, ParameterMode.IN);

        storedProcedure.setParameter("start_date", startDate);
        storedProcedure.setParameter("end_date", endDate);
        List<Object[]> resultList = storedProcedure.getResultList();
        List<ProductSales> productSales = resultList.stream()
                .map(result -> new ProductSales((String)result[0], (Double) result[1], (Double) result[2]))
                .collect(Collectors.toList());
        transaction.commit();
        session.close();
        return productSales;
    }

    @Override
    public List<ProductSales> getSalesProductsByContractor(LocalDate startDate, LocalDate endDate, int contractorId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        StoredProcedureQuery storedProcedure = session.createStoredProcedureQuery("getProductSalesByDateByContractor");
        storedProcedure.registerStoredProcedureParameter("start_date", LocalDate.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("end_date", LocalDate.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("contractor_id", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("start_date", startDate);
        storedProcedure.setParameter("end_date", endDate);
        storedProcedure.setParameter("contractor_id", contractorId);
        List<Object[]> resultList = storedProcedure.getResultList();
        List<ProductSales> productSales = resultList.stream()
                .map(result -> new ProductSales((String)result[0], (Double) result[1], (Double) result[2]))
                .collect(Collectors.toList());
        transaction.commit();
        session.close();
        return productSales;
    }
}
