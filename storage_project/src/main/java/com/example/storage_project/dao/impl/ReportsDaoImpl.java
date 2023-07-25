package com.example.storage_project.dao.impl;

import com.example.storage_project.dao.Reports;
import com.example.storage_project.command.ProductsBalance;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ReportsDaoImpl implements Reports {
    private final SessionFactory sessionFactory;

    public ReportsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ProductsBalance getReport() {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        String sqlQuery = "select rez.product, sum(rez.qnt) from (SELECT pr.name as product" +
//                       ",case"+
//                "when invoice_type = 1 then  -dd.quantity"+
//        "when invoice_type = 2 then  dd.quantity"+
//        "when invoice_type = 3 then  -dd.quantity"+
//        "end as qnt"+
//        "FROM storagedb.document doc"+
//        "left join storagedb.document_details dd on dd.doc_id = doc.id_document"+
//        "left join storagedb.product pr on pr.id_product = dd.product_id) as rez"+
//        "GROUP BY rez.product";
//        NativeQuery query = session.createNativeQuery(sqlQuery);
//        query.setResultTransformer(new ResultTransformer(){
//
//            @Override
//            public Object transformTuple(Object[] tuple, String[] aliases) {
//                Map<String, Object> resultMap = new HashMap<>();
//                for (int i = 0; i<aliases.length;i++){
//                    resultMap.put(aliases[i],tuple[i]);
//                }
//                return resultMap;
//            }
//
//            @Override
//            public List transformList(List collection) {
//                return collection;
//            }
//        });
//        List<ProductsBalance> results = query.list();
//        transaction.commit();
//        session.close();
//        return (ProductsBalance) results;
        return null;
    }
}
