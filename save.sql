create table type(
	id serial primary key,
	name varchar(300)
);

create table product(
	id serial primary key,
	name varchar(300),
	type_id int references type(id),
	expired_date timestamp,
	price float
);

insert into type(name) values('���');
insert into type(name) values('����');
insert into type(name) values('������');
insert into type(name) values('���������');

insert into product(name, type_id, expired_date, price) values ('��� �������', 4, date '14.05.2021', 1);
insert into product(name, type_id, expired_date, price) values ('��� ���������', 6, date '13.05.2021', 1);

insert into product(name, type_id, expired_date, price) values ('���� �����', 20, date '20.04.2021', 2);
insert into product(name, type_id, expired_date, price) values ('���� ������', 4, date '25.04.2021', 2);

insert into product(name, type_id, expired_date, price) values ('������ ���', 7, date '14.05.2021', 3);
insert into product(name, type_id, expired_date, price) values ('������ �����', 9, date '13.05.2021', 3);

insert into product(name, type_id, expired_date, price) values ('��������� ���������', 30, date '17.04.2021', 4);
insert into product(name, type_id, expired_date, price) values ('��������� �������', 1, date '17.04.2021', 4);

select * from product p join type t on t.id = p.type_id where t.name = '���';

select * from product where name like '���������%';

select current_date < current_date + interval '1 month'; 

select * from product where price = (select max(price) from product);

select name, type_id from product;

select * from product where (name like '�%' or name like '�%');

select t.name, count(t.id) from type t join product p on t.id = p.type_id group by t.name having count (t.id) < 10;

select * from type;

select * from product p join type t on p.type_id = t.id;