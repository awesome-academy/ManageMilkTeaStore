-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: bubbleTeaStore
-- ------------------------------------------------------
-- Server version	8.0.11

CREATE DATABASE IF NOT EXISTS bubbleTeaStore;
USE bubbleTeaStore;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
SET NAMES utf8;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `cartDetails`
--

DROP TABLE IF EXISTS `cartDetails`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `cartDetails`
(
  `id`        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `quantity`  INT(11) UNSIGNED NOT NULL DEFAULT '1',
  `productID` INT(11) UNSIGNED NOT NULL,
  `createdAt`       DATETIME          NOT NULL DEFAULT NOW(),
  `cartID`    INT(11) UNSIGNED NOT NULL,
  `sizeID`    INT(11) UNSIGNED NOT NULL,

  PRIMARY KEY (`id`),

  KEY `indexProductIDCartDetails` (`productID`),
  KEY `indexCartIDCartDetails` (`cartID`),
  KEY `indexSizeIDCartDetails` (`sizeID`),

  CONSTRAINT `fkCartCartDetails` FOREIGN KEY (`cartID`) REFERENCES `carts` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fkProductCartDetails` FOREIGN KEY (`productID`) REFERENCES `products` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fkSizeCartDetails` FOREIGN KEY (`sizeID`) REFERENCES `size` (`id`)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `size`
(
  `id`   INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `size` VARCHAR(5)       NOT NULL,

  PRIMARY KEY (`id`)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size`
  DISABLE KEYS */;

INSERT INTO `size`(size)
VALUES ('S'),
       ('M'),
       ('L');

/*!40000 ALTER TABLE `size`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carts`
--

DROP TABLE IF EXISTS `carts`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `carts`
(
  `id`     INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userID` INT(11) UNSIGNED NOT NULL,

  PRIMARY KEY (`id`),

  KEY `indexUserIDCart` (`userID`),

  CONSTRAINT `fkUserIDCart` FOREIGN KEY (`userID`) REFERENCES `users` (`id`) ON DELETE CASCADE

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `categories`
(
  `id`       INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(50)      NOT NULL,
  `parentID` INT(11) UNSIGNED NULL DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `indexParentIDCategory` (`parentID`),

  CONSTRAINT `fkParentIDCategory` FOREIGN KEY (`parentID`) REFERENCES categories (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `products`
(
  `id`         INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`       VARCHAR(50)      NOT NULL,
  `image`      VARCHAR(255)     NOT NULL,
  `price`      DECIMAL(10, 2)   NOT NULL DEFAULT 0,
  `status`     BOOLEAN          NOT NULL DEFAULT TRUE,
  `categoryID` INT(11) UNSIGNED NOT NULL,

  PRIMARY KEY (`id`),

  KEY `indexCategoryDetailIDProducts` (`categoryID`),

  CONSTRAINT `fkCategoryIDProducts` FOREIGN KEY (`categoryID`) REFERENCES `categories` (`id`)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `reviews`
(
  `id`        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content`   TEXT             NOT NULL,
  `atTime`    DATETIME         NOT NULL DEFAULT NOW(),
  `userID`    INT(11) UNSIGNED NOT NULL,
  `productID` INT(11) UNSIGNED NOT NULL,

  PRIMARY KEY (`id`),

  KEY `indexUserIDReviews` (`userID`),
  KEY `indexProductIDReviews` (`productID`),

  CONSTRAINT `fkProductIDReviews` FOREIGN KEY (`productID`) REFERENCES `products` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fkUserIDReviews` FOREIGN KEY (`userID`) REFERENCES `users` (`id`) ON DELETE CASCADE

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `roles`
(
  `id`   INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45)      NOT NULL,

  PRIMARY KEY (`id`)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles`
  DISABLE KEYS */;

INSERT INTO `roles`(name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_CUSTOMER');

/*!40000 ALTER TABLE `roles`
  ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `profile`
(
  `id`       INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `fullName` VARCHAR(50)      NULL DEFAULT NULL,
  `phone`    VARCHAR(15)      NULL DEFAULT NULL,
  `century`  VARCHAR(20)      NOT NULL,
  `City`     VARCHAR(20)      NOT NULL,
  `district` VARCHAR(50)      NOT NULL,
  `ward`     VARCHAR(50)      NOT NULL,
  `address`  VARCHAR(120)     NOT NULL,
  `userID`   INT(11) UNSIGNED NOT NULL,

  PRIMARY KEY (`id`),

  UNIQUE (`userID`),

  KEY `indexUserIDAddress` (`userID`),

  CONSTRAINT `fkUserID` FOREIGN KEY (`userID`) REFERENCES users (`id`) ON DELETE CASCADE

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `users`
(
  `id`       INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `email`    VARCHAR(254)     NOT NULL,
  `password` VARCHAR(120)     NOT NULL,
  `roleID`   INT(11) UNSIGNED NOT NULL,
  `enable`   BOOLEAN          NOT NULL DEFAULT FALSE,

  PRIMARY KEY (`id`),

  UNIQUE (`email`),

  KEY `indexRoleIDUsers` (`roleID`),

  CONSTRAINT `fkRoleIDUsers` FOREIGN KEY (`roleID`) REFERENCES roles (`id`)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `verificationToken`
--

DROP TABLE IF EXISTS `verificationToken`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `verificationToken`
(
  `id`         INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `token`      VARCHAR(255)     NOT NULL,
  `expiryDate` DATETIME         NOT NULL DEFAULT NOW(),
  `userID`     INT(11) UNSIGNED NOT NULL,

  PRIMARY KEY (`id`),

  UNIQUE (`userID`),

  KEY `indexUserIDVerificationToken` (`userID`),

  CONSTRAINT `fkUserIDVerificationToken` FOREIGN KEY (`userID`) REFERENCES users (`id`) ON DELETE CASCADE

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `delivery`
(
  `id`       INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `fullName` VARCHAR(50)      NULL DEFAULT NULL,
  `phone`    VARCHAR(15)      NULL DEFAULT NULL,
  `century`  VARCHAR(30)      NOT NULL,
  `City`     VARCHAR(30)      NOT NULL,
  `district` VARCHAR(30)      NOT NULL,
  `ward`     VARCHAR(50)      NOT NULL,
  `address`  VARCHAR(120)     NOT NULL,

  PRIMARY KEY (`id`)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `orders`
(
  `id`         INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `orderDate`  DATETIME         NOT NULL DEFAULT NOW(),
  `userID`     INT(11) UNSIGNED NULL     DEFAULT NULL,
  `deliveryID` INT(11) UNSIGNED NULL     DEFAULT NULL,
  PRIMARY KEY (`id`),

  KEY `indexUserIDOrders` (`userID`),
  KEY `indexDeliveryIDOrders` (`deliveryID`),

  CONSTRAINT `fkDeliveryIDOrders` FOREIGN KEY (`deliveryID`) REFERENCES delivery (`id`),
  CONSTRAINT `fkUserIDOrders` FOREIGN KEY (`userID`) REFERENCES users (`id`) ON DELETE SET NULL

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `orderDetails`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `orderDetails`
(
  `id`        INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `quantity`  INT(11) UNSIGNED NOT NULL DEFAULT 1,
  `unitPrice` DECIMAL(10, 2)   NOT NULL,
  `productID` INT(11) UNSIGNED NOT NULL,
  `sizeID`    INT(11) UNSIGNED NOT NULL,
  `orderID`   INT(11) UNSIGNED NOT NULL,

  PRIMARY KEY (`id`),

  KEY `indexProductIDOrderDetails` (`productID`),
  KEY `indexOrderIDOrderDetails` (`orderID`),
  KEY `indexSizeIDOrderDetails` (`sizeID`),

  CONSTRAINT `fkProductIDOrderDetails` FOREIGN KEY (`productID`) REFERENCES products (`id`),
  CONSTRAINT `fkOrderIDOrderDetails` FOREIGN KEY (`orderID`) REFERENCES orders (`id`) ON DELETE CASCADE,
  CONSTRAINT `fkSizeIDOrderDetails` FOREIGN KEY (`sizeID`) REFERENCES size (`id`)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `paymentMethods`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `paymentMethods`
(
  `id`          INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(50)      NOT NULL,
  `description` TEXT             NULL DEFAULT NULL,

  PRIMARY KEY (`id`)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `paymentMethods` WRITE;
/*!40000 ALTER TABLE `paymentMethods`
  DISABLE KEYS */;

INSERT INTO `paymentMethods`(name)
VALUES ('Receive'),
       ('PayPal');

/*!40000 ALTER TABLE `paymentMethods`
  ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `payment`
(
  `id`              INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `status`          BOOLEAN          NOT NULL DEFAULT FALSE,
  `paymentDate`     DATETIME         NULL     DEFAULT NULL,
  `orderID`         INT(11) UNSIGNED NOT NULL,
  `paymentMethodID` INT(11) UNSIGNED NOT NULL,

  PRIMARY KEY (`id`),
  UNIQUE (`paymentMethodID`),
  UNIQUE (`orderID`),

  KEY `indexOrderIDPayment` (`orderID`),
  KEY `indexPaymentMethodPayment` (`paymentMethodID`),

  CONSTRAINT `fkOrderIDPayment` FOREIGN KEY (`orderID`) REFERENCES orders (`id`),
  CONSTRAINT `fkPaymentMethodIDPayment` FOREIGN KEY (`paymentMethodID`) REFERENCES paymentMethods (`id`)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

