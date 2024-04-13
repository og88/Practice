create table Student_Record.Student_Info (
student_id int not null,
student_first_name varchar(25) not null,
student_middle_name varchar(25) not null,
student_last_name varchar(25) not null,
student_email varchar(255) not null,
student_dob timestamp not null,
primary key (student_id)
)
auto_increment = 1;

Commit;