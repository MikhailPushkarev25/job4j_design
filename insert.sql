
insert into rules(name) values('admin');
insert into role(name, users_id) values('role', 2);
insert into role_rules(rules_id, role_id) values('val', 1);
insert into item(users_id, category_id, state_id) values('names', 'role', 2);
