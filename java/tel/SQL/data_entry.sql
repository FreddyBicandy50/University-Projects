--TABLE customer_details DATA
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES ('Michael Smith', 19, 'Male');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES ('Michael Smith', 19, 'Male');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender) 
VALUES('Matthew Anderson',25,'Male');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('John Hammond',37,'Male');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('Nicolas Milani',18,'Male');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('Elizabeth Shelbey',65,'Female');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('Richard Daoud',33,'Male');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('Tiffany Andreas',21,'Male');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('Jacob Braidy',19,'Male');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('Christine Hourany',20,'Female');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('Anna-Maria Sarkis',20,'Female');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('Joelle Mazraani',23,'Female');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('George Milani',65,'Male');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('Raymond Al-Ashkar',55,'Male');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('Alex Waked',45,'Male');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('Dana Naayme',35,'Female');
INSERT INTO `Telecom_db`.`customer_details`(Full_name, Age, Gender)
VALUES('Gabriel Bou-Mirchid',39,'Male');
INSERT INTO `Telecom_db`.`customer_details`(full_name, age, gender)
VALUES('Edmond Raphaelle',28,'Male');
INSERT INTO `Telecom_db`.`customer_details`(full_name, age, gender)
VALUES('Susan Nassour',24,'Female');
INSERT INTO `Telecom_db`.`customer_details`(full_name, age, gender)
VALUES('Nassir Njem',37,'Male');
INSERT INTO `Telecom_db`.`customer_details`(full_name, age, gender)
VALUES('Alan Dergham',52,'Male');

--TABLE numbers  
INSERT INTO `Telecom_db`.`Numbers` VALUES('79-131-124',1,'prepaid',1);
INSERT INTO `Telecom_db`.`Numbers` VALUES('76-731-118',1,'postpaid',2);
INSERT INTO `Telecom_db`.`Numbers` VALUES('71-464-798',0,'prepaid',3);
INSERT INTO `Telecom_db`.`Numbers` VALUES('78-803-512',1,'prepaid',3);
INSERT INTO `Telecom_db`.`Numbers` VALUES('81-723-758',1,'postpaid',4);
INSERT INTO `Telecom_db`.`Numbers` VALUES('70-012-078',0,'prepaid',5);
INSERT INTO `Telecom_db`.`Numbers` VALUES('81-645-497',1,'prepaid',6);
INSERT INTO `Telecom_db`.`Numbers` VALUES('71-821-786',1,'postpaid',7);
INSERT INTO `Telecom_db`.`Numbers` VALUES('81-289-269',1,'postpaid',8);
INSERT INTO `Telecom_db`.`Numbers` VALUES('71-602-881',1,'prepaid',9);
INSERT INTO `Telecom_db`.`Numbers` VALUES('71-083-147',1,'prepaid',10);
INSERT INTO `Telecom_db`.`Numbers` VALUES('71-524-830',0,'postpaid',11);
INSERT INTO `Telecom_db`.`Numbers` VALUES('03-280-963',1,'prepaid',12);
INSERT INTO `Telecom_db`.`Numbers` VALUES('71-668-808',1,'postpaid',13);
INSERT INTO `Telecom_db`.`Numbers` VALUES('03-586-479',1,'postpaid',14);
INSERT INTO `Telecom_db`.`Numbers` VALUES('81-454-129',0,'prepaid',15);
INSERT INTO `Telecom_db`.`Numbers` VALUES('79-319-987',1,'postpaid',16);
INSERT INTO `Telecom_db`.`Numbers` VALUES('79-156-264',1,'prepaid',17);
INSERT INTO `Telecom_db`.`Numbers` VALUES('81-857-016',1,'prepaid',18);
INSERT INTO `Telecom_db`.`Numbers` VALUES('03-126-885',0,'postpaid',1);
INSERT INTO `Telecom_db`.`Numbers` VALUES('81-466-456',1,'postpaid',3);
INSERT INTO `Telecom_db`.`Numbers` VALUES('71-234-123',0,'prepaid',2);
INSERT INTO `Telecom_db`.`Numbers` VALUES('76-563-224',1,'postpaid',7);
INSERT INTO `Telecom_db`.`Numbers` VALUES('78-336-983',1,'prepaid',10);
INSERT INTO `Telecom_db`.`Numbers` VALUES('79-687-573',1,'postpaid',15);
INSERT INTO `Telecom_db`.`Numbers` VALUES('78-235-541',0,'prepaid',13);
INSERT INTO `Telecom_db`.`Numbers` VALUES('03-754-583',1,'postpaid',1);
INSERT INTO `Telecom_db`.`Numbers` VALUES('76-194-163',1,'postpaid',1);
INSERT INTO `Telecom_db`.`Numbers` VALUES('78-135-634',1,'prepaid',1);
INSERT INTO `Telecom_db`.`Numbers` VALUES('76-965-676',0,'prepaid',17);
INSERT INTO `Telecom_db`.`Numbers` VALUES('03-566-468',1,'postpaid',19);
INSERT INTO `Telecom_db`.`Numbers` VALUES('03-566-468',1,'postpaid',19);
INSERT INTO `Telecom_db`.`Numbers` VALUES('03-879-660',1,'postpaid',20);
INSERT INTO `Telecom_db`.`Numbers` VALUES('78-884-124',1,'postpaid',21);


--Table Services
    --to_date Function to convert date format 
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('Clip Alert',0.5,'71-234-123',TO_DATE('05/03/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('Clip Alert',0.5,'03-566-468',TO_DATE('14/8/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('Clip Alert',0.5,'78-235-541',TO_DATE('30/01/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('Clip Alert',0.5,'76-965-676',TO_DATE('12/06/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('Clip Alert',0.5,'78-135-634',TO_DATE('31/05/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('VIP',1.5,'79-131-124',TO_DATE('06/03/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('VIP',1.5,'71-234-123',TO_DATE('14/8/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('VIP',1.5,'78-235-541',TO_DATE('14/01/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('VIP',1.5,'81-645-497',TO_DATE('12/06/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('VIP',1.5,'71-821-786',TO_DATE('31/05/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('PRIVATE',3.0,'71-083-147',TO_DATE('06/07/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('PRIVATE',3.0,'71-524-830',TO_DATE('04/4/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('PRIVATE',3.0,'03-280-963',TO_DATE('14/12/2022', 'DD/MM/YYYY'));
INSERT INTO Services ("name",cost,subscribers,date_subscribed)
VALUES('PRIVATE',3.0,'78-135-634',TO_DATE('09/01/2022', 'DD/MM/YYYY'));




--Table plan
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('U-CHAT 9',9.0,'79-156-264',TO_DATE('14/04/2022', 'DD/MM/YYYY'));
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('U-CHAT 9',9.0,'71-234-123',TO_DATE('11/10/2022', 'DD/MM/YYYY'));
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('U-CHAT 9',9.0,'81-454-129',TO_DATE('09/09/2022', 'DD/MM/YYYY'));
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('U-CHAT 9',9.0,'71-464-798',TO_DATE('15/07/2022', 'DD/MM/YYYY'));
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('A+',15.0,'78-336-983',TO_DATE('06/07/2022', 'DD/MM/YYYY'));
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('A+',15.0,'81-466-456',TO_DATE('06/07/2022', 'DD/MM/YYYY'));
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('A+',15.0,'81-857-016',TO_DATE('06/07/2022', 'DD/MM/YYYY'));
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('A+',15.0,'78-803-512',TO_DATE('06/07/2022', 'DD/MM/YYYY'));
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('A+',15.0,'71-083-147',TO_DATE('06/07/2022', 'DD/MM/YYYY'));
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('U-CHAT 17',17.0,'76-965-676',TO_DATE('06/07/2022', 'DD/MM/YYYY'));
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('U-CHAT 17',17.0,'78-235-541',TO_DATE('06/07/2022', 'DD/MM/YYYY'));
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('U-CHAT 17',17.0,'03-280-963',TO_DATE('06/07/2022', 'DD/MM/YYYY'));
INSERT INTO plan ("name",cost,subscribers,date_subscribed)
VALUES('U-CHAT 17',17.0,'71-602-881',TO_DATE('06/07/2022', 'DD/MM/YYYY'));



--call_logs 
INSERT INTO Call_logs 
    (number_called,"Date/time",country_code,number_received,"duration",Termination_type)
VALUES
    ('03-586-479',TO_DATE('10/03/2022 12:30:59','DD/MM/YYYY HH24:MI:SS'),
    '+961','71-524-830','197','Singal Failure');
INSERT INTO Call_logs 
    (number_called,"Date/time",country_code,number_received,"duration",Termination_type)
VALUES
    ('71-821-786',TO_DATE('12/03/2022 8:10:25','DD/MM/YYYY HH24:MI:SS'),
    '+961','78-135-634','155','Singal Failure');
INSERT INTO Call_logs 
    (number_called,"Date/time",country_code,number_received,"duration",Termination_type)
VALUES
    ('76-194-163',TO_DATE('24/03/2022 09:30:07','DD/MM/YYYY HH24:MI:SS'),
    '+961','78-235-541','645','Singal Failure');
INSERT INTO Call_logs 
    (number_called,"Date/time",country_code,number_received,"duration",Termination_type)
VALUES
    ('03-754-583',TO_DATE('15/03/2022 1:30:15','DD/MM/YYYY HH24:MI:SS'),
    '+961','71-215-568','1112','Decline');
INSERT INTO Call_logs 
    (number_called,"Date/time",country_code,number_received,"duration",Termination_type)
VALUES
    ('81-857-016',TO_DATE('24/06/2022 2:30:15','DD/MM/YYYY HH24:MI:SS'),
    '+7','3-59874548','876','Decline');
INSERT INTO Call_logs 
    (number_called,"Date/time",country_code,number_received,"duration",Termination_type)
VALUES
    ('79-156-264',TO_DATE('05/06/2022 2:30:15','DD/MM/YYYY HH24:MI:SS'),
    '+1','91-59969739','4836','Decline');
INSERT INTO Call_logs 
    (number_called,"Date/time",country_code,number_received,"duration",Termination_type)
VALUES
    ('81-454-129',TO_DATE('19/07/2022 13:45:10','DD/MM/YYYY HH24:MI:SS'),
    '+1','42-633-365','3000','Decline');

--SMS/Logs
INSERT INTO "SMS/MMS_logs" 
    (number_sent,"Date/time",country_code,number_received,"Message Type",
    "Message Size")
VALUES
    ('71-524-830',TO_DATE('25/09/2022 10:00:00','DD/MM/YYYY HH24:MI:SS'),
    '+961','81-454-129','MMS',49.0);
INSERT INTO "SMS/MMS_logs" 
    (number_sent,"Date/time",country_code,number_received,"Message Type",
    "Message Size")
VALUES
    ('71-083-147',TO_DATE('12/07/2022 13:45:10','DD/MM/YYYY HH24:MI:SS'),
    '+961','79-156-264','SMS',0.1);
INSERT INTO "SMS/MMS_logs" 
    (number_sent,"Date/time",country_code,number_received,"Message Type",
    "Message Size")
VALUES
    ('03-280-963',TO_DATE('19/12/2022 21:00:10','DD/MM/YYYY HH24:MI:SS'),
    '+961','03-586-479','SMS',0.5); 
INSERT INTO "SMS/MMS_logs" 
    (number_sent,"Date/time",country_code,number_received,"Message Type",
    "Message Size")
VALUES
    ('79-319-987',TO_DATE('18/04/2022 9:30:00','DD/MM/YYYY HH24:MI:SS'),
    '+961','70-012-078','SMS',8.0);
INSERT INTO "SMS/MMS_logs" 
    (number_sent,"Date/time",country_code,number_received,"Message Type",
    "Message Size")
VALUES
    ('71-821-786',TO_DATE('21/08/2022 13:45:10','DD/MM/YYYY HH24:MI:SS'),'+1','42-633-365','MMS',13.5);
INSERT INTO "SMS/MMS_logs" 
    (number_sent,"Date/time",country_code,number_received,"Message Type",
    "Message Size")
VALUES
    ('81-289-269',TO_DATE('14/03/2022 07:15:00','DD/MM/YYYY HH24:MI:SS'),
    '+1','90-58848946','MMS',68.5);
INSERT INTO "SMS/MMS_logs" 
    (number_sent,"Date/time",country_code,number_received,"Message Type",
    "Message Size")
VALUES
    ('76-965-676',TO_DATE('11/06/2022 08:10:21','DD/MM/YYYY HH24:MI:SS'),
    '+963','89-618-465','MMS',90.5);


--Table Billings
--Define varaible for numbers
var number_check CHAR(11);
exec :number_check :='71-821-786';
INSERT INTO Billings (recharged_number,recharge_date,Total_cost)
VALUES ('71-821-786',TO_DATE('21/08/2022','DD/MM/YYYY'),
    (
        --Checking if Nested query return NULL if true return 0 for calcualtions
        SELECT DISTINCT CASE WHEN 
        (
            --checking if user sent and sms or mms to calculate fees 
            SELECT
            CASE WHEN "Message Type" ='SMS' 
            THEN "Message Size"*0.2 
            ELSE "Message Size"*1.2 END
            FROM "SMS/MMS_logs"
            WHERE  "SMS/MMS_logs".number_sent=:number_check
        ) IS NOT NULL 
        THEN 
        (
            --if true the total cost will be returned
            SELECT
            CASE WHEN "Message Type" ='SMS' 
            THEN "Message Size"*0.2 
            ELSE "Message Size"*1.2 END
            FROM "SMS/MMS_logs"
            WHERE  "SMS/MMS_logs".number_sent=:number_check
        )
        ELSE 0 
        END 
        AS Total_message_cost 
        FROM "SMS/MMS_logs"
        )+
        (
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(Call_logs."duration")
                    FROM Call_logs
                    WHERE Call_logs.number_called=:number_check
                    GROUP BY Call_logs.number_called
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(Call_logs."duration")
                    FROM Call_logs
                    WHERE Call_logs.number_called=:number_check
                    GROUP BY Call_logs.number_called
                )
            ELSE 0 
            END 
            AS Calculate_Total_Cost 
            FROM Call_logs
        )+
        (
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(Services.cost)
                    FROM  Services
                    WHERE Services.subscribers=:number_check
                    GROUP BY Services.subscribers
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(Services.cost)
                    FROM    Services
                    WHERE Services.subscribers=:number_check
                    GROUP BY Services.subscribers
                )
            ELSE 0 
            END 
            AS Total_Subs_Services_cost
            FROM Services
        )+(
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(plan.cost)
                    FROM    plan
                    WHERE plan.subscribers=:number_check
                    GROUP BY plan.subscribers
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(plan.cost)
                    FROM plan
                    WHERE plan.subscribers=:number_check
                    GROUP BY plan.subscribers
                )
            ELSE 0 
            END 
            AS Total_plan_cost
            FROM plan
        )
    );
var number_check CHAR(11);
exec :number_check :='71-234-123';
INSERT INTO Billings
    (recharged_number,recharge_date,Total_cost)
VALUES 
    ('71-234-123',TO_DATE('12/06/2022','DD/MM/YYYY'),
    (
        SELECT DISTINCT CASE WHEN 
        (
            SELECT
            CASE WHEN "Message Type" ='SMS' 
            THEN "Message Size"*0.2 
            ELSE "Message Size"*1.2 END
            FROM "SMS/MMS_logs"
            WHERE  "SMS/MMS_logs".number_sent=:number_check
        ) IS NOT NULL 
        THEN 
        (
            SELECT
            CASE WHEN "Message Type" ='SMS' 
            THEN "Message Size"*0.2 
            ELSE "Message Size"*1.2 END
            FROM "SMS/MMS_logs"
            WHERE  "SMS/MMS_logs".number_sent=:number_check
        )
        ELSE 0 
        END 
        AS Total_message_cost 
        FROM "SMS/MMS_logs"
        )+
        (
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(Call_logs."duration")
                    FROM Call_logs
                    WHERE Call_logs.number_called=:number_check
                    GROUP BY Call_logs.number_called
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(Call_logs."duration")
                    FROM Call_logs
                    WHERE Call_logs.number_called=:number_check
                    GROUP BY Call_logs.number_called
                )
            ELSE 0 
            END 
            AS Calculate_Total_Cost 
            FROM Call_logs
        )+
        (
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(Services.cost)
                    FROM  Services
                    WHERE Services.subscribers=:number_check
                    GROUP BY Services.subscribers
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(Services.cost)
                    FROM    Services
                    WHERE Services.subscribers=:number_check
                    GROUP BY Services.subscribers
                )
            ELSE 0 
            END 
            AS Total_Subs_Services_cost
            FROM Services
        )+(
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(plan.cost)
                    FROM    plan
                    WHERE plan.subscribers=:number_check
                    GROUP BY plan.subscribers
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(plan.cost)
                    FROM plan
                    WHERE plan.subscribers=:number_check
                    GROUP BY plan.subscribers
                )
            ELSE 0 
            END 
            AS Total_plan_cost
            FROM plan
        )
    );

var number_check CHAR(11);
exec :number_check :='81-857-016';
INSERT INTO Billings
    (recharged_number,recharge_date,Total_cost)
VALUES 
    ('81-857-016',TO_DATE('02/04/2022','DD/MM/YYYY'),
    (
        SELECT DISTINCT CASE WHEN 
        (
            SELECT
            CASE WHEN "Message Type" ='SMS' 
            THEN "Message Size"*0.2 
            ELSE "Message Size"*1.2 END
            FROM "SMS/MMS_logs"
            WHERE  "SMS/MMS_logs".number_sent=:number_check
        ) IS NOT NULL 
        THEN 
        (
            SELECT
            CASE WHEN "Message Type" ='SMS' 
            THEN "Message Size"*0.2 
            ELSE "Message Size"*1.2 END
            FROM "SMS/MMS_logs"
            WHERE  "SMS/MMS_logs".number_sent=:number_check
        )
        ELSE 0 
        END 
        AS Total_message_cost 
        FROM "SMS/MMS_logs"
        )+
        (
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(Call_logs."duration")
                    FROM Call_logs
                    WHERE Call_logs.number_called=:number_check
                    GROUP BY Call_logs.number_called
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(Call_logs."duration")
                    FROM Call_logs
                    WHERE Call_logs.number_called=:number_check
                    GROUP BY Call_logs.number_called
                )
            ELSE 0 
            END 
            AS Calculate_Total_Cost 
            FROM Call_logs
        )+
        (
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(Services.cost)
                    FROM  Services
                    WHERE Services.subscribers=:number_check
                    GROUP BY Services.subscribers
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(Services.cost)
                    FROM    Services
                    WHERE Services.subscribers=:number_check
                    GROUP BY Services.subscribers
                )
            ELSE 0 
            END 
            AS Total_Subs_Services_cost
            FROM Services
        )+(
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(plan.cost)
                    FROM    plan
                    WHERE plan.subscribers=:number_check
                    GROUP BY plan.subscribers
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(plan.cost)
                    FROM plan
                    WHERE plan.subscribers=:number_check
                    GROUP BY plan.subscribers
                )
            ELSE 0 
            END 
            AS Total_plan_cost
            FROM plan
        )
    );

var number_check CHAR(11);
exec :number_check :='03-586-479';
INSERT INTO Billings
    (recharged_number,recharge_date,Total_cost)
VALUES 
    ('03-586-479',TO_DATE('09/10/2022','DD/MM/YYYY'),
    (
        SELECT DISTINCT CASE WHEN 
        (
            SELECT
            CASE WHEN "Message Type" ='SMS' 
            THEN "Message Size"*0.2 
            ELSE "Message Size"*1.2 END
            FROM "SMS/MMS_logs"
            WHERE  "SMS/MMS_logs".number_sent=:number_check
        ) IS NOT NULL 
        THEN 
        (
            SELECT
            CASE WHEN "Message Type" ='SMS' 
            THEN "Message Size"*0.2 
            ELSE "Message Size"*1.2 END
            FROM "SMS/MMS_logs"
            WHERE  "SMS/MMS_logs".number_sent=:number_check
        )
        ELSE 0 
        END 
        AS Total_message_cost 
        FROM "SMS/MMS_logs"
        )+
        (
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(Call_logs."duration")
                    FROM Call_logs
                    WHERE Call_logs.number_called=:number_check
                    GROUP BY Call_logs.number_called
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(Call_logs."duration")
                    FROM Call_logs
                    WHERE Call_logs.number_called=:number_check
                    GROUP BY Call_logs.number_called
                )
            ELSE 0 
            END 
            AS Calculate_Total_Cost 
            FROM Call_logs
        )+
        (
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(Services.cost)
                    FROM  Services
                    WHERE Services.subscribers=:number_check
                    GROUP BY Services.subscribers
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(Services.cost)
                    FROM    Services
                    WHERE Services.subscribers=:number_check
                    GROUP BY Services.subscribers
                )
            ELSE 0 
            END 
            AS Total_Subs_Services_cost
            FROM Services
        )+(
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(plan.cost)
                    FROM    plan
                    WHERE plan.subscribers=:number_check
                    GROUP BY plan.subscribers
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(plan.cost)
                    FROM plan
                    WHERE plan.subscribers=:number_check
                    GROUP BY plan.subscribers
                )
            ELSE 0 
            END 
            AS Total_plan_cost
            FROM plan
        )
    );

var number_check CHAR(11);
exec :number_check :='81-289-269';
INSERT INTO Billings
    (recharged_number,recharge_date,Total_cost)
VALUES 
    ('81-289-269',TO_DATE('14/07/2022','DD/MM/YYYY'),
    (
        SELECT DISTINCT CASE WHEN 
        (
            SELECT
            CASE WHEN "Message Type" ='SMS' 
            THEN "Message Size"*0.2 
            ELSE "Message Size"*1.2 END
            FROM "SMS/MMS_logs"
            WHERE  "SMS/MMS_logs".number_sent=:number_check
        ) IS NOT NULL 
        THEN 
        (
            SELECT
            CASE WHEN "Message Type" ='SMS' 
            THEN "Message Size"*0.2 
            ELSE "Message Size"*1.2 END
            FROM "SMS/MMS_logs"
            WHERE  "SMS/MMS_logs".number_sent=:number_check
        )
        ELSE 0 
        END 
        AS Total_message_cost 
        FROM "SMS/MMS_logs"
        )+
        (
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(Call_logs."duration")
                    FROM Call_logs
                    WHERE Call_logs.number_called=:number_check
                    GROUP BY Call_logs.number_called
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(Call_logs."duration")
                    FROM Call_logs
                    WHERE Call_logs.number_called=:number_check
                    GROUP BY Call_logs.number_called
                )
            ELSE 0 
            END 
            AS Calculate_Total_Cost 
            FROM Call_logs
        )+
        (
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(Services.cost)
                    FROM  Services
                    WHERE Services.subscribers=:number_check
                    GROUP BY Services.subscribers
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(Services.cost)
                    FROM    Services
                    WHERE Services.subscribers=:number_check
                    GROUP BY Services.subscribers
                )
            ELSE 0 
            END 
            AS Total_Subs_Services_cost
            FROM Services
        )+(
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(plan.cost)
                    FROM    plan
                    WHERE plan.subscribers=:number_check
                    GROUP BY plan.subscribers
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(plan.cost)
                    FROM plan
                    WHERE plan.subscribers=:number_check
                    GROUP BY plan.subscribers
                )
            ELSE 0 
            END 
            AS Total_plan_cost
            FROM plan
        )
    );

var number_check CHAR(11);
exec :number_check :='71-083-147';
INSERT INTO Billings
    (recharged_number,recharge_date,Total_cost)
VALUES 
    ('71-083-147',TO_DATE('29/01/2022','DD/MM/YYYY'),
    (
        SELECT DISTINCT CASE WHEN 
        (
            SELECT
            CASE WHEN "Message Type" ='SMS' 
            THEN "Message Size"*0.2 
            ELSE "Message Size"*1.2 END
            FROM "SMS/MMS_logs"
            WHERE  "SMS/MMS_logs".number_sent=:number_check
        ) IS NOT NULL 
        THEN 
        (
            SELECT
            CASE WHEN "Message Type" ='SMS' 
            THEN "Message Size"*0.2 
            ELSE "Message Size"*1.2 END
            FROM "SMS/MMS_logs"
            WHERE  "SMS/MMS_logs".number_sent=:number_check
        )
        ELSE 0 
        END 
        AS Total_message_cost 
        FROM "SMS/MMS_logs"
        )+
        (
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(Call_logs."duration")
                    FROM Call_logs
                    WHERE Call_logs.number_called=:number_check
                    GROUP BY Call_logs.number_called
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(Call_logs."duration")
                    FROM Call_logs
                    WHERE Call_logs.number_called=:number_check
                    GROUP BY Call_logs.number_called
                )
            ELSE 0 
            END 
            AS Calculate_Total_Cost 
            FROM Call_logs
        )+
        (
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(Services.cost)
                    FROM  Services
                    WHERE Services.subscribers=:number_check
                    GROUP BY Services.subscribers
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(Services.cost)
                    FROM    Services
                    WHERE Services.subscribers=:number_check
                    GROUP BY Services.subscribers
                )
            ELSE 0 
            END 
            AS Total_Subs_Services_cost
            FROM Services
        )+(
            SELECT DISTINCT CASE WHEN 
                (
                    SELECT SUM(plan.cost)
                    FROM    plan
                    WHERE plan.subscribers=:number_check
                    GROUP BY plan.subscribers
                ) IS NOT NULL 
            THEN 
                (
                    SELECT SUM(plan.cost)
                    FROM plan
                    WHERE plan.subscribers=:number_check
                    GROUP BY plan.subscribers
                )
            ELSE 0 
            END 
            AS Total_plan_cost
            FROM plan
        )
    );

SELECT * FROM "SMS/MMS_logs";