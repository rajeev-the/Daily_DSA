# Write your MySQL query statement bS
SELECT score , DENSE_RANK() OVER (ORDER BY score  DESC) AS `rank`           
from Scores