create table assignment (
assignment_id int not null auto_increment primary key,
assignemnt_name varchar(255) not null,
grade int not null,
grade_letter int not null,
course int not null,
student_id int not null,
foreign key (course) references Student_Record.Course(class_id),
foreign key (student_id) references Student_Record.User_info(user_id),
foreign key (grade_letter) references Student_Record.R_Letter_Grades(letter_id) 
)
auto_increment = 1;