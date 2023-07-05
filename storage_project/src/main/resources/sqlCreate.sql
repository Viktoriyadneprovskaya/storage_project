CREATE schema storagedb;


CREATE TABLE storagedb.country
(
    id_country SERIAL NOT NULL primary key,
    countryName varchar(255)
);

CREATE TABLE storagedb.city
(
    id_city SERIAL NOT NULL primary key,
    city_name varchar(255)
);

create table storagedb.contractor_type
(
    id_contractor_type SERIAL NOT NULL primary key,
    contractor_type varchar(255)
);

create table storagedb.price_type
(
    id_price_type SERIAL NOT NULL primary key,
    price_type varchar(255),
    charge_percent double precision
);

create table storagedb.storage
(
    id_storage SERIAL NOT NULL primary key,
    storage_name varchar(255)
);

create table storagedb.contractors
(
    id_contractor SERIAL NOT NULL primary key,
    code int,
    contractor_name varchar,
    contract_number varchar,
    contractorType_id int references storagedb.contractor_type(id_contractor_type ),
    price_type_id int references storagedb.price_type(id_price_type)
);

create table storagedb.job_title
(
    id_job_title SERIAL NOT NULL primary key,
    name varchar
);

create table storagedb.employees
(
    id_employee SERIAL NOT NULL primary key,
    firstname varchar,
    lastname varchar,
    job_title_id int references storagedb.job_title(id_job_title)
);

CREATE TABLE storagedb.address
(
    id_address SERIAL NOT NULL primary key,
    index INT,
    street varchar,
    house_number varchar,
    id_country int references storagedb.country(id_country),
    id_city int references storagedb.city(id_city),
    id_contractor int references storagedb.contractors(id_contractor)
);

create table storagedb.invoice_type
(
    id_invoice_type SERIAL NOT NULL primary key,
    invoice_type varchar
);

create table storagedb.my_organization
(
    id_my_organization SERIAL NOT NULL primary key,
    name varchar,
    number int,
    address varchar
);

create table storagedb.document
(
    id_document SERIAL NOT NULL primary key,
    creation_date date,
    my_organization_id int references storagedb.my_organization(id_my_organization),
    contractor int references storagedb.contractors(id_contractor),
    storage int references storagedb.storage(id_storage),
    price_type int references storagedb.price_type(id_price_type),
    invoice_type int references storagedb.invoice_type(id_invoice_type)
);

CREATE table storagedb.measure_unit
(
    id_measure_unit SERIAL NOT NULL primary key,
    measure_unit_name varchar
);

CREATE table storagedb.product
(
    id_product SERIAL NOT NULL primary key,
    name varchar,
    measure_unit int references storagedb.measure_unit(id_measure_unit),
    shelfLife varchar,
    basic_price double precision
);

create table storagedb.document_details
(
    id_document_details SERIAL NOT NULL primary key,
    product_id int references storagedb.product(id_product),
    unit_id int references storagedb.measure_unit(id_measure_unit),
    quantity double precision,
    price double precision,
    sum double precision,
    doc_id int references storagedb.document(id_document)
);

ALTER TABLE storagedb.employees
    ADD COLUMN username varchar unique,
    ADD COLUMN password varchar;
