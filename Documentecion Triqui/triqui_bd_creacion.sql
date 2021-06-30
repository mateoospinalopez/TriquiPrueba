-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema triqui_bd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema triqui_bd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `triqui_bd` DEFAULT CHARACTER SET utf8 ;
USE `triqui_bd` ;

-- -----------------------------------------------------
-- Table `triqui_bd`.`jugador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `triqui_bd`.`jugador` (
  `id_jugador` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `puntaje` INT NULL,
  PRIMARY KEY (`id_jugador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `triqui_bd`.`juego`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `triqui_bd`.`juego` (
  `id_juego` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NULL,
  PRIMARY KEY (`id_juego`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `triqui_bd`.`ganador_juego`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `triqui_bd`.`ganador_juego` (
  `jugador_id_jugador` INT NOT NULL,
  `juego_id_juego` INT NOT NULL,
  `ganador` VARCHAR(45) NULL,
  PRIMARY KEY (`jugador_id_jugador`, `juego_id_juego`),
  INDEX `fk_jugador_has_juego_juego1_idx` (`juego_id_juego` ASC) VISIBLE,
  INDEX `fk_jugador_has_juego_jugador_idx` (`jugador_id_jugador` ASC) VISIBLE,
  CONSTRAINT `fk_jugador_has_juego_jugador`
    FOREIGN KEY (`jugador_id_jugador`)
    REFERENCES `triqui_bd`.`jugador` (`id_jugador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_jugador_has_juego_juego1`
    FOREIGN KEY (`juego_id_juego`)
    REFERENCES `triqui_bd`.`juego` (`id_juego`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
