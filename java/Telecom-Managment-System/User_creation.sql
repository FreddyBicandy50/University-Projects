--Creating The Telecom db User With password
CREATE USER 'Telecom_Admin'@'localhost' IDENTIFIED BY 'ADMIN@Tel$1120#7';
GRANT ALL PRIVILEGES ON *.* TO 'Telecom_Admin'@'localhost';
FLUSH PRIVILEGES; 

--
--CREATE DATABSE 
CREATE DATABASE Telecom_db;