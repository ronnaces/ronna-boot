/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 80300 (8.3.0)
 Source Host           : localhost:3306
 Source Schema         : ronna_cloud

 Target Server Type    : MySQL
 Target Server Version : 80300 (8.3.0)
 File Encoding         : 65001

 Date: 29/02/2024 11:00:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_department
-- ----------------------------
DROP TABLE IF EXISTS `system_department`;
CREATE TABLE `system_department`  (
  `id` bigint NOT NULL,
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '编码',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父级ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `ranking` int NULL DEFAULT NULL COMMENT '排名',
  `category` tinyint NULL DEFAULT NULL COMMENT '类别: 1-公司, 2-部门, 3-职位',
  `type` tinyint NULL DEFAULT NULL COMMENT '类型: 1-顶级部门, 2-子部门',
  `whether_forbid` tinyint(1) NULL DEFAULT 0 COMMENT '是否禁用: 0-否 1-是',
  `whether_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除: 0-否 1-是',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_department
-- ----------------------------
INSERT INTO `system_department` VALUES (1, 'huadong', NULL, '华东分部', NULL, NULL, 1, NULL, NULL, 0, 0, NULL, '2024-01-07 15:26:38', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (2, 'huanan', NULL, '华南分部', NULL, NULL, 2, NULL, NULL, 0, 0, NULL, '2024-01-07 15:27:11', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (3, 'xibei', NULL, '西北分部', NULL, NULL, 3, NULL, NULL, 0, 0, NULL, '2024-01-07 15:27:26', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (4, 'yanfa', 1, '研发部', NULL, NULL, 1, NULL, NULL, 0, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (5, 'shichang', 1, '市场部', NULL, NULL, 1, NULL, NULL, 0, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (6, 'shangwu', 1, '商务部', NULL, NULL, 1, NULL, NULL, 0, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (7, 'caiwu', 1, '财务部', NULL, NULL, 1, NULL, NULL, 0, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (8, 'yanfa', 2, '研发部', NULL, NULL, 1, NULL, NULL, 0, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (9, 'shichang', 2, '市场部', NULL, NULL, 1, NULL, NULL, 0, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (10, 'shangwu', 2, '商务部', NULL, NULL, 1, NULL, NULL, 0, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (11, 'caiwu', 2, '财务部', NULL, NULL, 1, NULL, NULL, 0, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for system_department_user
-- ----------------------------
DROP TABLE IF EXISTS `system_department_user`;
CREATE TABLE `system_department_user`  (
  `id` bigint NOT NULL,
  `department_id` bigint NULL DEFAULT NULL COMMENT '部门ID',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '部门用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_department_user
-- ----------------------------
INSERT INTO `system_department_user` VALUES (1744556381740048386, 3, 1735559959787204610);

-- ----------------------------
-- Table structure for system_dict
-- ----------------------------
DROP TABLE IF EXISTS `system_dict`;
CREATE TABLE `system_dict`  (
  `id` bigint NOT NULL,
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '编码',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `whether_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除: 0-否 1-是',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '字典表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_dict
-- ----------------------------

-- ----------------------------
-- Table structure for system_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `system_dict_item`;
CREATE TABLE `system_dict_item`  (
  `id` bigint NOT NULL,
  `dict_id` bigint NULL DEFAULT NULL COMMENT '字典ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `text` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '数据值',
  `ranking` int NULL DEFAULT NULL COMMENT '排名',
  `whether_forbid` tinyint(1) NULL DEFAULT 0 COMMENT '是否禁用: 0-禁用 1-启用',
  `whether_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除: 0-否 1-是',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '字典项目表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_dict_item
-- ----------------------------

-- ----------------------------
-- Table structure for system_edit_log
-- ----------------------------
DROP TABLE IF EXISTS `system_edit_log`;
CREATE TABLE `system_edit_log`  (
  `id` bigint NOT NULL,
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '请求方法',
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '请求路径',
  `ip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '请求IP',
  `agent` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户代理',
  `request_time` datetime NULL DEFAULT NULL COMMENT '请求时间',
  `duration` int NULL DEFAULT NULL COMMENT '耗时',
  `type` tinyint NULL DEFAULT NULL COMMENT '类型: 1-新增, 2-修改, 3-删除',
  `param` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '请求参数',
  `result_code` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '响应码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '操作日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_edit_log
-- ----------------------------
INSERT INTO `system_edit_log` VALUES (1736666741431349249, 1735559959787204610, '创建', 'POST', 'http://127.0.0.1:8080/system/user', '127.0.0.1', 'PostmanRuntime/7.36.0', '2023-12-18 16:36:31', 46, 1, '{\"birthday\":1747756800000,\"salt\":\"test_980401d14e10\",\"sex\":1,\"whetherDelete\":false,\"avatar\":\"test_84c0be69ded2\",\"password\":\"dev\",\"createTime\":1702888591405,\"phone\":\"13444445555\",\"name\":\"dev\",\"id\":\"1736666740932227073\",\"state\":0,\"email\":\"13444445555@163.com\",\"username\":\"dev\"}', '200');
INSERT INTO `system_edit_log` VALUES (1738102720956493826, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/system/user/1735559959787204610', '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', '2023-12-22 15:42:34', 2, 3, '{\"id\":\"1735559959787204610\"}', '200');
INSERT INTO `system_edit_log` VALUES (1738103163296190466, 1737755030393475074, '删除', 'DELETE', 'http://localhost:8080/system/user/1735559959787204610', '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', '2023-12-22 15:44:17', 5, 3, '{\"id\":\"1735559959787204610\"}', '200');
INSERT INTO `system_edit_log` VALUES (1738103666923048962, 1737755030393475074, '创建', 'POST', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', '2023-12-22 15:46:21', 12, 1, '{\"payload\":{\"salt\":\"\",\"sex\":0,\"description\":\"\",\"whetherDelete\":false,\"avatar\":\"\",\"createBy\":\"\",\"password\":\"\",\"createTime\":1703231181250,\"phone\":\"\",\"updateBy\":\"\",\"name\":\"111\",\"id\":\"1738103666860134401\",\"state\":0,\"email\":\"\",\"username\":\"\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1738104064845058050, 1737755030393475074, '创建', 'POST', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', '2023-12-22 15:47:23', 11, 1, '{\"payload\":{\"salt\":\"\",\"sex\":0,\"description\":\"\",\"whetherDelete\":false,\"avatar\":\"\",\"createBy\":\"\",\"password\":\"\",\"createTime\":1703231242544,\"phone\":\"\",\"updateBy\":\"\",\"name\":\"111\",\"id\":\"1738103923958386690\",\"state\":0,\"email\":\"\",\"username\":\"\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1738104305543581698, 1737755030393475074, '删除', 'DELETE', 'http://localhost:8080/system/user/1735559959787204610', '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', '2023-12-22 15:48:01', 13, 3, '{\"id\":\"1735559959787204610\"}', '200');
INSERT INTO `system_edit_log` VALUES (1738104571751866370, 1737755030393475074, '删除', 'DELETE', 'http://localhost:8080/system/user/1735559959787204610', '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', '2023-12-22 15:49:57', 39, 3, '{\"id\":\"1735559959787204610\"}', '200');
INSERT INTO `system_edit_log` VALUES (1738104600617066498, 1737755030393475074, '创建', 'POST', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', '2023-12-22 15:50:04', 22, 1, '{\"salt\":\"\",\"sex\":0,\"description\":\"\",\"whetherDelete\":false,\"avatar\":\"\",\"createBy\":\"\",\"password\":\"\",\"createTime\":1703231403810,\"phone\":\"\",\"updateBy\":\"\",\"name\":\"111\",\"id\":\"1738104600361213954\",\"state\":0,\"email\":\"\",\"username\":\"\"}', '200');
INSERT INTO `system_edit_log` VALUES (1738109697866723330, 1737755030393475074, '删除', 'DELETE', 'http://localhost:8080/system/user/173555995978720461', '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', '2023-12-22 16:10:19', 93, 3, '{\"id\":\"173555995978720461\"}', '200');
INSERT INTO `system_edit_log` VALUES (1738109749498605570, 1737755030393475074, '删除', 'DELETE', 'http://localhost:8080/system/user/173555995978720468', '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', '2023-12-22 16:10:31', 5, 3, '{\"id\":\"173555995978720468\"}', '200');
INSERT INTO `system_edit_log` VALUES (1738109794776117249, 1737755030393475074, '删除', 'DELETE', 'http://localhost:8080/system/user/173555995978720468', '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', '2023-12-22 16:10:42', 3, 3, '{\"id\":\"173555995978720468\"}', '200');
INSERT INTO `system_edit_log` VALUES (1738109881031979010, 1737755030393475074, '删除', 'DELETE', 'http://localhost:8080/system/user/173555995978720468', '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', '2023-12-22 16:11:03', 3, 3, '{\"id\":\"173555995978720468\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744260497789681665, 1737755030393475074, '创建', 'POST', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-08 15:31:24', 74, 1, '{\"createTime\":1704699083868,\"name\":\"sssa\",\"description\":\"safsadf\",\"id\":\"1744260496686579713\",\"email\":\"safsa@asgsa.com\",\"username\":\"ronna1\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744263653265244162, 1737755030393475074, '创建', 'POST', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-08 15:43:56', 12, 1, '{\"createTime\":1704699836439,\"name\":\"test\",\"description\":\"z\",\"id\":\"1744263653206523905\",\"email\":\"safsa@asgsa.com\",\"username\":\"ronna12\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744263784156889089, 1737755030393475074, '创建', 'POST', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-08 15:44:28', 10, 1, '{\"createTime\":1704699867642,\"name\":\"ronna\",\"description\":\"1\",\"id\":\"1744263784089780226\",\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"ronna121\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744524446368006145, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 09:00:14', 26, 2, '{\"name\":\"admin\",\"description\":\"222\",\"updateTime\":1704762014365,\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744524795329904642, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 09:01:38', 4, 2, '{\"name\":\"admin\",\"description\":\"1\",\"updateTime\":1704762097576,\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744525458042519553, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 09:04:16', 6, 2, '{\"name\":\"admin\",\"description\":\"1\",\"updateTime\":1704762255555,\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744525651425099778, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 09:05:02', 4, 2, '{\"name\":\"admin\",\"description\":\"1\",\"updateTime\":1704762301678,\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744525810871566337, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 09:05:40', 6, 2, '{\"name\":\"admin\",\"description\":\"1\",\"updateTime\":1704762339682,\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744538957229588481, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 09:57:54', 9, 2, '{\"name\":\"admin\",\"description\":\"1\",\"updateTime\":1704765474020,\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744539158602317826, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 09:58:42', 14, 2, '{\"name\":\"admin\",\"description\":\"1\",\"updateTime\":1704765522030,\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744539527038369794, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 10:00:10', 4, 2, '{\"name\":\"admin\",\"description\":\"1\",\"updateTime\":1704765609879,\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744540288073859074, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 10:03:11', 13, 2, '{\"name\":\"admin\",\"description\":\"1\",\"updateTime\":1704765791320,\"id\":\"1735559959787204610\",\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744543600445751298, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 10:16:21', 13, 2, '{\"name\":\"admin\",\"description\":\"1\",\"updateTime\":1704766581054,\"id\":\"1735559959787204610\",\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744543990700584961, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 10:17:54', 28, 2, '{\"name\":\"admin\",\"description\":\"1333\",\"updateTime\":1704766674056,\"id\":\"1735559959787204610\",\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744544373070114817, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 10:19:25', 12, 2, '{\"name\":\"admin\",\"description\":\"1333\",\"updateTime\":1704766765266,\"id\":\"1735559959787204610\",\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744544504960004097, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 10:19:57', 9, 2, '{\"name\":\"admin\",\"description\":\"1333\",\"updateTime\":1704766796699,\"id\":\"1735559959787204610\",\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744544603094134785, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 10:20:20', 10, 2, '{\"name\":\"admin\",\"description\":\"1333\",\"updateTime\":1704766820106,\"id\":\"1735559959787204610\",\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744545148332781570, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 10:22:30', 59, 2, '{\"name\":\"admin\",\"description\":\"1333\",\"updateTime\":1704766949867,\"id\":\"1735559959787204610\",\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744545710214230017, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 10:24:44', 62, 2, '{\"name\":\"admin\",\"description\":\"1333\",\"updateTime\":1704767083798,\"id\":\"1735559959787204610\",\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744554006455382018, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 10:57:42', 70, 2, '{\"name\":\"admin\",\"description\":\"1333\",\"updateTime\":1704769061787,\"id\":\"1735559959787204610\",\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744554381161918465, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 10:59:11', 18, 2, '{\"name\":\"admin\",\"description\":\"1333\",\"updateTime\":1704769151357,\"id\":\"1735559959787204610\",\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');
INSERT INTO `system_edit_log` VALUES (1744555304672161793, 1737755030393475074, '编辑', 'PUT', 'http://localhost:8080/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', '2024-01-09 11:02:52', 9, 2, '{\"name\":\"admin\",\"description\":\"1333\",\"updateTime\":1704769371557,\"id\":\"1735559959787204610\",\"email\":\"luokunlong.loong@gmail.com\",\"username\":\"admin\"}', '200');

-- ----------------------------
-- Table structure for system_login_log
-- ----------------------------
DROP TABLE IF EXISTS `system_login_log`;
CREATE TABLE `system_login_log`  (
  `id` bigint NOT NULL,
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `ip` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '请求IP',
  `agent` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户代理',
  `type` tinyint NULL DEFAULT NULL COMMENT '类型: 1-账号密码, 2-短信, 3-扫码, 4-第三方登录',
  `result_code` int NULL DEFAULT NULL COMMENT '响应码',
  `result_message` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '响应消息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '登录日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_login_log
-- ----------------------------
INSERT INTO `system_login_log` VALUES (1762730990758895618, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');

-- ----------------------------
-- Table structure for system_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_permission`;
CREATE TABLE `system_permission`  (
  `id` bigint NOT NULL,
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '编码',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父级ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图标',
  `ranking` int NULL DEFAULT NULL COMMENT '排名',
  `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组件路径',
  `component` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组件名称',
  `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '顶级菜单默认跳转地址',
  `type` tinyint NULL DEFAULT NULL COMMENT '类型: 1-顶级菜单, 2-子菜单, 3-按钮',
  `whether_hide` tinyint(1) NULL DEFAULT 0 COMMENT '是否隐藏: 0-否 1-是',
  `whether_split_route` tinyint(1) NULL DEFAULT 0 COMMENT '是否拆分子路由: 0-否 1-是',
  `whether_route` tinyint(1) NULL DEFAULT 0 COMMENT '是否路由: 0-否 1-是',
  `whether_leaf` tinyint(1) NULL DEFAULT 0 COMMENT '是否叶子节点: 0-否 1-是',
  `whether_cache` tinyint(1) NULL DEFAULT 0 COMMENT '是否缓存: 0-否 1-是',
  `whether_hide_tab` tinyint(1) NULL DEFAULT 0 COMMENT '是否隐藏Tab: 0-否 1-是',
  `whether_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除: 0-否 1-是',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_permission
-- ----------------------------
INSERT INTO `system_permission` VALUES (1, 'system', NULL, 'System', 'routes.demo.system.moduleName', NULL, 'ion:settings-outline', 0, '/system', 'LAYOUT', '/system/account', 1, 0, 0, 1, 0, 0, 0, 0, NULL, '2024-01-06 17:42:02', NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (2, 'account', 1, 'AccountManagement', 'routes.demo.system.account', NULL, NULL, 1, 'account', '/demo/system/account/index', NULL, 2, 0, 0, 1, 0, 0, 0, 0, NULL, '2024-01-06 17:43:59', NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (3, 'role', 1, 'RoleManagement', 'routes.ronna.system.role', NULL, NULL, 2, 'role', '/system/role/index', NULL, 2, 0, 0, 1, 0, 0, 0, 0, NULL, '2024-01-06 17:44:48', NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (4, 'permission', 1, 'MenuManagement', 'routes.ronna.system.menu', NULL, NULL, 3, 'menu', '/system/menu/index', NULL, 2, 0, 0, 1, 0, 0, 0, 0, NULL, '2024-01-06 17:45:44', NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (5, 'user', 1, 'UserManagement', 'routes.ronna.system.user', NULL, NULL, 4, 'user', '/system/user/index', NULL, 2, 0, 0, 1, 0, 0, 0, 0, NULL, '2024-01-06 17:43:59', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role`  (
  `id` bigint NOT NULL,
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '编码',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `whether_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除: 0-否 1-是',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES (1, 'admin', 'admin', 0, NULL, '2024-01-07 19:02:00', NULL, NULL, NULL);
INSERT INTO `system_role` VALUES (2, 'dev', 'dev', 0, NULL, '2024-01-07 19:02:03', NULL, NULL, NULL);
INSERT INTO `system_role` VALUES (3, 'test', 'test', 0, NULL, '2024-01-07 19:02:06', NULL, NULL, NULL);
INSERT INTO `system_role` VALUES (4, 'prod', 'prod', 0, NULL, '2024-01-07 19:02:09', NULL, NULL, NULL);
INSERT INTO `system_role` VALUES (5, 'hahah', 'haha', 0, NULL, '2024-01-09 10:19:09', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for system_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_role_permission`;
CREATE TABLE `system_role_permission`  (
  `id` bigint NOT NULL,
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID',
  `permission_id` bigint NULL DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_role_permission
-- ----------------------------
INSERT INTO `system_role_permission` VALUES (1, 1, 1);
INSERT INTO `system_role_permission` VALUES (2, 1, 2);
INSERT INTO `system_role_permission` VALUES (3, 1, 3);
INSERT INTO `system_role_permission` VALUES (4, 1, 4);
INSERT INTO `system_role_permission` VALUES (5, 1, 5);
INSERT INTO `system_role_permission` VALUES (6, 1, 6);

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user`  (
  `id` bigint NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'MD5密码盐',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `sex` tinyint NULL DEFAULT NULL COMMENT '性别: 1-未知, 2-男, 3-女',
  `email` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `state` tinyint NULL DEFAULT 1 COMMENT '状态: 1-正常, 2-锁定, 3-禁用',
  `whether_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除: 0-否 1-是',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES (1735559959787204610, 'admin', 'admin', '$2b$10$jlGZIUqiy1k9rEVwar8YFOw8ug/An2jGyUPH7.r/h.CW7Zb5ec.Ri', NULL, NULL, NULL, 1, 'luokunlong.loong@gmail.com', NULL, 1, 0, NULL, '2023-12-15 15:18:34', NULL, '2024-01-09 11:02:52', '1333');
INSERT INTO `system_user` VALUES (1737755030393475074, 'ronna', 'ronna', '$2b$10$dQTNQ6kIwdgdbkyE0zAxmOvUS2ti5GG6sAvr.NtWsm4njfJHwmnmm', NULL, NULL, NULL, 2, 'luokunlong.loong@gmail.com', NULL, 2, 0, NULL, '2023-12-21 16:41:00', NULL, NULL, '1');
INSERT INTO `system_user` VALUES (1738103666860134401, 'test', 'test', '$2b$10$A.6Q0pIV3c4gBnMS27NwWe6JCN3KzDIY23MEEn.eNkdDgGHpqOWfq', '', '', NULL, 0, '', '', 0, 0, '', '2023-12-22 15:46:21', '', '2024-01-31 18:03:11', '');
INSERT INTO `system_user` VALUES (1738103923958386690, 'prod', 'prod', '$2b$10$FwAzUschw9E5KAmofsn1d.t0NKriYd3OaT.x8A7B4JeqHXrhZnCuG', '', '', NULL, NULL, '', NULL, 1, 0, '', '2023-12-22 15:47:23', '', '2024-01-31 18:06:39', '1');
INSERT INTO `system_user` VALUES (1738104600361213954, 'dev', 'dev', '$2b$10$IwmTlL9kE3QmxvwGUdFp3.ZFOdIcWpZS.yzmCPui.FqKFYMjxuYca', '', '', NULL, NULL, '', NULL, 1, 0, '', '2023-12-22 15:50:04', NULL, '2024-02-29 10:14:46', '年十大高手觉得反抗拉萨解放拉萨解放拉萨');

-- ----------------------------
-- Table structure for system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role`  (
  `id` bigint NOT NULL,
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_user_role
-- ----------------------------
INSERT INTO `system_user_role` VALUES (1, 1737755030393475074, 1);
INSERT INTO `system_user_role` VALUES (2, 1737755030393475074, 2);
INSERT INTO `system_user_role` VALUES (3, 1737755030393475074, 3);
INSERT INTO `system_user_role` VALUES (4, 1737755030393475074, 4);
INSERT INTO `system_user_role` VALUES (1744555304814768130, 1735559959787204610, 5);

SET FOREIGN_KEY_CHECKS = 1;
