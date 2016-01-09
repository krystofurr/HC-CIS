
-- d888b  db    db d88888b .d8888. d888888b   d8888b.  .d88b.   .d88b.  db   dD
-- 88' Y8b 88    88 88'     88'  YP `~~88~~'   88  `8D .8P  Y8. .8P  Y8. 88 ,8P'
-- 88      88    88 88ooooo `8bo.      88      88oooY' 88    88 88    88 88,8P
-- 88  ooo 88    88 88~~~~~   `Y8b.    88      88~~~b. 88    88 88    88 88`8b
-- 88. ~8~ 88b  d88 88.     db   8D    88      88   8D `8b  d8' `8b  d8' 88 `88.
-- Y888P  ~Y8888P' Y88888P `8888Y'    YP      Y8888P'  `Y88P'   `Y88P'  YP   YD
--
--
-- Program name:       Assignment 2 - Guest Book
-- Author:             Christopher Sigouin
-- Version:            1.0
-- Description:        A guest book  web application with user registration and authentication
-- Dependencies:       See README
-- Database file:      db/database.sql
-- Change History:     2015.10.03 Original version by CJS


-- -----------------------------------------------------
-- Create `GuestBookDB`
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `GuestBookDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `GuestBookDB` ;

-- -----------------------------------------------------
-- Table `GuestBookDB`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuestBookDB`.`Users` (
  `user_ID` INT NOT NULL AUTO_INCREMENT,
  `user_Username` VARCHAR(45) NULL,
  `user_Password` VARCHAR(255) NULL,
  `user_Date_Registered` INT NULL,
  PRIMARY KEY (`user_ID`))
ENGINE = InnoDB
COMMENT = 'Table that will hold all users successfully registered';

-- -----------------------------------------------------
-- Table `GuestBookDB`.`Comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GuestBookDB`.`Comments` (
  `comm_ID` INT NOT NULL AUTO_INCREMENT,
  `comm_Title` VARCHAR(50) NULL,
  `comm_Body` VARCHAR(500) NULL,
  `comm_Date_Posted` INT NULL,
  `user_ID` INT NULL,
  PRIMARY KEY (`comm_ID`),
  INDEX `user_ID_idx` (`user_ID` ASC),
  CONSTRAINT `user_ID`
    FOREIGN KEY (`user_ID`)
    REFERENCES `GuestBookDB`.`Users` (`user_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'Table that will hold all user comments posted';

-- -----------------------------------------------------
-- Insert any desired users for the GuestBook
-- -----------------------------------------------------
-- The 'admin' user password is inserted as a hashed value ( value is "password").  This is only
-- for the Assignment because MySQL does not have a native bcrypt function.
insert into Users ( user_Username, user_Password, user_Date_Registered ) values ( 'admin', '$2y$12$um02G9GHEM2E6IgNOldqXe/ZU4D09K/69rJEUHVsomYYqMfqOfx76', UNIX_TIMESTAMP(NOW()) );
insert into Users ( user_Username, user_Password, user_Date_Registered ) values ( 'John', '$2y$12$B5hjFbFKsXH07Z1U6dCVqu5sixpe05iq.aMpd409icHqkWzf6DNkm', UNIX_TIMESTAMP(NOW()) );
insert into Users ( user_Username, user_Password, user_Date_Registered ) values ( 'Sally', '$2y$12$0DW/Rqsfi.qnSDhaOrJNsuT6zaXN6FLoTkr2d2QqFHY622VkOeK.6', UNIX_TIMESTAMP(NOW()) );

-- -----------------------------------------------------
-- Insert data into 'Comments' table for testing
-- -----------------------------------------------------
insert into Comments ( comm_Title, comm_Body, comm_Date_Posted, user_ID ) values ( 'John\'s Comment', 'This is John\'s comment here.  This is John\'s comment here.  This is John\'s comment here.  This is John\'s comment here.  This is John\'s comment here.  This is John\'s comment here.  This is John\'s comment here.  This is John\'s comment here.  This is John\'s comment here.  This is John\'s comment here.  ', UNIX_TIMESTAMP(NOW()), 2  );
insert into Comments ( comm_Title, comm_Body, comm_Date_Posted, user_ID ) values ( 'Sally\'s Comment', 'This is Sally\'s comment here.  This is Sally\'s comment here.  This is Sally\'s comment here.  This is Sally\'s comment here.  This is Sally\'s comment here.  This is Sally\'s comment here.  This is Sally\'s comment here.  This is Sally\'s comment here.  This is Sally\'s comment here.  This is Sally\'s comment here.  This is Sally\'s comment here.  This is Sally\'s comment here.  ', UNIX_TIMESTAMP(NOW()), 3 );

-- -----------------------------------------------------
-- Grant User Privileges
-- -----------------------------------------------------
GRANT SELECT, INSERT, UPDATE, DELETE ON `GuestBookDB`.* TO 'guestBookUser'@'localhost' IDENTIFIED BY 'guestBookPassword';
FLUSH PRIVILEGES;
