
create database bankmanagementsystem;

use bankmanagementsystem;

create table signup(form_number varchar(50), name varchar(50), fathers_name varchar(50), dob varchar(50), gender varchar(50), email varchar(50), martial varchar(50), address varchar(50), city varchar(50), state varchar(50), pin varchar(50));
show tables;
select * from signup;

create table signup2(form_number varchar(40), religion varchar(50), catogery varchar(50), income varchar(50), qualification varchar(50), occupation varchar(50), senior varchar(50), account varchar(50), pan varchar(10), adhar varchar(50));
select * from signup2;
 
create table signup3(form_number varchar(50), accountType varchar(50), cardNum varchar(50), pinNum varchar(50), facility varchar(50));
create table login(form_number varchar(50), cardNum varchar(50), pinNum varchar(50));
select * from signup3;
select * from login;
-- DROP table login;


create table bank(pinNum varchar(50), date varchar(50), type varchar(50), amount varchar(50));
select * from bank;
DROP table bank;
