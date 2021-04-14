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

select name from product where price = 1;

select * from product where name like 'Мороженое%';

select current_date < current_date + interval '1 month'; 

select * from product where price > 3;

select name, type_id from product;

select * from product where (name like 'С%' or name like 'М%');

select * from product where type_id < 10;

select * from type;

select * from product;


