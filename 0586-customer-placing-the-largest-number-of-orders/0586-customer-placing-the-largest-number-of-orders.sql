# Write your MySQL query statement below
Select customer_number
from Orders as a
group by a.customer_number 
ORDER BY count(customer_number) DESC
LIMIT 1;