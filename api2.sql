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
-- Table structure for table `commentaries`
--

DROP TABLE IF EXISTS `commentaries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commentaries` (
  `id` int NOT NULL AUTO_INCREMENT,
  `documentId` int DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  `author` int DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `commentaries_documents_FK` (`documentId`),
  KEY `commentaries_rabotniki_FK` (`author`),
  CONSTRAINT `commentaries_documents_FK` FOREIGN KEY (`documentId`) REFERENCES `documents` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `commentaries_rabotniki_FK` FOREIGN KEY (`author`) REFERENCES `sotrudniki` (`idSotridnik`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentaries`
--

LOCK TABLES `commentaries` WRITE;
/*!40000 ALTER TABLE `commentaries` DISABLE KEYS */;
/*!40000 ALTER TABLE `commentaries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documents`
--

DROP TABLE IF EXISTS `documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documents` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `dateCreated` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `hasComments` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documents`
--

LOCK TABLES `documents` WRITE;
/*!40000 ALTER TABLE `documents` DISABLE KEYS */;
INSERT INTO `documents` VALUES (1,'1',NULL,NULL,NULL,NULL),(2,'2',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `documents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dolshnosti`
--

DROP TABLE IF EXISTS `dolshnosti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dolshnosti` (
  `idDolshnost` int NOT NULL AUTO_INCREMENT,
  `nazvaniye` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idDolshnost`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dolshnosti`
--

LOCK TABLES `dolshnosti` WRITE;
/*!40000 ALTER TABLE `dolshnosti` DISABLE KEYS */;
INSERT INTO `dolshnosti` VALUES (1,'Уборщик');
/*!40000 ALTER TABLE `dolshnosti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kamandirovki`
--

DROP TABLE IF EXISTS `kamandirovki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kamandirovki` (
  `idKomandirovka` int NOT NULL AUTO_INCREMENT,
  `idSotrudnika` int DEFAULT NULL,
  `dateKomandirovkaNachalo` date DEFAULT NULL,
  `dateKomandirovkaOkonchaniye` date DEFAULT NULL,
  PRIMARY KEY (`idKomandirovka`),
  KEY `kamandirovki_rabotniki_FK` (`idSotrudnika`),
  CONSTRAINT `kamandirovki_rabotniki_FK` FOREIGN KEY (`idSotrudnika`) REFERENCES `sotrudniki` (`idSotridnik`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kamandirovki`
--

LOCK TABLES `kamandirovki` WRITE;
/*!40000 ALTER TABLE `kamandirovki` DISABLE KEYS */;
/*!40000 ALTER TABLE `kamandirovki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `klassificationsobuchenya`
--

DROP TABLE IF EXISTS `klassificationsobuchenya`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `klassificationsobuchenya` (
  `idClassification` int NOT NULL AUTO_INCREMENT,
  `nazvaniye` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idClassification`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klassificationsobuchenya`
--

LOCK TABLES `klassificationsobuchenya` WRITE;
/*!40000 ALTER TABLE `klassificationsobuchenya` DISABLE KEYS */;
/*!40000 ALTER TABLE `klassificationsobuchenya` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materalsobuchenya`
--

DROP TABLE IF EXISTS `materalsobuchenya`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materalsobuchenya` (
  `idMaterialObuchenya` int NOT NULL AUTO_INCREMENT,
  `idMaterial` int DEFAULT NULL,
  `idObuchenya` int DEFAULT NULL,
  PRIMARY KEY (`idMaterialObuchenya`),
  KEY `materalsobuchenya_obicheniya_FK` (`idObuchenya`),
  KEY `materalsobuchenya_materials_FK` (`idMaterial`),
  CONSTRAINT `materalsobuchenya_materials_FK` FOREIGN KEY (`idMaterial`) REFERENCES `materials` (`idMaterial`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `materalsobuchenya_obicheniya_FK` FOREIGN KEY (`idObuchenya`) REFERENCES `obicheniya` (`idObuchenya`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materalsobuchenya`
--

LOCK TABLES `materalsobuchenya` WRITE;
/*!40000 ALTER TABLE `materalsobuchenya` DISABLE KEYS */;
/*!40000 ALTER TABLE `materalsobuchenya` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materials` (
  `idMaterial` int NOT NULL AUTO_INCREMENT,
  `nazvaniye` varchar(100) DEFAULT NULL,
  `dateUtverchd` date DEFAULT NULL,
  `dateRedact` date DEFAULT NULL,
  `idStatus` int DEFAULT NULL,
  `idTipe` int DEFAULT NULL,
  `idOblast` int DEFAULT NULL,
  `iaSotrudnikAutor` int DEFAULT NULL,
  PRIMARY KEY (`idMaterial`),
  KEY `materials_statusesmaterials_FK` (`idStatus`),
  KEY `materials_tipesmaterials_FK` (`idTipe`),
  KEY `materials_oblastimaterials_FK` (`idOblast`),
  KEY `materials_rabotniki_FK` (`iaSotrudnikAutor`),
  CONSTRAINT `materials_oblastimaterials_FK` FOREIGN KEY (`idOblast`) REFERENCES `oblastimaterials` (`idOblast`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `materials_rabotniki_FK` FOREIGN KEY (`iaSotrudnikAutor`) REFERENCES `sotrudniki` (`idSotridnik`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `materials_statusesmaterials_FK` FOREIGN KEY (`idStatus`) REFERENCES `statusesmaterials` (`idStatus`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `materials_tipesmaterials_FK` FOREIGN KEY (`idTipe`) REFERENCES `tipesmaterials` (`idTipe`) ON DELETE CASCADE ON UPDATE CASCADE
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
-- Table structure for table `meropriyatiya`
--

DROP TABLE IF EXISTS `meropriyatiya`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meropriyatiya` (
  `idMeropriyatya` int NOT NULL AUTO_INCREMENT,
  `idTip` int DEFAULT NULL,
  `dateNachalo` date DEFAULT NULL,
  `dateKomandirovkaOkonchaniye` date DEFAULT NULL,
  `vremyaNachala` time DEFAULT NULL,
  `vremyaOconchnya` time DEFAULT NULL,
  `idStatus` int DEFAULT NULL,
  `idSotrudnikOtvetstvenen` int DEFAULT NULL,
  `opisanye` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idMeropriyatya`),
  KEY `meropriyatiya_tipimeropriyatya_FK` (`idTip`),
  KEY `meropriyatiya_statusesmeropriyatya_FK` (`idStatus`),
  KEY `meropriyatiya_rabotniki_FK` (`idSotrudnikOtvetstvenen`),
  CONSTRAINT `meropriyatiya_rabotniki_FK` FOREIGN KEY (`idSotrudnikOtvetstvenen`) REFERENCES `sotrudniki` (`idSotridnik`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `meropriyatiya_statusesmeropriyatya_FK` FOREIGN KEY (`idStatus`) REFERENCES `statusesmeropriyatya` (`idStatus`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `meropriyatiya_tipimeropriyatya_FK` FOREIGN KEY (`idTip`) REFERENCES `tipimeropriyatya` (`idTip`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meropriyatiya`
--

LOCK TABLES `meropriyatiya` WRITE;
/*!40000 ALTER TABLE `meropriyatiya` DISABLE KEYS */;
/*!40000 ALTER TABLE `meropriyatiya` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obicheniya`
--

DROP TABLE IF EXISTS `obicheniya`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `obicheniya` (
  `idObuchenya` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `opisaniye` varchar(100) DEFAULT NULL,
  `idClassification` int DEFAULT NULL,
  PRIMARY KEY (`idObuchenya`),
  KEY `obicheniya_klassificationsobuchenya_FK` (`idClassification`),
  CONSTRAINT `obicheniya_klassificationsobuchenya_FK` FOREIGN KEY (`idClassification`) REFERENCES `klassificationsobuchenya` (`idClassification`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obicheniya`
--

LOCK TABLES `obicheniya` WRITE;
/*!40000 ALTER TABLE `obicheniya` DISABLE KEYS */;
/*!40000 ALTER TABLE `obicheniya` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oblastimaterials`
--

DROP TABLE IF EXISTS `oblastimaterials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oblastimaterials` (
  `idOblast` int NOT NULL AUTO_INCREMENT,
  `nazvanye` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idOblast`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oblastimaterials`
--

LOCK TABLES `oblastimaterials` WRITE;
/*!40000 ALTER TABLE `oblastimaterials` DISABLE KEYS */;
/*!40000 ALTER TABLE `oblastimaterials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obuchenyesotrudnikov`
--

DROP TABLE IF EXISTS `obuchenyesotrudnikov`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `obuchenyesotrudnikov` (
  `idObuchenyaSotrudnika` int NOT NULL AUTO_INCREMENT,
  `idSotrudnik` int DEFAULT NULL,
  `idObuchenya` int DEFAULT NULL,
  `dateNachala` date DEFAULT NULL,
  `dateOkonchanya` date DEFAULT NULL,
  PRIMARY KEY (`idObuchenyaSotrudnika`),
  KEY `obuchenyesotrudnikov_obicheniya_FK` (`idObuchenya`),
  KEY `obuchenyesotrudnikov_rabotniki_FK` (`idSotrudnik`),
  CONSTRAINT `obuchenyesotrudnikov_obicheniya_FK` FOREIGN KEY (`idObuchenya`) REFERENCES `obicheniya` (`idObuchenya`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `obuchenyesotrudnikov_rabotniki_FK` FOREIGN KEY (`idSotrudnik`) REFERENCES `sotrudniki` (`idSotridnik`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obuchenyesotrudnikov`
--

LOCK TABLES `obuchenyesotrudnikov` WRITE;
/*!40000 ALTER TABLE `obuchenyesotrudnikov` DISABLE KEYS */;
/*!40000 ALTER TABLE `obuchenyesotrudnikov` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otguli`
--

DROP TABLE IF EXISTS `otguli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `otguli` (
  `idOtgul` int NOT NULL AUTO_INCREMENT,
  `idSotrudnika` int DEFAULT NULL,
  `idSotrudnikaZamestil` int DEFAULT NULL,
  `dateOtgulNachalo` date DEFAULT NULL,
  `dateOtgulOkonchaniye` date DEFAULT NULL,
  PRIMARY KEY (`idOtgul`),
  KEY `otguli_rabotniki_FK` (`idSotrudnika`),
  KEY `otguli_rabotniki_FK_1` (`idSotrudnikaZamestil`),
  CONSTRAINT `otguli_rabotniki_FK` FOREIGN KEY (`idSotrudnika`) REFERENCES `sotrudniki` (`idSotridnik`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `otguli_rabotniki_FK_1` FOREIGN KEY (`idSotrudnikaZamestil`) REFERENCES `sotrudniki` (`idSotridnik`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otguli`
--

LOCK TABLES `otguli` WRITE;
/*!40000 ALTER TABLE `otguli` DISABLE KEYS */;
/*!40000 ALTER TABLE `otguli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otpuski`
--

DROP TABLE IF EXISTS `otpuski`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `otpuski` (
  `idOtpusk` int NOT NULL AUTO_INCREMENT,
  `idSotrudnika` int DEFAULT NULL,
  `idSotrudnikaZamestil` int DEFAULT NULL,
  `dateOtpuskNachalo` date DEFAULT NULL,
  `dateOtpusklOkonchaniye` date DEFAULT NULL,
  PRIMARY KEY (`idOtpusk`),
  KEY `otpuski_rabotniki_FK` (`idSotrudnika`),
  KEY `otpuski_rabotniki_FK_1` (`idSotrudnikaZamestil`),
  CONSTRAINT `otpuski_rabotniki_FK` FOREIGN KEY (`idSotrudnika`) REFERENCES `sotrudniki` (`idSotridnik`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `otpuski_rabotniki_FK_1` FOREIGN KEY (`idSotrudnikaZamestil`) REFERENCES `sotrudniki` (`idSotridnik`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otpuski`
--

LOCK TABLES `otpuski` WRITE;
/*!40000 ALTER TABLE `otpuski` DISABLE KEYS */;
/*!40000 ALTER TABLE `otpuski` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otsutstiya`
--

DROP TABLE IF EXISTS `otsutstiya`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `otsutstiya` (
  `idOtsutstviya` int NOT NULL AUTO_INCREMENT,
  `idSotrudnika` int DEFAULT NULL,
  `idSotrudnikaZamestil` int DEFAULT NULL,
  `dateOtsustviya` date DEFAULT NULL,
  PRIMARY KEY (`idOtsutstviya`),
  KEY `otsutstiya_rabotniki_FK` (`idSotrudnika`),
  KEY `otsutstiya_rabotniki_FK_1` (`idSotrudnikaZamestil`),
  CONSTRAINT `otsutstiya_rabotniki_FK` FOREIGN KEY (`idSotrudnika`) REFERENCES `sotrudniki` (`idSotridnik`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `otsutstiya_rabotniki_FK_1` FOREIGN KEY (`idSotrudnikaZamestil`) REFERENCES `sotrudniki` (`idSotridnik`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otsutstiya`
--

LOCK TABLES `otsutstiya` WRITE;
/*!40000 ALTER TABLE `otsutstiya` DISABLE KEYS */;
/*!40000 ALTER TABLE `otsutstiya` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `padrazdeleniya`
--

DROP TABLE IF EXISTS `padrazdeleniya`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `padrazdeleniya` (
  `idPodrazdelenie` int NOT NULL AUTO_INCREMENT,
  `opisanie` varchar(100) DEFAULT NULL,
  `kodPodrazdelenia` varchar(30) DEFAULT NULL,
  `nazvaniye` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPodrazdelenie`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `padrazdeleniya`
--

LOCK TABLES `padrazdeleniya` WRITE;
/*!40000 ALTER TABLE `padrazdeleniya` DISABLE KEYS */;
INSERT INTO `padrazdeleniya` VALUES (1,NULL,'1.','Административный департамент'),(2,NULL,'1.1.','Административный департамент'),(3,NULL,'1.2.','Договорной отдел'),(4,NULL,'1.3.','Общий отдел'),(5,NULL,'1.4.','Отдел закупок'),(6,NULL,'1.5.','Отдел протокольного сопровождения'),(7,NULL,'1.6.','Управление административно-хозяйственной деятельности'),(8,NULL,'1.6.1.','Отдел ИТ'),(9,NULL,'1.6.2.','Управление административно-хозяйственной деятельности'),(10,NULL,'1.7.','Управление безопасности'),(11,NULL,'1.8.','Управление по обеспечению безопасности'),(12,NULL,'2.','Академия Умные дороги'),(13,NULL,'2.1.','Академия Умные дороги'),(14,NULL,'2.2.','Отдел сетевых программ'),(15,NULL,'2.3.','Проектно-аналитический отдел'),(16,NULL,'2.4.','Учебно-организационный отдел'),(17,NULL,'3.','Аппарат управления'),(18,NULL,'4.','Департамент коммуникаций'),(19,NULL,'4.1.','Департамент коммуникаций'),(20,NULL,'4.2.','Управление по PR-проектам'),(21,NULL,'4.2.1.','Отдел по организации и сопровождению мероприятий'),(22,NULL,'4.2.2.','Отдел по работе с корпорациями'),(23,NULL,'4.3.','Управление Пресс-службы'),(24,NULL,'4.3.1.','Отдел по работе со СМИ'),(25,NULL,'4.3.2.','Отдел цифровых коммуникаций'),(26,NULL,'4.3.3.','Управление Пресс-службы'),(27,NULL,'5.','Департамент маркетинга и партнерских отношений'),(28,NULL,'5.1.','Департамент маркетинга и партнерских отношений'),(29,NULL,'5.2.','Управление маркетинга'),(30,NULL,'5.2.1.','Лицензионный отдел'),(31,NULL,'5.2.2.','Управление маркетинга'),(32,NULL,'5.3.','Управление по развитию бизнеса'),(33,NULL,'5.3.1.','Отдел по  привлечению новых клиентов'),(34,NULL,'5.3.2.','Отдел по организации мероприятий'),(35,NULL,'5.4.','Управление по развитию партнерских отношений'),(36,NULL,'6.','Департамент по организации корпоративов'),(37,NULL,'7.','Департамент по работе с персоналом'),(38,NULL,'8.','Департамент по работе с промышленностью'),(39,NULL,'9.2.','Отдел проектного управления'),(40,NULL,'10.','Управление Финансового планирования и контроля'),(41,NULL,'11.','Финансово-экономический департамент'),(42,NULL,'11.1.','Управление бухгалтерского и налогового учета'),(43,NULL,'11.2.','Управление казначейства'),(44,NULL,'11.2.1.','Операционный отдел'),(45,NULL,'11.3.','Финансово-экономический департамент'),(46,NULL,'11.4.','Финансово-экономическое управление'),(47,NULL,'12.','Юридический департамент'),(48,NULL,'12.1.','Управление нормативного обеспечения и договорной работы'),(49,NULL,'12.2.','Юридический департамент');
/*!40000 ALTER TABLE `padrazdeleniya` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sotrudniki`
--

DROP TABLE IF EXISTS `sotrudniki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sotrudniki` (
  `idSotridnik` int NOT NULL AUTO_INCREMENT,
  `familiya` varchar(100) DEFAULT NULL,
  `imya` varchar(100) DEFAULT NULL,
  `otchestvo` varchar(100) DEFAULT NULL,
  `idPodrazd` int DEFAULT NULL,
  `workNomer` varchar(20) DEFAULT NULL,
  `persolalNomer` varchar(20) DEFAULT NULL,
  `cabinet` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `corporatEmail` varchar(100) DEFAULT NULL,
  `idDolshnost` int DEFAULT NULL,
  `denRoshdeniya` date DEFAULT NULL,
  `opisaniye` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `login` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idSotridnik`),
  KEY `rabotniki_dolshnosti_FK` (`idDolshnost`),
  KEY `rabotniki_padrazdeleniya_FK` (`idPodrazd`),
  CONSTRAINT `rabotniki_dolshnosti_FK` FOREIGN KEY (`idDolshnost`) REFERENCES `dolshnosti` (`idDolshnost`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rabotniki_padrazdeleniya_FK` FOREIGN KEY (`idPodrazd`) REFERENCES `padrazdeleniya` (`idPodrazdelenie`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sotrudniki`
--

LOCK TABLES `sotrudniki` WRITE;
/*!40000 ALTER TABLE `sotrudniki` DISABLE KEYS */;
INSERT INTO `sotrudniki` VALUES (2,'Белоусов','Семен','Агафонович',1,NULL,'89138748576','402А','белоусов@гкдр.ру',1,'1971-04-25','Хорош','123','123'),(3,'Белоусов','Семен','Агафонович',1,NULL,'89138748576','402А','белоусов@гкдр.ру',1,'1971-04-25','Хорош','1321','123'),(4,'Белоусов','Семен','Агафонович',1,NULL,'89138748576','402А','белоусов@гкдр.ру',1,'1971-04-25','Хорош','31314','123'),(5,'Белоусов','Семен','Агафонович',1,NULL,'89138748576','402А','белоусов@гкдр.ру',1,'1971-04-25','Хорош','23423','123'),(6,'Белоусов','Семен','Агафонович',1,NULL,'89138748576','402А','белоусов@гкдр.ру',1,'1971-04-25','Хорош','4534535','123'),(7,'Белоусов','Семен','Агафонович',1,NULL,'89138748576','402А','белоусов@гкдр.ру',1,'1971-04-25','Хорош','34532425','123'),(8,'Белоусов','Семен','Агафонович',1,NULL,'89138748576','402А','белоусов@гкдр.ру',1,'1971-04-25','Хорош','634534','123'),(9,'Белоусов','Семен','Агафонович',1,NULL,'89138748576','402А','белоусов@гкдр.ру',1,'1971-04-25','Хорош','2545323','123'),(10,'Белоусов','Семен','Агафонович',1,NULL,'89138748576','402А','белоусов@гкдр.ру',1,'1971-04-25','Хорош','43434344','123'),(11,'Белоусов','Семен','Агафонович',1,NULL,'89138748576','402А','белоусов@гкдр.ру',1,'1971-04-25','Хорош','243463421','123');
/*!40000 ALTER TABLE `sotrudniki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sotrudnikworkingcalendar`
--

DROP TABLE IF EXISTS `sotrudnikworkingcalendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sotrudnikworkingcalendar` (
  `idSotrudnikWorkingCalendar` int NOT NULL AUTO_INCREMENT,
  `idSotrudnik` int DEFAULT NULL,
  `idWorkingCalendar` int DEFAULT NULL,
  PRIMARY KEY (`idSotrudnikWorkingCalendar`),
  KEY `sotrudnikWorkingCalendar_workingcalendar_FK` (`idWorkingCalendar`),
  KEY `sotrudnikWorkingCalendar_rabotniki_FK` (`idSotrudnik`),
  CONSTRAINT `sotrudnikWorkingCalendar_rabotniki_FK` FOREIGN KEY (`idSotrudnik`) REFERENCES `sotrudniki` (`idSotridnik`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sotrudnikWorkingCalendar_workingcalendar_FK` FOREIGN KEY (`idWorkingCalendar`) REFERENCES `workingcalendar` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sotrudnikworkingcalendar`
--

LOCK TABLES `sotrudnikworkingcalendar` WRITE;
/*!40000 ALTER TABLE `sotrudnikworkingcalendar` DISABLE KEYS */;
/*!40000 ALTER TABLE `sotrudnikworkingcalendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `souskateli`
--

DROP TABLE IF EXISTS `souskateli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `souskateli` (
  `idSoiskatel` int NOT NULL AUTO_INCREMENT,
  `familiya` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `imya` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `otchestvo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `persolalNomer` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `idDolshnost` int DEFAULT NULL,
  `denRoshdeniya` date DEFAULT NULL,
  `opisaniye` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idSoiskatel`),
  KEY `Souskateli_dolshnosti_FK` (`idDolshnost`),
  CONSTRAINT `Souskateli_dolshnosti_FK` FOREIGN KEY (`idDolshnost`) REFERENCES `dolshnosti` (`idDolshnost`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `souskateli`
--

LOCK TABLES `souskateli` WRITE;
/*!40000 ALTER TABLE `souskateli` DISABLE KEYS */;
/*!40000 ALTER TABLE `souskateli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statusesmaterials`
--

DROP TABLE IF EXISTS `statusesmaterials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statusesmaterials` (
  `idStatus` int NOT NULL AUTO_INCREMENT,
  `nazvanye` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idStatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statusesmaterials`
--

LOCK TABLES `statusesmaterials` WRITE;
/*!40000 ALTER TABLE `statusesmaterials` DISABLE KEYS */;
/*!40000 ALTER TABLE `statusesmaterials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statusesmeropriyatya`
--

DROP TABLE IF EXISTS `statusesmeropriyatya`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statusesmeropriyatya` (
  `idStatus` int NOT NULL AUTO_INCREMENT,
  `nazvanye` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idStatus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statusesmeropriyatya`
--

LOCK TABLES `statusesmeropriyatya` WRITE;
/*!40000 ALTER TABLE `statusesmeropriyatya` DISABLE KEYS */;
/*!40000 ALTER TABLE `statusesmeropriyatya` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipesmaterials`
--

DROP TABLE IF EXISTS `tipesmaterials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipesmaterials` (
  `idTipe` int NOT NULL AUTO_INCREMENT,
  `nazvanye` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idTipe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipesmaterials`
--

LOCK TABLES `tipesmaterials` WRITE;
/*!40000 ALTER TABLE `tipesmaterials` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipesmaterials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipimeropriyatya`
--

DROP TABLE IF EXISTS `tipimeropriyatya`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipimeropriyatya` (
  `idTip` int NOT NULL AUTO_INCREMENT,
  `nazvanye` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idTip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipimeropriyatya`
--

LOCK TABLES `tipimeropriyatya` WRITE;
/*!40000 ALTER TABLE `tipimeropriyatya` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipimeropriyatya` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workingcalendar`
--

DROP TABLE IF EXISTS `workingcalendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workingcalendar` (
  `Id` int NOT NULL COMMENT 'Идентификатор строки',
  `ExceptionDate` date NOT NULL COMMENT 'День-исключение',
  `IsWorkingDay` tinyint(1) NOT NULL COMMENT '0 - будний день, но законодательно принят выходным; 1 - сб или вс, но является рабочим',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Список дней исключений в производственном календаре';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workingcalendar`
--

LOCK TABLES `workingcalendar` WRITE;
/*!40000 ALTER TABLE `workingcalendar` DISABLE KEYS */;
INSERT INTO `workingcalendar` VALUES (1,'2024-01-01',0),(2,'2024-01-02',0),(3,'2024-01-03',0),(4,'2024-01-04',0),(5,'2024-01-05',0),(6,'2024-01-08',0),(7,'2024-02-23',0),(8,'2024-03-08',0),(9,'2024-04-27',1),(10,'2024-04-29',0),(11,'2024-04-30',0),(12,'2024-05-01',0),(13,'2024-05-09',0),(14,'2024-05-10',0),(15,'2024-06-12',0),(16,'2024-11-02',1),(17,'2024-11-04',0),(18,'2024-12-28',1),(19,'2024-12-30',0),(20,'2024-12-31',0);
/*!40000 ALTER TABLE `workingcalendar` ENABLE KEYS */;
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

-- Dump completed on 2025-02-19 14:00:52
