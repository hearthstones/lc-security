/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 49.234.56.182:3306
 Source Schema         : security-demo

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 17/11/2021 19:21:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `mobile` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名（唯一）',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `clear_text` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '明文密码（实际应用中不应有该字段）',
  `enabled` tinyint(1) NULL DEFAULT NULL COMMENT '账号是否可用',
  `account_non_locked` tinyint(1) NULL DEFAULT NULL COMMENT '账号是否没被锁定',
  `account_non_expired` tinyint(1) NULL DEFAULT NULL COMMENT '账号是否没过期',
  `credentials_non_expired` tinyint(1) NULL DEFAULT NULL COMMENT '（凭证）密码是否没过期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_username`(`username`) USING BTREE COMMENT '用户名唯一索引',
  UNIQUE INDEX `uk_mobile`(`mobile`) USING BTREE COMMENT '手机号唯一索引'
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '15937379999', 'Tom', '$2a$10$pmKlnl.ny62NWK0vbCc/Ken8Kt3ZSuCT8EjO1TCuajr1m31fdUz66', '123456', 1, 0, 1, 1);
INSERT INTO `user` VALUES (2, '15966669999', 'Jack', '$2a$10$sS3nSINLx8kBd8E7IYGwceJNpAUkMdQy1yxu1bQJ0bxN10chXQRIm', '445566', 1, 1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
