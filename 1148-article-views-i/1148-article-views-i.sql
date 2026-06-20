# Write your MySQL query statement belowS
Select DISTINCT author_id as id
from Views as v
where  v.author_id = v.viewer_id 
ORDER By author_id ASC;