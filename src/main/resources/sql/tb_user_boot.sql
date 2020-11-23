/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1-mysql-root
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : kettle

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 20/11/2020 16:33:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user_boot
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_boot`;
CREATE TABLE `tb_user_boot`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `age` int(4) NULL DEFAULT NULL COMMENT '用户年龄',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_boot
-- ----------------------------
INSERT INTO `tb_user_boot` VALUES (1, 'a', 2334);
INSERT INTO `tb_user_boot` VALUES (2, 'b', 22);
INSERT INTO `tb_user_boot` VALUES (3, 'a', 22);
INSERT INTO `tb_user_boot` VALUES (4, 'd', 22);
INSERT INTO `tb_user_boot` VALUES (5, 'a', 22);
INSERT INTO `tb_user_boot` VALUES (6, 'f', 22);
INSERT INTO `tb_user_boot` VALUES (7, 'g', 22);
INSERT INTO `tb_user_boot` VALUES (8, 'h', 22);
INSERT INTO `tb_user_boot` VALUES (9, 'i', 22);
INSERT INTO `tb_user_boot` VALUES (10, 'j', 22);
INSERT INTO `tb_user_boot` VALUES (11, 'k', 22);
INSERT INTO `tb_user_boot` VALUES (12, 'l', 22);
INSERT INTO `tb_user_boot` VALUES (13, 'm', 22);
INSERT INTO `tb_user_boot` VALUES (14, 'n', 22);
INSERT INTO `tb_user_boot` VALUES (16, 'p', 22);
INSERT INTO `tb_user_boot` VALUES (17, 'q', 22);
INSERT INTO `tb_user_boot` VALUES (18, 'r', 22);
INSERT INTO `tb_user_boot` VALUES (19, 's', 22);
INSERT INTO `tb_user_boot` VALUES (20, 't', 22);
INSERT INTO `tb_user_boot` VALUES (21, 'aa', 25);
INSERT INTO `tb_user_boot` VALUES (22, 'aa', 25);
INSERT INTO `tb_user_boot` VALUES (23, 'aa', 26);
INSERT INTO `tb_user_boot` VALUES (25, 'aa', 12);

SET FOREIGN_KEY_CHECKS = 1;
