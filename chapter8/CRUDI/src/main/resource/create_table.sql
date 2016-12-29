\c tracker

--create item status table.
--this table describe a status of items at the tracker.
create table item_status(
id serial primary key,
status character varying(2000));

--create category table.
--describe category of task which exist at the system.
create table item_category(
id serial primary key,
category character varying(2000));

--create a table of link to the storage with attached files.
create table attached_files(
id serial primary key,
link character varying(2000));

--create table which 
create table items(
id serial primary key,
name character varying(200),
description character varying(2000),
create_time timestamp,
category_id integer references item_category(id),
status integer references item_status(id),
attach_id integer references attached_files(id));

--this table describe which role take part at the project.
create table roles (
id serial primary key,
role character varying(2000));

--describe which rules have a role at the project.
create table rules(
id serial primary key,
open_item boolean,
close_item boolean,
role_id integer references roles(id));

--describe users at the system.
create table users(
id serial primary key,
name character varying(2000),
email character varying(200),
role_id integer references roles(id));

--describe comments at the tracker.
create table comments(
id serial primary key,
author_id integer references users(id),
text character varying(2000),
item_id integer references items(id),
attach_id integer references attached_files(id));