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

 Date: 13/03/2024 19:06:15
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
  `type` tinyint NULL DEFAULT NULL COMMENT '类型: 1-顶级菜单, 2-子菜单, 3-按钮',
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '权限表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_permission
-- ----------------------------
INSERT INTO `system_permission` VALUES (1, NULL, NULL, NULL, 'menus.hssysManagement', NULL, 'ri:settings-3-line', 10, '/system', NULL, NULL, 1, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, '2024-01-06 17:42:02', NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (2, NULL, 1, 'SystemRole', 'menus.hsRole', NULL, 'ri:admin-fill', NULL, '/system/role/index', '', NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, '2024-01-06 17:44:48', NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (3, NULL, 1, 'SystemMenu', 'menus.hsSystemMenu', NULL, 'ep:menu', NULL, '/system/menu/index', '', NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, '2024-01-06 17:45:44', NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (4, NULL, 1, 'SystemUser', 'menus.hsUser', NULL, 'ri:admin-line', NULL, '/system/user/index', '', NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, '2024-01-06 17:43:59', NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (5, NULL, 1, 'SystemDept', 'menus.hsDept', NULL, 'ri:git-branch-line', NULL, '/system/dept/index', '', NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (6, NULL, NULL, NULL, 'menus.hssysMonitor', NULL, 'ep:monitor', 11, '/monitor', NULL, NULL, 1, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (7, NULL, 6, 'OnlineUser', 'menus.hsOnlineUser', NULL, 'ri:user-voice-line', NULL, '/monitor/online-user', 'monitor/online/index', NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (8, NULL, 6, 'LoginLog', 'menus.hsLoginLog', NULL, 'ri:window-line', NULL, '/monitor/login-logs', 'monitor/logs/login/index', NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (9, NULL, 6, 'OperationLog', 'menus.hsOperationLog', NULL, 'ri:history-fill', NULL, '/monitor/operation-logs', 'monitor/logs/operation/index', NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (10, NULL, 6, 'SystemLog', 'menus.hsSystemLog', NULL, 'ri:file-search-line', NULL, '/monitor/system-logs', 'monitor/logs/system/index', NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (11, NULL, NULL, NULL, 'menus.permission', NULL, 'ep:lollipop', 9, '/permission', NULL, NULL, 1, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (12, NULL, 11, 'PermissionPage', 'menus.permissionPage', NULL, NULL, NULL, '/permission/page/index', NULL, NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (13, NULL, 11, 'PermissionButton', 'menus.permissionButton', NULL, NULL, NULL, '/permission/button/index', NULL, NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (14, NULL, NULL, NULL, 'menus.hsExternalPage', NULL, 'ri:links-fill', 7, '/iframe', NULL, NULL, 1, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (15, NULL, 14, NULL, 'menus.hsExternalDoc', NULL, NULL, NULL, '/iframe/external', NULL, NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (16, NULL, 15, 'https://yiming_chang.gitee.io/ronna-admin-doc', 'menus.externalLink', NULL, NULL, NULL, '/external', NULL, NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (17, NULL, 15, 'https://ronna-admin-utils.netlify.app/', 'menus.pureutilsLink', NULL, NULL, NULL, '/pureutilsLink', NULL, NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (18, NULL, 14, NULL, 'menus.hsEmbeddedDoc', NULL, NULL, NULL, '/iframe/embedded', NULL, NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (19, NULL, 18, 'FrameEp', 'menus.hsEpDocument', 'https://element-plus.org/zh-CN/', NULL, NULL, '/iframe/ep', NULL, NULL, 2, NULL, NULL, 0, 1, 0, 1, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (20, NULL, 18, 'FrameVite', 'menus.hsViteDocument', 'https://cn.vitejs.dev/', NULL, NULL, '/iframe/vite', NULL, NULL, 2, NULL, NULL, 0, 1, 0, 1, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (21, NULL, 18, 'FramePinia', 'menus.hsPiniaDocument', 'https://pinia.vuejs.org/zh/index.html', NULL, NULL, '/iframe/pinia', NULL, NULL, 2, NULL, NULL, 0, 1, 0, 1, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (22, NULL, 18, 'FrameRouter', 'menus.hsRouterDocument', 'https://router.vuejs.org/zh/', NULL, NULL, '/iframe/vue-router', NULL, NULL, 2, NULL, NULL, 0, 1, 0, 1, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (23, NULL, NULL, NULL, 'menus.hstabs', NULL, 'ri:bookmark-2-line', 12, '/tabs', NULL, NULL, 1, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (24, NULL, 23, 'Tabs', 'menus.hstabs', NULL, NULL, NULL, '/tabs/index', NULL, NULL, 2, NULL, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (25, NULL, 23, 'TabQueryDetail', NULL, NULL, NULL, NULL, '/tabs/query-detail', NULL, NULL, 2, 1, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (26, NULL, 23, 'TabParamsDetail', NULL, NULL, NULL, NULL, '/tabs/params-detail/:id', 'params-detail', NULL, 2, 1, NULL, 0, 1, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (27, 'permission:btn:add', 13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL, 0, 0, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (28, 'permission:btn:edit', 13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL, 0, 0, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (29, 'permission:btn:delete', 13, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, NULL, 0, 0, 0, NULL, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (30, NULL, 18, 'FrameTailwindcss', 'menus.hsTailwindcssDocument', 'https://tailwindcss.com/docs/installation', NULL, NULL, '/iframe/tailwindcss', NULL, NULL, 2, NULL, NULL, 0, 1, 0, 1, 0, 0, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `system_permission` VALUES (31, NULL, 18, 'FrameVue', 'menus.hsVueDocument', 'https://cn.vuejs.org/', NULL, NULL, '/iframe/vue3', NULL, NULL, 2, NULL, NULL, 0, 1, 0, 1, 0, 0, NULL, NULL, NULL, NULL, NULL);

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES (1, 'admin', 'admin', 1, 0, NULL, '2024-01-07 19:02:00', NULL, NULL, NULL);
INSERT INTO `system_role` VALUES (2, 'dev', 'dev', 1, 0, NULL, '2024-01-07 19:02:03', NULL, NULL, NULL);
INSERT INTO `system_role` VALUES (3, 'test', 'test', 1, 0, NULL, '2024-01-07 19:02:06', NULL, NULL, NULL);
INSERT INTO `system_role` VALUES (4, 'prod', 'prod', 1, 0, NULL, '2024-01-07 19:02:09', NULL, NULL, NULL);
INSERT INTO `system_role` VALUES (5, 'hahah', 'haha', 1, 0, NULL, '2024-01-09 10:19:09', NULL, NULL, NULL);
INSERT INTO `system_role` VALUES (6, 'common', 'common', 1, 0, NULL, '2024-03-12 14:39:25', NULL, NULL, NULL);

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
INSERT INTO `system_role_permission` VALUES (2, 1, 2);
INSERT INTO `system_role_permission` VALUES (3, 1, 3);
INSERT INTO `system_role_permission` VALUES (4, 1, 4);
INSERT INTO `system_role_permission` VALUES (5, 1, 5);
INSERT INTO `system_role_permission` VALUES (6, 1, 7);
INSERT INTO `system_role_permission` VALUES (7, 1, 8);
INSERT INTO `system_role_permission` VALUES (8, 1, 9);
INSERT INTO `system_role_permission` VALUES (9, 1, 10);
INSERT INTO `system_role_permission` VALUES (10, 1, 12);
INSERT INTO `system_role_permission` VALUES (11, 1, 13);
INSERT INTO `system_role_permission` VALUES (12, 1, 16);
INSERT INTO `system_role_permission` VALUES (13, 1, 17);
INSERT INTO `system_role_permission` VALUES (14, 1, 19);
INSERT INTO `system_role_permission` VALUES (15, 1, 20);
INSERT INTO `system_role_permission` VALUES (16, 1, 21);
INSERT INTO `system_role_permission` VALUES (17, 1, 22);
INSERT INTO `system_role_permission` VALUES (18, 1, 24);
INSERT INTO `system_role_permission` VALUES (19, 1, 25);
INSERT INTO `system_role_permission` VALUES (20, 1, 26);
INSERT INTO `system_role_permission` VALUES (21, 6, 12);
INSERT INTO `system_role_permission` VALUES (22, 6, 13);
INSERT INTO `system_role_permission` VALUES (23, 6, 16);
INSERT INTO `system_role_permission` VALUES (24, 6, 17);
INSERT INTO `system_role_permission` VALUES (25, 6, 19);
INSERT INTO `system_role_permission` VALUES (26, 6, 20);
INSERT INTO `system_role_permission` VALUES (27, 6, 21);
INSERT INTO `system_role_permission` VALUES (28, 6, 22);
INSERT INTO `system_role_permission` VALUES (29, 6, 24);
INSERT INTO `system_role_permission` VALUES (30, 6, 25);
INSERT INTO `system_role_permission` VALUES (31, 6, 26);
INSERT INTO `system_role_permission` VALUES (32, 6, 30);
INSERT INTO `system_role_permission` VALUES (33, 1, 30);
INSERT INTO `system_role_permission` VALUES (34, 1, 31);
INSERT INTO `system_role_permission` VALUES (35, 6, 31);

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
INSERT INTO `system_user` VALUES (1735559959787204610, 'admin', 'admin', '$2b$10$kFC6SJ/rgXiUjs.LFoyA2O3nj2Nmjlza26LsbjvsqQ//RnE7lhT3a', NULL, NULL, NULL, 1, 'luokunlong.loong@gmail.com', NULL, 1, 0, NULL, '2023-12-15 15:18:34', NULL, '2024-01-09 11:02:52', '1333');
INSERT INTO `system_user` VALUES (1737755030393475074, 'ronna', 'ronna', '$2b$10$dQTNQ6kIwdgdbkyE0zAxmOvUS2ti5GG6sAvr.NtWsm4njfJHwmnmm', NULL, NULL, NULL, 2, 'luokunlong.loong@gmail.com', NULL, 2, 0, NULL, '2023-12-21 16:41:00', NULL, NULL, '1');
INSERT INTO `system_user` VALUES (1738103666860134401, 'test', 'test', '$2b$10$A.6Q0pIV3c4gBnMS27NwWe6JCN3KzDIY23MEEn.eNkdDgGHpqOWfq', '', '', NULL, 0, '', '', 0, 0, '', '2023-12-22 15:46:21', '', '2024-01-31 18:03:11', '');
INSERT INTO `system_user` VALUES (1738103923958386690, 'prod', 'prod', '$2b$10$FwAzUschw9E5KAmofsn1d.t0NKriYd3OaT.x8A7B4JeqHXrhZnCuG', '', '', NULL, NULL, '', NULL, 1, 0, '', '2023-12-22 15:47:23', '', '2024-01-31 18:06:39', '1');
INSERT INTO `system_user` VALUES (1738104600361213954, 'dev', 'dev', NULL, '', '', NULL, NULL, '', NULL, 1, 0, '', '2023-12-22 15:50:04', '', NULL, '年十大高手觉得反抗拉萨解放拉萨解放拉萨');
INSERT INTO `system_user` VALUES (1765680250051731458, NULL, 'a', '$2b$10$RGdyI2vvWXWVGxvEF3igzu9XFqCUwttP1cMfs..I6sbCUGvAv5b7O', NULL, NULL, NULL, NULL, NULL, '', 1, 0, NULL, '2024-03-07 18:05:51', NULL, NULL, NULL);

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
INSERT INTO `system_user_role` VALUES (5, 1735559959787204610, 1);
INSERT INTO `system_user_role` VALUES (1744555304814768130, 1735559959787204610, 5);

SET FOREIGN_KEY_CHECKS = 1;
