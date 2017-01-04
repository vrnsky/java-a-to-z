\c car_catalog

create table transmission(
id serial primary key,
type varchar(200));

create table engine(
id serial primary key,
type varchar(200));

create table gearbox(
id serial primary key,
type varchar(200));


create table cars(
id serial primary key,
name varchar(2000),
transmission_id integer not null references transmission(id),
engine_id integer not null references engine(id),
gearbox_id integer not null references gearbox(id));