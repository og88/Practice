create table Student_Record.R_Type(
type_id int not null auto_increment,
type_name varchar(255) not null unique,
primary key(type_id)
)
auto_increment = 1;
commit;

insert into Student_Record.R_Type (type_name) values ('Student');
insert into Student_Record.R_Type (type_name) values ('Professor');

commit;

