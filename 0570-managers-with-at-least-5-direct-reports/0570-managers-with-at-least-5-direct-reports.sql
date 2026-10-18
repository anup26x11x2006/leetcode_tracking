# Write your MySQL query statement below
SELECT t1.name
FROM Employee t1 JOIN Employee t2 ON t1.ID = t2.managerID
GROUP BY t2.managerID
HAVING COUNT(t2.managerID) >= 5