/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.61.45
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 192.168.61.45:3306
 Source Schema         : springbootdemo

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 27/11/2020 02:02:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '清单id',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '清单名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `run` tinyint DEFAULT '1' COMMENT '是否被删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES (1, 1, '今天', '2020-05-03 20:13:39', '2020-08-18 10:30:06', 1);
INSERT INTO `category` VALUES (2, NULL, 'Java学习', '2020-11-27 01:57:32', NULL, 1);
INSERT INTO `category` VALUES (41, 1, '明天', '2020-07-24 15:28:25', '2020-08-19 05:55:56', 1);
INSERT INTO `category` VALUES (85, 1, '购物', '2020-08-20 11:13:25', NULL, 1);
INSERT INTO `category` VALUES (86, 1, '学习', '2020-08-20 11:13:31', NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标签名称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `run` tinyint DEFAULT '1' COMMENT '是否还在使用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of label
-- ----------------------------
BEGIN;
INSERT INTO `label` VALUES (1, 1, '工作', '2020-08-17 16:45:13', '2020-08-18 16:53:39', 1);
INSERT INTO `label` VALUES (2, 1, '学习', '2020-08-17 16:45:17', '2020-08-18 16:53:39', 1);
INSERT INTO `label` VALUES (3, 1, '生活', '2020-08-17 16:58:49', '2020-08-19 06:08:09', 1);
INSERT INTO `label` VALUES (6, 1, '心智', '2020-08-20 11:13:54', NULL, 1);
INSERT INTO `label` VALUES (7, 1, 'Java', '2020-08-20 11:14:01', NULL, 1);
INSERT INTO `label` VALUES (8, 1, 'Mysql', '2020-08-20 11:14:10', NULL, 1);
INSERT INTO `label` VALUES (9, 1, '笔记', '2020-08-20 11:14:24', NULL, 1);
INSERT INTO `label` VALUES (10, 1, '家人', '2020-08-20 11:14:32', NULL, 1);
INSERT INTO `label` VALUES (11, 1, '朋友', '2020-08-20 11:14:35', NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `category_id` int DEFAULT '1' COMMENT '所属清单id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务名',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '任务描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `run` tinyint unsigned DEFAULT '1' COMMENT '是否完成',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of task
-- ----------------------------
BEGIN;
INSERT INTO `task` VALUES (4, 1, 1, '早起', '6点钟起床', '2020-05-03 22:36:53', '2020-08-20 11:12:21', 1);
INSERT INTO `task` VALUES (6, 1, 1, '早睡', '12点准时睡觉', '2020-05-04 10:35:19', '2020-08-20 11:13:03', 1);
INSERT INTO `task` VALUES (32, 1, 1, '学猫叫', '喵喵喵', '2020-05-31 19:11:05', '2020-08-20 11:12:02', 1);
INSERT INTO `task` VALUES (33, 1, 1, '学狗叫', '汪汪汪', '2020-05-31 19:11:14', '2020-08-20 11:12:02', 1);
INSERT INTO `task` VALUES (34, 1, 1, '学猪叫', '呃呃呃', '2020-05-31 19:11:24', '2020-08-20 11:12:02', 1);
COMMIT;

-- ----------------------------
-- Table structure for task_label
-- ----------------------------
DROP TABLE IF EXISTS `task_label`;
CREATE TABLE `task_label` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `task_id` int NOT NULL COMMENT '清单id',
  `label_id` int DEFAULT NULL COMMENT '标签id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of task_label
-- ----------------------------
BEGIN;
INSERT INTO `task_label` VALUES (1, 78, 1, '2020-08-16 08:31:56', NULL);
INSERT INTO `task_label` VALUES (2, 78, 2, '2020-08-16 08:31:56', NULL);
INSERT INTO `task_label` VALUES (3, 79, 1, '2020-08-16 08:42:44', NULL);
INSERT INTO `task_label` VALUES (4, 80, 1, '2020-08-16 08:42:54', NULL);
INSERT INTO `task_label` VALUES (5, 81, 1, '2020-08-16 12:41:59', NULL);
INSERT INTO `task_label` VALUES (6, 81, 2, '2020-08-16 12:41:59', NULL);
INSERT INTO `task_label` VALUES (7, 4, 1, '2020-08-16 20:22:03', NULL);
INSERT INTO `task_label` VALUES (8, 4, 2, '2020-08-16 20:22:03', NULL);
INSERT INTO `task_label` VALUES (9, 37, 1, '2020-08-17 11:18:52', NULL);
INSERT INTO `task_label` VALUES (10, 37, 2, '2020-08-17 11:18:52', NULL);
INSERT INTO `task_label` VALUES (11, 32, 1, '2020-08-17 11:19:01', NULL);
INSERT INTO `task_label` VALUES (12, 32, 2, '2020-08-17 11:19:01', NULL);
INSERT INTO `task_label` VALUES (13, 32, 1, '2020-08-17 11:19:12', NULL);
INSERT INTO `task_label` VALUES (14, 32, 2, '2020-08-17 11:19:12', NULL);
INSERT INTO `task_label` VALUES (15, 32, 1, '2020-08-17 13:37:26', NULL);
INSERT INTO `task_label` VALUES (16, 32, 2, '2020-08-17 13:37:26', NULL);
INSERT INTO `task_label` VALUES (17, 32, 1, '2020-08-17 13:37:26', NULL);
INSERT INTO `task_label` VALUES (18, 32, 2, '2020-08-17 13:37:26', NULL);
INSERT INTO `task_label` VALUES (19, 89, 2, '2020-08-17 19:24:29', NULL);
INSERT INTO `task_label` VALUES (20, 90, 2, '2020-08-18 10:21:13', NULL);
INSERT INTO `task_label` VALUES (21, 35, 2, '2020-08-18 10:21:24', NULL);
INSERT INTO `task_label` VALUES (22, 91, 1, '2020-08-18 17:00:50', NULL);
INSERT INTO `task_label` VALUES (23, 91, 2, '2020-08-18 17:00:50', NULL);
INSERT INTO `task_label` VALUES (24, 92, 1, '2020-08-18 19:37:18', NULL);
INSERT INTO `task_label` VALUES (25, 92, 2, '2020-08-18 19:37:18', NULL);
INSERT INTO `task_label` VALUES (26, 36, 1, '2020-08-18 19:38:26', NULL);
INSERT INTO `task_label` VALUES (27, 36, 2, '2020-08-18 19:38:26', NULL);
INSERT INTO `task_label` VALUES (28, 36, 1, '2020-08-19 05:41:42', NULL);
INSERT INTO `task_label` VALUES (29, 36, 2, '2020-08-19 05:41:42', NULL);
INSERT INTO `task_label` VALUES (30, 36, 3, '2020-08-19 05:41:42', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话号码',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `head_portrait` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `roles` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '权限',
  `status` tinyint DEFAULT '1' COMMENT '是否被冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'user', '15484596587', '$2a$10$sWcogzyDN43YUx38iUdADe9U4skcAtLcNQb93FmI3wg5xiom6V.P6', '2020-06-06 15:36:54', '2020-07-22 09:41:21', '541269@qq.ocm', NULL, 'ROLE_USER', 1);
INSERT INTO `user` VALUES (2, 'admin', '12569854865', '$2a$10$sWcogzyDN43YUx38iUdADe9U4skcAtLcNQb93FmI3wg5xiom6V.P6', '2020-06-06 15:37:09', '2020-07-22 09:41:25', '98714649544@qq.com', NULL, 'ROLE_USER', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
