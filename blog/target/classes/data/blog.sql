/*
Navicat MySQL Data Transfer

Source Server         : DaNei
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2019-07-22 19:59:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(400) NOT NULL COMMENT '标题',
  `cover` varchar(400) DEFAULT NULL COMMENT '封面',
  `author` varchar(100) NOT NULL COMMENT '作者',
  `content` mediumint(9) DEFAULT NULL COMMENT '内容',
  `state` int(10) NOT NULL COMMENT '文章状态，0：隐藏，1：可见，3：删除',
  `type` int(10) DEFAULT NULL COMMENT '来源，0：原创，1：转载',
  `publish_time` datetime NOT NULL,
  `edit_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(100) NOT NULL COMMENT '书名',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `publishDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '出版日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', 'Java编程思想', '98.50', '2005-01-02 00:00:00');
INSERT INTO `books` VALUES ('2', 'HeadFirst设计模式', '55.70', '2010-11-09 00:00:00');
INSERT INTO `books` VALUES ('3', '第一行Android代码', '69.90', '2015-06-23 00:00:00');
INSERT INTO `books` VALUES ('4', 'C++编程思想', '88.50', '2004-01-09 00:00:00');
INSERT INTO `books` VALUES ('5', 'HeadFirst Java', '55.70', '2013-12-17 00:00:00');
INSERT INTO `books` VALUES ('6', '疯狂Android', '19.50', '2014-07-31 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(100) NOT NULL COMMENT '用户名,',
  `email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `password` varchar(100) NOT NULL COMMENT '用户密码,登录凭证',
  `true_name` varchar(50) DEFAULT NULL COMMENT '用户真实姓名',
  `sex` int(10) DEFAULT NULL COMMENT '性别',
  `phone` varchar(50) DEFAULT NULL COMMENT '用户联系方式',
  `icon` varchar(400) DEFAULT NULL COMMENT '头像,存放头像地址',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `addr` varchar(255) DEFAULT NULL COMMENT '地址',
  `create_time` datetime NOT NULL COMMENT '创建用户时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', null, '$2a$10$ZnhGYLZl4HyzkSUAMAEe5Onxy7ySRMll5JrFpKBrarAgh2Fz1q1ES', null, null, null, null, null, null, '2019-07-19 16:02:54');
INSERT INTO `user` VALUES ('2', 'adminadmin', null, '$2a$10$.HhMbiyV3.m0XvSD4eEI9elahk7tza3W.U3J.IfYQatcvlp1J2TO.', null, null, null, null, null, null, '2019-07-20 12:47:34');
INSERT INTO `user` VALUES ('3', 'admin1', null, '$2a$10$vGNkIEgqqMzaYEreTMhlTumCpLQkd3LBy9xTY28AIwlEvS0Fp71ey', null, null, null, null, null, null, '2019-07-20 12:53:52');
