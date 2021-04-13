create table students(
 id serial primary key,
 name varchar(255),
 course int,
 budget bool,
 speciality varchar(255),
 enroll_date timestamp,
 university_id int references universities(id)
);
