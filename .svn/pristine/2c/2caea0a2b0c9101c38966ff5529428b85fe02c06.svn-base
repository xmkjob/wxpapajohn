DROP DATABASE IF EXISTS papajohn;
CREATE DATABASE papajohn CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

GRANT ALL ON papajohn.* TO 'papa'@'%' IDENTIFIED BY 'Aq1sW2de#';
GRANT ALL ON papajohn.* TO 'papa'@'localhost' IDENTIFIED BY 'Aq1sW2de#';
GRANT SELECT ON mysql.proc to 'papa'@'%' IDENTIFIED BY 'Aq1sW2de#';
GRANT FILE ON *.* TO papa@localhost;

USE papajohn;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bonuslist`
-- ----------------------------
DROP TABLE IF EXISTS `bonuslist`;
CREATE TABLE `bonuslist` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `phonenum` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `bonusno` varchar(255) NOT NULL,
  `creattime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_bonusnum` (`bonusno`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
--  Records of `bonuslist`
-- ----------------------------
BEGIN;
INSERT INTO `bonuslist` VALUES ('1', 'test00', '1299222222', '北京', '12300', '2014-10-14 21:35:38'), ('3', 'test0021103475', '1299222222', '北京', '0021103475', '2014-10-14 21:41:46');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
