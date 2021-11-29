/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : web

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2021-11-29 20:06:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_emp
-- ----------------------------
DROP TABLE IF EXISTS `t_emp`;
CREATE TABLE `t_emp` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `salary` double(10,2) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_emp
-- ----------------------------
INSERT INTO `t_emp` VALUES ('21', 'xiaomi 11', 'f3f09c84-ff05-4df6-adf2-f9e2a64b56c9.jpg', '4599.00', '2');
INSERT INTO `t_emp` VALUES ('22', 'xiaomi 11', 'a47c2412-46a5-42c9-926e-17e83da87656.jpg', '4599.00', '1');
INSERT INTO `t_emp` VALUES ('23', 'xiaomi 11 pro', '0857f3c9-1261-4ade-aeb5-ce441dd8fc2a.jpg', '4999.00', '20');
INSERT INTO `t_emp` VALUES ('24', 'xiaomi11 青春版', '8e5891f2-b23c-4f88-bbad-40ba45830fb4.jpg', '1999.00', '2');
INSERT INTO `t_emp` VALUES ('25', 'redmi k40', 'c1cb4c71-256c-475b-b08a-6b95bebd38dc.jpg', '1999.00', '20');
INSERT INTO `t_emp` VALUES ('31', 'redmi k40 pro', '7d23b6ad-9c77-431a-b4e0-a77df3e50337.jpg', '2499.00', '1');
