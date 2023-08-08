CREATE OR REPLACE FUNCTION getProductQuantities()
    RETURNS TABLE (product VARCHAR, quantity float)
AS $$
BEGIN
    RETURN QUERY
        SELECT rez.product, SUM(rez.qnt) AS quantity
        FROM
            (SELECT pr."name" AS product,
                    CASE
                        WHEN invoice_type = 2 THEN dd.quantity
                        ELSE -dd.quantity
                        END AS qnt
             FROM storagedb."document" doc
                      LEFT JOIN storagedb.document_details dd ON dd.doc_id = doc.id_document
                      LEFT JOIN storagedb.product pr ON pr.id_product = dd.product_id) AS rez
        GROUP BY rez.product;
END;
$$ LANGUAGE plpgsql;


SELECT * FROM GetProductQuantities();


CREATE OR REPLACE FUNCTION getProductSalesByDate(start_date DATE, end_date DATE)
    RETURNS TABLE (product VARCHAR, quantity float, summa float)
AS $$
BEGIN
    RETURN QUERY
SELECT 	pr.name as product
     ,sum(dd.quantity) as quantity
     ,sum(dd.sum) as summa
FROM storagedb.document doc
         left join storagedb.document_details dd on dd.doc_id = doc.id_document
         left join storagedb.product pr on pr.id_product = dd.product_id
where doc.invoice_type = 1 and doc.creation_date between start_date and end_date
group by product;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM getProductSalesByDate('2023-02-01','2023-02-28');


CREATE OR REPLACE FUNCTION getProductSalesByDateByContractor(start_date DATE, end_date DATE, contractor_id int)
    RETURNS TABLE (product VARCHAR, quantity float, summa float)
AS $$
BEGIN
    RETURN QUERY
SELECT 	pr.name as product
     ,sum(dd.quantity) as quantity
     ,sum(dd.sum) as Summa
FROM storagedb."document" doc
         left join storagedb.document_details dd on dd.doc_id = doc.id_document
         left join storagedb.product pr on pr.id_product = dd.product_id
where doc.invoice_type = 1 and doc.creation_date between start_date and end_date
  and doc.contractor = contractor_id
group by product;
END;
$$ LANGUAGE plpgsql;

SELECT * FROM getProductSalesByDateByContractor('2023-02-01','2023-02-28', 6);