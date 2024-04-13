create or replace view Student_Record.V_Course AS
select c.class_name, r.subject_abv, c.class_number, c.class_desc
from 
Student_Record.Course c, Student_Record.R_Class_Subject r
where c.class_subject = r.subject_id;

commit;