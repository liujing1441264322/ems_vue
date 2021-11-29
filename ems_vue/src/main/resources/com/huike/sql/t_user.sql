/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : web

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2021-11-29 20:07:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(60) DEFAULT NULL,
  `realname` varchar(60) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL,
  `regsterTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', 'admin', '小陈', '123', '男', '已激活', '2020-06-20 08:43:35');
INSERT INTO `t_user` VALUES ('4', 'zhangsan', '小张', '123', '男', '已激活', '2020-06-20 08:53:22');
INSERT INTO `t_user` VALUES ('7', '大大', 'admin', '123', '男', '已激活', '2021-11-10 19:09:57');
INSERT INTO `t_user` VALUES ('13', '123', 'admin', '123', null, '已激活', '2021-11-12 13:41:32');
INSERT INTO `t_user` VALUES ('20', '阿信', '阿信', '123456', '男', '已激活', '2021-11-12 17:02:00');
INSERT INTO `t_user` VALUES ('28', '刘京', '1441264322', '1441264322', '男', '已激活', '2021-11-15 22:18:50');
INSERT INTO `t_user` VALUES ('29', 'liuj', '1441264322', '1441264322', null, '已激活', '2021-11-15 22:18:59');
INSERT INTO `t_user` VALUES ('30', '1441264322', '刘京', '1441264322', '男', '已激活', '2021-11-15 22:22:00');
INSERT INTO `t_user` VALUES ('31', '陈欣怡', '456', '123', '女', '已激活', '2021-11-16 10:17:14');
