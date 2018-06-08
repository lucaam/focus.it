CREATE TABLE if not exists usr (
id_usr int primary key not null auto_increment,
name varchar(30) not null,
surname varchar(30) not null,
login varchar(25) not null,
pwd varchar(30) not null,
email varchar(60) not null,
city_born varchar (50),
bday date,
phone varchar (11),
role varchar (10) default 'user',
id_usrorder int,
id_addr int
);

CREATE TABLE if not exists product (
id_product int primary key not null auto_increment,
product_name varchar(25) not null,
price decimal(5,3) not null default '0.0',
brand varchar(25) not null,
description text(5000),
colour varchar(15) default 'black',
mpx decimal(5,3) not null,
product_type varchar (15) default 'Reflex',
img mediumblob
);

CREATE TABLE if not exists usrorder(
id_usrorder int primary key not null auto_increment,
id_product int,
price decimal(5,3),
id_usr int,
total_usrorder decimal (8,3),
id_addr int
);

CREATE TABLE if not exists cart(
id_cart int,
id_product int,
price int,
total decimal (8,3)
);

CREATE TABLE if not exists addr(
id_addr int primary key not null auto_increment,
id_usr int,
street varchar (35) not null,
addr_number varchar (10) not null,
state varchar (15) not null,
region varchar (20) not null,
district varchar (25) not null,
city varchar (25) not null
);

ALTER TABLE usr ADD FOREIGN KEY (id_usrorder) references usrorder (id_usrorder);
ALTER TABLE usr ADD FOREIGN KEY (id_addr) references addr (id_addr);
ALTER TABLE usrorder ADD FOREIGN KEY (id_addr) references addr (id_addr);
ALTER TABLE usrorder ADD FOREIGN KEY (id_product) references product (id_product);
ALTER TABLE usrorder ADD FOREIGN KEY (id_usr) references usr (id_usr);
ALTER TABLE cart ADD FOREIGN KEY (id_product) references product (id_product);
ALTER TABLE cart ADD FOREIGN KEY (id_cart) references usr (id_usr);
ALTER TABLE addr ADD FOREIGN KEY (id_usr) references usr (id_usr);
