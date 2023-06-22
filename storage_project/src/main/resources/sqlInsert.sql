INSERT INTO storagedb.country (countryname)
values ('Ukraine'),
       ('Poland'),
       ('Germany');

INSERT INTO storagedb.city(city_name)
values ('Dnipro'),
       ('Kyiv'),
       ('Lviv'),
       ('Poltava'),
       ('Warszawa'),
       ('Krakov'),
       ('Berlin'),
       ('Munchen'),
       ('Hamburg');

INSERT INTO storagedb.contractor_type(contractor_type)
values ('supplier'),
       ('consumer');


INSERT INTO storagedb.price_type(price_type, charge_percent)
values ('market',10),
       ('distributor',20),
       ('other consumers',0),
       ('supplier',50);


INSERT INTO storagedb.storage(storage_name)
values ('flour products'),
       ('sugar products');

INSERT INTO storagedb.contractors(code, contractor_name, contract_number, contractortype_id, price_type_id)
values (123456,'TOV "ASD"','S0001',1,4),
       (563214,'TOV "Sugar world"','S0002',1,4),
       (523647,'TOV "Sugar day"','S0003',1,4),
       (235874,'TOV "ATB Market"','M0004',2,1),
       (456789,'TOV "Silpo"','M0005',2,1),
       (028965,'TOV "Varus"','M0006',2,1),
       (012365,'TOV "Sweetland"','D0007',2,2),
       (782456,'TOV "Berrysweet"','D0008',2,2),
       (789456,'TOV "Konfetka"','D0009',2,2),
       (456789,'Other consumers and employees','A0000',2,3);

INSERT INTO storagedb.job_title(name)
values ('admin'),
       ('storekeeper'),
       ('operator');

INSERT INTO storagedb.employees(firstname, lastname, job_title_id)
values ('Viktoriya', 'Lepetiukh', 1),
       ('John', 'Smith', 2),
       ('Jane', 'Winder', 3);

INSERT INTO storagedb.address(index, street, house_number,id_country, id_city, id_contractor)
VALUES (49026, 'Kalynova', '153',1,1,1),
       (52000, 'Pavla Tychiny', '12/1',1,2,2),
       (42000, 'Vitchysnyana', '78',1, 4, 3),
       (49000, 'Kirova', '42',1, 1, 4),
       (42000, 'Vitchysnyana', '75',1, 2, 5),
       (49001, 'Kirova', '126',1, 1, 6),
       (49003, 'Osinnya', '25',1, 1, 7),
       (12345, 'Polska', '14',2, 5, 8),
       (48000, 'Stepana Bandery', '13',1, 3, 9),
       (49000, 'pickup', 'pickup',1, 1, 10);

INSERT INTO storagedb.invoice_type(invoice_type)
values ('sales invoice'),
       ('input invoice'),
       ('write-off product');
INSERT INTO storagedb.my_organization(name,number, address)
values ('TOV "My Organization"',555888,'Ukraine, Dnipro, Winter Street,5');

INSERT INTO storagedb.document(creation_date,my_organization_id, contractor, storage, price_type, invoice_type)
values ('2023-01-05',1,1,2,4,2),
       ('2023-02-03',1,2,2,4,2),
       ('2023-02-25',1,3,1,4,2),
       ('2023-01-05',1,4,2,1,1),
       ('2023-01-07',1,5,1,1,1),
       ('2023-02-10',1,6,1,1,1),
       ('2023-02-15',1,7,1,2,1),
       ('2023-01-23',1,8,2,2,1),
       ('2023-01-23',1,9,2,2,1),
       ('2023-02-06',1,10,2,3,1);

INSERT INTO storagedb.measure_unit(measure_unit_name)
values ('kg');

INSERT INTO storagedb.product(name, measure_unit, shelflife, basic_price)
values ('Marshmallow White pink',1, '3 months', 98.50),
       ('Marshmallow Glazed',1, '3 months', 126.00),
       ('Marshmallow White marmalade',1,'3 months', 134.40),
       ('Marshmallow Mango',1,'3 months', 160.00),
       ('Marshmallow Apple',1,'3 months',160.00),
       ('Marshmallow Vanilla',1,'3 months',102.00),
       ('Marshmallow Latte',1,'3 months',110.80),
       ('Marmalade Jelly-form',1,'6 months', 95.00),
       ('Marmalade Bears',1,'6 months',130.00),
       ('Marmalade Slices',1,'6 months', 150.00),
       ('Gingerbread European',1,'3 months', 68.00),
       ('Gingerbread Ukrainian',1,'3 months', 75.00),
       ('Gingerbread with apricot filling',1,'3 months',92.00),
       ('Biscuit Family ',1, '4 months',68.00),
       ('Biscuit Rainbow',1,'4 months', 74.00);

INSERT INTO storagedb.document_details(product_id, unit_id, quantity, price, sum, doc_id)
values (1,1,10000.00,65.60,656000.00,1),
       (7,1,8000.00,73.80,590400.00,1),
       (2,1,9000.00,84.00,756000.00,1),
       (3,1,3000.00,89.60,268800.00,1),
       (4,1,3000.00,106.60,319800.00,1),
       (5,1,3000.00,106.60,319800.00,1),
       (6,1,3000,68.00,204000.00,1),
       (8,1,1500.00,63.30,94950.00,2),
       (9,1,2500.00,86.60,216500.00,2),
       (10,1,1200.00,100.00,120000.00,2),
       (11,1,20000.00,45.30,906000.00,3),
       (12,1,15000.00,50.00,750000.00,3),
       (13,1,12000.00,61.30,735600.00,3),
       (14,1,20000.00,45.30,906000.00,3),
       (15,1,17000.00,49.30,838100.00,3),
       (1,1,300.00,88.65,26565.00,4),
       (3,1,200.00,120.96,24192.00,4),
       (11,1,500.00,62.60,30600.00,5),
       (15,1,300.00,66.60,19980.00,5),
       (12,1,400.00,67.50,27000.00,6),
       (13,1,300.00,82.80,24840.00,6),
       (11,1,250.00,54.40,13600.00,7),
       (14,1,250,54.40,13600.00,7),
       (7,1, 700.00,88.64,62048.00,8),
       (8,1,200.00,76.00,15200.00,8),
       (4,1,200.00,128.00,25600.00,9),
       (10,1,100.00,120.00,12000.00,9),
       (1,1,3.00,98.50,295.50,10),
       (9,1,1.00,130.00,130.00,10),
       (7,1,5.00,110.80,554.00,10);