-- MySQL Script generated by MySQL Workbench
-- Sun May 29 18:47:48 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MoviesSP
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `MoviesSP` ;

-- -----------------------------------------------------
-- Schema MoviesSP
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MoviesSP` DEFAULT CHARACTER SET utf8 ;
USE `MoviesSP` ;

-- -----------------------------------------------------
-- Table `MoviesSP`.`movies`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MoviesSP`.`movies` ;

CREATE TABLE IF NOT EXISTS `MoviesSP`.`movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `image` VARCHAR(45) NULL,
  `title` VARCHAR(45) NULL,
  `creation_date` DATE NULL,
  `rate` INT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MoviesSP`.`genres`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MoviesSP`.`genres` ;

CREATE TABLE IF NOT EXISTS `MoviesSP`.`genres` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `image` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MoviesSP`.`characters`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MoviesSP`.`characters` ;

CREATE TABLE IF NOT EXISTS `MoviesSP`.`characters` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `image` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  `weight` DOUBLE NULL,
  `history` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MoviesSP`.`movies_genres`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MoviesSP`.`movies_genres` ;

CREATE TABLE IF NOT EXISTS `MoviesSP`.`movies_genres` (
  `genres_id` INT NOT NULL,
  `movies_id` INT NOT NULL,
  PRIMARY KEY (`genres_id`, `movies_id`),
  INDEX `fk_genres_has_movies_movies1_idx` (`movies_id` ASC) VISIBLE,
  INDEX `fk_genres_has_movies_genres_idx` (`genres_id` ASC) VISIBLE,
  CONSTRAINT `fk_genres_has_movies_genres`
    FOREIGN KEY (`genres_id`)
    REFERENCES `MoviesSP`.`genres` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_genres_has_movies_movies1`
    FOREIGN KEY (`movies_id`)
    REFERENCES `MoviesSP`.`movies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MoviesSP`.`movies_characters`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MoviesSP`.`movies_characters` ;

CREATE TABLE IF NOT EXISTS `MoviesSP`.`movies_characters` (
  `movies_id` INT NOT NULL,
  `characters_id` INT NOT NULL,
  PRIMARY KEY (`movies_id`, `characters_id`),
  INDEX `fk_movies_has_characters_characters1_idx` (`characters_id` ASC) VISIBLE,
  INDEX `fk_movies_has_characters_movies1_idx` (`movies_id` ASC) VISIBLE,
  CONSTRAINT `fk_movies_has_characters_movies1`
    FOREIGN KEY (`movies_id`)
    REFERENCES `MoviesSP`.`movies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movies_has_characters_characters1`
    FOREIGN KEY (`characters_id`)
    REFERENCES `MoviesSP`.`characters` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
