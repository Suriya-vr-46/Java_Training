-- UsertTable
DROP TABLE IF EXISTS INV_PART;
CREATE TABLE INV_USER(
	USER_ID INT IDENTITY(1000,1) PRIMARY KEY, 
	NAME VARCHAR(20) UNIQUE NOT NULL,
	PASSWORD VARCHAR(20) NOT NULL,
	CREATE_AT DATETIME DEFAULT GETDATE(),
	UPDATED_AT DATETIME DEFAULT NULL
);

SELECT * FROM INV_USER;


-- Part Table
drop table if exists INV_PART;
create table INV_PART(
	part_id int identity(1,1) primary key not null,
	name varchar(20),
	number varchar(20),
	quantity int,
	description varchar(20) default null,
	tag_id varchar(20) not null,
	constraint FK_PART_TAG
		foreign key(tag_id) 
		references INV_TAG(tag_id),
	address_id int not null,
	constraint FK_PART_ADDRESS
		foreign key(address_id)
		references INV_Address(address_id)
);

sp_help INV_PART;

select * from INV_PART;


-- Address Table
drop table if exists INV_ADDRESS;
create table INV_ADDRESS(
	address_id int identity(1,1) primary key not null,
	doorno int,
	street varchar(10),
	district varchar(10),
	state varchar(10),
	country varchar(10)
);

select * from INV_ADDRESS;


--Tag Table
drop table if exists INV_TAG;
create table INV_TAG(
	tag_id varchar(20) primary key
);


--Ship Tag Table
drop table if exists INV_SHIP_TAG;
create table INV_SHIP_TAG(
	tag_id varchar(20) primary key
);


-- Shipment Table
drop table if exists INV_SHIPMENT;
create table INV_SHIPMENT(
	ship_id int identity(1,1) primary key not null,
	tag_id varchar(20),
	constraint FK_SHIPMENT_TAG
	foreign key(tag_id) 
	references INV_SHIP_TAG(tag_id),
	part_id int,
	constraint FK_PART_ID
	foreign key(part_id) 
	references INV_PART(part_id),
	address_id int,
	constraint FK_ADDRESS_ID
	foreign key(address_id) 
	references INV_ADDRESS(address_id)
);

sp_help INV_SHIPMENT;

select * from INV_SHIPMENT;