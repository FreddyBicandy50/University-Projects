CREATE TABLE `teachers`(
    `Teacher_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `school_id` BIGINT NOT NULL,
    `first_name` TEXT NOT NULL,
    `middle_name` TEXT NULL,
    `last_name` TEXT NOT NULL,
    `teaching_subject` TEXT NOT NULL,
    `teacher_email` LONGTEXT NOT NULL,
    `teacher_password` LONGTEXT NOT NULL
);
ALTER TABLE `teachers` AUTO_INCREMENT = 5020230000;  

CREATE TABLE `students`(
    `student_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` TEXT NOT NULL,
    `middle_name` TEXT NULL,
    `lastname` TEXT NOT NULL,
    `address` TEXT NOT NULL,
    `school_email` LONGTEXT NOT NULL,
    `password` LONGTEXT NOT NULL
);
ALTER TABLE `students` AUTO_INCREMENT = 8020230000; 
 
CREATE TABLE `schools`(
    `school_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `school_name` BIGINT NOT NULL,
    `school_address` TEXT NOT NULL,
    `school_owner` TEXT NOT NULL
);
ALTER TABLE `schools` AUTO_INCREMENT = 1020230000; 

CREATE TABLE `app`(
    `student_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `school_code` BIGINT NOT NULL
);
CREATE TABLE `classes`(
    `grade` TEXT NOT NULL,
    `student_id` BIGINT NULL,
    `teacher_id` BIGINT NULL
);
ALTER TABLE
    `classes` ADD UNIQUE `classes_student_id_unique`(`student_id`);
 