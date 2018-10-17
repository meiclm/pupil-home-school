/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : home_school

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-10-16 09:41:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `t_id` varchar(11) NOT NULL,
  `p_id` varchar(11) NOT NULL,
  `message` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `t_id` (`t_id`),
  KEY `p_id` (`p_id`),
  CONSTRAINT `p_id` FOREIGN KEY (`p_id`) REFERENCES `t_parent` (`phone`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `t_id` FOREIGN KEY (`t_id`) REFERENCES `t_teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `class_no` varchar(45) NOT NULL,
  `teacher` varchar(45) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `describe` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_no`),
  KEY `teacher_idx` (`teacher`),
  CONSTRAINT `teacher` FOREIGN KEY (`teacher`) REFERENCES `t_teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('150841', '1999090102', '40', '4');
INSERT INTO `t_class` VALUES ('150842', '1998090102', '40', '4');

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('1', '语文');
INSERT INTO `t_course` VALUES ('2', '数学');
INSERT INTO `t_course` VALUES ('3', '英语');
INSERT INTO `t_course` VALUES ('4', '体育');
INSERT INTO `t_course` VALUES ('5', '思想政治');
INSERT INTO `t_course` VALUES ('6', '美术');
INSERT INTO `t_course` VALUES ('7', '音乐');
INSERT INTO `t_course` VALUES ('8', '秋游');
INSERT INTO `t_course` VALUES ('9', '实践课');
INSERT INTO `t_course` VALUES ('10', '管理学校');

-- ----------------------------
-- Table structure for t_grade
-- ----------------------------
DROP TABLE IF EXISTS `t_grade`;
CREATE TABLE `t_grade` (
  `grade_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_no` varchar(45) DEFAULT NULL,
  `c_no` int(11) DEFAULT NULL,
  `term` varchar(45) DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`grade_id`),
  KEY `s_no_idx` (`s_no`),
  KEY `c_no_idx` (`c_no`),
  CONSTRAINT `c_no` FOREIGN KEY (`c_no`) REFERENCES `t_course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `s_no` FOREIGN KEY (`s_no`) REFERENCES `t_student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_grade
-- ----------------------------
INSERT INTO `t_grade` VALUES ('1', '15084201', '1', '16-17-01', '80');
INSERT INTO `t_grade` VALUES ('2', '15084201', '2', '16-17-01', '90');
INSERT INTO `t_grade` VALUES ('3', '15084201', '3', '16-17-01', '60');
INSERT INTO `t_grade` VALUES ('4', '15084101', '1', '16-17-01', '66');
INSERT INTO `t_grade` VALUES ('5', '15084101', '2', '16-17-01', '78');
INSERT INTO `t_grade` VALUES ('6', '15084101', '3', '16-17-01', '100');
INSERT INTO `t_grade` VALUES ('7', '15084201', '1', '16-17-02', '90');
INSERT INTO `t_grade` VALUES ('8', '15084201', '2', '16-17-02', '66');
INSERT INTO `t_grade` VALUES ('9', '15084201', '3', '16-17-02', '100');

-- ----------------------------
-- Table structure for t_parent
-- ----------------------------
DROP TABLE IF EXISTS `t_parent`;
CREATE TABLE `t_parent` (
  `openID` varchar(32) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `wechat` varchar(45) DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `describe` longtext,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_parent
-- ----------------------------
INSERT INTO `t_parent` VALUES ('oZTNs5d5929B-QAtyckE7DsZGsrU', '15735657423', '123456', '孙琦', null, 'e868142', '个体经营', null);
INSERT INTO `t_parent` VALUES ('', '18735361050', '123456', '李燕锦', null, 'a1185024561', '教师', null);
INSERT INTO `t_parent` VALUES ('', '18745632152', '123456', '单父母', null, 'joy134065', '个体经营', null);

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` varchar(50) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `addres` varchar(100) DEFAULT NULL,
  `parent` varchar(45) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_idx` (`parent`),
  CONSTRAINT `parent` FOREIGN KEY (`parent`) REFERENCES `t_parent` (`phone`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('15084101', '单紫嫣', '小店区田园小区A45', '18745632152', '2008-11-06');
INSERT INTO `t_student` VALUES ('15084201', '张田梦', '上兰村文瀛小区A540', '18735361050', '2008-11-09');
INSERT INTO `t_student` VALUES ('15084232', '黄海波', '肥西县', '15735657423', '2008-11-12');
INSERT INTO `t_student` VALUES ('15084235', '孔德林', '济宁市', '15735657423', '2008-11-12');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `id` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `wechat` varchar(45) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  `teaching` int(11) DEFAULT NULL,
  `admin` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teaching_idx` (`teaching`),
  CONSTRAINT `teaching` FOREIGN KEY (`teaching`) REFERENCES `t_course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1998090101', '123456', '陈柳梅', '普通老师', '18735361050', '1667440354@qq.com', 'joy134065', '0', '1978-11-09', '2', '0');
INSERT INTO `t_teacher` VALUES ('1998090102', '123456', '赵琦', '普通老师', '15735659693', '396558528@qq.com', 'Yue-6666666', '0', '1978-1109', '1', '0');
INSERT INTO `t_teacher` VALUES ('1998090103', '123456', '谭诗雨', '校长', '15925207632', '1150573527@qq.com', 'tsy11223456', '0', '1968-10-15', '10', '1');
INSERT INTO `t_teacher` VALUES ('1998090104', '123456', '李丹妮', '教务处主任', '18334729708', '1565893158@qq.com', 'wxid_nraasje1tksh22', '0', '1968-10-15', '9', '1');
INSERT INTO `t_teacher` VALUES ('1999090101', '123456', '翟思源', '副校长', '13834648200', '921358361@qq.com', 'zsy921358361', '1', '1968-03-02', '3', '1');
INSERT INTO `t_teacher` VALUES ('1999090102', '123456', '孙琦', '普通老师', '13834648200', '1904705132@qq.com', 'e868142', '1', '1978-10-02', '4', '0');

-- ----------------------------
-- View structure for view_grade
-- ----------------------------
DROP VIEW IF EXISTS `view_grade`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_grade` AS select `t_grade`.`s_no` AS `s_no`,`t_grade`.`c_no` AS `c_no`,`t_course`.`name` AS `name`,`t_grade`.`term` AS `term`,`t_grade`.`grade` AS `grade` from (`t_grade` join `t_course`) where (`t_grade`.`c_no` = `t_course`.`id`) ;
