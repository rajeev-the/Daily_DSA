# Write your MySQL query statement below
Select Person.lastName,Person.firstName , Address.city , Address.state  from Person
LEFT JOIN Address
On Person.personId = Address.personId