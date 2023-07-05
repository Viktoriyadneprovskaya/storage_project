package com.example.storage_project.dao.impl;

import com.example.storage_project.dao.MeasureUnitDao;
import com.example.storage_project.model.MeasureUnit;
import com.example.storage_project.model.Product;
import com.example.storage_project.command.ProductUpdateCommand;
import com.example.storage_project.dao.ProductDao;
import com.example.storage_project.service.MeasureUnitService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDao {
    private final SessionFactory sessionFactory;
    private final MeasureUnitService measureUnitService;

    public ProductDaoImpl(SessionFactory sessionFactory, MeasureUnitDao measureUnitDao, MeasureUnitService measureUnitService) {
        this.sessionFactory = sessionFactory;
        this.measureUnitService = measureUnitService;
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Product> query = session.createQuery("""
                select p from Product p
                join fetch p.measureUnit
                """, Product.class);
        List<Product> products =query.getResultList();
        transaction.commit();
        session.close();
        return products;
    }

    @Override
    public void saveProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteProductById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, id);//доработать валидацию на несуществующий id
        session.remove(product);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateProductById(ProductUpdateCommand command) {
        MeasureUnit measureUnit = measureUnitService.getMeasureUnitById(command.getMeasureUnit());
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, command.getProductId());
        product.setName(command.getName());
        product.setMeasureUnit(measureUnit);
        product.setShelfLife(command.getShelfLife());
        product.setBasicPrice(command.getBasicPrice());
        transaction.commit();
        session.close();
    }
}
