CREATE DATABASE Telecom_db;




CREATE TABLE customer_details (
    cust_id INT NOT NULL,
    full_name CHAR(255) NOT NULL,
    age  SMALLINT,
    gender CHAR(6) NOT NULL,
    CONSTRAINT pk_cust_id PRIMARY KEY (cust_id) 
); 

USE Telecom_db;
INSERT INTO customer_details 
VALUES(544,'Matthew Anderson',25,'Male');