SELECT DISTINCT a.num AS ConsecutiveNums
FROM Logs a
JOIN Logs b
    ON a.num = b.num
   AND a.id = b.id + 1
JOIN Logs c
    ON b.num = c.num
   AND b.id = c.id + 1;