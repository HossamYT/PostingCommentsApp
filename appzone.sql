-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema appzone
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema appzone
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `appzone` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema usersdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema usersdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `usersdb` DEFAULT CHARACTER SET utf8 ;
USE `appzone` ;

-- -----------------------------------------------------
-- Table `appzone`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `appzone`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `appzone`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `appzone`.`comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(150) NOT NULL,
  `status` INT(11) NOT NULL,
  `creation_date` DATETIME NULL DEFAULT NULL,
  `approved_date` DATETIME NULL DEFAULT NULL,
  `user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_comment_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_comment_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `appzone`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `usersdb` ;

-- -----------------------------------------------------
-- Table `usersdb`.`app_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersdb`.`app_user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `sso_id` VARCHAR(30) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `first_name` VARCHAR(30) NOT NULL,
  `last_name` VARCHAR(30) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `sso_id` (`sso_id` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `usersdb`.`user_profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersdb`.`user_profile` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `type` (`type` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `usersdb`.`app_user_user_profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersdb`.`app_user_user_profile` (
  `user_id` BIGINT(20) NOT NULL,
  `user_profile_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`user_id`, `user_profile_id`),
  INDEX `FK_USER_PROFILE` (`user_profile_id` ASC),
  CONSTRAINT `FK_APP_USER`
    FOREIGN KEY (`user_id`)
    REFERENCES `usersdb`.`app_user` (`id`),
  CONSTRAINT `FK_USER_PROFILE`
    FOREIGN KEY (`user_profile_id`)
    REFERENCES `usersdb`.`user_profile` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `usersdb`.`persistent_logins`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usersdb`.`persistent_logins` (
  `username` VARCHAR(64) NOT NULL,
  `series` VARCHAR(64) NOT NULL,
  `token` VARCHAR(64) NOT NULL,
  `last_used` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
