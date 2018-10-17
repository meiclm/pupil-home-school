-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: home_school
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `t_id` varchar(11) NOT NULL,
  `p_id` varchar(11) NOT NULL,
  `message` varchar(255) NOT NULL,
  `send_time` varchar(45) DEFAULT NULL,
  `send_reci` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `t_id` (`t_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `p_id` FOREIGN KEY (`p_id`) REFERENCES `t_parent` (`phone`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `t_id` FOREIGN KEY (`t_id`) REFERENCES `t_teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,'1998090102','15735657423','你的孩子表现零号','2018-10-17 11:30:00',1),(2,'1998090102','18735361050','0000','2018-10-17 11:30:00',2);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_class`
--

DROP TABLE IF EXISTS `t_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_class` (
  `class_no` varchar(45) NOT NULL,
  `teacher` varchar(45) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `describe` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_no`),
  KEY `teacher_idx` (`teacher`),
  CONSTRAINT `teacher` FOREIGN KEY (`teacher`) REFERENCES `t_teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_class`
--

LOCK TABLES `t_class` WRITE;
/*!40000 ALTER TABLE `t_class` DISABLE KEYS */;
INSERT INTO `t_class` VALUES ('150841','1999090102',40,4),('150842','1998090102',40,4);
/*!40000 ALTER TABLE `t_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_course`
--

DROP TABLE IF EXISTS `t_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_course` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_course`
--

LOCK TABLES `t_course` WRITE;
/*!40000 ALTER TABLE `t_course` DISABLE KEYS */;
INSERT INTO `t_course` VALUES (1,'语文'),(2,'数学'),(3,'英语'),(4,'体育'),(5,'思想政治'),(6,'美术'),(7,'音乐'),(8,'秋游'),(9,'实践课'),(10,'管理学校');
/*!40000 ALTER TABLE `t_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_grade`
--

DROP TABLE IF EXISTS `t_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_grade` (
  `grade_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_no` varchar(45) DEFAULT NULL,
  `c_no` int(11) DEFAULT NULL,
  `term` varchar(45) DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`grade_id`),
  KEY `s_no_idx` (`s_no`),
  KEY `c_no_idx` (`c_no`),
  CONSTRAINT `c_no` FOREIGN KEY (`c_no`) REFERENCES `t_course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `s_no` FOREIGN KEY (`s_no`) REFERENCES `t_student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_grade`
--

LOCK TABLES `t_grade` WRITE;
/*!40000 ALTER TABLE `t_grade` DISABLE KEYS */;
INSERT INTO `t_grade` VALUES (1,'15084201',1,'16-17-01','80'),(2,'15084201',2,'16-17-01','90'),(3,'15084201',3,'16-17-01','60'),(4,'15084101',1,'16-17-01','66'),(5,'15084101',2,'16-17-01','78'),(6,'15084101',3,'16-17-01','100'),(7,'15084201',1,'16-17-02','90'),(8,'15084201',2,'16-17-02','66'),(9,'15084201',3,'16-17-02','100');
/*!40000 ALTER TABLE `t_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_parent`
--

DROP TABLE IF EXISTS `t_parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_parent` (
  `openID` varchar(32) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `wechat` varchar(45) DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `describe` longtext,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_parent`
--

LOCK TABLES `t_parent` WRITE;
/*!40000 ALTER TABLE `t_parent` DISABLE KEYS */;
INSERT INTO `t_parent` VALUES ('oZTNs5d5929B-QAtyckE7DsZGsrU','15735657423','123456','孙琦',NULL,'e868142','个体经营',NULL),('','18735361050','123456','李燕锦',NULL,'a1185024561','教师',NULL),('','18745632152','123456','单父母',NULL,'joy134065','个体经营',NULL);
/*!40000 ALTER TABLE `t_parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_student`
--

DROP TABLE IF EXISTS `t_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_student` (
  `id` varchar(50) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `addres` varchar(100) DEFAULT NULL,
  `parent` varchar(45) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_idx` (`parent`),
  CONSTRAINT `parent` FOREIGN KEY (`parent`) REFERENCES `t_parent` (`phone`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_student`
--

LOCK TABLES `t_student` WRITE;
/*!40000 ALTER TABLE `t_student` DISABLE KEYS */;
INSERT INTO `t_student` VALUES ('15084101','单紫嫣','小店区田园小区A45','18745632152','2008-11-06'),('15084201','张田梦','上兰村文瀛小区A540','18735361050','2008-11-09'),('15084232','黄海波','肥西县','15735657423','2008-11-12'),('15084235','孔德林','济宁市','15735657423','2008-11-12');
/*!40000 ALTER TABLE `t_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_teacher`
--

DROP TABLE IF EXISTS `t_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_teacher` (
  `id` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `wechat` varchar(45) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  `teaching` int(11) DEFAULT NULL,
  `admin` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teaching_idx` (`teaching`),
  CONSTRAINT `teaching` FOREIGN KEY (`teaching`) REFERENCES `t_course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_teacher`
--

LOCK TABLES `t_teacher` WRITE;
/*!40000 ALTER TABLE `t_teacher` DISABLE KEYS */;
INSERT INTO `t_teacher` VALUES ('1998090101','123456','陈柳梅','普通老师','18735361050','1667440354@qq.com','joy134065',0,'1978-11-09',2,0),('1998090102','123456','赵琦','普通老师','15735659693','396558528@qq.com','Yue-6666666',0,'1978-11-09',1,0),('1998090103','123456','谭诗雨','校长','15925207632','1150573527@qq.com','tsy11223456',0,'1968-10-15',10,1),('1998090104','123456','李丹妮','教务处主任','18334729708','1565893158@qq.com','wxid_nraasje1tksh22',0,'1968-10-15',9,1),('1999090101','123456','翟思源','副校长','13834648200','921358361@qq.com','zsy921358361',1,'1968-03-02',3,1),('1999090102','123456','孙琦','普通老师','13834648200','1904705132@qq.com','e868142',1,'1978-10-02',4,0);
/*!40000 ALTER TABLE `t_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_grade`
--

DROP TABLE IF EXISTS `view_grade`;
/*!50001 DROP VIEW IF EXISTS `view_grade`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_grade` AS SELECT 
 1 AS `s_no`,
 1 AS `c_no`,
 1 AS `name`,
 1 AS `term`,
 1 AS `grade`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'home_school'
--

--
-- Dumping routines for database 'home_school'
--

--
-- Final view structure for view `view_grade`
--

/*!50001 DROP VIEW IF EXISTS `view_grade`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_grade` AS select `t_grade`.`s_no` AS `s_no`,`t_grade`.`c_no` AS `c_no`,`t_course`.`name` AS `name`,`t_grade`.`term` AS `term`,`t_grade`.`grade` AS `grade` from (`t_grade` join `t_course`) where (`t_grade`.`c_no` = `t_course`.`id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-17 21:52:48
