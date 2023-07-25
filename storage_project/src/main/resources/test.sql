SELECT code, contractor_name, contract_number, contractor_type.contractor_type, price_type.price_type
from storagedb.contractors
         left join storagedb.contractor_type ON contractors.contractortype_id = contractor_type.id_contractor_type
         left join storagedb.price_type ON contractors.price_type_id = price_type.id_price_type;



select *
from storagedb.document
         left join storagedb.contractors on contractor = contractors.id_contractor
         left join storagedb.my_organization On my_organization_id = my_organization.id_my_organization
         left join storagedb.contractor_type on contractortype_id = contractor_type.id_contractor_type
         left join storagedb.document_details dd on document.id_document = dd.doc_id
where document.id_document = 1;

select * from storagedb.employees
where username = 'admin';


--docDetails only
select product.name, measure_unit_name, quantity, price, sum
from storagedb.document_details
         left join storagedb.product ON product_id = product.id_product
         left join storagedb.measure_unit ON unit_id = measure_unit.id_measure_unit
where doc_id = 1;

select * from storagedb.document_details
left join storagedb.product ON product_id = product.id_product
left join storagedb.measure_unit ON unit_id = measure_unit.id_measure_unit
left join storagedb.document ON document_details.doc_id = document.id_document
where doc_id = 1;

select * from storagedb.contractor_type
where contractor_type.contractor_type =1;

select * from storagedb.document_details
left join storagedb.document d on d.id_document = document_details.doc_id
left join storagedb.measure_unit mu on mu.id_measure_unit = document_details.unit_id
where doc_id = 1;

select  rez.product, sum(rez.qnt)
from
    (SELECT pr.name as product
          ,case
               when invoice_type = 1 then  -dd.quantity
               when invoice_type = 2 then  dd.quantity
               when invoice_type = 3 then  -dd.quantity
            end as qnt
     FROM storagedb.document doc
              left join storagedb.document_details dd on dd.doc_id = doc.id_document
              left join storagedb.product pr on pr.id_product = dd.product_id) as rez
group by rez.product;

SELECT rez.product, sum(rez.qnt)
FROM (
         SELECT pr.name as product,
                CASE
                    WHEN invoiceType = 1 THEN -dd.quantity
                    WHEN invoiceType = 2 THEN dd.quantity
                    WHEN invoiceType = 3 THEN -dd.quantity
                    END as qnt
         FROM Document doc
                  LEFT JOIN doc.details dd
                  LEFT JOIN dd.product pr
     ) rez
GROUP BY rez.product

SELECT 	pr.name as product
     ,sum(dd.quantity) as kvo
     ,sum(dd.sum) as Summa
FROM storagedb.document doc
         left join storagedb.document_details dd on dd.doc_id = doc.id_document
         left join storagedb.product pr on pr.id_product = dd.product_id
where doc.invoice_type = 1 and doc.creation_date between '2023-02-01' and '2023-02-28'
group by product

SELECT 	pr."name" as product
     ,sum(dd.quantity) as kvo
     ,sum(dd.sum) as Summa
FROM storagedb."document" doc
         left join storagedb.document_details dd on dd.doc_id = doc.id_document
         left join storagedb.product pr on pr.id_product = dd.product_id
where doc.invoice_type = 1 and doc.creation_date between '2023-02-01' and '2023-02-28'
  and doc.contractor = 6
group by product