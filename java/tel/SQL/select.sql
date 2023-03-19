SELECT * FROM Telecom_db.customer_details; 

SELECT customer_details.Full_Name, Numbers.SIM_Number, Numbers.Type FROM Telecom_db.customer_details 
    INNER JOIN Telecom_db.Numbers ON customer_details.Customer_ID = Numbers.cust_id WHERE Numbers.cust_id 
    IN (
    SELECT Numbers.cust_id  FROM Telecom_db.customer_details 
    INNER JOIN Telecom_db.Numbers ON customer_details.Customer_ID = Numbers.cust_id
    GROUP BY Numbers.cust_id
    HAVING COUNT(*) > 1
    )
ORDER BY 1;