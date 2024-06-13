create database details;
use details;

create table student(
 ID int(10) NOT NULL AUTO_INCREMENT,  
   NAME varchar(100) NOT NULL,
   BRANCH varchar(255) NOT NULL,
   PERCENTAGE int(3) NOT NULL,  
   PHONE int(10) NOT NULL,
   EMAIL varchar(255) NOT NULL,
   PRIMARY KEY ( ID )
);

insert into student(NAME, BRANCH, PERCENTAGE, PHONE, EMAIL) values ('Shyam', 'it', 80, 954788457, 'mail@mail.com');