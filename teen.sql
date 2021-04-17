create table departments(
	id serial primary key,
	name varchar(100)
);

create table emploees(
	emploees_id serial primary key,
	name varchar(100),
	department_id int references departments(id)
);

insert into departments(name) values ('�����');
insert into departments(name) values ('���');
insert into departments(name) values ('���');

insert into emploees(name, department_id) values ('�������', 1);
insert into emploees(name, department_id) values ('��������', 2);
insert into emploees(name, department_id) values ('�����', 3);
insert into emploees(name, department_id) values ('�������', null);

select * from departments d left join emploees e on d.id = e.department_id;

select * from departments d right join emploees e on e.department_id = d.id;

select * from departments d cross join emploees e;

select * from departments d full join emploees e on e.department_id = d.id;

select * from emploees e left join departments d on e.department_id = d.id where e.department_id is null;

select * from emploees e left join departments d on e.department_id = d.id;

select * from departments d right join emploees e on e.department_id = d.id;

create table teens(
	name varchar(100),
	gender varchar(100)
);

insert into teens(name, gender) values ('Елена', 'Ж');
insert into teens(name, gender) values ('Николай', 'М');
insert into teens(name, gender) values ('Виктория', 'Ж');
insert into teens(name, gender) values ('Василий', 'М');
insert into teens(name, gender) values ('Екатерина', 'Ж');


select * from teens t1 cross join teens t2 where t1.gender != t1.gender;




