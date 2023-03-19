CREATE DATABASE IF NOT EXISTS Telecom_db;

CREATE TABLE Telecom_db.customer_details (
    Customer_ID INT AUTO_INCREMENT NOT NULL,
    Full_Name CHAR(255) NOT NULL,
    Age  SMALLINT,
    Gender CHAR(6) NOT NULL,
    CONSTRAINT pk_cust_id PRIMARY KEY (Customer_ID) 
);  

CREATE TABLE Telecom_db.Numbers (
    SIM_Number CHAR(11) NOT NULL,
    Active CHAR(1) NOT NULL,
    Type CHAR(10) NOT NULL,
    Cust_id INT,
    CONSTRAINT pk_number PRIMARY KEY (SIM_Number),
    CONSTRAINT fk_customer_id FOREIGN KEY (Cust_id)
    REFERENCES customer_details(Customer_ID)
);

CREATE TABLE Telecom_db.Services (
    Name CHAR(30) NOT NULL,
    Subscribers CHAR(11) NOT NULL, 
    Cost FLOAT NOT NULL,
    Date_Subscribed DATE NOT NULL,
    CONSTRAINT pk_Service_name_subscriber PRIMARY KEY (Name, Subscribers),
    CONSTRAINT fk_Service_subscriber FOREIGN KEY (Subscribers)
    REFERENCES Numbers(SIM_Number)
); 

CREATE TABLE Telecom_db.plan (
    Subscribers CHAR(11) NOT NULL,
    Plan_Name CHAR(30) NOT NULL, 
    Cost FLOAT NOT NULL,
    Date_Subscribed DATE NOT NULL,
    CONSTRAINT pk_plan_subscribers PRIMARY KEY (Subscribers),
    CONSTRAINT fk_plan_subscribers_number FOREIGN KEY (Subscribers)
    REFERENCES Numbers(SIM_Number)
); 

  
CREATE TABLE Telecom_db.Call_logs (
     Call_datentime TIMESTAMP NOT NULL, 
     Number_Called CHAR(11) NOT NULL,
     Number_Received CHAR(11) NOT NULL,
     country_code CHAR(5),
    `duration` DATE NOT NULL,
    Termination_type CHAR(25) NOT NULL,
    CONSTRAINT pk_composite PRIMARY KEY (Call_datentime,Number_Called),
    CONSTRAINT fk_number_called FOREIGN KEY (Number_Called)
    REFERENCES Numbers(SIM_Number)
);

--SELECT DATE_FORMAT(NOW(), 'YYYY-MM-DD HH24:MI:SS');
  
CREATE TABLE Telecom_db.`SMS/MMS_logs` (
     Country_code CHAR(5),
     Number_sent CHAR(11) NOT NULL,
     Number_Received CHAR(11) NOT NULL,
    `Date/time` TIMESTAMP NOT NULL,
    `Message Type` CHAR(3) NOT NULL,
    `Message Size` FLOAT NOT NULL,
    CONSTRAINT fk_number_sent FOREIGN KEY (Number_sent)
    REFERENCES Numbers(SIM_Number)
);   

CREATE TABLE Telecom_db.Billings (
    Recharge_date DATE NOT NULL,
    Recharged_number CHAR(11) NOT NULL,
    Total_Cost FLOAT NOT NULL,
    CONSTRAINT pk_Number_and_date_recharged PRIMARY KEY (Recharge_date,Recharged_number),
    CONSTRAINT fk_Recharged_number FOREIGN KEY (Recharged_number)
    REFERENCES Numbers(SIM_Number)
);