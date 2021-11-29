/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : web

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2021-11-29 20:07:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `t_shopcar`;
CREATE TABLE `t_shopcar` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `salary` double(10,2) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shopcar
-- ----------------------------
INSERT INTO `t_shopcar` VALUES ('11', 'xiaomi 11', '00c2aebf-3302-408d-a322-af4da98b4d4f.jpg', '4599.00', '1');
INSERT INTO `t_shopcar` VALUES ('16', 'redmi k40 ', '3a3745b6-76f5-45d5-a713-3dcf7066481f.jpg', '1999.00', '1');
INSERT INTO `t_shopcar` VALUES ('17', '小米note10', '46002393-757c-4172-b401-de0694d351ee.jpg', '1999.00', '1');
