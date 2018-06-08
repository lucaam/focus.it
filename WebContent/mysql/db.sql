CREATE DATABASE if not exists focusit;
USE focusit;

CREATE TABLE if not exists user (
id_user int primary key not null auto_increment,
name varchar(30) not null,
surname varchar(30) not null,
login varchar(25) not null,
pwd varchar(30) not null,
email varchar(60) not null,
city_born varchar (50) not null,
bday date not null,
phone varchar (11) not null,
id_order int,
id_addr int,
CONSTRAINT FOREIGN KEY user (id_order) references order (id_order),
CONSTRAINT FOREIGN KEY user (id_addr) references addr (id_addr)
);

CREATE TABLE if not exists product (
id_product int primary key not null auto_increment,
product_name varchar(25) not null,
price decimal(5,2) not null,
brand varchar(25) not null,
description text(5000),
colour varchar(15) not null,
mpx decimal(3,2) not null,
product_type varchar (15) not null,
img mediumblob
);

CREATE TABLE if not exists order(
id_order int primary key not null auto_increment,
id_product int,
price decimal(5,2),
id_user int,
total_order decimal (8,2),
id_addr int,
CONSTRAINT FOREIGN KEY order (id_addr) references addr (id_addr),
CONSTRAINT FOREIGN KEY order (id_product) references product (id_product),
CONSTRAINT FOREIGN KEY order (id_user) references user (id_user),
CONSTRAINT FOREIGN KEY order (price) references product (price)
);

CREATE TABLE if not exists cart(
id_cart int,
id_product int,
price int,
total decimal (8,2),
CONSTRAINT FOREIGN KEY cart (price) references product (price),
CONSTRAINT FOREIGN KEY cart (id_product) references product (id_product),
CONSTRAINT FOREIGN KEY cart (id_cart) references user (id_user)
);

CREATE TABLE if not exists addr(
id_addr int primary key not null auto_increment,
id_user int,
street varchar (35) not null,
addr_number varchar (10) not null,
state varchar (15) not null,
region varchar (20) not null,
district varchar (25) not null,
city varchar (25) not null,
CONSTRAINT FOREIGN KEY addr (id_user) references user (id_user)
);
