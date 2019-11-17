-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: hms
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_info`
--

DROP TABLE IF EXISTS `admin_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_info` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(150) NOT NULL,
  `name` varchar(150) NOT NULL,
  `phone_no` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_id_UNIQUE` (`admin_id`),
  UNIQUE KEY `email_id_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_info`
--

LOCK TABLES `admin_info` WRITE;
/*!40000 ALTER TABLE `admin_info` DISABLE KEYS */;
INSERT INTO `admin_info` VALUES (1,'service@iiitb.org','thanksiiitb','Admin','9998889990');
/*!40000 ALTER TABLE `admin_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaint_info`
--

DROP TABLE IF EXISTS `complaint_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `complaint_info` (
  `complaint_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `handyman_id` int(5) DEFAULT NULL,
  `subject` varchar(200) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `catagory` varchar(20) DEFAULT NULL,
  `time_slot` varchar(45) NOT NULL,
  `priority` int(11) DEFAULT '1',
  `flag` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `cost` int(11) DEFAULT '0',
  `date` datetime DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `feedback` varchar(100) DEFAULT NULL,
  `otp` int(5) NOT NULL,
  `descriptionFull` varchar(100) DEFAULT '',
  `assignDate` datetime DEFAULT NULL,
  PRIMARY KEY (`complaint_id`),
  UNIQUE KEY `complaint_id_UNIQUE` (`complaint_id`),
  KEY `student_id_idx` (`student_id`),
  KEY `handyman_id_idx` (`handyman_id`),
  CONSTRAINT `handyman_id` FOREIGN KEY (`handyman_id`) REFERENCES `handyman_info` (`handyman_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_id` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`student_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint_info`
--


--
-- Table structure for table `feedback_info`
--

DROP TABLE IF EXISTS `feedback_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback_info` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `complaint_id` int(11) NOT NULL,
  `text` varchar(250) NOT NULL,
  `student_id` int(11) NOT NULL,
  `handyman_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`feedback_id`),
  KEY `complaint_id_idx` (`complaint_id`),
  KEY `student_id_idx` (`student_id`),
  KEY `handymain_Id_idx` (`handyman_id`),
  CONSTRAINT `fk_feedback_info_1` FOREIGN KEY (`complaint_id`) REFERENCES `complaint_info` (`complaint_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_feedback_info_2` FOREIGN KEY (`handyman_id`) REFERENCES `handyman_info` (`handyman_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_feedback_info_3` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback_info`
--

LOCK TABLES `feedback_info` WRITE;
/*!40000 ALTER TABLE `feedback_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `feedback_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `handyman_info`
--

DROP TABLE IF EXISTS `handyman_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `handyman_info` (
  `handyman_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(40) NOT NULL,
  `password` varchar(150) NOT NULL,
  `name` varchar(150) NOT NULL,
  `phone_no` varchar(13) NOT NULL,
  `Catagory` varchar(13) NOT NULL,
  `slot1` int(5) DEFAULT '0',
  `slot2` int(5) DEFAULT '0',
  `slot3` int(5) DEFAULT '0',
  `issued` int(5) DEFAULT '0',
  `solved` int(5) DEFAULT '0',
  `today` int(5) DEFAULT '0',
  PRIMARY KEY (`handyman_id`),
  UNIQUE KEY `handyman_id_UNIQUE` (`handyman_id`),
  UNIQUE KEY `email_id_UNIQUE` (`email`),
  UNIQUE KEY `Phone_no_UNIQUE` (`phone_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `handyman_info`
--

LOCK TABLES `handyman_info` WRITE;
/*!40000 ALTER TABLE `handyman_info` DISABLE KEYS */;
INSERT INTO `handyman_info` VALUES (1,'handyman@iiitb.org','thanks123','John Doe','+918882229991','Carpenter',0,0,0,0,0,0),(2,'Bmahesh@iiitb.org','thanks123','Mahesh Bhupati','918889991112','Electrician',0,0,0,0,0,0),(3,'hkiran@iiitb.org','thanks123','Kiran Rao','917282991112','Electrician',0,0,0,0,0,0);
/*!40000 ALTER TABLE `handyman_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_data`
--

DROP TABLE IF EXISTS `master_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `master_data` (
  `owner` varchar(30) DEFAULT NULL,
  `handman` varchar(30) DEFAULT NULL,
  `equipment` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_data`
--

LOCK TABLES `master_data` WRITE;
/*!40000 ALTER TABLE `master_data` DISABLE KEYS */;
INSERT INTO `master_data` VALUES ('Hostel','Carpenter','Table'),('Hostel','Carpenter','Chair'),('Hostel','Carpenter','Cupboard'),('Hostel','Electrician','Fan'),('Hostel','Electrician','Tubelight'),('Hostel','Electrician','Regulator'),('Personnel','Electrician','Iron'),('Personnel','Electrician','Kettle'),('Personnel','Electrician','Heater'),('Personnel','Carpenter','Table'),('Hostel','Carpenter','Door');
/*!40000 ALTER TABLE `master_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_info` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `roll_no` varchar(150) NOT NULL,
  `phone_no` varchar(150) NOT NULL,
  `room_no` int(11) NOT NULL,
  `gender` char(1) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_no_UNIQUE` (`phone_no`),
  UNIQUE KEY `room_no_UNIQUE` (`room_no`),
  UNIQUE KEY `roll_no_UNIQUE` (`roll_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_info`
--

LOCK TABLES `student_info` WRITE;
/*!40000 ALTER TABLE `student_info` DISABLE KEYS */;
INSERT INTO `student_info` VALUES (1,'anubhav.gupta@iiitb.org','thanks123','MT2016018','8305771509',315,'M','Anubhav Gupta'),(3,'arpit.waghmare@iiitb.org','thanks123','MT2016024','9066218124',318,'M','Arpit Waghmare');
/*!40000 ALTER TABLE `student_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-23  0:04:34
