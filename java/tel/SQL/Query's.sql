--#1 Display all customers having more one number line
SELECT customer_details.Full_Name, Numbers.SIM_Number, Numbers.Type
FROM Telecom_db.customer_details 
INNER JOIN Telecom_db.Numbers ON customer_details.Customer_ID = Numbers.cust_id
WHERE Numbers.cust_id IN (
  SELECT Numbers.cust_id 
  FROM Telecom_db.customer_details 
  INNER JOIN Telecom_db.Numbers ON customer_details.Customer_ID = Numbers.cust_id
  GROUP BY Numbers.cust_id
  HAVING COUNT(*) > 1
)
ORDER BY 1;

--display all active numbers and plan name of customers age between 18 27 Having PRIVATE Service Enabled

SELECT DISTINCT plan.Subscribers,plan.Plan_Name AS "Active Plan",Services.Name AS "Services"
FROM Telecom_db.Services,Telecom_db.plan
INNER JOIN Telecom_db.Numbers
ON  Numbers.SIM_Number=plan.Subscribers
WHERE plan.Subscribers IN 
    (
        SELECT  Services.Subscribers
        FROM  Telecom_db.Services
        INNER JOIN  Telecom_db.Numbers
        ON  Numbers.SIM_Number=Services.Subscribers
        WHERE Numbers.Active=1 AND Services.Name='PRIVATE' 
    )
AND 
    plan.Subscribers IN 
    (
        SELECT Numbers.SIM_Number
        FROM 
            Telecom_db.customer_details
        INNER JOIN Telecom_db.Numbers
        ON  Numbers.cust_id=customer_details.Customer_ID
        WHERE customer_details.Age BETWEEN 18 AND 27
    )
AND Services.Name='PRIVATE';

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