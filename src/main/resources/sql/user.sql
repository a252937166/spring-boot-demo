/*
 Navicat Premium Data Transfer

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : utf-8

 Date: 12/08/2018 17:52:06 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userName` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('11', 'girl', '11', '12'), ('22', 'boy', '12', '124'), ('22', 'middle', '13', '3545'), ('33', 'ok', '111', 'asasdff'), ('333', 'ok', '111', 'd'), ('1111', 'asdf', '1', 'asdfas');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
