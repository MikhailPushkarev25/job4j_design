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

insert into type(name) values('Сыр');
insert into type(name) values('Хлеб');
insert into type(name) values('Зелень');
insert into type(name) values('Мороженое');

insert into product(name, type_id, expired_date, price) values ('Сыр Ламберд', 4, date '14.05.2021', 1);
insert into product(name, type_id, expired_date, price) values ('Сыр Президент', 6, date '13.05.2021', 1);

insert into product(name, type_id, expired_date, price) values ('Хлеб Белый', 20, date '20.04.2021', 2);
insert into product(name, type_id, expired_date, price) values ('Хлеб Черный', 4, date '25.04.2021', 2);

insert into product(name, type_id, expired_date, price) values ('Зелень Лук', 7, date '14.05.2021', 3);
insert into product(name, type_id, expired_date, price) values ('Зелень Укроп', 9, date '13.05.2021', 3);

insert into product(name, type_id, expired_date, price) values ('Мороженое стаканчик', 30, date '17.04.2021', 4);
insert into product(name, type_id, expired_date, price) values ('Мороженое пломбир', 1, date '17.04.2021', 4);

select * from product p join type t on t.id = p.type_id	 where t.name = 'Сыр';

select * from product where name like 'Мороженое%';

select * from product where date_part('month', expired_date) = date_part('month', current_date + interval '1 month');

select * from product where price = (select max(price) from product);

select t.name, count(p.id) from type t join product p on t.id = p.type_id group by t.name;

select * from product p join type t on t.id = p.type_id where t.name in ('Сыр', 'Молоко');

select t.name, count(p.id) from type t join product p on t.id = p.type_id group by t.name having count(t.id) < 10;

select * from type;

select * from product p join type t where t.id = p.type_id;




