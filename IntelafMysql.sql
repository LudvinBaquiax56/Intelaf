-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Intelaf
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Intelaf
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Intelaf` ;
USE `Intelaf` ;

-- -----------------------------------------------------
-- Table `Intelaf`.`Tienda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Intelaf`.`Tienda` (
  `Codigo` VARCHAR(20) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(20) NOT NULL,
  `Telefono2` VARCHAR(20) NULL,
  `Correo_Electronico` VARCHAR(45) NULL,
  `Horario` VARCHAR(65) NULL,
  PRIMARY KEY (`Codigo`),
  UNIQUE INDEX `Codigo_UNIQUE` (`Codigo` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Intelaf`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Intelaf`.`Cliente` (
  `NIT` VARCHAR(20) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(20) NOT NULL,
  `Credito_De_Compra` DOUBLE NOT NULL,
  `DPI` VARCHAR(20) NULL,
  `Correo_Electronico` VARCHAR(55) NULL,
  `Direccion` VARCHAR(90) NULL,
  PRIMARY KEY (`NIT`),
  UNIQUE INDEX `NIT_UNIQUE` (`NIT` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Intelaf`.`Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Intelaf`.`Venta` (
  `idVenta` INT NOT NULL AUTO_INCREMENT,
  `Total` DOUBLE NOT NULL,
  `Fecha` DATE NOT NULL,
  `Tienda_Codigo` VARCHAR(20) NOT NULL,
  `Cliente_NIT` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idVenta`, `Tienda_Codigo`, `Cliente_NIT`),
  INDEX `fk_Venta_Tienda1_idx` (`Tienda_Codigo` ASC) ,
  INDEX `fk_Venta_Cliente1_idx` (`Cliente_NIT` ASC) ,
  CONSTRAINT `fk_Venta_Tienda1`
    FOREIGN KEY (`Tienda_Codigo`)
    REFERENCES `Intelaf`.`Tienda` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Cliente1`
    FOREIGN KEY (`Cliente_NIT`)
    REFERENCES `Intelaf`.`Cliente` (`NIT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Intelaf`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Intelaf`.`Pedido` (
  `Codigo` VARCHAR(20) NOT NULL,
  `Tienda_Origen` VARCHAR(20) NOT NULL,
  `Tienda_Destino` VARCHAR(20) NOT NULL,
  `Fecha` DATE NOT NULL,
  `Cliente_NIT` VARCHAR(20) NOT NULL,
  `Total` DOUBLE NOT NULL,
  `Anticipo` DOUBLE NOT NULL,
  PRIMARY KEY (`Codigo`),
  INDEX `fk_Pedido_Tienda1_idx` (`Tienda_Origen` ASC) ,
  INDEX `fk_Pedido_Tienda2_idx` (`Tienda_Destino` ASC) ,
  INDEX `fk_Pedido_Cliente1_idx` (`Cliente_NIT` ASC) ,
  CONSTRAINT `fk_Pedido_Tienda1`
    FOREIGN KEY (`Tienda_Origen`)
    REFERENCES `Intelaf`.`Tienda` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Tienda2`
    FOREIGN KEY (`Tienda_Destino`)
    REFERENCES `Intelaf`.`Tienda` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Cliente1`
    FOREIGN KEY (`Cliente_NIT`)
    REFERENCES `Intelaf`.`Cliente` (`NIT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Intelaf`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Intelaf`.`Producto` (
  `Codigo` VARCHAR(20) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Fabricante` VARCHAR(45) NOT NULL,
  `Precio` DOUBLE NOT NULL,
  `Descripccion` VARCHAR(200) NULL,
  `Garantia` INT NULL,
  PRIMARY KEY (`Codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Intelaf`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Intelaf`.`Empleado` (
  `Codigo` VARCHAR(15) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(20) NOT NULL,
  `DPI` VARCHAR(20) NOT NULL,
  `NIT` VARCHAR(20) NULL,
  `Correo_Electronico` VARCHAR(45) NULL,
  `Direccion` VARCHAR(45) NULL,
  PRIMARY KEY (`Codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Intelaf`.`Tiempo_Entre_Tiendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Intelaf`.`Tiempo_Entre_Tiendas` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Dias` INT NOT NULL,
  `Tienda_Codigo` VARCHAR(20) NOT NULL,
  `Tienda_Codigo1` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Tiempo_Entre_Tiendas_Tienda1_idx` (`Tienda_Codigo` ASC) ,
  INDEX `fk_Tiempo_Entre_Tiendas_Tienda2_idx` (`Tienda_Codigo1` ASC) ,
  CONSTRAINT `fk_Tiempo_Entre_Tiendas_Tienda1`
    FOREIGN KEY (`Tienda_Codigo`)
    REFERENCES `Intelaf`.`Tienda` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tiempo_Entre_Tiendas_Tienda2`
    FOREIGN KEY (`Tienda_Codigo1`)
    REFERENCES `Intelaf`.`Tienda` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Intelaf`.`Detalle_Producto_En_Tienda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Intelaf`.`Detalle_Producto_En_Tienda` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Producto_Codigo` VARCHAR(20) NULL,
  `Tienda_Codigo` VARCHAR(20) NULL,
  `cantidad` INT NOT NULL,
  INDEX `fk_Producto_has_Tienda_Tienda1_idx` (`Tienda_Codigo` ASC) ,
  INDEX `fk_Producto_has_Tienda_Producto_idx` (`Producto_Codigo` ASC) ,
  PRIMARY KEY (`Id`),
  CONSTRAINT `fk_Producto_has_Tienda_Producto`
    FOREIGN KEY (`Producto_Codigo`)
    REFERENCES `Intelaf`.`Producto` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Tienda_Tienda1`
    FOREIGN KEY (`Tienda_Codigo`)
    REFERENCES `Intelaf`.`Tienda` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Intelaf`.`Detalle_Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Intelaf`.`Detalle_Pedido` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Producto_Codigo` VARCHAR(20) NOT NULL,
  `Pedido_Codigo` VARCHAR(20) NOT NULL,
  `Cantidad` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_Producto_has_Pedido_Pedido1_idx` (`Pedido_Codigo` ASC) ,
  INDEX `fk_Producto_has_Pedido_Producto1_idx` (`Producto_Codigo` ASC) ,
  CONSTRAINT `fk_Producto_has_Pedido_Producto1`
    FOREIGN KEY (`Producto_Codigo`)
    REFERENCES `Intelaf`.`Producto` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Pedido_Pedido1`
    FOREIGN KEY (`Pedido_Codigo`)
    REFERENCES `Intelaf`.`Pedido` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Intelaf`.`Detalle_Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Intelaf`.`Detalle_Venta` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Producto_Codigo` VARCHAR(20) NOT NULL,
  `Venta_idVenta` INT NOT NULL,
  `Cantidad` INT NOT NULL,
  `Sub_Total` DOUBLE NOT NULL,
  INDEX `fk_Producto_has_Venta_Venta1_idx` (`Venta_idVenta` ASC) ,
  INDEX `fk_Producto_has_Venta_Producto1_idx` (`Producto_Codigo` ASC) ,
  PRIMARY KEY (`Id`, `Sub_Total`),
  CONSTRAINT `fk_Producto_has_Venta_Producto1`
    FOREIGN KEY (`Producto_Codigo`)
    REFERENCES `Intelaf`.`Producto` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_has_Venta_Venta1`
    FOREIGN KEY (`Venta_idVenta`)
    REFERENCES `Intelaf`.`Venta` (`idVenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
