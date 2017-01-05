\c tracker

--create table which 
create table if not exists items(
id serial primary key,
item_name character varying(200),
description character varying(2000),
create_time timestamp default now());

--describe comments at the tracker.
create table if not exists comments(
id serial primary key,
text character varying(2000),
item_id integer references items(id));