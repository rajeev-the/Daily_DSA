# Write your MySQL query statement below
Select d.name as Department , e.name as Employee, salary as Salary from 
Employee  as e
INNER JOIN Department as d
ON d.id = e.departmentId
where e.salary =(
     select  MAX(e2.salary)
     FROM Employee  as e2
     Where e2.departmentId = e.departmentId
);