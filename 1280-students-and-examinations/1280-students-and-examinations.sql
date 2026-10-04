# Write your MySQL query statement below
select  st.student_id , st.student_name , su.subject_name , Count(ex.student_id) AS attended_exams
From Students AS st
Cross join Subjects AS su
left join Examinations  as ex
 on st.student_id = ex.student_id
 and su.subject_name = ex.subject_name
 group by 
        st.student_id,
        st.student_name,
        su.subject_name
 order by 
        st.student_id,
        su.subject_name;