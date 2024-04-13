create or replace view Student_Record.V_Roster AS
Select u.user_first_name, u.user_middle_name, u.user_last_name, u.user_email, ur.type_name, c.class_name, cr.course
from Student_Record.User_Info u, Student_Record.R_Type ur, Student_Record.Course c, Student_Record.Class_Roster cr
where cr.user_id = u.user_id and cr.course = c.class_id and cr.user_type_id = ur.type_id;

commit;