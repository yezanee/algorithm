# Write your MySQL query statement below
SELECT IFNULL(unique_id, null) AS unique_id, name
FROM Employees E LEFT JOIN EmployeeUNI U ON E.id = U.id
;