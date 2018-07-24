/*
 Navicat Premium Data Transfer

 Source Server         : cat
 Source Server Type    : MySQL
 Source Server Version : 100131
 Source Host           : localhost:3306
 Source Schema         : catdb

 Target Server Type    : MySQL
 Target Server Version : 100131
 File Encoding         : 65001

 Date: 24/07/2018 15:28:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for c_album
-- ----------------------------
DROP TABLE IF EXISTS `c_album`;
CREATE TABLE `c_album`  (
  `album_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `album_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `album_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `album_cover_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `album_gmt_create` datetime(4) NOT NULL,
  `album_gmt_modified` datetime(4) NOT NULL,
  PRIMARY KEY (`album_id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_deleted`(`is_deleted`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_album
-- ----------------------------
INSERT INTO `c_album` VALUES (1, 1, '人物', '人物相册。', 'http://127.0.0.1:8080/ssm/images/test/figure.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_album` VALUES (2, 1, '风景', '风景图片。', 'http://127.0.0.1:8080/ssm/images/test/scenery.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_album` VALUES (3, 1, '美食', '美食集合。', 'http://127.0.0.1:8080/ssm/images/test/food.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');

-- ----------------------------
-- Table structure for c_group
-- ----------------------------
DROP TABLE IF EXISTS `c_group`;
CREATE TABLE `c_group`  (
  `group_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `group_parent_id` int(11) UNSIGNED NOT NULL,
  `group_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `group_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `group_gmt_create` datetime(4) NOT NULL,
  `group_gmt_modified` datetime(4) NOT NULL,
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_group
-- ----------------------------
INSERT INTO `c_group` VALUES (1, 0, '婴儿', '0-6', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_group` VALUES (2, 0, '少年', '6-12', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_group` VALUES (3, 0, '青年', '12-20', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_group` VALUES (4, 0, '壮年', '20-30', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_group` VALUES (5, 0, '中年', '30-50', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_group` VALUES (6, 0, '老年', '50-100', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_group` VALUES (7, 0, '开发部', 'admin', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_group` VALUES (8, 0, '测试部', 'admin', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_group` VALUES (9, 0, '产品部', 'vvip', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');

-- ----------------------------
-- Table structure for c_group_permission
-- ----------------------------
DROP TABLE IF EXISTS `c_group_permission`;
CREATE TABLE `c_group_permission`  (
  `gp_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `group_id` int(11) UNSIGNED NOT NULL,
  `permisson_id` int(11) UNSIGNED NOT NULL,
  `gp_gmt_create` datetime(4) NOT NULL,
  `gp_gmt_modified` datetime(4) NOT NULL,
  PRIMARY KEY (`gp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_group_role
-- ----------------------------
DROP TABLE IF EXISTS `c_group_role`;
CREATE TABLE `c_group_role`  (
  `gr_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `group_id` int(11) UNSIGNED NOT NULL,
  `role_id` int(11) UNSIGNED NOT NULL,
  `gr_gmt_create` datetime(4) NOT NULL,
  `gt_gmt_modified` datetime(4) NOT NULL,
  PRIMARY KEY (`gr_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for c_image
-- ----------------------------
DROP TABLE IF EXISTS `c_image`;
CREATE TABLE `c_image`  (
  `image_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `album_id` int(11) UNSIGNED NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `image_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `image_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `image_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `image_gmt_create` datetime(4) NOT NULL,
  `image_gmt_modified` datetime(4) NOT NULL,
  PRIMARY KEY (`image_id`) USING BTREE,
  INDEX `idx_album_id`(`album_id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_deleted`(`is_deleted`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_image
-- ----------------------------
INSERT INTO `c_image` VALUES (1, 1, 1, '', '人物1', '人物，人物，人物。', 'http://127.0.0.1:8080/ssm/images/test/figure1.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_image` VALUES (2, 1, 1, '', '人物2', '人物，人物，人物。', 'http://127.0.0.1:8080/ssm/images/test/figure2.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_image` VALUES (3, 2, 1, '', '风景1', '风景，风景，风景。', 'http://127.0.0.1:8080/ssm/images/test/scenery1.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_image` VALUES (4, 2, 1, '', '风景2', '风景，风景，风景。', 'http://127.0.0.1:8080/ssm/images/test/scenery2.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_image` VALUES (5, 3, 1, '', '美食1', '美食，美食，美食。', 'http://127.0.0.1:8080/ssm/images/test/food1.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_image` VALUES (6, 3, 1, '', '美食2', '美食，美食，美食。', 'http://127.0.0.1:8080/ssm/images/test/food2.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');

-- ----------------------------
-- Table structure for c_info
-- ----------------------------
DROP TABLE IF EXISTS `c_info`;
CREATE TABLE `c_info`  (
  `info_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `info_title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `info_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `info_level` int(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '0:info 1:warn 2:error',
  `info_gmt_create` datetime(4) NOT NULL,
  `info_gmt_finish` datetime(4) NOT NULL,
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_info
-- ----------------------------
INSERT INTO `c_info` VALUES (1, 1, '欢迎注册', '注册信息 error', 2, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_info` VALUES (2, 1, '欢迎登录', '登录信息 warn', 1, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_info` VALUES (3, 1, '欢迎使用', '使用信息 info', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');

-- ----------------------------
-- Table structure for c_log
-- ----------------------------
DROP TABLE IF EXISTS `c_log`;
CREATE TABLE `c_log`  (
  `log_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `user_role_id` int(11) UNSIGNED NOT NULL,
  `user_ip` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `log_record_time` timestamp(4) NOT NULL ON UPDATE CURRENT_TIMESTAMP(4),
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_log
-- ----------------------------
INSERT INTO `c_log` VALUES (1, 1, 1, '127.0.0.1', '中国，无锡', 'PC', '2018-07-24 14:31:16.9976');
INSERT INTO `c_log` VALUES (2, 1, 1, '127.0.0.1', '中国，上海', 'Android', '2018-07-24 14:31:42.0753');

-- ----------------------------
-- Table structure for c_permission
-- ----------------------------
DROP TABLE IF EXISTS `c_permission`;
CREATE TABLE `c_permission`  (
  `permission_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `permission_parent_id` int(11) UNSIGNED NOT NULL DEFAULT 0,
  `permission_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permission_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permission_gmt_create` datetime(4) NOT NULL ON UPDATE CURRENT_TIMESTAMP(4),
  `permission_gmt_modified` datetime(4) NOT NULL ON UPDATE CURRENT_TIMESTAMP(4),
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_permission
-- ----------------------------
INSERT INTO `c_permission` VALUES (1, 0, 'create', '创建全部', '2018-07-24 15:10:19.5617', '2018-07-24 15:10:19.5617');
INSERT INTO `c_permission` VALUES (2, 0, 'read', '查看全部', '2018-07-24 15:10:22.2336', '2018-07-24 15:10:22.2336');
INSERT INTO `c_permission` VALUES (3, 0, 'update', '更新全部', '2018-07-24 15:10:24.8472', '2018-07-24 15:10:24.8472');
INSERT INTO `c_permission` VALUES (4, 0, 'delete', '删除全部', '2018-07-24 15:10:33.5052', '2018-07-24 15:10:33.5052');
INSERT INTO `c_permission` VALUES (5, 0, 'create-album', '创建相册', '2018-07-24 15:06:39.0336', '2018-07-24 15:06:39.0336');
INSERT INTO `c_permission` VALUES (6, 0, 'read-album', '查看相册', '2018-07-24 15:06:42.6854', '2018-07-24 15:06:42.6854');
INSERT INTO `c_permission` VALUES (7, 0, 'update-album', '更新相册', '2018-07-24 15:06:45.8296', '2018-07-24 15:06:45.8296');
INSERT INTO `c_permission` VALUES (8, 0, 'delete-album', '删除相册', '2018-07-24 15:06:49.5519', '2018-07-24 15:06:49.5519');
INSERT INTO `c_permission` VALUES (9, 0, 'create-image', '创建图片', '2018-07-24 15:07:54.0529', '2018-07-24 15:07:54.0529');
INSERT INTO `c_permission` VALUES (10, 0, 'read-image', '查看图片', '2018-07-24 15:07:57.6561', '2018-07-24 15:07:57.6561');
INSERT INTO `c_permission` VALUES (11, 0, 'update-image', '更新图片', '2018-07-24 15:08:00.0100', '2018-07-24 15:08:00.0100');
INSERT INTO `c_permission` VALUES (12, 0, 'delete-image', '删除图片', '2018-07-24 15:08:02.5217', '2018-07-24 15:08:02.5217');
INSERT INTO `c_permission` VALUES (13, 0, 'create-record', '创建记录', '2018-07-24 15:08:28.0837', '2018-07-24 15:08:28.0837');
INSERT INTO `c_permission` VALUES (14, 0, 'read-record', '查看记录', '2018-07-24 15:08:30.9107', '2018-07-24 15:08:30.9107');
INSERT INTO `c_permission` VALUES (15, 0, 'update-record', '更新记录', '2018-07-24 15:08:33.5730', '2018-07-24 15:08:33.5730');
INSERT INTO `c_permission` VALUES (16, 0, 'delete-record', '删除记录', '2018-07-24 15:08:35.8688', '2018-07-24 15:08:35.8688');
INSERT INTO `c_permission` VALUES (17, 0, 'create-comment', '创建留言', '2018-07-24 15:09:27.4936', '2018-07-24 15:09:27.4936');
INSERT INTO `c_permission` VALUES (18, 0, 'read-comment', '查看留言', '2018-07-24 15:09:30.9162', '2018-07-24 15:09:30.9162');
INSERT INTO `c_permission` VALUES (19, 0, 'update-comment', '更新留言', '2018-07-24 15:09:33.9624', '2018-07-24 15:09:33.9624');
INSERT INTO `c_permission` VALUES (20, 0, 'delete-comment', '删除留言', '2018-07-24 15:09:36.9509', '2018-07-24 15:09:36.9509');

-- ----------------------------
-- Table structure for c_record
-- ----------------------------
DROP TABLE IF EXISTS `c_record`;
CREATE TABLE `c_record`  (
  `record_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `post_id` bigint(20) UNSIGNED NOT NULL,
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `record_gmt_create` datetime(4) NOT NULL,
  `record_gmt_modified` datetime(4) NOT NULL,
  PRIMARY KEY (`record_id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_record
-- ----------------------------
INSERT INTO `c_record` VALUES (1, 1, 1, 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_record` VALUES (2, 1, 2, 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_record` VALUES (3, 1, 3, 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');

-- ----------------------------
-- Table structure for c_record_comment
-- ----------------------------
DROP TABLE IF EXISTS `c_record_comment`;
CREATE TABLE `c_record_comment`  (
  `comment_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `comment_record_id` bigint(20) UNSIGNED NOT NULL,
  `comment_customer_id` bigint(20) UNSIGNED NOT NULL,
  `comment_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `comment_gmt_create` datetime(4) NOT NULL,
  `comment_gmt_modified` datetime(4) NOT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_record_comment
-- ----------------------------
INSERT INTO `c_record_comment` VALUES (1, 1, 1, '第一条评论。', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_record_comment` VALUES (2, 2, 1, '第二条评论。', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_record_comment` VALUES (3, 3, 1, '第一条评论。', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');

-- ----------------------------
-- Table structure for c_record_post
-- ----------------------------
DROP TABLE IF EXISTS `c_record_post`;
CREATE TABLE `c_record_post`  (
  `post_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `post_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `post_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `post_image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_record_post
-- ----------------------------
INSERT INTO `c_record_post` VALUES (1, '欢迎使用lifecat', '欢迎使用lifecat，欢迎使用lifecat，欢迎使用lifecat。', 'http://127.0.0.1:8080/ssm/images/test/record.jpg');
INSERT INTO `c_record_post` VALUES (2, '这是您的第一篇文章', '这是您的第一篇文章，这是您的第一篇文章，这是您的第一篇文章。', 'http://127.0.0.1:8080/ssm/images/test/record.jpg');
INSERT INTO `c_record_post` VALUES (3, '今天天气不错', '今天天气不错，今天天气不错，今天天气不错。', 'http://127.0.0.1:8080/ssm/images/test/record.jpg');

-- ----------------------------
-- Table structure for c_role
-- ----------------------------
DROP TABLE IF EXISTS `c_role`;
CREATE TABLE `c_role`  (
  `role_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_parent_id` int(11) UNSIGNED NOT NULL DEFAULT 0,
  `role_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_role_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `role_gmt_create` datetime(4) NOT NULL,
  `role_gmt_modified` datetime(4) NOT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_role
-- ----------------------------
INSERT INTO `c_role` VALUES (1, 0, 'super', 'super', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role` VALUES (2, 0, 'admin', 'admin', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role` VALUES (3, 0, 'user_vip_super', 'vvip', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role` VALUES (4, 0, 'user_vip', 'vip', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role` VALUES (5, 0, 'user', 'user', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role` VALUES (6, 0, 'tourist', 'tourist', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');

-- ----------------------------
-- Table structure for c_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `c_role_permission`;
CREATE TABLE `c_role_permission`  (
  `rp_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_id` int(11) UNSIGNED NOT NULL,
  `permission_id` int(11) UNSIGNED NOT NULL,
  `rp_gmt_create` datetime(4) NOT NULL,
  `rp_gmt_modified` datetime(4) NOT NULL,
  PRIMARY KEY (`rp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_role_permission
-- ----------------------------
INSERT INTO `c_role_permission` VALUES (1, 1, 1, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (2, 1, 2, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (3, 1, 3, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (4, 1, 4, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (5, 2, 1, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (6, 2, 2, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (7, 2, 3, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (8, 2, 4, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (9, 3, 1, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (10, 3, 2, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (11, 3, 3, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (12, 3, 4, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (13, 4, 1, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (14, 4, 2, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (15, 4, 3, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (16, 4, 4, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (17, 5, 1, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (18, 5, 2, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (19, 5, 3, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (20, 5, 4, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (21, 6, 6, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (22, 6, 10, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (23, 6, 14, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_role_permission` VALUES (24, 6, 18, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');

-- ----------------------------
-- Table structure for c_user
-- ----------------------------
DROP TABLE IF EXISTS `c_user`;
CREATE TABLE `c_user`  (
  `user_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_account_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_account_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '游客',
  `user_sex` tinyint(2) UNSIGNED NOT NULL DEFAULT 0,
  `user_birthday` datetime(4) NOT NULL,
  `user_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `user_location` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `user_phone_number` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `user_icon_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `is_user_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `user_gmt_create` datetime(4) NOT NULL,
  `user_gmt_modified` datetime(4) NOT NULL,
  `user_last_login` datetime(4) NOT NULL,
  `user_login_count` bigint(20) UNSIGNED NOT NULL DEFAULT 1,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `uk_user_account_name`(`user_account_name`) USING BTREE,
  INDEX `idx_user_name`(`user_name`) USING BTREE,
  INDEX `idx_deleted`(`is_user_deleted`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_user
-- ----------------------------
INSERT INTO `c_user` VALUES (1, 'ten', 'ten', 'super', 1, '0000-00-00 00:00:00.0000', 'wshten@gmail.com', '中国，无锡', '18812345678', 'http://127.0.0.1:8080/ssm/images/test/super.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000', 1);
INSERT INTO `c_user` VALUES (2, 'admin', 'admin', 'admin', 1, '0000-00-00 00:00:00.0000', 'admin@qq.com', '中国，上海', '19912345678', 'http://127.0.0.1:8080/ssm/images/test/admin.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000', 1);
INSERT INTO `c_user` VALUES (3, 'vvip', 'vvip', 'vvip', 2, '0000-00-00 00:00:00.0000', 'vvip@qq.com', '中国，上海', '19912345678', 'http://127.0.0.1:8080/ssm/images/test/vvip.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000', 1);
INSERT INTO `c_user` VALUES (4, 'vip', 'vip', 'vip', 2, '0000-00-00 00:00:00.0000', 'vip@qq.com', '中国，上海', '19912345678', 'http://127.0.0.1:8080/ssm/images/test/vip.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000', 1);
INSERT INTO `c_user` VALUES (5, 'user', 'user', 'user', 0, '0000-00-00 00:00:00.0000', 'user@qq.com', '中国，上海', '19912345678', 'http://127.0.0.1:8080/ssm/images/test/user.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000', 1);
INSERT INTO `c_user` VALUES (6, 'tourist', 'tourist', 'tourist', 0, '0000-00-00 00:00:00.0000', 'tourist@qq.com', '中国，上海', '19912345678', 'http://127.0.0.1:8080/ssm/images/test/tourist.jpg', 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000', 1);

-- ----------------------------
-- Table structure for c_user_group
-- ----------------------------
DROP TABLE IF EXISTS `c_user_group`;
CREATE TABLE `c_user_group`  (
  `ug_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `group_id` int(11) UNSIGNED NOT NULL,
  `ug_gmt_create` datetime(4) NOT NULL,
  `ug_gmt_modified` datetime(4) NOT NULL,
  PRIMARY KEY (`ug_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_user_group
-- ----------------------------
INSERT INTO `c_user_group` VALUES (1, 1, 4, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_group` VALUES (2, 2, 4, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_group` VALUES (3, 3, 2, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_group` VALUES (4, 4, 4, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_group` VALUES (5, 5, 3, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_group` VALUES (6, 6, 6, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');

-- ----------------------------
-- Table structure for c_user_permission
-- ----------------------------
DROP TABLE IF EXISTS `c_user_permission`;
CREATE TABLE `c_user_permission`  (
  `up_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `permission_id` int(11) UNSIGNED NOT NULL,
  `up_gmt_create` datetime(4) NOT NULL,
  `up_gmt_modified` datetime(4) NOT NULL,
  PRIMARY KEY (`up_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_user_permission
-- ----------------------------
INSERT INTO `c_user_permission` VALUES (1, 1, 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_permission` VALUES (2, 2, 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_permission` VALUES (3, 3, 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_permission` VALUES (4, 4, 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_permission` VALUES (5, 5, 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_permission` VALUES (6, 6, 0, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');

-- ----------------------------
-- Table structure for c_user_role
-- ----------------------------
DROP TABLE IF EXISTS `c_user_role`;
CREATE TABLE `c_user_role`  (
  `ur_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) UNSIGNED NOT NULL,
  `role_id` int(11) UNSIGNED NOT NULL,
  `ur_gmt_create` datetime(4) NOT NULL,
  `ur_gmt_modified` datetime(4) NOT NULL,
  PRIMARY KEY (`ur_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_user_role
-- ----------------------------
INSERT INTO `c_user_role` VALUES (1, 1, 1, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_role` VALUES (2, 2, 2, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_role` VALUES (3, 3, 3, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_role` VALUES (4, 4, 4, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_role` VALUES (5, 5, 5, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');
INSERT INTO `c_user_role` VALUES (6, 6, 6, '0000-00-00 00:00:00.0000', '0000-00-00 00:00:00.0000');

SET FOREIGN_KEY_CHECKS = 1;
