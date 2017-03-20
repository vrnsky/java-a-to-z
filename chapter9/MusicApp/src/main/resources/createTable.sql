\c musicapp

create table if not exists roles (
id serial primary key,
role_name varchar(200));

create table if not exists address (
id serial primary key,
country varchar(200),
city varchar(200));

create table if not exists musictype(
id serial primary key,
mtype varchar(200));

create table if not exists users (
id serial primary key,
email varchar(200),
password varchar(200),
role_id integer references roles(id),
address_id integer references address(id));

create table if not exists usermusictype (
id serial primary key,
user_id integer references users(id),
musictype_id integer references musictype(id));

insert into musictype (mtype) values('ROCK');
insert into musictype (mtype) values('POP');
insert into musictype (mtype) values('ALTERNATIVE');

insert into roles (role_name) values('ADMIN');
insert into roles (role_name) values('MANDATOR');
insert into roles (role_name) values('USER');


insert into address (country, city) values('Russia', 'Moscow');
insert into users (email, password, role_id, address_id) values ('voronyansky.egor@yandex.ru', 'vrnsky', 1, 1);
insert into usermusictype (user_id, musictype_id) values (1, 1);
insert into usermusictype (user_id, musictype_id) values (1, 2);
insert into usermusictype (user_id, musictype_id) values (1, 3);