package com.example.storage_project.dao.impl;


import com.example.storage_project.command.document.DocDetailsUpdateModel;
import com.example.storage_project.model.contractor.Contractors;
import com.example.storage_project.model.document.DocumentDetails;
import com.example.storage_project.dao.DocDetailsDao;
import com.example.storage_project.model.product.Product;
import com.example.storage_project.service.MeasureUnitService;
import com.example.storage_project.service.ProductService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DocDetailsDaoImpl implements DocDetailsDao {
    private final SessionFactory sessionFactory;
    private final ProductService productService;
    private final MeasureUnitService measureUnitService;

    public DocDetailsDaoImpl(SessionFactory sessionFactory, ProductService productService, MeasureUnitService measureUnitService) {
        this.sessionFactory = sessionFactory;
        this.productService = productService;
        this.measureUnitService = measureUnitService;
    }
    @Override
    public List<DocumentDetails> getAllDocDetailsByDocumentId(Long document_id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<DocumentDetails> query = session.createQuery("""
                select dd from DocumentDetails dd
                join fetch dd.product
                join fetch dd.unit
                where dd.document.documentId = :document_id
                """, DocumentDetails.class);
        query.setParameter("document_id",document_id);
        List<DocumentDetails> documentDetails = query.getResultList();
        transaction.commit();
        session.close();
        return documentDetails;
    }

    @Override
    public void saveDocumentDetails(DocumentDetails documentDetails) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(documentDetails);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteDocDetailsById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        DocumentDetails documentDetails = session.get(DocumentDetails.class, id);
        session.remove(documentDetails);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateDocDetailsById(DocDetailsUpdateModel docDetailsUpdateModel, Contractors contractor, Long invoiceType) {
        Product product = productService.getProductById(docDetailsUpdateModel.getProducts());
        double price;
        if(invoiceType == 1) {
            price = product.getBasicPrice() - (product.getBasicPrice() * contractor.getPriceType().getChargePercent() / 100);
        }else {
            price = docDetailsUpdateModel.getPrice();
        }
        double sum = price * docDetailsUpdateModel.getQuantities();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        DocumentDetails documentDetails = session.get(DocumentDetails.class, docDetailsUpdateModel.getId());
        documentDetails.setProduct(product);
        documentDetails.setUnit(measureUnitService.getMeasureUnitById(docDetailsUpdateModel.getMeasureUnits()));
        documentDetails.setQuantity(docDetailsUpdateModel.getQuantities());
        documentDetails.setPrice(price);
        documentDetails.setSum(sum);
        transaction.commit();
        session.close();
    }

}
