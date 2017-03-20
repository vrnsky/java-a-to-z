select u.id, u.email, u.role_id, address_id, m.mtype from users as u
left outer join usermusictype as umt on u.id = umt.user_id
left outer join musictype as m on m.id = umt.id;
