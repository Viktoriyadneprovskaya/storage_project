SELECT code, contractor_name, contract_number, contractor_type.contractor_type, price_type.price_type
from storagedb.contractors
         left join storagedb.contractor_type ON contractors.contractortype_id = contractor_type.id_contractor_type
         left join storagedb.price_type ON contractors.price_type_id = price_type.id_price_type;


-- переделать мою организацию в отдельный Класс
select id_document, creation_date, contractor_name, contract_number, my_organisation_id
from storagedb.document
         left join storagedb.contractors on contractor = contractors.id_contractor
         left join storagedb.contractors On my_organisation_id = contractors.id_contractor
         left join storagedb.contractor_type on contractortype_id = contractor_type.id_contractor_type
where document.id_document = 1;


--docDetails only
select product.name, measure_unit_name, quantity, price, sum
from storagedb.document_details
         left join storagedb.product ON product_id = product.id_product
         left join storagedb.measure_unit ON unit_id = measure_unit.id_measure_unit
where doc_id = 1;

--entire document, need to add my organization
select id_document,
       my_organisation_id,
        creation_date,
       contractor_name,
       contract_number,
       product.name,
       measure_unit_name,
       quantity,
       price,
       sum
from storagedb.document_details
         left join storagedb.product ON product_id = product.id_product
         left join storagedb.measure_unit ON unit_id = measure_unit.id_measure_unit
         left join storagedb.document d on document_details.doc_id = d.id_document
         left join storagedb.contractors c on c.id_contractor = d.contractor
where doc_id = 1;