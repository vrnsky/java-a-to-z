\c carapp


--create a users table
create table users(
id serial primary key,
email varchar(120),
password varchar(100));



--create a car details tables
create table body (
id serial primary key,
name varchar(100));

create table color(
id serial primary key,
name varchar(100));

create table gearbox(
id serial primary key,
name varchar(100));

create table producer(
id serial primary key,
name varchar(100));

create table model(
id serial primary key,
name varchar(100));

--create a car table
create table car (
id serial primary key,
body_id int references body(id),
color_id int references color(id),
gearbox_id int references gearbox(id),
producer_id int references producer(id),
model_id int references model(id));

--create advert table
create table advert(
id serial primary key,
title varchar(1000),
car_id references car(id),
price integer,
user_id int references users(id));


--adding some value to tables.
insert into body values ('sedan');
insert into body values ('hatchback');
insert into body values ('crossover');
insert into body values ('jeep');

--adding some value to tables.
insert into color values ('black');
insert into color values ('gray');
insert into color values ('green');
insert into color values ('yellow');

--adding some value to tables.
insert into gearbox values ('mechanic');
insert into gearbox values ('automat');


--adding some value to table.
insert into producer values ('audi');
insert into producer values ('bmw');
insert into producer values ('mercesedes');
insert into producer values ('lada(VAZ');

--adding some value to the table.
insert into model values ('a4');
insert into model values ('x6');
insert into model values ('S63');
insert into model values ('Granta');

