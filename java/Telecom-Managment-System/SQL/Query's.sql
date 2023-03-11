--Display all customers having more one number line
SELECT 
    customer_details.full_name,numbers."number",numbers.Type
FROM 
    customer_details
INNER JOIN 
    numbers
ON 
    customer_details.cust_id = numbers.customer_id
WHERE 
    numbers.customer_id IN 
    (
        SELECT 
            numbers.customer_id
        FROM 
            customer_details
        INNER JOIN 
            numbers
        ON 
            customer_details.cust_id = numbers.customer_id
        GROUP BY 
            numbers.customer_id
        HAVING 
            COUNT(*)>1
    )
ORDER BY 1;

--display all active numbers and plan name of customers age between 18 27 Having PRIVATE Service Enabled
SELECT 
    DISTINCT plan.subscribers,plan."name" AS "Active Plan",Services."name" AS "Services"
FROM 
    Services,plan
INNER JOIN 
    numbers
ON 
    numbers."number"=plan.subscribers
WHERE 
    plan.subscribers IN 
    (
        SELECT 
            Services.subscribers
        FROM 
            Services
        INNER JOIN 
            numbers
        ON 
            numbers."number"=Services.subscribers
        WHERE 
            numbers.active='Y' AND Services."name"='PRIVATE' 
    )
AND 
    plan.subscribers IN 
    (
        SELECT 
            numbers."number"
        FROM 
            customer_details
        INNER JOIN 
            numbers
        ON 
            numbers.customer_id=customer_details.cust_id
        WHERE 
            customer_details.age BETWEEN 18 AND 27
    )
AND 
    Services."name"='PRIVATE';

--display all records for international calls and message made before 'July 2022'
SELECT 
    call_logs.number_called,call_logs.country_code,
    call_logs.number_received,call_logs."Date/time"
FROM 
    call_logs
WHERE 
    call_logs."Date/time" < TO_DATE('01/07/2022','DD/MM/YYYY')
    AND
    call_logs.country_code <> '+961'  
UNION
SELECT 
    "SMS/MMS_logs".number_sent,"SMS/MMS_logs".country_code,
    "SMS/MMS_logs".number_received,"SMS/MMS_logs"."Date/time"
FROM  
    "SMS/MMS_logs"
WHERE  
        "SMS/MMS_logs"."Date/time" < TO_DATE('01/07/2022','DD/MM/YYYY')
    AND 
        "SMS/MMS_logs".country_code <> '+961'
ORDER BY 4;


--Display total cost of postpaid calls made in dollar and in lebanese pound rate(1515)
SELECT Billings.recharged_number,
CONCAT('$',total_cost) AS total_cost_$, 
CONCAT(total_cost*1515,'L.L')AS LBP
FROM Billings
INNER JOIN call_logs
ON number_called=Billings.recharged_number;