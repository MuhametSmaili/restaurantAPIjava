-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema restaurantdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema restaurantdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `restaurantdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `restaurantdb` ;

-- -----------------------------------------------------
-- Table `restaurantdb`.`food`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantdb`.`food` (
  `food_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`food_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `restaurantdb`.`persons`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantdb`.`persons` (
  `person_id` INT(11) NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `birthday` DATE NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `surname` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`person_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `restaurantdb`.`order_food`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantdb`.`order_food` (
  `order_id` INT(11) NOT NULL AUTO_INCREMENT,
  `order_date` DATE NULL DEFAULT NULL,
  `total_price` DOUBLE NULL DEFAULT NULL,
  `type_of_payment` VARCHAR(255) NULL DEFAULT NULL,
  `person_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `FKik63wlqd4xrkxp25ctfue6skm` (`person_id` ASC) VISIBLE,
  CONSTRAINT `FKik63wlqd4xrkxp25ctfue6skm`
    FOREIGN KEY (`person_id`)
    REFERENCES `restaurantdb`.`persons` (`person_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `restaurantdb`.`order_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantdb`.`order_details` (
  `order_details_id` INT(11) NOT NULL AUTO_INCREMENT,
  `price_unit` DOUBLE NULL DEFAULT NULL,
  `quantity` INT(11) NULL DEFAULT NULL,
  `food` INT(11) NULL DEFAULT NULL,
  `order_food_order_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_details_id`),
  INDEX `FKqqfksaj2qey1sloerv2lrp3w7` (`food` ASC) VISIBLE,
  INDEX `FKq4n76d6dncsdktwv3hou9ub9k` (`order_food_order_id` ASC) VISIBLE,
  CONSTRAINT `FKq4n76d6dncsdktwv3hou9ub9k`
    FOREIGN KEY (`order_food_order_id`)
    REFERENCES `restaurantdb`.`order_food` (`order_id`),
  CONSTRAINT `FKqqfksaj2qey1sloerv2lrp3w7`
    FOREIGN KEY (`food`)
    REFERENCES `restaurantdb`.`food` (`food_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `restaurantdb`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantdb`.`roles` (
  `role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `restaurantdb`.`persons_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantdb`.`persons_role` (
  `persons_person_id` INT(11) NOT NULL,
  `role_role_id` INT(11) NOT NULL,
  INDEX `FKsb7hah8v1bme7cgwxhba5uuar` (`role_role_id` ASC) VISIBLE,
  INDEX `FKk559gkje476lss8laxsl89enj` (`persons_person_id` ASC) VISIBLE,
  CONSTRAINT `FKk559gkje476lss8laxsl89enj`
    FOREIGN KEY (`persons_person_id`)
    REFERENCES `restaurantdb`.`persons` (`person_id`),
  CONSTRAINT `FKsb7hah8v1bme7cgwxhba5uuar`
    FOREIGN KEY (`role_role_id`)
    REFERENCES `restaurantdb`.`roles` (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `restaurantdb`.`roles_persons_list_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `restaurantdb`.`roles_persons_list_role` (
  `roles_role_id` INT(11) NOT NULL,
  `persons_list_role_person_id` INT(11) NOT NULL,
  INDEX `FKjq5vl9ur043mpalivofjlnk2x` (`persons_list_role_person_id` ASC) VISIBLE,
  INDEX `FKq7ttwawyya0kly683fhqu7y8u` (`roles_role_id` ASC) VISIBLE,
  CONSTRAINT `FKjq5vl9ur043mpalivofjlnk2x`
    FOREIGN KEY (`persons_list_role_person_id`)
    REFERENCES `restaurantdb`.`persons` (`person_id`),
  CONSTRAINT `FKq7ttwawyya0kly683fhqu7y8u`
    FOREIGN KEY (`roles_role_id`)
    REFERENCES `restaurantdb`.`roles` (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
