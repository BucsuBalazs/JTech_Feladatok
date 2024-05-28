SELECT 
    m.id,
    m.created,
    m.attr2,
    COUNT(CASE WHEN d.status = 0 THEN 1 END) AS detail_status_0_count,
    COUNT(CASE WHEN d.status = 1 THEN 1 END) AS detail_status_1_count
FROM 
    Master m
LEFT JOIN 
    Detail d ON m.id = d.masterFk
WHERE 
    m.created >= SYSDATE - 100
GROUP BY 
    m.id, m.created, m.attr2;