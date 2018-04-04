/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.20 : Database - user
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`user` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `user`;

/*Table structure for table `user_emp_entity` */

DROP TABLE IF EXISTS `user_emp_entity`;

CREATE TABLE `user_emp_entity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_date` bigint(20) DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  `update_date` bigint(20) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL COMMENT '性別',
  `permission` int(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `user_emp_entity` */

insert  into `user_emp_entity`(`id`,`username`,`password`,`create_date`,`create_by`,`update_by`,`update_date`,`sex`,`permission`) values (1,'admin','123456',1517557115288,'admin','admin',1517557115288,1,3),(2,'阿丁','456',1517557115288,NULL,NULL,1517557115288,2,4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
