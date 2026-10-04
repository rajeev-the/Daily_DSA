# Write your MySQL query statement below
Select e.name from Employee as e
join Employee as a
  On e.id = a.managerId
group by e.id , e.name
Having Count(*) >= 5;
