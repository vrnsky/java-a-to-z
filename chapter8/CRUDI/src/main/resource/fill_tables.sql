--insert data to the roles.
\c tracker
insert into roles (role) values('employer');
insert into roles (role) values('developer');
insert into roles (role) values('manager');
insert into roles (role) values('ceo');


--insert data to the rules.
insert into rules (open_item, close_item, role_id) values(false, false, 1); -- rights of simple employer.
insert into rules (open_item, close_item, role_id) values(false, true, 1);  -- rights of developer.
insert into rules (open_item, close_item, role_id) values(true, false, 3);  -- rights of manager.
insert into rules (open_item, close_item, role_id) values(true, true, 4);   -- rights of ceo.

--insert data to the controllers table.
insert into users (name, email, role_id) values('Bryan Gotz', 'gotz@java.com', 1);
insert into users (name, email, role_id) values('Yegor Voronyansky', 'vrnsky@vrngroup.com', 2);
insert into users (name, email, role_id) values('Effective Manager', 'efficient@manager', 3);
insert into users (name, email, role_id) values('Cool ceo', 'ceo@seo.com', 4);

--insert data to the item_status table
insert into item_status (status) values('OPEN');
insert into item_status (status) values('DOING');
insert into item_status (status) values('REVIEW');
insert into item_status (status) values('DONE');

--insert data to the category table.
insert into item_category (category) values('bug');
insert into item_category (category) values('feature request');
insert into item_category (category) values('performance improvments');

--insert data to the items table.
insert into attached_files(link) values('.../storage/idnumber/');
insert into items (name, description, create_time, category_id, status, attach_id) values ('fix bug', 'when user submit on the button form does not handle it.', '1999-01-08 04:05:06', 1, 1, 1);
insert into items (name, description, create_time, category_id, status) values ('feature request', 'As user I would have access to the my bank account operation.', '2016-02-12 08:05:06', 1, 2);
insert into items (name, description, create_time, category_id, status) values ('performance improvments', 'we need must improve speed of calculation.', '2016-01-12 10:05:06', 1, 3);

--insert data to the comments table
insert into comments(author_id, text, item_id, attach_id) values(2, 'I make it today', 1, 1);
insert into comments(author_id, text, item_id) values (4, 'Cool! Make it ASAP. And I wait report from you', 1);