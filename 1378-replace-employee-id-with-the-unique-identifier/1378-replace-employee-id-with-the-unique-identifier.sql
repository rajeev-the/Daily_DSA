# Write your MySQL query statement below
Select u.unique_id as unique_id ,e.name
from Employees as e
Left JOIN EmployeeUNI as u
on e.id = u.id