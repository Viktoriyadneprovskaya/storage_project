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


select * from storagedb.document_details
left join storagedb.document d on d.id_document = document_details.doc_id
left join storagedb.measure_unit mu on mu.id_measure_unit = document_details.unit_id
where doc_id = 1;

select  rez.product, sum(rez.qnt) as balance
from
    (SELECT pr.name as product
          ,case
               when invoice_type = 1 then  -dd.quantity
               when invoice_type = 2 then  dd.quantity
            end as qnt
     FROM storagedb.document doc
              left join storagedb.document_details dd on dd.doc_id = doc.id_document
              left join storagedb.product pr on pr.id_product = dd.product_id) as rez
group by rez.product;


SELECT 	pr.name as product
     ,sum(dd.quantity) as quantity
     ,sum(dd.sum) as summa
FROM storagedb.document doc
         left join storagedb.document_details dd on dd.doc_id = doc.id_document
         left join storagedb.product pr on pr.id_product = dd.product_id
where doc.invoice_type = 1 and doc.creation_date between '2023-02-01' and '2023-02-28'
group by product;

SELECT 	pr.name as product
     ,sum(dd.quantity) as quantity
     ,sum(dd.sum) as Summa
FROM storagedb.document doc
         left join storagedb.document_details dd on dd.doc_id = doc.id_document
         left join storagedb.product pr on pr.id_product = dd.product_id
where doc.invoice_type = 1 and doc.creation_date between '2023-02-01' and '2023-02-28'
  and doc.contractor = 6
group by product;

