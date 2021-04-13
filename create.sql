

create table users(
 id serial primary key,
 name varchar(100)
);

create table role(
 id serial primary key,
 name varchar(100),
 users_id int references users(id)
);

create table rules(
 id serial primary key,
 name varchar(100)
);

create table role_rules(
 id serial primary key,
 rules_id int references rules(id),
 role_id int references role(id)
);

create table comments(
 id serial primary key,
 item_id int references item(id)
);

create table attachs(
 id serial primary key,
 name varchar(100),
 item_id int references item(id)
);

create table category(
 id serial primary key,
 name varchar(100)
);

create table state(
 id serial primary key,
 name varchar(100)
);

create table item(
 id serial primary key,
 users_id int references users(id),
 category_id int references category(id),
 state_id int references state(id)
);

