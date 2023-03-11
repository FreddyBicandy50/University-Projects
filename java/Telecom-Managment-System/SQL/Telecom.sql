--Customer Details table 
    --customer_id is primary key
CREATE TABLE `Telecom_db`.`customer_details`(
    `Customer_id` INT NOT NULL AUTO_INCREMENT,
    `Full_Name` CHAR(255) NOT NULL,
    `Age`  SMALLINT,
    `Gender` CHAR(6) NOT NULL,
    CONSTRAINT pk_Customer_id PRIMARY KEY (Customer_id) 
);

--Phone Numbers Table 
    --Numbers is primary key
    --cust_id is Foreign key of ->(customer_id) form TABLE (customer_details)
CREATE TABLE `Telecom_db`.`Numbers`(
     `Number` CHAR(11) NOT NULL,
     `Active` BOOLEAN NOT NULL,
     `Type` CHAR(10) NOT NULL,
     `cust_id` INT,
     CONSTRAINT pk_number PRIMARY KEY (number),
     CONSTRAINT fk_cust_ud FOREIGN KEY (cust_id)
     REFERENCES customer_details(Customer_id)
);
 