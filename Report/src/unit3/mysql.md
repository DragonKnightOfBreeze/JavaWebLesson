```mysql
use JavaWebLesson; 

create table employee(
    userName varchar(20),
    salary int(9),
    age int(3)
);

select * from employee order by age;

update employee set salary=salary+500 where salary <=5000;

create table user(
    userID varchar(12) auto_increment primary key ,
    userName varchar(50),
    password varchar(20),
    mail varchar(20)
);

alter table user add tel varchar(11);

alter table user modify userName varchar(20);

alter table user drop mail;

insert into user (userID,userName,password,mail) value ('201601020011','admin','123456','13907921234');
```
