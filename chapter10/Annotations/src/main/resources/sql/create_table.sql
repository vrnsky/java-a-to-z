\c annotations

--create user table
create table if not exists users(
id serial primary key,
email varchar(200),
password varchar(200));

--create item table
create table if not exists items(
id serial primary key,
description varchar(200),
author_id int references users(id));

--create comments table
create table if not exists comments(
id serial primary key,
text varchar(200),
author_id int references users(id));







