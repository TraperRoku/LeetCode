# Write your MySQL query statement below
SELECT s.student_id as student_id , s.student_name  as student_name , sub.subject_name as subject_name , COUNT(e.student_id ) as attended_exams
FROM Students s
CROSS JOIN Subjects sub
    LEFT OUTER JOIN Examinations e on e.student_id = s.student_id and
                                      sub.subject_name = e.subject_name
group by s.student_id, s.student_name, sub.subject_name  order by s.student_id;