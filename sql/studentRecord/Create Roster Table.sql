create table Student_Record.Class_Roster(
roster_id int not null auto_increment primary key,
user_id int not null,
user_type_id int not null,
course int not null,
foreign key (course) references Student_Record.Course(class_id)
)
auto_increment = 1;

Commit;