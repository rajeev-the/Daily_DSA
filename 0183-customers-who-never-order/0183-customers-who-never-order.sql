# Write your MySQL query statement below
select c.name as Customers
from Customers as c
Left join Orders as o
On c.id = o.customerId
where  o.customerId IS NULL