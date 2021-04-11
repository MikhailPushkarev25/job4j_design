create table car(
   id serial primary key,
   name varchar(255),
   area text 
);

insert into car(name, area) values('Lada', 'Россия');

update car set name = 'Laddaa';

delete from car;

select * from car;