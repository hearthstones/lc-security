/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 49.234.56.182:3306
 Source Schema         : security_oauth

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 17/11/2021 16:19:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'client_id',
  `resource_ids` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源id（\',\'分隔）',
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'client_secret（加密）',
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限范围',
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支持的授权方式',
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '重定向URL',
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `access_token_validity` int(11) NULL DEFAULT NULL COMMENT 'access_token有效期（单位秒）',
  `refresh_token_validity` int(11) NULL DEFAULT NULL COMMENT 'refresh_token有效期（单位秒）',
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'ClientDetails表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('app', 'oauth2-resource', '$2a$10$1KZrwgizSB22uhX7MlU7punrROak0SU3tmolASIqaGGWGfzJjNax.', 'app', 'password,refresh_token,custom', 'http://baidu.com', 'ROLE_CLIENT', 1728001, 788000000, NULL, NULL);
INSERT INTO `oauth_client_details` VALUES ('web', 'oauth2-resource', '$2a$10$1KZrwgizSB22uhX7MlU7punrROak0SU3tmolASIqaGGWGfzJjNax.', 'web', 'password,refresh_token,custom', 'http://baidu.com', 'ROLE_CLIENT', 1728001, 788000000, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
