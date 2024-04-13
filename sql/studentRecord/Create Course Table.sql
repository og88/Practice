create table Student_Record.Course (
class_id int not null auto_increment primary key,
class_number int not null,
class_subject int not null,
class_desc varchar(4000),
foreign key (class_subject) references Student_Record.R_Class_Subject(subject_id),
constraint unique_course unique (class_subject, class_number)
);
commit;
