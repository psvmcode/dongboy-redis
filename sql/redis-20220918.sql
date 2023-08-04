/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : redis

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 18/09/2022 21:43:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for seckill_commodity
-- ----------------------------
DROP TABLE IF EXISTS `seckill_commodity`;
CREATE TABLE `seckill_commodity`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `cdy_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `cdy_describe` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `cdy_status` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品状态',
  `cdy_price` decimal(10, 2) NOT NULL COMMENT '商品价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seckill_commodity
-- ----------------------------
INSERT INTO `seckill_commodity` VALUES (1, '111', '111', '2022-09-18 21:26:05', '2022-09-18 21:26:05', '', 0.00);
INSERT INTO `seckill_commodity` VALUES (2, '111', '111', '2022-09-18 21:28:07', '2022-09-18 21:28:07', '', 0.00);
INSERT INTO `seckill_commodity` VALUES (3, '第2个商品的名称', 'the 2 description!', '2022-09-18 20:25:28', '0000-00-00 00:00:00', '1', 3.20);
INSERT INTO `seckill_commodity` VALUES (4, '第3个商品的名称', 'the 3 description!', '2022-09-18 20:25:28', '0000-00-00 00:00:00', '1', 4.20);
INSERT INTO `seckill_commodity` VALUES (5, '第4个商品的名称', 'the 4 description!', '2022-09-18 20:25:28', '0000-00-00 00:00:00', '1', 5.20);
INSERT INTO `seckill_commodity` VALUES (6, '第5个商品的名称', 'the 5 description!', '2022-09-18 20:25:28', '0000-00-00 00:00:00', '1', 6.20);
INSERT INTO `seckill_commodity` VALUES (7, '第6个商品的名称', 'the 6 description!', '2022-09-18 20:25:28', '0000-00-00 00:00:00', '1', 7.20);
INSERT INTO `seckill_commodity` VALUES (8, '第7个商品的名称', 'the 7 description!', '2022-09-18 20:25:28', '0000-00-00 00:00:00', '1', 8.20);
INSERT INTO `seckill_commodity` VALUES (9, '第8个商品的名称', 'the 8 description!', '2022-09-18 20:25:28', '0000-00-00 00:00:00', '1', 9.20);
INSERT INTO `seckill_commodity` VALUES (10, '第9个商品的名称', 'the 9 description!', '2022-09-18 20:25:28', '0000-00-00 00:00:00', '1', 10.20);

-- ----------------------------
-- Table structure for seckill_order
-- ----------------------------
DROP TABLE IF EXISTS `seckill_order`;
CREATE TABLE `seckill_order`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `voucher_id` bigint(20) NULL DEFAULT NULL COMMENT '优惠券id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '下单时间',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seckill_order
-- ----------------------------

-- ----------------------------
-- Table structure for seckill_voucher
-- ----------------------------
DROP TABLE IF EXISTS `seckill_voucher`;
CREATE TABLE `seckill_voucher`  (
  `voucher_id` bigint(20) UNSIGNED NOT NULL COMMENT '关联的优惠券的id',
  `stock` int(8) NOT NULL COMMENT '库存',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `begin_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '生效时间',
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '失效时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`voucher_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '秒杀优惠券表，与优惠券是一对一关系' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of seckill_voucher
-- ----------------------------
INSERT INTO `seckill_voucher` VALUES (9, 10, '2022-09-13 15:43:41', '2022-09-13 15:43:41', '2022-09-15 15:43:41', '2022-09-14 17:59:22');

SET FOREIGN_KEY_CHECKS = 1;
