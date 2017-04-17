CREATE schema IF NOT EXISTS $schema_name;

CREATE TABLE IF NOT EXISTS `$schema_name`.`users` (
  `idusers` INT NOT NULL AUTO_INCREMENT,
  `createddatetime` LONG NOT NULL,
  `lastupdateddatetime` LONG NOT NULL,
  `fullname` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `authhash` CHAR(72) NOT NULL,
  `rootadmin` BIT(1) NOT NULL,
  `banned`  BIT(1) NOT NULL,
  `banneddatetime` LONG,
  PRIMARY KEY (`idusers`),
  UNIQUE INDEX `idusers_UNIQUE` (`idusers` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC));


CREATE TABLE IF NOT EXISTS  `$schema_name`.`groups` (
  `idgroups` INT NOT NULL AUTO_INCREMENT,
  `createddatetime` LONG NOT NULL,
  `lastupdateddatetime` LONG NOT NULL,
  `groupname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idgroups`),
  UNIQUE INDEX `idgroups_UNIQUE` (`idgroups` ASC),
  UNIQUE INDEX `groupname_UNIQUE` (`groupname` ASC));


CREATE TABLE IF NOT EXISTS `$schema_name`.`user2group` (
  `idusers` INT NOT NULL,
  `lastupdateddatetime` LONG NOT NULL,
  `idgroups` INT NOT NULL);

CREATE TABLE IF NOT EXISTS `$schema_name`.`routeentities` (
  `idrouteentities` INT NOT NULL,
  `parentid` INT,
  `name` VARCHAR(45) NOT NULL,
  `type` INT NOT NULL,
  `pageid` INT,
  PRIMARY KEY (`idrouteentities`),
  UNIQUE INDEX `idrouteentities_UNIQUE` (`idrouteentities` ASC));

CREATE TABLE IF NOT EXISTS `$schema_name`.`resetpassword` (
  `idresetpasswords` INT NOT NULL AUTO_INCREMENT,
  `createddatetime` LONG NOT NULL,
  `lastupdateddatetime` LONG NOT NULL,
  `banneddatetime` LONG,
  `idusers` INT NOT NULL,
  `authhash` VARCHAR(100) NOT NULL,
  `expired` BIT(1) NOT NULL,
  PRIMARY KEY (`idresetpasswords`),
  UNIQUE INDEX `idresetpasswords_UNIQUE` (`idresetpasswords` ASC),
  UNIQUE INDEX `idusers_UNIQUE` (`idusers` ASC));