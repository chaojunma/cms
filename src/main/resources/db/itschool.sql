/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : itschool

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 26/04/2019 11:27:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `series_id` int(20) NOT NULL DEFAULT 0,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES (1, 1, 'JFinal极速开发之从零开始', 'https://study.163.com/course/courseMain.htm?share=2&shareId=400000000551018&courseId=1005740018&_trace_c_p_k2_=b59d880efc0541019fedf94f23355208', '2019-04-26 11:27:29');

-- ----------------------------
-- Table structure for class_series
-- ----------------------------
DROP TABLE IF EXISTS `class_series`;
CREATE TABLE `class_series`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `classify_id` int(20) NOT NULL DEFAULT 0,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `instructor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `pv` int(10) NOT NULL DEFAULT 0,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `about_instructor` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class_series
-- ----------------------------
INSERT INTO `class_series` VALUES (1, 1, 'JFinal系列课程', '开发 jfinal 项目建议使用 maven，而不是使用传统手工的方式去管理 jar 包和构建项目。由于 maven 应用十分广泛，互联网已经有很多 maven 方面的资源，所以本小节只介绍 maven 使用的最基础的几个小点，了解这几个点上手使用 jfinal 已经够用。', '小明童鞋', 0, '2019-04-26 11:14:00', '有丰富的研发经验', '');

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES (1, 'JAVA', '2019-04-26 10:55:47');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL DEFAULT 0,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (1, 1, '/classify/saveOrUpdate', '{\"name\":[\"JAVA\"],\"id\":[\"\"]}', 'error', 'com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column \'id\' cannot be null', '172.22.83.4');
INSERT INTO `sys_log` VALUES (2, 1, '/classify/saveOrUpdate', '{\"name\":[\"JAVA\"],\"id\":[\"\"]}', 'error', 'com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column \'id\' cannot be null', '172.22.83.4');
INSERT INTO `sys_log` VALUES (3, 1, '/classify/saveOrUpdate', '{\"name\":[\"JAVA\"],\"id\":[\"\"]}', 'error', 'com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column \'id\' cannot be null', '172.22.83.4');
INSERT INTO `sys_log` VALUES (4, 1, '/classify/saveOrUpdate', '{\"name\":[\"JAVA\"],\"id\":[\"\"]}', 'info', '{\"code\":200,\"message\":\"success\"}', '172.22.83.4');
INSERT INTO `sys_log` VALUES (5, 1, '/series/saveOrUpdate', '{}', 'error', 'The model attribute classify_id is not exists.', '172.22.83.4');
INSERT INTO `sys_log` VALUES (6, 1, '/series/saveOrUpdate', '{}', 'error', 'The model attribute classify_id is not exists.', '172.22.83.4');
INSERT INTO `sys_log` VALUES (7, 1, '/series/saveOrUpdate', '{}', 'error', 'The model attribute about_instructor is not exists.', '172.22.83.4');
INSERT INTO `sys_log` VALUES (8, 1, '/series/saveOrUpdate', '{}', 'error', 'The model attribute about_instructor is not exists.', '172.22.83.4');
INSERT INTO `sys_log` VALUES (9, 1, '/series/saveOrUpdate', '{}', 'error', 'The model attribute about_instructor is not exists.', '172.22.83.4');
INSERT INTO `sys_log` VALUES (10, 1, '/series/saveOrUpdate', '{}', 'error', 'The model attribute about_instructor is not exists.', '172.22.83.4');
INSERT INTO `sys_log` VALUES (11, 1, '/series/saveOrUpdate', '{}', 'error', 'java.lang.reflect.InvocationTargetException', '172.22.83.4');
INSERT INTO `sys_log` VALUES (12, 1, '/class/saveOrUpdate', '{\"title\":[\"JFinal极速开发之从零开始\"],\"url\":[\"https://study.163.com/course/courseMain.htm?share=2&shareId=400000000551018&courseId=1005740018&_trace_c_p_k2_=b59d880efc0541019fedf94f23355208\"],\"series_id\":[\"1\"]}', 'error', 'The model attribute series_id is not exists.', '172.22.83.4');
INSERT INTO `sys_log` VALUES (13, 1, '/class/saveOrUpdate', '{\"title\":[\"JFinal极速开发之从零开始\"],\"url\":[\"https://study.163.com/course/courseMain.htm?share=2&shareId=400000000551018&courseId=1005740018&_trace_c_p_k2_=b59d880efc0541019fedf94f23355208\"],\"series_id\":[\"1\"]}', 'error', 'The model attribute series_id is not exists.', '172.22.83.4');
INSERT INTO `sys_log` VALUES (14, 1, '/class/saveOrUpdate', '{\"title\":[\"JFinal极速开发之从零开始\"],\"url\":[\"https://study.163.com/course/courseMain.htm?share=2&shareId=400000000551018&courseId=1005740018&_trace_c_p_k2_=b59d880efc0541019fedf94f23355208\"],\"series_id\":[\"1\"]}', 'error', 'java.sql.SQLException: Field \'id\' doesn\'t have a default value', '172.22.83.4');
INSERT INTO `sys_log` VALUES (15, 1, '/class/saveOrUpdate', '{\"title\":[\"JFinal极速开发之从零开始\"],\"url\":[\"https://study.163.com/course/courseMain.htm?share=2&shareId=400000000551018&courseId=1005740018&_trace_c_p_k2_=b59d880efc0541019fedf94f23355208\"],\"series_id\":[\"1\"]}', 'info', '{\"code\":200,\"message\":\"success\"}', '172.22.83.4');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `is_lock` int(4) NOT NULL DEFAULT 0,
  `online` int(4) NOT NULL DEFAULT 0,
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '小明童鞋', '13700370977', 'xiaoming@163.com', '12345678', 0, 1, '2019-04-26 10:40:37');

SET FOREIGN_KEY_CHECKS = 1;
