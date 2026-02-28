SELECT
    t.EMP_NO,
    t.EMP_NAME,
    t.GRADE,
    CASE
        WHEN t.GRADE = 'S' THEN t.SAL * 0.2
        WHEN t.GRADE = 'A' THEN t.SAL * 0.15
        WHEN t.GRADE = 'B' THEN t.SAL * 0.1
        ELSE 0
    END AS BONUS
FROM (
    SELECT
        E.EMP_NO,
        E.EMP_NAME,
        E.SAL,
        CASE
            WHEN AVG(G.SCORE) >= 96 THEN 'S'
            WHEN AVG(G.SCORE) >= 90 THEN 'A'
            WHEN AVG(G.SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END AS GRADE
    FROM HR_EMPLOYEES E
    JOIN HR_GRADE G ON E.EMP_NO = G.EMP_NO
    GROUP BY E.EMP_NO, E.EMP_NAME, E.SAL
) t
ORDER BY t.EMP_NO;