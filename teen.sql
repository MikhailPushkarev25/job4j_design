create table departments(
	id serial primary key,
	name varchar(100)
);

create table emploees(
	emploees_id serial primary key,
	name varchar(100),
	department_id int references departments(id)
);

insert into departments(name) values ('Кухня');
insert into departments(name) values ('Бар');
insert into departments(name) values ('Зал');

insert into emploees(name, department_id) values ('Алексей', 1);
insert into emploees(name, department_id) values ('Владимир', 2);
insert into emploees(name, department_id) values ('Мария', 3);
insert into emploees(name, department_id) values ('Василий', null);

select * from departments d left join emploees e on d.id = e.department_id;

select * from departments d right join emploees e on e.department_id = d.id;

select * from departments d cross join emploees e;

select * from departments d full join emploees e on e.department_id = d.id;

select * from emploees e left join departments d on e.department_id = d.id where e.department_id is null;

select * from emploees e left join departments d on e.department_id = d.id;

select * from departments d right join emploees e on e.department_id = d.id;

create table teens(
	name varchar(100),
	gender char(10)
);

insert into teens(name, gender) values (1, 2);
insert into teens(name, gender) values (3, 4);
insert into teens(name, gender) values (5, 6);
insert into teens(name, gender) values (7, 8);
insert into teens(name, gender) values (9, 10);


select t1.name, concat(t1.gender, t2.gender) as a, t2.name from teens t1 cross join teens t2;




