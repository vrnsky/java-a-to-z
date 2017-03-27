\c carshop

--create table which store user at the system. 
create table if not exists users(
id serial primary key,
email varchar(200),
password varchar(200));

--create table for car bodies.
create table if not exists bodies (
id serial primary key,
name varchar(200));

--create table for car producers.
create table if not exists producers (
id serial primary key,
producer varchar(200));

--create table for cars.
create table if not exists cars (
id serial primary key,
name varchar(200),
body_id integer references bodies(id),
producer_id integer references producers(id));

--create table for averts
create table if not exists adverts (
id serial primary key,
car_id integer references cars(id),
price bigint,
added timestamp default now(),
author_id integer references users(id),
sale boolean);

--fill bodies table
insert into bodies (name) values('hatchback');
insert into bodies (name) values('sedan');
insert into bodies (name) values('cabriolet');
insert into bodies (name) values('coupe');
insert into bodies (name) values('pickup');
insert into bodies (name) values('crossover');

--fill producers table
insert into producers(producer) values('LADA(VAZ)');
insert into producers(producer) values('Ford');
insert into producers(producer) values('Honda');
insert into producers(producer) values('Audi');
insert into producers(producer) values('Skoda');







