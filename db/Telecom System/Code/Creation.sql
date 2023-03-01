--Creating User in for database With password
CREATE USER Telecom_system IDENTIFIED BY "Admin@Tel$1120#7";
GRANT CONNECT,RESOURCE, DBA TO Telecom_system; 

CREATE TABLE customer_details (
    cust_id INT NOT NULL,
    full_name CHAR(255) NOT NULL,
    age  SMALLINT,
    gender CHAR(6) NOT NULL,
    CONSTRAINT pk_cust_id PRIMARY KEY (cust_id) 
);

--auto_increment for cust_id 
CREATE SEQUENCE cust_id START WITH 502022001 NOMAXVALUE;
 
CREATE TABLE numbers (
    "number" CHAR(11) NOT NULL,
    Active CHAR(1) NOT NULL,
    Type CHAR(10) NOT NULL,
    customer_id INT,
    CONSTRAINT pk_number PRIMARY KEY ("number"),
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id)
    REFERENCES customer_details(cust_id)
);
 

CREATE TABLE Services (
    "name" CHAR(30) NOT NULL,
    subscribers CHAR(11) NOT NULL, 
    cost FLOAT NOT NULL,
    date_subscribed DATE NOT NULL,
    CONSTRAINT pk_Service_name_subscriber PRIMARY KEY ("name",subscribers),
    CONSTRAINT fk_Service_subscriber FOREIGN KEY (subscribers)
    REFERENCES numbers("number")
); 

CREATE TABLE plan (
    subscribers CHAR(11) NOT NULL,
    "name" CHAR(30) NOT NULL, 
    cost FLOAT NOT NULL,
    date_subscribed DATE NOT NULL,
    CONSTRAINT pk_plan_subscribers PRIMARY KEY (subscribers),
    CONSTRAINT fk_plan_subscribers_number FOREIGN KEY (subscribers)
    REFERENCES numbers("number")
); 


CREATE TABLE Call_logs (
    "Date/time" TIMESTAMP NOT NULL,
    number_called CHAR(11) NOT NULL,
    number_received CHAR(11) NOT NULL,
    country_code CHAR(5),
    "duration" DATE NOT NULL,
    Termination_type CHAR(25) NOT NULL,
    CONSTRAINT pk_composite PRIMARY KEY ("Date/time",number_called),
    CONSTRAINT fk_number_called FOREIGN KEY (number_called)
    REFERENCES numbers("number")
);
ALTER SESSION SET NLS_DATE_FORMAT='DD-MON-YYYY HH24:MI:SS';

CREATE TABLE "SMS/MMS_logs" (
    number_sent CHAR(11) NOT NULL,
    country_code CHAR(5),
    number_received CHAR(11) NOT NULL,
    "Date/time" TIMESTAMP NOT NULL,
    "Message Type" CHAR(3) NOT NULL,
    "Message Size" FLOAT NOT NULL,
    CONSTRAINT fk_number_sent FOREIGN KEY (number_sent)
    REFERENCES numbers("number")
);  

CREATE TABLE Billings (
    Recharge_date DATE NOT NULL,
    Recharged_number CHAR(11) NOT NULL,
    Total_Cost FLOAT NOT NULL,
    CONSTRAINT pk_Number_and_date_recharged PRIMARY KEY (Recharge_date,Recharged_number),
    CONSTRAINT fk_Recharged_number FOREIGN KEY (Recharged_number)
    REFERENCES numbers("number")
);