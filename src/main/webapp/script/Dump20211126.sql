CREATE DATABASE  IF NOT EXISTS `pqrs` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pqrs`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: pqrs
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_pqrs`
--

DROP TABLE IF EXISTS `tbl_pqrs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_pqrs` (
  `pqr_pqrsid` int NOT NULL AUTO_INCREMENT,
  `fk_usucrea` int DEFAULT NULL,
  `fk_usuasigna` int DEFAULT NULL,
  `fk_usuresponde` int DEFAULT NULL,
  `pqu_fechacreacion` datetime(6) DEFAULT NULL,
  `pqu_fechaasignacion` datetime(6) DEFAULT NULL,
  `pqu_fecharespuesta` datetime(6) DEFAULT NULL,
  `pqu_solicitud` longtext,
  `pqu_respuesta` longtext,
  `pqu_estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pqr_pqrsid`),
  KEY `fk_usucres_idx` (`fk_usucrea`),
  KEY `fk_usuasigna_idx` (`fk_usuasigna`),
  KEY `fk_usuresponde_idx` (`fk_usuresponde`),
  CONSTRAINT `fk_usuasigna` FOREIGN KEY (`fk_usuasigna`) REFERENCES `tbl_usuario` (`usu_usuarioid`),
  CONSTRAINT `fk_usucres` FOREIGN KEY (`fk_usucrea`) REFERENCES `tbl_usuario` (`usu_usuarioid`),
  CONSTRAINT `fk_usuresponde` FOREIGN KEY (`fk_usuresponde`) REFERENCES `tbl_usuario` (`usu_usuarioid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_pqrs`
--

LOCK TABLES `tbl_pqrs` WRITE;
/*!40000 ALTER TABLE `tbl_pqrs` DISABLE KEYS */;
INSERT INTO `tbl_pqrs` VALUES (1,7,2,4,'2021-11-25 00:00:00.000000','2021-11-25 00:00:00.000000',NULL,'Validad funcionamiento del equipo asignado.',NULL,'Nuevo');
/*!40000 ALTER TABLE `tbl_pqrs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_rol`
--

DROP TABLE IF EXISTS `tbl_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_rol` (
  `rol_rolid` int NOT NULL AUTO_INCREMENT,
  `rol_tipo` varchar(45) DEFAULT NULL,
  `rol_descripcion` varchar(45) DEFAULT NULL,
  `rol_ruta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rol_rolid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_rol`
--

LOCK TABLES `tbl_rol` WRITE;
/*!40000 ALTER TABLE `tbl_rol` DISABLE KEYS */;
INSERT INTO `tbl_rol` VALUES (1,'Administrador','administrador',NULL),(2,'Cliente','cliente',NULL),(3,'Empleado','empleado',NULL);
/*!40000 ALTER TABLE `tbl_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario`
--

DROP TABLE IF EXISTS `tbl_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuario` (
  `usu_usuarioid` int NOT NULL AUTO_INCREMENT,
  `usu_tipodocumento` varchar(45) DEFAULT NULL,
  `usu_documento` bigint DEFAULT NULL,
  `usu_nombres` varchar(60) DEFAULT NULL,
  `usu_apellidos` varchar(60) DEFAULT NULL,
  `usu_correoelectronico` varchar(60) NOT NULL,
  `usu_clave` varchar(45) DEFAULT NULL,
  `usu_estado` tinyint DEFAULT '1',
  PRIMARY KEY (`usu_usuarioid`),
  UNIQUE KEY `usu_correoelectronico_UNIQUE` (`usu_correoelectronico`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario`
--

LOCK TABLES `tbl_usuario` WRITE;
/*!40000 ALTER TABLE `tbl_usuario` DISABLE KEYS */;
INSERT INTO `tbl_usuario` VALUES (1,'Cedula',10101010,'Jose Luis','Sarta','josarta@misena.edu.co','12345',1),(2,'Cedula',10101010,'Diego','Cañon','diegoc@misena.edu.co','12345',1),(3,'Cedula',10101011,'Nicolas',' Sanchez','nsanchez@misena.edu.co','12345',1),(4,'Cedula',10101012,'Gerson','Jimenez','gjimenez@misena.edu.co','12345',1),(5,'Cedula',10101013,'Dawin','Calderon','dcalderon@misena.edu.co','12345',1),(6,'Cedula',10101014,'Jorge Luis','Acevedo','jacevedo@misena.edu.co','12345',1),(7,'Cedula',10101015,'Brayan','Lote','blote@misena.edu.co','12345',1),(8,'T. Identidad',10101045,'User ','Uno','useruno@misena.edu.co','12345',1),(9,'Cedula',10101046,'User ','Dos','userdos@misena.edu.co','12345',1),(10,'Pasaporte',10101047,'User ','tres','usertres@misena.edu.co','12345',1),(15,'Cedula',10101049,'User ','cuatro','usercuatro@misena.edu.co','12345',1);
/*!40000 ALTER TABLE `tbl_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_usuario_has_rol`
--

DROP TABLE IF EXISTS `tbl_usuario_has_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_usuario_has_rol` (
  `fk_usuarioid` int DEFAULT NULL,
  `fk_rolid` int DEFAULT NULL,
  KEY `fk_usu_idx` (`fk_usuarioid`),
  KEY `fk_rol_idx` (`fk_rolid`),
  CONSTRAINT `fk_rol` FOREIGN KEY (`fk_rolid`) REFERENCES `tbl_rol` (`rol_rolid`),
  CONSTRAINT `fk_usu` FOREIGN KEY (`fk_usuarioid`) REFERENCES `tbl_usuario` (`usu_usuarioid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_usuario_has_rol`
--

LOCK TABLES `tbl_usuario_has_rol` WRITE;
/*!40000 ALTER TABLE `tbl_usuario_has_rol` DISABLE KEYS */;
INSERT INTO `tbl_usuario_has_rol` VALUES (1,1),(2,1),(2,2),(1,2),(4,3),(5,3),(6,3),(7,2);
/*!40000 ALTER TABLE `tbl_usuario_has_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pqrs'
--

--
-- Dumping routines for database 'pqrs'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-26 23:05:28
