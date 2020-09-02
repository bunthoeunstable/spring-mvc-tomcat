CREATE DATABASE IF NOT EXISTS spring_mvc;

USE spring_mvc;

DROP TABLE IF EXISTS `spring_mvc`.`USERS`;

CREATE TABLE `spring_mvc`.`USERS` (
  `ID` INT AUTO_INCREMENT NOT NULL,
  `USERNAME` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  `FIRST_NAME` VARCHAR(45) NOT NULL,
  `LAST_NAME` VARCHAR(45) NULL,
  `EMAIL` VARCHAR(45) NULL,
  `ADDRESS` VARCHAR(255) NULL,
  `PHONE` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`));