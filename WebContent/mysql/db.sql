CREATE DATABASE if not exists focusit;
USE focusit;

CREATE TABLE if not exists user (
id_user int primary key not null auto_increment,
nomeutente varchar(30) not null,
cognomeutente varchar(30) not null,
pwd varchar(30) not null,
email varchar(60) not null
);

CREATE TABLE if not exists product (
id_product int primary key not null auto_increment,
nomeprodotto varchar(25) not null,
prezzo decimal(5,2) not null,
marca varchar(25) not null,
descrizione text(5000),
colore varchar(15) not null,
mpx decimal(3,2) not null,
foto blob
);

CREATE TABLE if not exists userorder(
id_product int,
prezzoprod decimal(5,2),
id_order int primary key not null auto_increment,
id_user int,
CONSTRAINT FOREIGN KEY  userorder (id_product) references product (id_product)
CONSTRAINT FOREIGN KEY  userorder (id_user) references user (id_user)
);
