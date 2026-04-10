CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      Select Max(salary) As getNthHighestSalary   from(
         Select salary , DENSE_Rank() over (ORDER BY  salary  DESC) AS rnk
      from  Employee
      ) t
      Where rnk = N

  );
END