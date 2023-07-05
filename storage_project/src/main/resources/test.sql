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