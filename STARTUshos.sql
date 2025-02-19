-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: SRV-1208-1    Database: kalugin
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `absents`
--

DROP TABLE IF EXISTS `absents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `absents` (
  `idAbsent` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `dateStart` date DEFAULT NULL,
  `dateEnd` date DEFAULT NULL,
  `employee` int DEFAULT NULL,
  PRIMARY KEY (`idAbsent`),
  KEY `absents_employees_FK` (`employee`),
  CONSTRAINT `absents_employees_FK` FOREIGN KEY (`employee`) REFERENCES `employees` (`EmployeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `absents`
--

LOCK TABLES `absents` WRITE;
/*!40000 ALTER TABLE `absents` DISABLE KEYS */;
INSERT INTO `absents` VALUES (1,NULL,'2010-01-01','2011-01-01',2);
/*!40000 ALTER TABLE `absents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicants`
--

DROP TABLE IF EXISTS `applicants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applicants` (
  `idApplicant` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `secondName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `middleName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `post` int NOT NULL,
  `meNumber` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idApplicant`),
  KEY `applicants_posts_FK` (`post`),
  CONSTRAINT `applicants_posts_FK` FOREIGN KEY (`post`) REFERENCES `positions` (`PositionID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicants`
--

LOCK TABLES `applicants` WRITE;
/*!40000 ALTER TABLE `applicants` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendarevents`
--

DROP TABLE IF EXISTS `calendarevents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendarevents` (
  `idCalendarEvent` int NOT NULL AUTO_INCREMENT,
  `employee` int DEFAULT NULL,
  `event` int DEFAULT NULL,
  PRIMARY KEY (`idCalendarEvent`),
  KEY `calendarevents_events_FK` (`event`),
  KEY `calendarevents_employees_FK` (`employee`),
  CONSTRAINT `calendarevents_employees_FK` FOREIGN KEY (`employee`) REFERENCES `employees` (`EmployeeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `calendarevents_events_FK` FOREIGN KEY (`event`) REFERENCES `events` (`idEvent`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendarevents`
--

LOCK TABLES `calendarevents` WRITE;
/*!40000 ALTER TABLE `calendarevents` DISABLE KEYS */;
/*!40000 ALTER TABLE `calendarevents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classifications`
--

DROP TABLE IF EXISTS `classifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classifications` (
  `idClassification` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idClassification`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classifications`
--

LOCK TABLES `classifications` WRITE;
/*!40000 ALTER TABLE `classifications` DISABLE KEYS */;
/*!40000 ALTER TABLE `classifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `idComment` int NOT NULL AUTO_INCREMENT,
  `idDocument` int DEFAULT NULL,
  `text` text,
  `dateCreate` datetime DEFAULT NULL,
  `dateUpdate` datetime DEFAULT NULL,
  `autor` int DEFAULT NULL,
  PRIMARY KEY (`idComment`),
  KEY `comment_employees_FK` (`autor`),
  KEY `comment_document_FK` (`idDocument`),
  CONSTRAINT `comment_document_FK` FOREIGN KEY (`idDocument`) REFERENCES `document` (`idDocument`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_employees_FK` FOREIGN KEY (`autor`) REFERENCES `employees` (`EmployeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1,'Оооо','2010-01-01 00:00:00','2011-10-10 00:00:00',1),(2,1,'Классс','2020-01-01 00:00:00','2021-01-01 00:00:00',1);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `DepartmentID` int NOT NULL AUTO_INCREMENT,
  `DepartmentName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`DepartmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'Дороги России','1'),(2,'Административный отдел','11'),(3,'Академия Умные дороги','12'),(4,'Договорной отдел','111'),(5,'Общий отдел','112'),(6,'Управление маркетинга','1121'),(7,'Лицензионный отдел','1122'),(8,'Управление безопасности','17'),(9,'Отдел привлечения','531');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document` (
  `idDocument` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `dateCreate` datetime DEFAULT NULL,
  `dateUpdate` datetime DEFAULT NULL,
  `categoryDocument` varchar(100) DEFAULT NULL,
  `hasComents` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idDocument`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (1,'Документ о','2010-10-10 00:00:00','2020-10-01 00:00:00',NULL,1);
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educations`
--

DROP TABLE IF EXISTS `educations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `educations` (
  `idEducation` int NOT NULL AUTO_INCREMENT,
  `dateStart` date DEFAULT NULL,
  `dateEnd` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `classification` int DEFAULT NULL,
  PRIMARY KEY (`idEducation`),
  KEY `educations_classifications_FK` (`classification`),
  CONSTRAINT `educations_classifications_FK` FOREIGN KEY (`classification`) REFERENCES `classifications` (`idClassification`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educations`
--

LOCK TABLES `educations` WRITE;
/*!40000 ALTER TABLE `educations` DISABLE KEYS */;
INSERT INTO `educations` VALUES (1,'2010-02-02','2020-01-01',NULL,NULL);
/*!40000 ALTER TABLE `educations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `EmployeeID` int NOT NULL AUTO_INCREMENT,
  `PositionID` int NOT NULL,
  `Department` int NOT NULL,
  `Name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Surname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Patronymic` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `WorkPhone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `PersonalNumber` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Office` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CorporateEmail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `login` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EmployeeID`),
  KEY `employees_posts_FK` (`PositionID`),
  KEY `employees_divisions_FK` (`Department`),
  CONSTRAINT `employees_departments_FK` FOREIGN KEY (`Department`) REFERENCES `departments` (`DepartmentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `employees_posts_FK` FOREIGN KEY (`PositionID`) REFERENCES `positions` (`PositionID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,1,9,'Олегu','Олег','Олег','89412987485','89412987485','1234','gmail@gmail.com','2010-01-01','123','11','{jhji'),(2,1,1,'Козлов','Зайцев','Олегович','89412987485','89412987485','1234','gmail@gmail.com','2010-01-01','123','00','Gkj['),(3,1,1,'Игорь','Олегов','Олегович','89412987485','89412987485','1234','gmail@gmail.com','2010-01-01','123','99','Gkj['),(4,1,1,'Игор','Игорёв','Игоревич','89419387584','89412987485','1234','gmail@gmail.com','1238-10-17','123','88','4'),(6,3,2,'Кхмблинязабыл','Сальников','Владиславович','89476566473','89476566473','43543','jFormattedTextField5',NULL,'123','77',NULL),(7,1,1,'Игорь','Олегов','Олегович','89412987485','89412987485','345346','gmail@gmail.com','2010-01-01','123','66',NULL);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeeseducations`
--

DROP TABLE IF EXISTS `employeeseducations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employeeseducations` (
  `idEployeeEducation` int NOT NULL AUTO_INCREMENT,
  `employee` int DEFAULT NULL,
  `education` int DEFAULT NULL,
  PRIMARY KEY (`idEployeeEducation`),
  KEY `employeeseducations_employees_FK` (`employee`),
  KEY `employeeseducations_educations_FK` (`education`),
  CONSTRAINT `employeeseducations_educations_FK` FOREIGN KEY (`education`) REFERENCES `educations` (`idEducation`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `employeeseducations_employees_FK` FOREIGN KEY (`employee`) REFERENCES `employees` (`EmployeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeeseducations`
--

LOCK TABLES `employeeseducations` WRITE;
/*!40000 ALTER TABLE `employeeseducations` DISABLE KEYS */;
INSERT INTO `employeeseducations` VALUES (1,1,1);
/*!40000 ALTER TABLE `employeeseducations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events` (
  `idEvent` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `statusEvent` int DEFAULT NULL,
  `typeEvent` int DEFAULT NULL,
  `dateTimeEvent` datetime DEFAULT NULL,
  `responsible` int DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idEvent`),
  KEY `events_statusesevents_FK` (`statusEvent`),
  KEY `events_typesevents_FK` (`typeEvent`),
  CONSTRAINT `events_statusesevents_FK` FOREIGN KEY (`statusEvent`) REFERENCES `statusesevents` (`idStetuEvent`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `events_typesevents_FK` FOREIGN KEY (`typeEvent`) REFERENCES `typesevents` (`idTypeEvent`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (1,'Восхождение царя на медную гору',NULL,NULL,'2000-01-01 00:00:00',NULL,'Царь идёт.');
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materials` (
  `idMaterial` int NOT NULL AUTO_INCREMENT,
  `nameMaterial` varchar(100) DEFAULT NULL,
  `dateUpdate` date DEFAULT NULL,
  `type` int DEFAULT NULL,
  `status` int DEFAULT NULL,
  `region` int DEFAULT NULL,
  `autor` varchar(100) DEFAULT NULL,
  `dateAccept` date DEFAULT NULL,
  PRIMARY KEY (`idMaterial`),
  KEY `materials_regions_FK` (`region`),
  KEY `materials_statuses_FK` (`status`),
  KEY `materials_types_FK` (`type`),
  CONSTRAINT `materials_regions_FK` FOREIGN KEY (`region`) REFERENCES `regions` (`idRegion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `materials_statuses_FK` FOREIGN KEY (`status`) REFERENCES `statuses` (`idStatus`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `materials_types_FK` FOREIGN KEY (`type`) REFERENCES `types` (`idType`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materialseducations`
--

DROP TABLE IF EXISTS `materialseducations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materialseducations` (
  `idMaterialEducation` int NOT NULL AUTO_INCREMENT,
  `material` int DEFAULT NULL,
  `education` int DEFAULT NULL,
  PRIMARY KEY (`idMaterialEducation`),
  KEY `materialseducations_educations_FK` (`education`),
  KEY `materialseducations_materials_FK` (`material`),
  CONSTRAINT `materialseducations_educations_FK` FOREIGN KEY (`education`) REFERENCES `educations` (`idEducation`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `materialseducations_materials_FK` FOREIGN KEY (`material`) REFERENCES `materials` (`idMaterial`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materialseducations`
--

LOCK TABLES `materialseducations` WRITE;
/*!40000 ALTER TABLE `materialseducations` DISABLE KEYS */;
/*!40000 ALTER TABLE `materialseducations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `positions`
--

DROP TABLE IF EXISTS `positions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `positions` (
  `PositionID` int NOT NULL AUTO_INCREMENT,
  `PositionName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`PositionID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `positions`
--

LOCK TABLES `positions` WRITE;
/*!40000 ALTER TABLE `positions` DISABLE KEYS */;
INSERT INTO `positions` VALUES (1,'Электрик'),(2,'Помощник'),(3,'Руководитель');
/*!40000 ALTER TABLE `positions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regions`
--

DROP TABLE IF EXISTS `regions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regions` (
  `idRegion` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idRegion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regions`
--

LOCK TABLES `regions` WRITE;
/*!40000 ALTER TABLE `regions` DISABLE KEYS */;
/*!40000 ALTER TABLE `regions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statuses`
--

DROP TABLE IF EXISTS `statuses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statuses` (
  `idStatus` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idStatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statuses`
--

LOCK TABLES `statuses` WRITE;
/*!40000 ALTER TABLE `statuses` DISABLE KEYS */;
/*!40000 ALTER TABLE `statuses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statusesevents`
--

DROP TABLE IF EXISTS `statusesevents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statusesevents` (
  `idStetuEvent` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idStetuEvent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statusesevents`
--

LOCK TABLES `statusesevents` WRITE;
/*!40000 ALTER TABLE `statusesevents` DISABLE KEYS */;
/*!40000 ALTER TABLE `statusesevents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types`
--

DROP TABLE IF EXISTS `types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `types` (
  `idType` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types`
--

LOCK TABLES `types` WRITE;
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
/*!40000 ALTER TABLE `types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typesevents`
--

DROP TABLE IF EXISTS `typesevents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typesevents` (
  `idTypeEvent` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idTypeEvent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typesevents`
--

LOCK TABLES `typesevents` WRITE;
/*!40000 ALTER TABLE `typesevents` DISABLE KEYS */;
/*!40000 ALTER TABLE `typesevents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uvoleni`
--

DROP TABLE IF EXISTS `uvoleni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uvoleni` (
  `idUvolen` int NOT NULL AUTO_INCREMENT,
  `idEmployeer` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`idUvolen`),
  KEY `uvoleni_employees_FK` (`idEmployeer`),
  CONSTRAINT `uvoleni_employees_FK` FOREIGN KEY (`idEmployeer`) REFERENCES `employees` (`EmployeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uvoleni`
--

LOCK TABLES `uvoleni` WRITE;
/*!40000 ALTER TABLE `uvoleni` DISABLE KEYS */;
INSERT INTO `uvoleni` VALUES (1,1,'2025-02-12'),(2,2,'2025-02-12'),(3,3,'2025-02-12');
/*!40000 ALTER TABLE `uvoleni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacations`
--

DROP TABLE IF EXISTS `vacations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacations` (
  `idVacation` int NOT NULL AUTO_INCREMENT,
  `dateStart` date DEFAULT NULL,
  `dateEnd` date DEFAULT NULL,
  `eployee` int DEFAULT NULL,
  `replaces` int DEFAULT NULL,
  PRIMARY KEY (`idVacation`),
  KEY `vacations_employees_FK` (`eployee`),
  KEY `vacations_applicants_FK` (`replaces`),
  CONSTRAINT `vacations_applicants_FK` FOREIGN KEY (`replaces`) REFERENCES `applicants` (`idApplicant`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vacations_employees_FK` FOREIGN KEY (`eployee`) REFERENCES `employees` (`EmployeeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacations`
--

LOCK TABLES `vacations` WRITE;
/*!40000 ALTER TABLE `vacations` DISABLE KEYS */;
INSERT INTO `vacations` VALUES (1,'2010-01-01','2010-01-02',1,NULL);
/*!40000 ALTER TABLE `vacations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'kalugin'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-17 10:06:23
