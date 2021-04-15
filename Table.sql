create table numbers(
	num int unique
);

insert into numbers(num) values (1);
insert into numbers(num) values (2);
insert into numbers(num) values (3);
insert into numbers(num) values (4);
insert into numbers(num) values (5);
insert into numbers(num) values (6);
insert into numbers(num) values (7);
insert into numbers(num) values (8);
insert into numbers(num) values (9);

select n1.num as a, n2.num as b, (n1.num * n2.num) as "a * b = " from numbers n1 cross join numbers n2;