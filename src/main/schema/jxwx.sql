DROP DATABASE IF EXISTS jxwx;
CREATE DATABASE jxwx CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

GRANT ALL ON jxwx.* TO 'weixin'@'%' IDENTIFIED BY 'Aq1sW2de#';
GRANT ALL ON jxwx.* TO 'weixin'@'localhost' IDENTIFIED BY 'Aq1sW2de#';
GRANT SELECT ON mysql.proc to 'weixin'@'%' IDENTIFIED BY 'Aq1sW2de#';
GRANT FILE ON *.* TO app@localhost;

USE jxwx;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `admin_action`
-- ----------------------------
DROP TABLE IF EXISTS `admin_action`;
CREATE TABLE `admin_action` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `desc` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `admin_depart`
-- ----------------------------
DROP TABLE IF EXISTS `admin_depart`;
CREATE TABLE `admin_depart` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `desc` varchar(64) DEFAULT NULL,
  `creattime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `admin_group`
-- ----------------------------
DROP TABLE IF EXISTS `admin_group`;
CREATE TABLE `admin_group` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `departid` bigint(20) unsigned NOT NULL,
  `departname` varchar(32) NOT NULL,
  `memberid` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_memberid` (`memberid`) USING BTREE,
  KEY `uk_departid` (`departid`) USING BTREE,
  CONSTRAINT `fk_group_departid` FOREIGN KEY (`departid`) REFERENCES `admin_depart` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_group_memberid` FOREIGN KEY (`memberid`) REFERENCES `admin_member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `admin_log`
-- ----------------------------
DROP TABLE IF EXISTS `admin_log`;
CREATE TABLE `admin_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `membername` varchar(64) NOT NULL,
  `memberid` bigint(20) unsigned NOT NULL,
  `actionid` bigint(20) unsigned NOT NULL,
  `actiontime` datetime NOT NULL,
  `actiondesc` varchar(64) DEFAULT NULL,
  `actiondetail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uk_memberid` (`memberid`) USING BTREE,
  KEY `uk_actionid` (`actionid`) USING BTREE,
  CONSTRAINT `fk_admin_log_actionid` FOREIGN KEY (`actionid`) REFERENCES `admin_action` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_admin_log_memberid` FOREIGN KEY (`memberid`) REFERENCES `admin_member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=620 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `admin_member`
-- ----------------------------
DROP TABLE IF EXISTS `admin_member`;
CREATE TABLE `admin_member` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `password` char(64) NOT NULL,
  `salt` char(32) NOT NULL,
  `realname` varchar(64) NOT NULL,
  `logintime` datetime DEFAULT NULL,
  `creattime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `admin_pri`
-- ----------------------------
DROP TABLE IF EXISTS `admin_pri`;
CREATE TABLE `admin_pri` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `departid` bigint(20) unsigned NOT NULL,
  `actionid` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uk_departid` (`departid`) USING BTREE,
  KEY `uk_actionid` (`actionid`) USING BTREE,
  CONSTRAINT `fk_pri_actionid` FOREIGN KEY (`actionid`) REFERENCES `admin_action` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pri_departid` FOREIGN KEY (`departid`) REFERENCES `admin_depart` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `admin_member`
-- ----------------------------
DROP TABLE IF EXISTS `admin_member`;
CREATE TABLE `admin_member` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `password` char(64) NOT NULL,
  `salt` char(32) NOT NULL,
  `realname` varchar(64) NOT NULL,
  `logintime` datetime DEFAULT NULL,
  `creattime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `admin_pri`
-- ----------------------------
DROP TABLE IF EXISTS `admin_pri`;
CREATE TABLE `admin_pri` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `departid` bigint(20) unsigned NOT NULL,
  `actionid` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `uk_departid` (`departid`) USING BTREE,
  KEY `uk_actionid` (`actionid`) USING BTREE,
  CONSTRAINT `fk_pri_actionid` FOREIGN KEY (`actionid`) REFERENCES `admin_action` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pri_departid` FOREIGN KEY (`departid`) REFERENCES `admin_depart` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
