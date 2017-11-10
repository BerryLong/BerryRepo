/*
Navicat MySQL Data Transfer

Source Server         : Berry
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : house

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-10-25 20:20:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_city
-- ----------------------------
DROP TABLE IF EXISTS `tb_city`;
CREATE TABLE `tb_city` (
  `cityid` int(11) NOT NULL AUTO_INCREMENT,
  `cityname` varchar(255) COLLATE utf8_bin NOT NULL,
  `prov_id` int(11) NOT NULL,
  PRIMARY KEY (`cityid`),
  KEY `fk_city_prov` (`prov_id`),
  CONSTRAINT `fk_city_prov` FOREIGN KEY (`prov_id`) REFERENCES `tb_province` (`provid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_city
-- ----------------------------
INSERT INTO `tb_city` VALUES ('1', '北京', '1');
INSERT INTO `tb_city` VALUES ('2', '重庆', '2');
INSERT INTO `tb_city` VALUES ('3', '成都', '3');
INSERT INTO `tb_city` VALUES ('4', '绵阳', '3');
INSERT INTO `tb_city` VALUES ('5', '德阳', '3');

-- ----------------------------
-- Table structure for tb_district
-- ----------------------------
DROP TABLE IF EXISTS `tb_district`;
CREATE TABLE `tb_district` (
  `distid` int(11) NOT NULL AUTO_INCREMENT,
  `distname` varchar(255) COLLATE utf8_bin NOT NULL,
  `city_id` int(11) NOT NULL,
  PRIMARY KEY (`distid`),
  KEY `fk_district_city` (`city_id`),
  CONSTRAINT `fk_district_city` FOREIGN KEY (`city_id`) REFERENCES `tb_city` (`cityid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_district
-- ----------------------------
INSERT INTO `tb_district` VALUES ('1', '东城区', '1');
INSERT INTO `tb_district` VALUES ('2', '海淀区', '1');
INSERT INTO `tb_district` VALUES ('3', '大兴区', '1');
INSERT INTO `tb_district` VALUES ('4', '其他', '1');
INSERT INTO `tb_district` VALUES ('5', '渝北区', '2');
INSERT INTO `tb_district` VALUES ('6', '江北区', '2');
INSERT INTO `tb_district` VALUES ('7', '沙坪坝区', '2');
INSERT INTO `tb_district` VALUES ('8', '万州区', '2');
INSERT INTO `tb_district` VALUES ('9', '其他', '2');
INSERT INTO `tb_district` VALUES ('10', '成华区', '3');
INSERT INTO `tb_district` VALUES ('11', '武侯区', '3');
INSERT INTO `tb_district` VALUES ('12', '金牛区', '3');
INSERT INTO `tb_district` VALUES ('13', '锦江区', '3');
INSERT INTO `tb_district` VALUES ('14', '青羊区', '3');
INSERT INTO `tb_district` VALUES ('15', '其他', '3');
INSERT INTO `tb_district` VALUES ('16', '涪城区', '4');
INSERT INTO `tb_district` VALUES ('17', '游仙区', '4');
INSERT INTO `tb_district` VALUES ('18', '三台县', '4');
INSERT INTO `tb_district` VALUES ('19', '其他', '5');
INSERT INTO `tb_district` VALUES ('20', '旌阳区', '5');
INSERT INTO `tb_district` VALUES ('21', '绵竹市', '5');
INSERT INTO `tb_district` VALUES ('22', '其他', '5');

-- ----------------------------
-- Table structure for tb_house
-- ----------------------------
DROP TABLE IF EXISTS `tb_house`;
CREATE TABLE `tb_house` (
  `houseid` int(11) NOT NULL AUTO_INCREMENT,
  `area` int(11) NOT NULL,
  `contacterEmail` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `contacterName` varchar(10) COLLATE utf8_bin NOT NULL,
  `contacterQQ` varchar(12) COLLATE utf8_bin DEFAULT NULL,
  `contacterTel` varchar(20) COLLATE utf8_bin NOT NULL,
  `detail` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `floor` int(11) NOT NULL,
  `mainPhoto` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` float NOT NULL,
  `pubDate` datetime DEFAULT NULL,
  `street` varchar(255) COLLATE utf8_bin NOT NULL,
  `title` varchar(50) COLLATE utf8_bin NOT NULL,
  `totalFloor` int(11) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL,
  `house_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`houseid`),
  KEY `fk_house_district` (`district_id`),
  KEY `fk_house_type` (`house_type_id`),
  KEY `fk_house_user` (`user_id`),
  CONSTRAINT `fk_house_district` FOREIGN KEY (`district_id`) REFERENCES `tb_district` (`distid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_house_type` FOREIGN KEY (`house_type_id`) REFERENCES `tb_house_type` (`typeid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_house_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_house
-- ----------------------------
INSERT INTO `tb_house` VALUES ('1', '100', '12345678@qq.com', '张三丰', '1123145654', '13598766789', '七里晓月 精装套二 楼层适中 满两年', '1', '32a01026-a4a9-434b-a4bb-f3c324125297.png', '158', '2017-10-23 16:43:07', '跳伞塔街道', '七里晓月 精装套二 楼层适中 满两年', '9', '12', '2', '1');
INSERT INTO `tb_house` VALUES ('2', '100', '1138768221@qq.com', '张翠山', '1138768221', '13598766789', '七里晓月 精装套二 楼层适中 满两年', '1', '32a01026-a4a9-434b-a4bb-f3c324125297.png', '158', '2017-10-23 16:44:02', '跳伞塔街道', '精装套二 楼层适中', '9', null, '3', '1');
INSERT INTO `tb_house` VALUES ('3', '100', '112312312@qq.com', '易天行', '112312312', '18722772277', '精装套二 楼层适中 满两年', '1', '32a01026-a4a9-434b-a4bb-f3c324125297.png', '158', '2017-10-23 16:44:41', '跳伞塔街道', '精装套二 楼层适中', '9', null, '3', '1');
INSERT INTO `tb_house` VALUES ('4', '200', '113710@qq.com', '王大锤', '1138768221', '13598766789', '好的一笔', '2', '32a01026-a4a9-434b-a4bb-f3c324125297.png', '320', '2017-10-23 19:01:46', '跳伞塔街道', '天山人间', '15', '1', '3', '1');
INSERT INTO `tb_house` VALUES ('5', '60', '113710@qq.com', '张三丰', '1138768221', '13598766789', 'sadad', '1', '32a01026-a4a9-434b-a4bb-f3c324125297.png', '40', '2017-10-23 20:13:52', '跳伞塔街道', '天山人间', '2', '2', '7', '1');
INSERT INTO `tb_house` VALUES ('6', '1', '113710@qq.com', '张三丰', '1138768221', '13598766789', '', '1', '32a01026-a4a9-434b-a4bb-f3c324125297.png', '2', '2017-10-23 20:17:44', '跳伞塔街道', '精装套二 楼层适中', '2', '10', '7', '1');
INSERT INTO `tb_house` VALUES ('7', '5', '12345678@qq.com', '易天行', '1123145654', '13598766789', '', '1', '32a01026-a4a9-434b-a4bb-f3c324125297.png', '1', '2017-10-23 20:20:36', '跳伞塔街道', '天山人间', '1', '5', '1', '1');
INSERT INTO `tb_house` VALUES ('8', '200', '113710@qq.com', '张三丰', '1138768221', '13598766789', '', '2', '32a01026-a4a9-434b-a4bb-f3c324125297.png', '1000', '2017-10-23 20:43:28', '跳伞塔街道', '天山人间', '4', '10', '5', '1');
INSERT INTO `tb_house` VALUES ('9', '80', '113710@qq.com', '张三丰', '1138768221', '13598766789', '', '2', '32a01026-a4a9-434b-a4bb-f3c324125297.png', '120', '2017-10-24 10:35:31', '跳伞塔街道', '精装套二 楼层适中', '4', '1', '7', '1');

-- ----------------------------
-- Table structure for tb_house_photo
-- ----------------------------
DROP TABLE IF EXISTS `tb_house_photo`;
CREATE TABLE `tb_house_photo` (
  `photoid` int(11) NOT NULL AUTO_INCREMENT,
  `photoname` varchar(255) COLLATE utf8_bin NOT NULL,
  `house_id` int(11) NOT NULL,
  PRIMARY KEY (`photoid`),
  KEY `fk_photo_house` (`house_id`),
  CONSTRAINT `fk_photo_house` FOREIGN KEY (`house_id`) REFERENCES `tb_house` (`houseid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_house_photo
-- ----------------------------

-- ----------------------------
-- Table structure for tb_house_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_house_type`;
CREATE TABLE `tb_house_type` (
  `typeid` int(11) NOT NULL,
  `typename` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_house_type
-- ----------------------------
INSERT INTO `tb_house_type` VALUES ('1', '单间');
INSERT INTO `tb_house_type` VALUES ('2', '一室一厅');
INSERT INTO `tb_house_type` VALUES ('3', '二室一厅');
INSERT INTO `tb_house_type` VALUES ('4', '三室一厅');
INSERT INTO `tb_house_type` VALUES ('5', '三室两厅');
INSERT INTO `tb_house_type` VALUES ('6', '四室两厅');
INSERT INTO `tb_house_type` VALUES ('7', '别墅');
INSERT INTO `tb_house_type` VALUES ('8', '其他');

-- ----------------------------
-- Table structure for tb_login_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_log`;
CREATE TABLE `tb_login_log` (
  `loginid` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `ipaddr` varchar(255) COLLATE utf8_bin NOT NULL,
  `logdate` datetime NOT NULL,
  PRIMARY KEY (`loginid`),
  KEY `fk_log_user` (`user_id`),
  CONSTRAINT `fk_log_user` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_login_log
-- ----------------------------
INSERT INTO `tb_login_log` VALUES ('1', '1', '0:0:0:0:0:0:0:1', '2017-10-23 18:56:16');
INSERT INTO `tb_login_log` VALUES ('2', '1', '0:0:0:0:0:0:0:1', '2017-10-23 18:59:46');
INSERT INTO `tb_login_log` VALUES ('3', '1', '0:0:0:0:0:0:0:1', '2017-10-23 19:35:15');
INSERT INTO `tb_login_log` VALUES ('4', '1', '0:0:0:0:0:0:0:1', '2017-10-23 19:42:20');
INSERT INTO `tb_login_log` VALUES ('5', '1', '0:0:0:0:0:0:0:1', '2017-10-23 19:43:21');
INSERT INTO `tb_login_log` VALUES ('6', '1', '0:0:0:0:0:0:0:1', '2017-10-23 19:44:30');
INSERT INTO `tb_login_log` VALUES ('7', '1', '0:0:0:0:0:0:0:1', '2017-10-23 19:59:28');
INSERT INTO `tb_login_log` VALUES ('8', '1', '0:0:0:0:0:0:0:1', '2017-10-23 20:11:24');
INSERT INTO `tb_login_log` VALUES ('9', '1', '0:0:0:0:0:0:0:1', '2017-10-23 20:13:00');
INSERT INTO `tb_login_log` VALUES ('10', '1', '0:0:0:0:0:0:0:1', '2017-10-24 10:33:04');
INSERT INTO `tb_login_log` VALUES ('11', '1', '0:0:0:0:0:0:0:1', '2017-10-24 16:39:23');
INSERT INTO `tb_login_log` VALUES ('12', '1', '0:0:0:0:0:0:0:1', '2017-10-24 18:33:04');
INSERT INTO `tb_login_log` VALUES ('13', '1', '0:0:0:0:0:0:0:1', '2017-10-24 19:20:15');
INSERT INTO `tb_login_log` VALUES ('14', '1', '0:0:0:0:0:0:0:1', '2017-10-24 19:50:25');
INSERT INTO `tb_login_log` VALUES ('15', '1', '0:0:0:0:0:0:0:1', '2017-10-24 19:51:24');
INSERT INTO `tb_login_log` VALUES ('16', '1', '0:0:0:0:0:0:0:1', '2017-10-24 21:00:59');

-- ----------------------------
-- Table structure for tb_province
-- ----------------------------
DROP TABLE IF EXISTS `tb_province`;
CREATE TABLE `tb_province` (
  `provid` int(11) NOT NULL AUTO_INCREMENT,
  `provname` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`provid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_province
-- ----------------------------
INSERT INTO `tb_province` VALUES ('1', '北京');
INSERT INTO `tb_province` VALUES ('2', '重庆');
INSERT INTO `tb_province` VALUES ('3', '四川省');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` char(32) COLLATE utf8_bin NOT NULL,
  `realname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tel` char(11) COLLATE utf8_bin DEFAULT NULL,
  `isadmin` bit(1) DEFAULT b'0',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `uni_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '王大锤', '13800112233', '');
