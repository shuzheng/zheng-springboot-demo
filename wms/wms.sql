/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : wms

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-06-05 18:14:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `count` int(11) DEFAULT NULL COMMENT '库存数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='库存表';

-- ----------------------------
-- Records of inventory
-- ----------------------------

-- ----------------------------
-- Table structure for records
-- ----------------------------
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购买记录ID',
  `productId` int(11) DEFAULT NULL COMMENT '购买商品ID',
  `count` int(11) DEFAULT NULL COMMENT '购买商品数量',
  `userId` int(11) DEFAULT NULL COMMENT '购买用户ID',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购买记录表';

-- ----------------------------
-- Records of records
-- ----------------------------
