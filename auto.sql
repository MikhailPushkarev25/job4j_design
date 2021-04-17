create table bodywork(
	id serial primary key,
	name varchar(255)
);

create table engine(
	id serial primary key,
	name varchar(255)
);

create table transmission(
	id serial primary key,
	name varchar(255)
);

create table auto(
	id serial primary key,
	name varchar(255),
	bodywork_id int references bodywork(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into bodywork(name) values ('Лифтбэк');
insert into bodywork(name) values ('Сидан');
insert into bodywork(name) values ('Хэтчбек');

insert into engine(name) values ('2.2');
insert into engine(name) values ('1.8');
insert into engine(name) values ('2.0');

insert into transmission(name) values ('Передний привод');
insert into transmission(name) values ('Задний привод');
insert into transmission(name) values ('Полный привод');

insert into auto(name, bodywork_id, engine_id, transmission_id) values ('BMW', 1, 1, 1);
insert into auto(name, bodywork_id, engine_id, transmission_id) values ('Audi', 2, 2, 2);
insert into auto(name, bodywork_id, engine_id, transmission_id) values ('Jeep', 3, 3, 3);

select * from auto a left join bodywork b on a.bodywork_id = b.id left join engine e on a.engine_id = e.id left join transmission t on a.transmission_id = t.id;

select * from auto a right join bodywork b on a.bodywork_id = b.id where b.id is null;

select * from auto a right join engine e on a.engine_id = e.id where e.id is null;

select * from auto a right join transmission t on a.transmission_id = t.id where t.id is null;
