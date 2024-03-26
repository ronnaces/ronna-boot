/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 80300 (8.3.0)
 Source Host           : localhost:3306
 Source Schema         : ronna_boot

 Target Server Type    : MySQL
 Target Server Version : 80300 (8.3.0)
 File Encoding         : 65001

 Date: 26/03/2024 10:27:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for system_department
-- ----------------------------
DROP TABLE IF EXISTS `system_department`;
CREATE TABLE `system_department`  (
  `id` bigint NOT NULL,
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父级ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `principal` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
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
INSERT INTO `system_department` VALUES (1, 0, '湖南总公司', NULL, NULL, NULL, NULL, 1, NULL, 1, 1, 0, NULL, '2024-01-07 15:26:38', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (2, 0, '广东总公司', NULL, NULL, NULL, NULL, 2, NULL, 1, 1, 0, NULL, '2024-01-07 15:27:11', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (3, 0, '江苏总公司', '', '', '', NULL, 3, NULL, 1, 1, 0, NULL, '2024-01-07 15:27:26', NULL, '2024-03-22 10:28:54', 'a');
INSERT INTO `system_department` VALUES (4, 1, '长沙分公司', NULL, NULL, NULL, NULL, 1, NULL, 2, 1, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (5, 1, '衡阳分公司', NULL, NULL, NULL, NULL, 2, NULL, 2, 1, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (6, 2, '广州分公司', NULL, NULL, NULL, NULL, 3, NULL, 2, 1, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (7, 2, '佛山分公司', NULL, NULL, NULL, NULL, 4, NULL, 2, 1, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (8, 5, '研发部', NULL, NULL, NULL, NULL, 1, NULL, 3, 1, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (9, 5, '市场部', NULL, NULL, NULL, NULL, 2, NULL, 3, 1, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (10, 5, '商务部', NULL, NULL, NULL, NULL, 3, NULL, 3, 1, 0, NULL, '2024-01-07 15:27:45', NULL, NULL, NULL);
INSERT INTO `system_department` VALUES (1771006106655567873, 3, '苏州分公司', '张伟', '', '', NULL, 0, NULL, NULL, 1, 0, NULL, '2024-03-22 10:48:54', NULL, '2024-03-22 10:50:22', 'a');

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
INSERT INTO `system_department_user` VALUES (1, 2, 1737755030393475074);
INSERT INTO `system_department_user` VALUES (1770331387224772609, 10, 1770292396479844354);
INSERT INTO `system_department_user` VALUES (1770647998821404673, 3, 1735559959787204610);
INSERT INTO `system_department_user` VALUES (1770648044388323330, 5, 1738103666860134401);
INSERT INTO `system_department_user` VALUES (1770682244046884866, 2, 1770331602472259586);
INSERT INTO `system_department_user` VALUES (1771007373666725889, 3, 1770292204644962306);

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
INSERT INTO `system_dict` VALUES (1, 'sex', '性别', 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_dict` VALUES (2, 'trade', '行业', 0, NULL, NULL, NULL, NULL, NULL);

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
INSERT INTO `system_dict_item` VALUES (1, 1, '1', '男', 1, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_dict_item` VALUES (2, 1, '2', '女', 2, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_dict_item` VALUES (3, 2, '1', '信息传输、软件和信息技术服务业', 1, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_dict_item` VALUES (4, 2, '2', '制造业', 2, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_dict_item` VALUES (5, 2, '3', '租赁和商务服务业', 3, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_dict_item` VALUES (6, 2, '4', '教育', 4, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_dict_item` VALUES (7, 2, '5', '金融业', 5, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_dict_item` VALUES (8, 2, '6', '建筑业', 6, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_dict_item` VALUES (9, 2, '7', '科学研究和技术服务业', 7, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_dict_item` VALUES (10, 2, '8', '批发和零售业', 8, 0, 0, NULL, NULL, NULL, NULL, NULL);

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
INSERT INTO `system_edit_log` VALUES (1770078603854221314, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/v1/system/user/1738104600361213954', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-19 21:23:20', 22, 3, '{\"arg0\":\"1738104600361213954\"}', '200');
INSERT INTO `system_edit_log` VALUES (1770078746435391489, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/v1/system/user/1738104600361213954', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-19 21:23:54', 4, 3, '{\"arg0\":\"1738104600361213954\"}', '200');
INSERT INTO `system_edit_log` VALUES (1770078855550210050, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/v1/system/user/1738103923958386690', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-19 21:24:20', 6, 3, '{\"arg0\":\"1738103923958386690\"}', '200');
INSERT INTO `system_edit_log` VALUES (1770078892820795393, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/v1/system/user/1738103666860134401', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-19 21:24:29', 9, 3, '{\"arg0\":\"1738103666860134401\"}', '200');
INSERT INTO `system_edit_log` VALUES (1770079068465664002, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/v1/system/user/1737755030393475074', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-19 21:25:11', 11, 3, '{\"arg0\":\"1737755030393475074\"}', '200');
INSERT INTO `system_edit_log` VALUES (1770085040730935297, 1735559959787204610, '批量删除', 'DELETE', 'http://localhost:8080/v1/system/user/batch/del', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-19 21:48:55', 33, 3, '{\"arg0\":[\"1738104600361213954\"]}', '200');
INSERT INTO `system_edit_log` VALUES (1770085147987677186, 1735559959787204610, '批量删除', 'DELETE', 'http://localhost:8080/v1/system/user/batch/del', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-19 21:49:21', 18, 3, '{\"arg0\":[\"1738103923958386690\"]}', '200');
INSERT INTO `system_edit_log` VALUES (1770085169177300994, 1735559959787204610, '批量删除', 'DELETE', 'http://localhost:8080/v1/system/user/batch/del', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-19 21:49:26', 13, 3, '{\"arg0\":[\"1737755030393475074\"]}', '200');
INSERT INTO `system_edit_log` VALUES (1770257185708756994, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 09:12:57', 40, 1, '{\"arg0\":{\"createTime\":\"2024-03-20 09:12:57\",\"email\":\"156888958418@163.com\",\"id\":\"1770257185532596226\",\"name\":\"a\",\"password\":\"a\",\"phone\":\"15888888888\",\"sex\":0,\"username\":\"a\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770291189308731394, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 11:28:05', 74, 1, '{\"arg0\":{\"createTime\":\"2024-03-20 11:28:04\",\"email\":\"\",\"id\":\"1770291189115793410\",\"name\":\"b\",\"password\":\"b\",\"phone\":\"\",\"username\":\"b\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770291540271308802, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/system/user', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 11:29:28', 49, 1, '{\"arg0\":{\"createTime\":\"2024-03-20 11:29:28\",\"email\":\"\",\"id\":\"1770291540191617025\",\"name\":\"c\",\"password\":\"c\",\"phone\":\"\",\"username\":\"c\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770292204842094593, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/user/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 11:32:04', 3057, 1, '{\"arg0\":{\"email\":\"\",\"name\":\"d\",\"parentId\":\"3\",\"password\":\"d\",\"phone\":\"\",\"remark\":\"\",\"status\":1,\"username\":\"d\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770292396605673473, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/user/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 11:32:52', 117, 1, '{\"arg0\":{\"email\":\"\",\"name\":\"e\",\"parentId\":\"10\",\"password\":\"e\",\"phone\":\"\",\"remark\":\"\",\"status\":1,\"username\":\"e\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770292895740432385, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/v1/system/user/1770292396479844354', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 11:34:51', 16, 3, '{\"arg0\":\"1770292396479844354\"}', '200');
INSERT INTO `system_edit_log` VALUES (1770292912274378754, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/v1/system/user/1770292396479844354', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 11:34:55', 5, 3, '{\"arg0\":\"1770292396479844354\"}', '200');
INSERT INTO `system_edit_log` VALUES (1770292935221415937, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/v1/system/user/1770292204644962306', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 11:35:01', 11, 3, '{\"arg0\":\"1770292204644962306\"}', '200');
INSERT INTO `system_edit_log` VALUES (1770329226814279681, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 13:59:13', 83, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770292396479844354\",\"name\":\"e\",\"parentId\":\"10\",\"password\":\"\",\"phone\":\"15355884987\",\"remark\":\"\",\"sex\":0,\"status\":1,\"username\":\"e\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770331323483934722, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 14:07:33', 32, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770292396479844354\",\"name\":\"e\",\"parentId\":\"10\",\"phone\":\"15355884987\",\"remark\":\"a\",\"sex\":0,\"status\":1,\"username\":\"e\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770331387224772610, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 14:07:49', 18, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770292396479844354\",\"name\":\"e\",\"parentId\":\"10\",\"phone\":\"15355884987\",\"remark\":\"a\",\"sex\":0,\"status\":1,\"username\":\"e\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770331602472259587, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/user/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 14:08:40', 77, 1, '{\"arg0\":{\"email\":\"\",\"name\":\"t\",\"password\":\"t\",\"phone\":\"\",\"status\":1,\"username\":\"t\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770332023119007746, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 14:10:20', 8, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770331602472259586\",\"name\":\"t\",\"phone\":\"15666669999\",\"status\":1,\"username\":\"t\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770332080346091522, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 14:10:34', 9, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770331602472259586\",\"name\":\"t\",\"phone\":\"15666669999\",\"status\":1,\"username\":\"t\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770332448937332738, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 14:12:02', 14, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770331602472259586\",\"name\":\"t\",\"phone\":\"15666669999\",\"remark\":\"\",\"sex\":0,\"status\":1,\"username\":\"t\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770332476829454338, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 14:12:08', 19, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770331602472259586\",\"name\":\"t\",\"parentId\":\"3\",\"phone\":\"15666669999\",\"remark\":\"\",\"sex\":0,\"status\":1,\"username\":\"t\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770332500644712450, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-20 14:12:14', 20, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770331602472259586\",\"name\":\"t\",\"parentId\":\"3\",\"phone\":\"15666669999\",\"remark\":\"\",\"sex\":1,\"status\":1,\"username\":\"t\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770647998884319234, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-21 11:05:55', 61, 1, '{\"arg0\":{\"email\":\"luokunlong.loong@gmail.com\",\"id\":\"1735559959787204610\",\"name\":\"admin\",\"parentId\":\"3\",\"phone\":\"15578583639\",\"remark\":\"1333\",\"sex\":0,\"status\":1,\"username\":\"admin\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770648044388323331, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-21 11:06:05', 18, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1738103666860134401\",\"name\":\"test\",\"parentId\":\"5\",\"phone\":\"15578583639\",\"remark\":\"\",\"sex\":0,\"status\":1,\"username\":\"test\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770682173221867521, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-21 13:21:42', 30, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770331602472259586\",\"name\":\"t\",\"parentId\":\"3\",\"phone\":\"15666669999\",\"remark\":\"\",\"sex\":0,\"status\":1,\"username\":\"t\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770682189277663235, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-21 13:21:46', 30, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770331602472259586\",\"name\":\"t\",\"parentId\":\"3\",\"phone\":\"15666669999\",\"remark\":\"a\",\"sex\":0,\"status\":1,\"username\":\"t\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770682244113993729, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-21 13:21:59', 19, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770331602472259586\",\"name\":\"t\",\"parentId\":\"2\",\"phone\":\"15666669999\",\"remark\":\"a\",\"sex\":0,\"status\":1,\"username\":\"t\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770748086931443713, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/role/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-21 17:43:37', 41, 1, '{\"arg0\":{\"code\":\"common\",\"id\":\"6\",\"name\":\"common\",\"remark\":\"1\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770748203575037953, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/role/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-21 17:44:05', 16, 1, '{\"arg0\":{\"code\":\"common\",\"id\":\"6\",\"name\":\"common\",\"remark\":\"2\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770748880237907969, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/role/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-21 17:46:47', 10, 1, '{\"arg0\":{\"code\":\"a\",\"name\":\"a\",\"remark\":\"a\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770748918401880066, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/v1/system/role/1770748880170799105', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-21 17:46:56', 12, 3, '{\"arg0\":\"1770748880170799105\"}', '200');
INSERT INTO `system_edit_log` VALUES (1770749105056796673, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/role/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-21 17:47:40', 11, 1, '{\"arg0\":{\"code\":\"common\",\"id\":\"6\",\"name\":\"common\",\"remark\":\"\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770962705885265921, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/role/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 07:56:23', 3777, 1, '{\"arg0\":{\"code\":\"common\",\"id\":\"6\",\"name\":\"common\",\"remark\":\"a\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1770962777234571266, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/role/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 07:56:44', 10, 1, '{\"arg0\":{\"code\":\"common\",\"id\":\"6\",\"name\":\"common\",\"remark\":\"b\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771001071720853505, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/dept/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:28:54', 30, 1, '{\"arg0\":{\"id\":\"3\",\"name\":\"江苏总公司\",\"remark\":\"\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771001205531734017, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/dept/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:29:26', 8, 1, '{\"arg0\":{\"id\":\"3\",\"name\":\"江苏总公司\",\"remark\":\"\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771001265438978049, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/dept/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:29:40', 8, 1, '{\"arg0\":{\"id\":\"3\",\"name\":\"江苏总公司\",\"remark\":\"\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771003625280237569, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/dept/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:39:03', 4, 1, '{\"arg0\":{\"id\":\"3\",\"name\":\"江苏总公司\",\"remark\":\"\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771003981691219970, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/dept/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:40:28', 6, 1, '{\"arg0\":{\"id\":\"3\",\"name\":\"江苏总公司\",\"remark\":\"\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771005008721076226, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/dept/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:44:32', 36, 1, '{\"arg0\":{\"id\":\"3\",\"name\":\"江苏总公司\",\"remark\":\"\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771005443578048514, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/dept/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:46:16', 42, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"3\",\"name\":\"江苏总公司\",\"parentId\":\"0\",\"phone\":\"\",\"principal\":\"\",\"remark\":\"\",\"sort\":3,\"status\":0}}', '200');
INSERT INTO `system_edit_log` VALUES (1771005478835367937, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/dept/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:46:24', 14, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"3\",\"name\":\"江苏总公司\",\"parentId\":\"0\",\"phone\":\"\",\"principal\":\"\",\"remark\":\"a\",\"sort\":3,\"status\":1}}', '200');
INSERT INTO `system_edit_log` VALUES (1771006106722676737, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/dept/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:48:54', 18, 1, '{\"arg0\":{\"email\":\"\",\"name\":\"苏州分公司\",\"parentId\":\"3\",\"phone\":\"\",\"principal\":\"张伟\",\"remark\":\"a\",\"sort\":0,\"status\":1}}', '200');
INSERT INTO `system_edit_log` VALUES (1771006474965790722, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/v1/system/department/1771006106655567873', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:50:22', 11, 3, '{\"arg0\":\"1771006106655567873\"}', '200');
INSERT INTO `system_edit_log` VALUES (1771006887534309377, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/role/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:52:00', 10, 1, '{\"arg0\":{\"code\":\"common\",\"id\":\"6\",\"name\":\"common\",\"remark\":\"c\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771006909889949698, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/role/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:52:06', 12, 1, '{\"arg0\":{\"code\":\"common\",\"id\":\"6\",\"name\":\"common\",\"remark\":\"d\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771007020313391106, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/v1/system/role/6', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:52:32', 9, 3, '{\"arg0\":\"6\"}', '200');
INSERT INTO `system_edit_log` VALUES (1771007176177922049, 1735559959787204610, '删除', 'DELETE', 'http://localhost:8080/v1/system/role/1770748880170799105', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:53:09', 7, 3, '{\"arg0\":\"1770748880170799105\"}', '200');
INSERT INTO `system_edit_log` VALUES (1771007312719294467, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:53:42', 36, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770292204644962306\",\"name\":\"d\",\"parentId\":\"3\",\"phone\":\"\",\"remark\":\"d\",\"status\":1,\"username\":\"d\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771007373666725890, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/user/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 10:53:56', 17, 1, '{\"arg0\":{\"email\":\"\",\"id\":\"1770292204644962306\",\"name\":\"d\",\"parentId\":\"3\",\"phone\":\"\",\"remark\":\"d\",\"status\":1,\"username\":\"d\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771102965701046274, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-22 17:13:47', 28, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"ep:cpu\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":0,\"name\":\"Iot\",\"parentId\":\"0\",\"path\":\"/iot\",\"rank\":18,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"menus.Iot\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771526815882432513, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-23 21:18:01', 17, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":0,\"name\":\"IotDevice\",\"parentId\":\"1771102965583605761\",\"path\":\"/iot/device/index\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"menus.hsIotDevice\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771532007159902210, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/menu/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-23 21:38:39', 18, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"fa-solid:tv\",\"id\":\"1771526815815323650\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":0,\"name\":\"IotDevice\",\"parentId\":\"1771102965583605761\",\"path\":\"/iot/device/index\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"menus.hsIotDevice\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771829197023490049, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/menu/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 17:19:34', 10, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"ep:cpu\",\"id\":\"1771102965583605761\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":0,\"name\":\"Iot\",\"parentId\":\"0\",\"path\":\"/iot\",\"rank\":18,\"redirect\":\"\",\"showLink\":true,\"showParent\":true,\"title\":\"menus.iot\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771829227507691521, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/menu/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 17:19:41', 16, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"fa-solid:tv\",\"id\":\"1771526815815323650\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":0,\"name\":\"IotDevice\",\"parentId\":\"1771102965583605761\",\"path\":\"/iot/device/index\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":true,\"title\":\"menus.iotDevice\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771836969928634369, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 17:50:27', 12, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"https://www.typescriptlang.org/\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":true,\"leaveTransition\":\"\",\"menuType\":1,\"name\":\"FrameTypescript\",\"parentId\":\"18\",\"path\":\"/iframe/typescript\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":true,\"title\":\"menus.hsTypescriptDocument\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771839758146744321, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 18:01:32', 12, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"user:btn:add\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":3,\"name\":\"\",\"parentId\":\"4\",\"path\":\"\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"添加\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771841716823797762, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/menu/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 18:09:19', 13, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"ri:links-fill\",\"id\":\"14\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":0,\"name\":\"ExternalPage\",\"parentId\":\"0\",\"path\":\"/iframe\",\"rank\":7,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"menus.hsExternalPage\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771841767121891329, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/menu/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 18:09:31', 12, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"ri:links-fill\",\"id\":\"14\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":0,\"name\":\"ExternalPage\",\"parentId\":\"0\",\"path\":\"/iframe\",\"rank\":7,\"redirect\":\"\",\"showLink\":false,\"showParent\":false,\"title\":\"menus.hsExternalPage\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771841844661989377, 1735559959787204610, '编辑', 'POST', 'http://localhost:8080/v1/menu/edit', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 18:09:50', 23, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"ri:links-fill\",\"id\":\"14\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":0,\"name\":\"ExternalPage\",\"parentId\":\"0\",\"path\":\"/iframe\",\"rank\":7,\"redirect\":\"\",\"showLink\":true,\"showParent\":true,\"title\":\"menus.hsExternalPage\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771875489347112962, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 20:23:31', 13, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"user:btn:upload:avatar\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":3,\"name\":\"\",\"parentId\":\"4\",\"path\":\"\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"上传头像\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771875631794065410, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 20:24:05', 6, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"user:btn:reset:password\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":3,\"name\":\"\",\"parentId\":\"4\",\"path\":\"\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"重置密码\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771876074624487425, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 20:25:51', 9, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"user:btn:allocate:role\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":3,\"name\":\"\",\"parentId\":\"4\",\"path\":\"\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"分配角色\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771876372277465090, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 20:27:02', 10, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"user:btn:edit\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":3,\"name\":\"\",\"parentId\":\"4\",\"path\":\"\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"修改\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771876441475092482, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 20:27:18', 16, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"user:btn:delete\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":3,\"name\":\"\",\"parentId\":\"4\",\"path\":\"\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"删除\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771876564582109186, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 20:27:48', 12, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"user:btn:batch:delete\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":3,\"name\":\"\",\"parentId\":\"4\",\"path\":\"\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"批量删除\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771894641185005570, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 21:39:37', 20, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"user:btn:operation\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":3,\"name\":\"\",\"parentId\":\"4\",\"path\":\"\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"操作\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771896987092787202, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 21:48:57', 10, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"dept:btn:add\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":3,\"name\":\"\",\"parentId\":\"5\",\"path\":\"\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"新增\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771897108056514561, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 21:49:25', 11, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"dept:btn:edit\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":3,\"name\":\"\",\"parentId\":\"5\",\"path\":\"\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"修改\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771897175660306434, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 21:49:42', 10, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"dept:btn:delete\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":3,\"name\":\"\",\"parentId\":\"5\",\"path\":\"\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"删除\"}}', '200');
INSERT INTO `system_edit_log` VALUES (1771897245860372482, 1735559959787204610, '创建', 'POST', 'http://localhost:8080/v1/menu/create', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', '2024-03-24 21:49:58', 10, 1, '{\"arg0\":{\"activePath\":\"\",\"auths\":\"dept:btn:operation\",\"component\":\"\",\"enterTransition\":\"\",\"extraIcon\":\"\",\"frameLoading\":true,\"frameSrc\":\"\",\"hiddenTag\":false,\"icon\":\"\",\"keepAlive\":false,\"leaveTransition\":\"\",\"menuType\":3,\"name\":\"\",\"parentId\":\"5\",\"path\":\"\",\"rank\":99,\"redirect\":\"\",\"showLink\":true,\"showParent\":false,\"title\":\"操作\"}}', '200');

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
INSERT INTO `system_login_log` VALUES (1736623657410719746, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736623808959311874, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736624151990464514, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736627564547432450, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736627596872933378, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736627659670052865, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736653576849068033, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736653618230071297, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736655054238224386, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736657393422532610, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736657927680299009, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736659533926764545, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736659783454298113, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736661201649184769, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736661230199812097, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1736662627796500482, 1735559959787204610, '127.0.0.1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737754022753968130, 1735559959787204610, '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737755520590172161, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737755857610887169, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737756308053970945, 1735559959787204610, '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737756379520716802, 1737755030393475074, '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737757038462652417, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737757087284350977, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737757432253272066, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737757705445068802, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737758997068402689, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737759238467375106, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737760008147324930, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1737760641202016257, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738103095201665026, 1737755030393475074, '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738110129632571393, 1737755030393475074, '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738886725612097537, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738886876971945985, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738890537362018306, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738891597455572993, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738891955112263682, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738895447612735490, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738896092910600194, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738896125806526466, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738896420552851458, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738896553822666754, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738896939941904385, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738896987576614913, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738897501194305537, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1738898604719882242, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743540241391681537, 1737755030393475074, '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743540372212023298, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743570741795799042, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743585090522365953, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743585136139616258, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743585707533844481, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743585729537163266, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743586443348946946, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743611458475798530, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743611558308622337, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743614746302623746, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743614760689086466, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743615075459018753, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743618019101290498, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743618157081309185, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743622436416434178, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743622518142447617, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743622564124602369, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743622943402930178, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743622953767055362, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743622961144836097, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743622965582409729, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743623198492110849, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743623265420619778, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743623285565861889, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743623346555236353, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743623554076815362, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743623570677870593, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743623580979081218, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743625832682795009, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743625842765901826, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743625848075890689, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743625850974154754, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743625854442844161, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743625858922360834, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743625951272546305, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743627951624204290, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743628140623736833, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743628293397065729, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743628301890531330, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743628435399421954, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743793691153252353, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743801581062610946, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743826566590259202, 1737755030393475074, '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743830826061160449, 1737755030393475074, '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743901956071546881, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743922355039682561, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743924853351694338, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743930289148657666, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743956621106720769, 1737755030393475074, '0:0:0:0:0:0:0:1', 'PostmanRuntime/7.36.0', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743991885841641473, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743992879224795137, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743996496115740673, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743996514021224450, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743996539862331393, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743996981656690690, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1743998469447741442, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744001481113100290, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744001843735851009, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744001857577054210, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744001915580084225, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744001969904709634, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744002452593602561, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744159227733090306, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744166190957207554, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744167798621347841, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744168222413824001, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744244400701100034, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744244909738582017, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744246205321433089, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1744543917363179521, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'Success');
INSERT INTO `system_login_log` VALUES (1752969346931519489, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1754045806836490242, 1735559959787204610, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1754046181266202626, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1754047881028849665, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1754435152626397186, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1755522628392697857, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1755887210680401922, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1756250518734360578, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765706280342691842, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765706908091555842, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765746565915406338, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765746764838608898, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765746774770720769, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765746790444834817, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765750275311685633, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765755791895228417, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765905666817470465, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765906618630828033, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765907271902101505, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765907892298334210, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765909421533278209, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765912279229923329, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765914576173514753, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765915188642492418, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765916472888000514, NULL, '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765917504699367425, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765917514555981825, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765919530586075138, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765919646764101634, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1765923327773282305, NULL, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767050314281684994, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767052146332749825, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767052459710173186, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767098100821823490, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767098785722376193, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767098963875438593, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767098986952499202, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767099062982647809, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767099318487064577, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767099399734927362, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767099446547554306, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767106657902501889, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767106944553820162, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767107982518231042, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767111915139604481, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767111926350979074, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767111933787480066, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767111936857710593, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767111939542065154, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767112136959565825, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767118083153043457, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767118357120786433, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767118834839429122, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767123600819847169, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767165498597949441, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767334812021964802, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767338706986864642, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767338802503753729, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767338810229661698, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767338813174063106, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767338815443181570, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767338817439670274, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767351610633101314, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767435875878227970, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767448252942155778, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767448302539800578, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767453831022522370, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767454654364397569, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767460811212709889, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767476663597264898, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767477762836262914, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767480973542346753, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767481594731352066, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767482921754611714, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767483597381488642, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767485669791289346, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767485983575523330, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767800218838999042, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767803626899742722, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1767811277310238722, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1769545938784768002, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1769693268368461826, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1769694603545436161, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1769695107763666945, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1769700213204754433, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1769704709414756354, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1769704830395260930, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1769998232525586434, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770009471511269377, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770018678855819266, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770635317385224194, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770635830222737409, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770635887927971841, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770635917657198594, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770636639421419521, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770638579568037890, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770640715861282817, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770642130671325186, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770645457425436674, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770645678591152129, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770647340152098817, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770647799440969730, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770647910254481410, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770681752411541505, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770686348068491266, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770706144336093185, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770706981112250369, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770710004152770562, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770714270556856321, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770715991009923073, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770719462614372353, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770720346643632129, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770720893522153474, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770727106951524353, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1770814041753767937, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771063754889457665, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771063821193015297, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771091798702178305, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771525696984731649, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771532297829363714, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771533007409131522, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771533857326116865, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771537560909131778, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771538124275462146, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771538970128166914, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36 Edg/122.0.0.0', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771828729811578882, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771829125598687233, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771837142096424962, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771843236902481922, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771846990305542145, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771857495967404033, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771868338117513217, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771868505361190913, 1737755030393475074, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771868906575728641, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771869820858503169, 1738104600361213954, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771874984143196161, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771877695404216321, 1738104600361213954, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771878103048622082, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771878505244626945, 1738104600361213954, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771893206049361922, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771893851997364225, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771894433126555649, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771894729617711105, 1738104600361213954, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771896799796142082, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771901145204137986, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771902445996220417, 1738104600361213954, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1771902964697407489, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1772034671937331201, 1738104600361213954, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1772035010543493122, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1772035243511914497, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1772035301686910978, 1738104600361213954, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1772036542785658882, 1738104600361213954, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1772036586456752129, 1735559959787204610, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');
INSERT INTO `system_login_log` VALUES (1772036731793580033, 1738104600361213954, '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36', 1, 200, 'OK');

-- ----------------------------
-- Table structure for system_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_permission`;
CREATE TABLE `system_permission`  (
  `id` bigint NOT NULL,
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '编码',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '父级ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '图标',
  `ranking` int NULL DEFAULT NULL COMMENT '排名',
  `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组件路径',
  `component` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组件名称',
  `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '顶级菜单默认跳转地址',
  `type` tinyint NULL DEFAULT NULL COMMENT '类型: 1-菜单, 2-iframe, 3-外链, 4-按钮',
  `whether_hide` tinyint(1) NULL DEFAULT NULL COMMENT '是否隐藏: 0-否 1-是',
  `whether_hide_parent` tinyint(1) NULL DEFAULT NULL COMMENT '是否隐藏父级: 0-否 1-是',
  `whether_split_route` tinyint(1) NULL DEFAULT 0 COMMENT '是否拆分子路由: 0-否 1-是',
  `whether_route` tinyint(1) NULL DEFAULT 0 COMMENT '是否路由: 0-否 1-是',
  `whether_leaf` tinyint(1) NULL DEFAULT 0 COMMENT '是否叶子节点: 0-否 1-是',
  `whether_cache` tinyint(1) NULL DEFAULT NULL COMMENT '是否缓存: 0-否 1-是',
  `whether_hide_tab` tinyint(1) NULL DEFAULT 0 COMMENT '是否隐藏Tab: 0-否 1-是',
  `whether_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除: 0-否 1-是',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `whether_forbid` tinyint(1) NULL DEFAULT 0 COMMENT '是否禁用: 0-否 1-是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_permission
-- ----------------------------
INSERT INTO `system_permission` VALUES (1, NULL, 0, 'SystemManagement', 'menus.hssysManagement', NULL, 'ri:settings-3-line', 10, '/system', NULL, NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, '2024-01-06 17:42:02', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (2, NULL, 1, 'SystemRole', 'menus.hsRole', NULL, 'ri:admin-fill', NULL, '/system/role/index', '', NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, '2024-01-06 17:44:48', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (3, NULL, 1, 'SystemMenu', 'menus.hsSystemMenu', NULL, 'ep:menu', NULL, '/system/menu/index', '', NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, '2024-01-06 17:45:44', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (4, NULL, 1, 'SystemUser', 'menus.hsUser', NULL, 'ri:admin-line', NULL, '/system/user/index', '', NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, '2024-01-06 17:43:59', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (5, NULL, 1, 'SystemDept', 'menus.hsDept', NULL, 'ri:git-branch-line', NULL, '/system/dept/index', '', NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (6, NULL, 0, 'SystemMonitor', 'menus.hssysMonitor', NULL, 'ep:monitor', 11, '/monitor', NULL, NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (7, NULL, 6, 'OnlineUser', 'menus.hsOnlineUser', NULL, 'ri:user-voice-line', NULL, '/monitor/online-user', 'monitor/online/index', NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (8, NULL, 6, 'LoginLog', 'menus.hsLoginLog', NULL, 'ri:window-line', NULL, '/monitor/login-logs', 'monitor/logs/login/index', NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (9, NULL, 6, 'OperationLog', 'menus.hsOperationLog', NULL, 'ri:history-fill', NULL, '/monitor/operation-logs', 'monitor/logs/operation/index', NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (10, NULL, 6, 'SystemLog', 'menus.hsSystemLog', NULL, 'ri:file-search-line', NULL, '/monitor/system-logs', 'monitor/logs/system/index', NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (11, NULL, 0, 'Permission', 'menus.permission', NULL, 'ep:lollipop', 9, '/permission', NULL, NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (12, NULL, 11, 'PermissionPage', 'menus.permissionPage', NULL, NULL, NULL, '/permission/page/index', NULL, NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (13, NULL, 11, 'PermissionButton', 'menus.permissionButton', NULL, NULL, NULL, '/permission/button/index', NULL, NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (14, '', 0, 'ExternalPage', 'menus.hsExternalPage', NULL, 'ri:links-fill', 7, '/iframe', NULL, NULL, 1, 0, 0, 0, 1, 0, 0, 0, 0, NULL, NULL, NULL, '2024-03-24 18:09:19', NULL, 0);
INSERT INTO `system_permission` VALUES (15, NULL, 14, 'ExternalDoc', 'menus.hsExternalDoc', NULL, NULL, NULL, '/iframe/external', NULL, NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (16, NULL, 15, 'https://yiming_chang.gitee.io/ronna-admin-doc', 'menus.externalLink', NULL, NULL, NULL, '/external', NULL, NULL, 3, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (17, NULL, 15, 'https://ronna-admin-utils.netlify.app/', 'menus.pureutilsLink', NULL, NULL, NULL, '/pureutilsLink', NULL, NULL, 3, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (18, NULL, 14, 'EmbeddedDoc', 'menus.hsEmbeddedDoc', NULL, NULL, NULL, '/iframe/embedded', NULL, NULL, 2, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (19, NULL, 18, 'FrameEp', 'menus.hsEpDocument', 'https://element-plus.org/zh-CN/', NULL, NULL, '/iframe/ep', NULL, NULL, 2, NULL, 0, 0, 1, 0, 1, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (20, NULL, 18, 'FrameVite', 'menus.hsViteDocument', 'https://cn.vitejs.dev/', NULL, NULL, '/iframe/vite', NULL, NULL, 2, NULL, 0, 0, 1, 0, 1, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (21, NULL, 18, 'FramePinia', 'menus.hsPiniaDocument', 'https://pinia.vuejs.org/zh/index.html', NULL, NULL, '/iframe/pinia', NULL, NULL, 2, NULL, 0, 0, 1, 0, 1, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (22, NULL, 18, 'FrameRouter', 'menus.hsRouterDocument', 'https://router.vuejs.org/zh/', NULL, NULL, '/iframe/vue-router', NULL, NULL, 2, NULL, 0, 0, 1, 0, 1, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (23, NULL, 0, 'Tabs', 'menus.hstabs', NULL, 'ri:bookmark-2-line', 12, '/tabs', NULL, NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (24, NULL, 23, 'TabsIndex', 'menus.hstabs', NULL, NULL, NULL, '/tabs/index', NULL, NULL, 1, NULL, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (25, NULL, 23, 'TabQueryDetail', 'query传参模式', NULL, NULL, NULL, '/tabs/query-detail', NULL, NULL, 1, 1, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (26, NULL, 23, 'TabParamsDetail', 'params传参模式', NULL, NULL, NULL, '/tabs/params-detail/:id', 'params-detail', NULL, 1, 1, 0, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (27, 'permission:btn:add', 13, '', '添加', NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, 0, 0, 0, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (28, 'permission:btn:edit', 13, '', '编辑', NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, 0, 0, 0, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (29, 'permission:btn:delete', 13, '', '删除', NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, 0, 0, 0, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (30, NULL, 18, 'FrameTailwindcss', 'menus.hsTailwindcssDocument', 'https://tailwindcss.com/docs/installation', NULL, NULL, '/iframe/tailwindcss', NULL, NULL, 2, NULL, 0, 0, 1, 0, 1, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (31, NULL, 18, 'FrameVue', 'menus.hsVueDocument', 'https://cn.vuejs.org/', NULL, NULL, '/iframe/vue3', NULL, NULL, 2, NULL, 0, 0, 1, 0, 1, 0, 0, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771102965583605761, '', 0, 'Iot', 'menus.iot', NULL, 'ep:cpu', 18, '/iot', '', '', 1, 0, 0, 0, 1, 0, 0, 0, 0, NULL, '2024-03-22 17:13:47', NULL, '2024-03-24 17:19:34', NULL, 0);
INSERT INTO `system_permission` VALUES (1771526815815323650, '', 1771102965583605761, 'IotDevice', 'menus.iotDevice', NULL, 'fa-solid:tv', 99, '/iot/device/index', '', '', 1, 0, 0, 0, 1, 0, 0, 0, 0, NULL, '2024-03-23 21:18:01', NULL, '2024-03-23 21:38:39', NULL, 0);
INSERT INTO `system_permission` VALUES (1771836969865719810, NULL, 18, 'FrameTypescript', 'menus.hsTypescriptDocument', 'https://www.typescriptlang.org/', '', 99, '/iframe/typescript', NULL, NULL, 2, 0, 0, 0, 1, 0, 1, 0, 0, NULL, '2024-03-24 17:50:27', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771839758079635458, 'user:btn:add', 4, NULL, '添加', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, NULL, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 18:01:32', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771875489280004098, 'user:btn:upload:avatar', 4, NULL, '上传头像', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 20:23:31', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771875631794065409, 'user:btn:reset:password', 4, NULL, '重置密码', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 20:24:05', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771876074561572866, 'user:btn:allocate:role', 4, NULL, '分配角色', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 20:25:51', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771876372214550530, 'user:btn:edit', 4, NULL, '修改', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 20:27:02', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771876441395400706, 'user:btn:delete', 4, NULL, '删除', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 20:27:18', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771876564519194626, 'user:btn:batch:delete', 4, NULL, '批量删除', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 20:27:48', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771894641117896705, 'user:btn:operation', 4, NULL, '操作', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:39:37', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771894641117896706, 'role:btn:operation', 2, NULL, '操作', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:39:37', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771894641117896711, 'menu:btn:operation', 3, NULL, '操作', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:39:37', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771896987092787201, 'dept:btn:add', 5, NULL, '新增', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:48:57', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771896987092787207, 'role:btn:add', 2, NULL, '新增', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:48:57', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771896987092787212, 'menu:btn:add', 3, NULL, '新增', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:48:57', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771897107993600002, 'dept:btn:edit', 5, NULL, '修改', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:49:25', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771897107993600008, 'role:btn:edit', 2, NULL, '修改', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:49:25', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771897107993600013, 'menu:btn:edit', 3, NULL, '修改', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:49:25', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771897175597391814, 'menu:btn:delete', 3, NULL, '删除', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:49:42', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771897175597391873, 'dept:btn:delete', 5, NULL, '删除', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:49:42', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771897175597391879, 'role:btn:delete', 2, NULL, '删除', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:49:42', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771897245789069311, 'role:btn:permission', 2, NULL, '权限', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:49:58', NULL, NULL, NULL, 0);
INSERT INTO `system_permission` VALUES (1771897245789069313, 'dept:btn:operation', 5, NULL, '操作', NULL, NULL, 99, NULL, NULL, NULL, 4, NULL, 1, 0, 0, 0, NULL, 0, 0, NULL, '2024-03-24 21:49:58', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role`  (
  `id` bigint NOT NULL,
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '编码',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `state` tinyint NULL DEFAULT 1 COMMENT '状态: 1-正常, 2-禁用',
  `whether_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除: 0-否 1-是',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  `whether_forbid` tinyint(1) NULL DEFAULT 0 COMMENT '是否禁用: 0-否 1-是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES (1, 'admin', '超级管理员', 1, 0, NULL, '2024-01-07 19:02:00', NULL, '2024-03-22 10:26:53', NULL, 1);
INSERT INTO `system_role` VALUES (2, 'dev', '开发', 1, 0, NULL, '2024-01-07 19:02:03', NULL, '2024-03-22 10:26:50', NULL, 1);
INSERT INTO `system_role` VALUES (3, 'test', '测试', 1, 0, NULL, '2024-01-07 19:02:06', NULL, '2024-03-22 10:26:47', NULL, 1);
INSERT INTO `system_role` VALUES (4, 'prod', '生产', 1, 0, NULL, '2024-01-07 19:02:09', NULL, '2024-03-22 10:26:44', NULL, 1);
INSERT INTO `system_role` VALUES (5, 'hahah', 'haha', 1, 0, NULL, '2024-01-09 10:19:09', NULL, '2024-03-22 10:23:46', NULL, 1);
INSERT INTO `system_role` VALUES (6, 'common', '普通', 1, 0, NULL, '2024-03-12 14:39:25', NULL, '2024-03-22 10:52:32', 'd', 1);

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
INSERT INTO `system_role_permission` VALUES (1771006953691066370, 6, 1);
INSERT INTO `system_role_permission` VALUES (1771006953691066371, 6, 2);
INSERT INTO `system_role_permission` VALUES (1771006953691066372, 6, 3);
INSERT INTO `system_role_permission` VALUES (1771006953691066373, 6, 4);
INSERT INTO `system_role_permission` VALUES (1771006953691066374, 6, 5);
INSERT INTO `system_role_permission` VALUES (1771006953691066375, 6, 6);
INSERT INTO `system_role_permission` VALUES (1771006953691066376, 6, 7);
INSERT INTO `system_role_permission` VALUES (1771006953691066377, 6, 8);
INSERT INTO `system_role_permission` VALUES (1771006953691066378, 6, 9);
INSERT INTO `system_role_permission` VALUES (1771006953691066379, 6, 10);
INSERT INTO `system_role_permission` VALUES (1771006953691066380, 6, 11);
INSERT INTO `system_role_permission` VALUES (1771006953691066381, 6, 12);
INSERT INTO `system_role_permission` VALUES (1771006953691066382, 6, 13);
INSERT INTO `system_role_permission` VALUES (1771006953691066383, 6, 14);
INSERT INTO `system_role_permission` VALUES (1771006953691066384, 6, 15);
INSERT INTO `system_role_permission` VALUES (1771006953691066385, 6, 16);
INSERT INTO `system_role_permission` VALUES (1771006953691066386, 6, 17);
INSERT INTO `system_role_permission` VALUES (1771006953691066387, 6, 18);
INSERT INTO `system_role_permission` VALUES (1771006953691066388, 6, 19);
INSERT INTO `system_role_permission` VALUES (1771006953691066389, 6, 20);
INSERT INTO `system_role_permission` VALUES (1771006953691066390, 6, 21);
INSERT INTO `system_role_permission` VALUES (1771006953691066391, 6, 22);
INSERT INTO `system_role_permission` VALUES (1771006953691066392, 6, 23);
INSERT INTO `system_role_permission` VALUES (1771006953691066393, 6, 24);
INSERT INTO `system_role_permission` VALUES (1771006953691066394, 6, 25);
INSERT INTO `system_role_permission` VALUES (1771006953691066395, 6, 26);
INSERT INTO `system_role_permission` VALUES (1771006953691066396, 6, 27);
INSERT INTO `system_role_permission` VALUES (1771006953691066397, 6, 28);
INSERT INTO `system_role_permission` VALUES (1771006953691066398, 6, 29);
INSERT INTO `system_role_permission` VALUES (1771006953691066399, 6, 30);
INSERT INTO `system_role_permission` VALUES (1771006953691066400, 6, 31);
INSERT INTO `system_role_permission` VALUES (1771863983830175746, 1, 1);
INSERT INTO `system_role_permission` VALUES (1771863983830175747, 1, 2);
INSERT INTO `system_role_permission` VALUES (1771863983830175748, 1, 3);
INSERT INTO `system_role_permission` VALUES (1771863983830175749, 1, 4);
INSERT INTO `system_role_permission` VALUES (1771863983830175750, 1, 5);
INSERT INTO `system_role_permission` VALUES (1771863983830175751, 1, 6);
INSERT INTO `system_role_permission` VALUES (1771863983830175752, 1, 7);
INSERT INTO `system_role_permission` VALUES (1771863983830175753, 1, 8);
INSERT INTO `system_role_permission` VALUES (1771863983830175754, 1, 9);
INSERT INTO `system_role_permission` VALUES (1771863983830175755, 1, 10);
INSERT INTO `system_role_permission` VALUES (1771863983830175756, 1, 11);
INSERT INTO `system_role_permission` VALUES (1771863983830175757, 1, 12);
INSERT INTO `system_role_permission` VALUES (1771863983830175758, 1, 13);
INSERT INTO `system_role_permission` VALUES (1771863983830175759, 1, 14);
INSERT INTO `system_role_permission` VALUES (1771863983830175760, 1, 15);
INSERT INTO `system_role_permission` VALUES (1771863983830175761, 1, 16);
INSERT INTO `system_role_permission` VALUES (1771863983830175762, 1, 17);
INSERT INTO `system_role_permission` VALUES (1771863983830175763, 1, 18);
INSERT INTO `system_role_permission` VALUES (1771863983830175764, 1, 19);
INSERT INTO `system_role_permission` VALUES (1771863983830175765, 1, 20);
INSERT INTO `system_role_permission` VALUES (1771863983830175766, 1, 21);
INSERT INTO `system_role_permission` VALUES (1771863983830175767, 1, 22);
INSERT INTO `system_role_permission` VALUES (1771863983830175768, 1, 23);
INSERT INTO `system_role_permission` VALUES (1771863983830175769, 1, 24);
INSERT INTO `system_role_permission` VALUES (1771863983830175770, 1, 25);
INSERT INTO `system_role_permission` VALUES (1771863983830175771, 1, 26);
INSERT INTO `system_role_permission` VALUES (1771863983830175772, 1, 27);
INSERT INTO `system_role_permission` VALUES (1771863983830175773, 1, 28);
INSERT INTO `system_role_permission` VALUES (1771863983830175774, 1, 29);
INSERT INTO `system_role_permission` VALUES (1771863983830175775, 1, 30);
INSERT INTO `system_role_permission` VALUES (1771863983830175776, 1, 31);
INSERT INTO `system_role_permission` VALUES (1771863983830175777, 1, 1771102965583605761);
INSERT INTO `system_role_permission` VALUES (1771863983830175778, 1, 1771526815815323650);
INSERT INTO `system_role_permission` VALUES (1771863983830175779, 1, 1771839758079635458);
INSERT INTO `system_role_permission` VALUES (1772036671513042946, 2, 1);
INSERT INTO `system_role_permission` VALUES (1772036671513042947, 2, 2);
INSERT INTO `system_role_permission` VALUES (1772036671513042948, 2, 3);
INSERT INTO `system_role_permission` VALUES (1772036671513042949, 2, 4);
INSERT INTO `system_role_permission` VALUES (1772036671513042950, 2, 5);
INSERT INTO `system_role_permission` VALUES (1772036671513042951, 2, 6);
INSERT INTO `system_role_permission` VALUES (1772036671513042952, 2, 7);
INSERT INTO `system_role_permission` VALUES (1772036671513042953, 2, 8);
INSERT INTO `system_role_permission` VALUES (1772036671513042954, 2, 9);
INSERT INTO `system_role_permission` VALUES (1772036671513042955, 2, 10);
INSERT INTO `system_role_permission` VALUES (1772036671513042956, 2, 1771839758079635458);
INSERT INTO `system_role_permission` VALUES (1772036671513042957, 2, 1771875489280004098);
INSERT INTO `system_role_permission` VALUES (1772036671513042958, 2, 1771875631794065409);
INSERT INTO `system_role_permission` VALUES (1772036671513042959, 2, 1771876074561572866);
INSERT INTO `system_role_permission` VALUES (1772036671513042960, 2, 1771876372214550530);
INSERT INTO `system_role_permission` VALUES (1772036671513042961, 2, 1771876441395400706);
INSERT INTO `system_role_permission` VALUES (1772036671513042962, 2, 1771876564519194626);
INSERT INTO `system_role_permission` VALUES (1772036671513042963, 2, 1771894641117896705);
INSERT INTO `system_role_permission` VALUES (1772036671513042964, 2, 1771894641117896706);
INSERT INTO `system_role_permission` VALUES (1772036671513042965, 2, 1771894641117896711);
INSERT INTO `system_role_permission` VALUES (1772036671513042966, 2, 1771896987092787201);
INSERT INTO `system_role_permission` VALUES (1772036671513042967, 2, 1771896987092787207);
INSERT INTO `system_role_permission` VALUES (1772036671513042968, 2, 1771896987092787212);
INSERT INTO `system_role_permission` VALUES (1772036671513042969, 2, 1771897107993600002);
INSERT INTO `system_role_permission` VALUES (1772036671513042970, 2, 1771897107993600008);
INSERT INTO `system_role_permission` VALUES (1772036671513042971, 2, 1771897107993600013);
INSERT INTO `system_role_permission` VALUES (1772036671513042972, 2, 1771897175597391814);
INSERT INTO `system_role_permission` VALUES (1772036671513042973, 2, 1771897175597391873);
INSERT INTO `system_role_permission` VALUES (1772036671575957505, 2, 1771897175597391879);
INSERT INTO `system_role_permission` VALUES (1772036671575957506, 2, 1771897245789069311);
INSERT INTO `system_role_permission` VALUES (1772036671575957507, 2, 1771897245789069313);

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
  `whether_forbid` tinyint(1) NULL DEFAULT 0 COMMENT '是否禁用: 0-否 1-是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES (1735559959787204610, 'admin', 'admin', '$2b$10$4SjN./2t/En.mj4tYUPbwOeHXFYpGIpWezaJ4solHBP0G1.D6RvtW', NULL, 'http://localhost:8080/images/20240321/1770642082252279810.jpg', NULL, 0, 'luokunlong.loong@gmail.com', '15578583639', 1, 0, NULL, '2023-12-15 15:18:34', NULL, '2024-01-09 11:02:52', '1333', 1);
INSERT INTO `system_user` VALUES (1737755030393475074, 'ronna', 'ronna', '$2b$10$4SjN./2t/En.mj4tYUPbwOeHXFYpGIpWezaJ4solHBP0G1.D6RvtW', NULL, NULL, NULL, 2, 'luokunlong.loong@gmail.com', '15578583639', 1, 0, NULL, '2023-12-21 16:41:00', NULL, '2024-03-19 21:49:26', '1', 1);
INSERT INTO `system_user` VALUES (1738103666860134401, 'test', 'test', '$2b$10$4SjN./2t/En.mj4tYUPbwOeHXFYpGIpWezaJ4solHBP0G1.D6RvtW', '', NULL, NULL, 0, '', '15578583639', 1, 0, '', '2023-12-22 15:46:21', NULL, '2024-03-19 21:24:29', '', 1);
INSERT INTO `system_user` VALUES (1738103923958386690, 'prod', 'prod', '$2b$10$4SjN./2t/En.mj4tYUPbwOeHXFYpGIpWezaJ4solHBP0G1.D6RvtW', '', NULL, NULL, NULL, '', '15578583639', 1, 0, '', '2023-12-22 15:47:23', NULL, '2024-03-19 21:49:21', '1', 1);
INSERT INTO `system_user` VALUES (1738104600361213954, 'dev', 'dev', '$2b$10$4SjN./2t/En.mj4tYUPbwOeHXFYpGIpWezaJ4solHBP0G1.D6RvtW', '', 'http://localhost:8080/images/20240320/logo.png', NULL, NULL, '', '15578583639', 1, 0, '', '2023-12-22 15:50:04', NULL, '2024-03-19 21:48:55', '年十大高手觉得反抗拉萨解放拉萨解放拉萨', 1);

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
INSERT INTO `system_user_role` VALUES (1771053435970482178, 1735559959787204610, 1);
INSERT INTO `system_user_role` VALUES (1771053435970482179, 1735559959787204610, 2);
INSERT INTO `system_user_role` VALUES (1771053435970482180, 1735559959787204610, 5);
INSERT INTO `system_user_role` VALUES (1771869631393402882, 1738104600361213954, 2);

SET FOREIGN_KEY_CHECKS = 1;
