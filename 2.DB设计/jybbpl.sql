/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : jybbpl

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2022-12-19 09:40:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for coachcourse
-- ----------------------------
DROP TABLE IF EXISTS `coachcourse`;
CREATE TABLE `coachcourse` (
  `ccid` int(11) NOT NULL AUTO_INCREMENT,
  `ucid` int(11) NOT NULL,
  `ccattendtime` time NOT NULL,
  `ccendtime` time NOT NULL,
  `ccreateid` int(11) NOT NULL,
  `useridt` int(11) NOT NULL,
  `ccheckstart` int(11) DEFAULT NULL,
  PRIMARY KEY (`ccid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of coachcourse
-- ----------------------------
INSERT INTO `coachcourse` VALUES ('1', '11', '08:00:00', '10:00:00', '2', '6', '1');
INSERT INTO `coachcourse` VALUES ('2', '5', '08:30:00', '09:30:00', '3', '5', '1');
INSERT INTO `coachcourse` VALUES ('3', '10', '09:00:00', '11:00:00', '3', '5', '1');
INSERT INTO `coachcourse` VALUES ('4', '4', '09:30:00', '10:30:00', '2', '4', '1');
INSERT INTO `coachcourse` VALUES ('5', '2', '10:00:00', '12:30:00', '2', '4', '0');
INSERT INTO `coachcourse` VALUES ('6', '7', '10:30:00', '12:00:00', '3', '6', '0');
INSERT INTO `coachcourse` VALUES ('7', '12', '14:00:00', '16:00:00', '3', '4', '1');

-- ----------------------------
-- Table structure for coachsign
-- ----------------------------
DROP TABLE IF EXISTS `coachsign`;
CREATE TABLE `coachsign` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `scouid` int(11) NOT NULL,
  `srecid` int(11) NOT NULL,
  `srstats` int(11) NOT NULL,
  `srtime` datetime NOT NULL,
  `scoaid` int(11) NOT NULL,
  `scoastats` int(11) NOT NULL,
  `scoatime` datetime DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of coachsign
-- ----------------------------
INSERT INTO `coachsign` VALUES ('1', '1', '3', '1', '2022-12-15 08:30:00', '5', '0', '2022-12-15 09:30:00');
INSERT INTO `coachsign` VALUES ('2', '2', '4', '0', '2022-12-15 08:30:00', '4', '0', '2022-12-15 08:00:00');
INSERT INTO `coachsign` VALUES ('3', '3', '4', '1', '2022-12-16 08:30:00', '6', '0', '2022-12-16 14:00:00');
INSERT INTO `coachsign` VALUES ('4', '5', '3', '1', '2022-12-16 08:30:00', '2', '1', '2022-12-16 08:00:00');
INSERT INTO `coachsign` VALUES ('5', '6', '3', '1', '2022-12-16 08:30:00', '3', '0', '2022-12-16 10:00:00');
INSERT INTO `coachsign` VALUES ('6', '7', '3', '1', '2022-12-16 08:30:00', '4', '0', '2022-12-16 10:30:00');

-- ----------------------------
-- Table structure for consumptionrecords
-- ----------------------------
DROP TABLE IF EXISTS `consumptionrecords`;
CREATE TABLE `consumptionrecords` (
  `crid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `said` int(11) NOT NULL,
  `crtime` datetime NOT NULL,
  `cramount` float(8,2) NOT NULL,
  PRIMARY KEY (`crid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of consumptionrecords
-- ----------------------------
INSERT INTO `consumptionrecords` VALUES ('1', '1', '1', '2022-12-16 10:30:00', '50.00');
INSERT INTO `consumptionrecords` VALUES ('2', '1', '1', '2022-12-16 10:30:00', '50.00');
INSERT INTO `consumptionrecords` VALUES ('3', '1', '2', '2022-12-16 10:30:00', '50.00');
INSERT INTO `consumptionrecords` VALUES ('4', '2', '2', '2022-12-16 10:30:00', '50.00');
INSERT INTO `consumptionrecords` VALUES ('5', '3', '3', '2022-12-16 10:30:00', '50.00');
INSERT INTO `consumptionrecords` VALUES ('6', '5', '5', '2022-12-16 11:00:00', '0.00');
INSERT INTO `consumptionrecords` VALUES ('7', '6', '6', '2022-12-16 10:30:00', '50.00');
INSERT INTO `consumptionrecords` VALUES ('8', '4', '4', '2022-12-18 11:00:00', '50.00');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(40) COLLATE utf8_bin NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `useridt` int(11) NOT NULL,
  `cstarttime` date NOT NULL,
  `cattendtime` time NOT NULL,
  `cendtime` time NOT NULL,
  `clesson` int(2) NOT NULL,
  `cdescribe` varchar(255) COLLATE utf8_bin NOT NULL,
  `cpeonum` int(3) NOT NULL,
  `cactpeonum` int(11) NOT NULL,
  `cstartstatus` int(11) NOT NULL,
  `creservetime` datetime NOT NULL,
  `ccreateid` int(11) NOT NULL,
  `ccreatetime` datetime NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '塑造型男课', '1', '5', '2022-10-01', '09:30:00', '11:30:00', '2', '有效地美化肌肉线条和轮廓，增加肌肉立体感，能很好地锻炼臂肌，胸肌，塑造型男的必备。', '15', '0', '0', '2022-09-15 09:00:00', '3', '2022-09-14 16:00:00');
INSERT INTO `course` VALUES ('2', '猛男成型课', '2', '4', '2022-08-01', '10:00:00', '12:00:00', '2', '用于增强肌肉力量训练的简单器材。它的用途是用于肌力训练，肌肉复合动作训练。因运动麻痹、疼痛、长期不活动等导致肌力低下的患者，手持哑铃，\r\n可利用哑铃的重量进行抗阻力主动运动，训练肌力。', '15', '0', '0', '2022-07-15 09:00:00', '2', '2022-07-10 16:00:00');
INSERT INTO `course` VALUES ('3', '舞动青春课', '3', '6', '2022-03-01', '15:00:00', '17:00:00', '2', ' 韵律操是一种在场地内，使用球、棍、圈、绳、棒、带进行比赛的体操项目，\r\n参加的人数比较灵活，可以是单人、双人或者三人以上。韵律操融合了芭蕾、体操、舞蹈等项目的特点。', '15', '0', '0', '2022-01-22 09:00:00', '2', '2022-01-01 16:00:00');
INSERT INTO `course` VALUES ('4', '瑜伽', '4', '4', '2022-12-12', '09:30:00', '10:30:00', '4', '锻炼身体，保持体型，修身养性', '10', '0', '0', '2022-12-10 09:00:00', '2', '2022-12-09 09:00:00');
INSERT INTO `course` VALUES ('5', '街舞', '5', '5', '2022-12-15', '08:30:00', '09:30:00', '4', '有氧舞蹈可以帮助减肥者消耗身体多余的热量', '10', '0', '0', '2022-12-10 09:00:00', '3', '2022-12-09 09:00:00');
INSERT INTO `course` VALUES ('6', '健身操', '6', '6', '2022-12-16', '10:00:00', '11:00:00', '4', '大众健身操可以锻炼到全身每个关节，有效的提高参与者的心肺功能', '10', '0', '0', '2022-12-10 09:00:00', '2', '2022-12-09 09:00:00');
INSERT INTO `course` VALUES ('7', '体态修复课', '7', '6', '2022-10-01', '10:30:00', '11:30:00', '2', '改变体态，修复骨盆前倾，驼背，脊柱侧弯，修复体态必备。', '10', '0', '0', '2022-09-15 09:00:00', '3', '2022-09-14 16:00:00');
INSERT INTO `course` VALUES ('8', '五分化增肌课', '8', '4', '2022-08-01', '10:00:00', '12:00:00', '2', '为外胚型体质制作训练计划。五分化训练，周一胸部训练。周二背部训练、周三肩部训练,周四手臂训练，周五腿部训练，有效的增肌为外胚体质制定计划，\r\n让肌肉孤立发力，更好的刺激目标肌群。', '10', '0', '0', '2022-07-15 09:00:00', '3', '2022-07-10 16:00:00');
INSERT INTO `course` VALUES ('9', '系统化训练课', '9', '4', '2022-03-01', '15:00:00', '17:00:00', '2', '系统化训练时专门为内胚型体质的专门训练计划，适用于大多数人，对单独目标肌群进行反复训练达到撕裂肌肉纤维效果为此最大效果增肌，\r\n训练结束后要进行40分钟椭圆机有氧训练，从而达到增肌减脂同时进行。', '10', '0', '0', '2022-01-22 09:00:00', '2', '2022-01-01 16:00:00');
INSERT INTO `course` VALUES ('10', '慢跑', '5', '5', '2022-12-16', '09:00:00', '11:00:00', '4', '增强肌肉与肌耐力，增进心肺功能', '20', '0', '0', '2022-12-14 07:00:00', '3', '2022-12-14 00:00:00');
INSERT INTO `course` VALUES ('11', '健身球', '5', '6', '2022-12-19', '08:00:00', '10:00:00', '4', '提高身体柔韧性', '20', '0', '0', '2022-12-17 07:00:00', '2', '2022-12-17 00:00:00');
INSERT INTO `course` VALUES ('12', '杠铃操', '10', '4', '2022-12-21', '14:00:00', '16:00:00', '4', '较快速的瘦身运动', '20', '0', '0', '2022-12-19 07:00:00', '3', '2022-12-19 00:00:00');

-- ----------------------------
-- Table structure for coursereserve
-- ----------------------------
DROP TABLE IF EXISTS `coursereserve`;
CREATE TABLE `coursereserve` (
  `csid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `ulid` int(11) NOT NULL,
  `cappointment` datetime NOT NULL,
  `cappointmentstatus` int(11) NOT NULL,
  `ulida` int(11) NOT NULL,
  `cprocessingtime` datetime NOT NULL,
  `cveto` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`csid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of coursereserve
-- ----------------------------
INSERT INTO `coursereserve` VALUES ('1', '9', '8', '2022-02-22 11:05:49', '1', '3', '2022-02-28 10:01:49', null);
INSERT INTO `coursereserve` VALUES ('2', '4', '11', '2022-12-01 10:03:49', '1', '3', '2022-12-03 09:03:49', null);
INSERT INTO `coursereserve` VALUES ('3', '3', '10', '2022-02-20 11:12:49', '1', '4', '2022-02-21 11:03:49', null);
INSERT INTO `coursereserve` VALUES ('4', '6', '11', '2022-11-19 08:01:49', '0', '4', '2022-12-02 11:01:49', '人数已满');
INSERT INTO `coursereserve` VALUES ('5', '6', '12', '2022-12-01 09:05:23', '0', '4', '2022-12-02 10:29:49', '人数已满');
INSERT INTO `coursereserve` VALUES ('6', '8', '13', '2022-07-15 13:51:12', '0', '4', '2022-07-15 15:31:05', '人数已满');
INSERT INTO `coursereserve` VALUES ('7', '11', '18', '2022-12-10 10:56:14', '1', '3', '2022-12-13 13:14:52', null);
INSERT INTO `coursereserve` VALUES ('8', '7', '14', '2022-09-28 11:23:54', '1', '3', '2022-09-29 12:01:25', null);

-- ----------------------------
-- Table structure for guidance
-- ----------------------------
DROP TABLE IF EXISTS `guidance`;
CREATE TABLE `guidance` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `ccid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `useridt` int(11) NOT NULL,
  `gquestion` varchar(255) COLLATE utf8_bin NOT NULL,
  `gquetime` datetime NOT NULL,
  `greply` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `grepsta` int(11) NOT NULL,
  `greptime` datetime DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of guidance
-- ----------------------------
INSERT INTO `guidance` VALUES ('1', '1', '18', '6', '锻炼之后全身酸痛怎么办', '2022-11-03 11:30:00', null, '0', null);
INSERT INTO `guidance` VALUES ('2', '2', '12', '5', '跑不动怎么办', '2022-11-04 11:30:00', '你体力不够，肺活量也差一些，肌肉力量也更不上。爆发力不行，多吃东西，加大运动量，一段时间后会好很多', '1', '2022-11-03 11:30:00');
INSERT INTO `guidance` VALUES ('3', '2', '12', '5', '不会发力怎么办', '2022-11-05 11:30:00', '缺乏锻炼会使，神经系统变的迟钝。神经系统和肌肉的关系，就像两个好朋友。如果太久没有联系，关系就会变得陌生。', '1', '2022-11-06 11:30:00');
INSERT INTO `guidance` VALUES ('4', '3', '17', '5', '肌肉增长，有极限吗？', '2022-11-03 11:30:00', '有的这里提供的有数据，第一年肌肉增长，极限是十公斤，第二年肌肉可能是五公斤，第三年四公斤，第四年的可能更少，注意你要是坚持时间越长最后的极限数据越少，甚至你练的非常非常好了，才能达到这个极限重量，如果你每一年都能打到这个肌肉效果，五年内增长接近20公斤的肌肉已经是很了不起了。', '0', '2022-11-03 11:30:00');
INSERT INTO `guidance` VALUES ('5', '3', '5', '5', '徒手健身可以增加肌肉吗？', '2022-12-03 07:30:00', '这个是当然可以的，要是满足渐进超负荷原则，如果仅仅停留在每天做200个俯卧撑的不行的，你只会看起来比公园老大爷强壮一点，甚至没有训练的痕迹，很多顿肉，健身可以练出很强的肌肉，但是需要一个很有努力的方法，在高难度健身之路，你要不断的解锁，更难的姿势来实现监禁复活，有些姿势难度，水平不亚于体操，比如说俄式挺身，双力臂等等，有些人可能花几年的时间甚至更多也做不到。', '1', '2022-11-03 11:30:00');
INSERT INTO `guidance` VALUES ('6', '0', '6', '6', '健身时需要怎么正确饮食', '2022-12-14 09:32:00', '健身的同时要保持科学合理的饮食，否则对肌肉或者身体都有损伤。主要有以下几点建议：1、肉食要适量的吃，如鸡肉、鱼、牛肉等等。尽量不要吃太油腻的食物，略为清淡些。2、补充适量的蛋白粉。3、早餐主要是吃蛋白质、低碳水化合物类的食物。4、每天要吃富含淀粉的蔬菜，如土豆、通心粉等等。5、每天要吃2-3个水果，最好是不同类的水果，在运动时间延长时需要再补充甜食或甜饮料。6、运动后避免喝含有咖啡因的饮料。', '0', '2022-12-14 10:00:00');
INSERT INTO `guidance` VALUES ('7', '4', '4', '4', '徒手健身可以增加肌肉吗？', '2022-12-03 20:30:01', '这个是当然可以的，要是满足渐进超负荷原则，如果仅仅停留在每天做200个俯卧撑的不行的，你只会看起来比公园老大爷强壮一点，甚至没有训练的痕迹，很多顿肉，健身可以练出很强的肌肉，但是需要一个很有努力的方法，在高难度健身之路，你要不断的解锁，更难的姿势来实现监禁复活，有些姿势难度，水平不亚于体操，比如说俄式挺身，双力臂等等，有些人可能花几年的时间甚至更多也做不到。', '1', '2022-11-03 21:30:00');
INSERT INTO `guidance` VALUES ('8', '3', '17', '1', '不会发力怎么办', '2022-12-03 20:30:01', '缺乏锻炼会使，神经系统变的迟钝。神经系统和肌肉的关系，就像两个好朋友。如果太久没有联系，关系就会变得陌生。', '1', '2022-11-03 21:30:00');

-- ----------------------------
-- Table structure for parameter
-- ----------------------------
DROP TABLE IF EXISTS `parameter`;
CREATE TABLE `parameter` (
  `parid` int(11) NOT NULL AUTO_INCREMENT,
  `parname` varchar(40) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`parid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of parameter
-- ----------------------------
INSERT INTO `parameter` VALUES ('1', '性别');
INSERT INTO `parameter` VALUES ('2', '在线状态');
INSERT INTO `parameter` VALUES ('3', '封停状态');
INSERT INTO `parameter` VALUES ('4', '教练授课状态');
INSERT INTO `parameter` VALUES ('5', '是否开始');
INSERT INTO `parameter` VALUES ('6', '到店状态');
INSERT INTO `parameter` VALUES ('7', '学员上课状态');
INSERT INTO `parameter` VALUES ('8', '回复状态');
INSERT INTO `parameter` VALUES ('9', '开课状态');
INSERT INTO `parameter` VALUES ('10', '预约状态');
INSERT INTO `parameter` VALUES ('11', '前台签到状态');
INSERT INTO `parameter` VALUES ('12', '教练签到状态');
INSERT INTO `parameter` VALUES ('13', '评价等级');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(40) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '弹簧拉力器项目');
INSERT INTO `project` VALUES ('2', '哑铃项目');
INSERT INTO `project` VALUES ('3', '韵律操项目');
INSERT INTO `project` VALUES ('4', '塑型');
INSERT INTO `project` VALUES ('5', '有氧项目');
INSERT INTO `project` VALUES ('6', '大众健身操');
INSERT INTO `project` VALUES ('7', '拉伸项目');
INSERT INTO `project` VALUES ('8', '无氧项目');
INSERT INTO `project` VALUES ('9', '增肌项目');
INSERT INTO `project` VALUES ('10', '杠铃项目');

-- ----------------------------
-- Table structure for purview
-- ----------------------------
DROP TABLE IF EXISTS `purview`;
CREATE TABLE `purview` (
  `purid` int(11) NOT NULL AUTO_INCREMENT,
  `purname` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`purid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of purview
-- ----------------------------
INSERT INTO `purview` VALUES ('1', '管理员');
INSERT INTO `purview` VALUES ('2', '用户');
INSERT INTO `purview` VALUES ('3', '教练');
INSERT INTO `purview` VALUES ('4', '前台');

-- ----------------------------
-- Table structure for rate
-- ----------------------------
DROP TABLE IF EXISTS `rate`;
CREATE TABLE `rate` (
  `rateid` int(11) NOT NULL AUTO_INCREMENT,
  `ccid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `useridt` int(11) NOT NULL,
  `ratelevel` int(11) DEFAULT NULL,
  `ratetime` datetime DEFAULT NULL,
  PRIMARY KEY (`rateid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of rate
-- ----------------------------
INSERT INTO `rate` VALUES ('1', '7', '3', '5', '2', '2022-01-01 12:00:00');
INSERT INTO `rate` VALUES ('2', '6', '7', '9', null, '2022-05-11 14:20:05');
INSERT INTO `rate` VALUES ('3', '5', '6', '3', '3', '2022-06-02 09:30:42');
INSERT INTO `rate` VALUES ('4', '4', '9', '7', null, '2022-08-01 17:54:06');
INSERT INTO `rate` VALUES ('5', '3', '5', '6', '1', '2022-11-11 10:10:01');
INSERT INTO `rate` VALUES ('6', '2', '5', '4', '1', '2022-11-11 15:32:58');

-- ----------------------------
-- Table structure for recharge
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge` (
  `reid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `userida` int(11) NOT NULL,
  `retime` datetime NOT NULL,
  `reamo` float(8,2) NOT NULL,
  PRIMARY KEY (`reid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of recharge
-- ----------------------------
INSERT INTO `recharge` VALUES ('1', '9', '1', '2022-01-26 00:00:00', '200.00');
INSERT INTO `recharge` VALUES ('2', '10', '1', '2022-02-24 00:00:00', '50.10');
INSERT INTO `recharge` VALUES ('3', '11', '1', '2022-03-25 00:00:00', '300.32');
INSERT INTO `recharge` VALUES ('4', '12', '1', '2022-04-23 00:00:00', '100.20');
INSERT INTO `recharge` VALUES ('5', '13', '1', '2022-05-22 00:00:00', '50.00');
INSERT INTO `recharge` VALUES ('6', '14', '2', '2022-06-20 00:00:00', '100.13');
INSERT INTO `recharge` VALUES ('7', '15', '2', '2022-07-19 00:00:00', '250.00');
INSERT INTO `recharge` VALUES ('8', '16', '2', '2022-08-17 00:00:00', '150.97');
INSERT INTO `recharge` VALUES ('9', '17', '2', '2022-09-15 00:00:00', '200.54');
INSERT INTO `recharge` VALUES ('10', '18', '2', '2022-10-14 00:00:00', '300.00');

-- ----------------------------
-- Table structure for studentac
-- ----------------------------
DROP TABLE IF EXISTS `studentac`;
CREATE TABLE `studentac` (
  `said` int(11) NOT NULL,
  `ccid` int(11) NOT NULL,
  `useridf` int(11) NOT NULL,
  `sastate` int(11) NOT NULL,
  `satime` datetime NOT NULL,
  `userid` int(11) NOT NULL,
  `saclassstatus` int(11) NOT NULL,
  `saattendtime` datetime DEFAULT NULL,
  PRIMARY KEY (`said`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of studentac
-- ----------------------------
INSERT INTO `studentac` VALUES ('1', '1', '2', '1', '2022-12-19 07:07:33', '18', '1', '2022-12-19 08:00:00');
INSERT INTO `studentac` VALUES ('2', '2', '3', '1', '2022-12-15 07:10:13', '12', '0', '2022-12-15 08:30:00');
INSERT INTO `studentac` VALUES ('3', '2', '2', '0', '0000-00-00 00:00:00', '17', '0', '2022-12-16 09:30:00');
INSERT INTO `studentac` VALUES ('4', '3', '3', '0', '0000-00-00 00:00:00', '11', '0', '2022-12-12 10:00:00');
INSERT INTO `studentac` VALUES ('5', '5', '2', '1', '2022-08-01 09:42:08', '9', '1', '2022-08-01 10:30:00');
INSERT INTO `studentac` VALUES ('6', '6', '2', '1', '2022-10-01 10:09:33', '14', '1', '2022-10-01 10:30:00');
INSERT INTO `studentac` VALUES ('7', '7', '2', '1', '2022-12-21 13:50:01', '19', '1', '2022-12-21 14:00:00');

-- ----------------------------
-- Table structure for subparameter
-- ----------------------------
DROP TABLE IF EXISTS `subparameter`;
CREATE TABLE `subparameter` (
  `parid` int(11) NOT NULL AUTO_INCREMENT,
  `sparid` int(11) NOT NULL,
  `sparname` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`parid`,`sparid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of subparameter
-- ----------------------------
INSERT INTO `subparameter` VALUES ('1', '0', '男');
INSERT INTO `subparameter` VALUES ('1', '1', '女');
INSERT INTO `subparameter` VALUES ('2', '0', '离线');
INSERT INTO `subparameter` VALUES ('2', '1', '在线');
INSERT INTO `subparameter` VALUES ('3', '0', '未封停  ');
INSERT INTO `subparameter` VALUES ('3', '1', '已封停');
INSERT INTO `subparameter` VALUES ('4', '0', '未授课');
INSERT INTO `subparameter` VALUES ('4', '1', '已授课');
INSERT INTO `subparameter` VALUES ('5', '0', '否  ');
INSERT INTO `subparameter` VALUES ('5', '1', '是');
INSERT INTO `subparameter` VALUES ('6', '0', '未到店 ');
INSERT INTO `subparameter` VALUES ('6', '1', '已到店');
INSERT INTO `subparameter` VALUES ('7', '0', '未到店');
INSERT INTO `subparameter` VALUES ('7', '1', '已到店');
INSERT INTO `subparameter` VALUES ('8', '0', '未到店');
INSERT INTO `subparameter` VALUES ('8', '1', '已到店');
INSERT INTO `subparameter` VALUES ('9', '0', '未审批');
INSERT INTO `subparameter` VALUES ('9', '1', '审批通过');
INSERT INTO `subparameter` VALUES ('9', '2', '审批否决');
INSERT INTO `subparameter` VALUES ('10', '0', '未打卡');
INSERT INTO `subparameter` VALUES ('10', '1', '已打卡');
INSERT INTO `subparameter` VALUES ('11', '0', '未打卡');
INSERT INTO `subparameter` VALUES ('11', '1', '已打卡');
INSERT INTO `subparameter` VALUES ('12', '0', '未签到');
INSERT INTO `subparameter` VALUES ('12', '1', '已签到');
INSERT INTO `subparameter` VALUES ('13', '0', '暂无评分');
INSERT INTO `subparameter` VALUES ('13', '1', '⭐');
INSERT INTO `subparameter` VALUES ('13', '2', '⭐⭐');
INSERT INTO `subparameter` VALUES ('13', '3', '⭐⭐⭐');
INSERT INTO `subparameter` VALUES ('13', '4', '⭐⭐⭐⭐');
INSERT INTO `subparameter` VALUES ('13', '5', '⭐⭐⭐⭐⭐');

-- ----------------------------
-- Table structure for ucouse
-- ----------------------------
DROP TABLE IF EXISTS `ucouse`;
CREATE TABLE `ucouse` (
  `ucid` int(11) NOT NULL AUTO_INCREMENT,
  `ucuid` int(11) NOT NULL,
  `uccouid` int(11) NOT NULL,
  PRIMARY KEY (`ucid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ucouse
-- ----------------------------
INSERT INTO `ucouse` VALUES ('1', '8', '1');
INSERT INTO `ucouse` VALUES ('2', '9', '2');
INSERT INTO `ucouse` VALUES ('3', '10', '3');
INSERT INTO `ucouse` VALUES ('4', '11', '4');
INSERT INTO `ucouse` VALUES ('5', '12', '5');
INSERT INTO `ucouse` VALUES ('6', '13', '6');
INSERT INTO `ucouse` VALUES ('7', '14', '7');
INSERT INTO `ucouse` VALUES ('8', '15', '8');
INSERT INTO `ucouse` VALUES ('9', '16', '9');
INSERT INTO `ucouse` VALUES ('10', '17', '10');
INSERT INTO `ucouse` VALUES ('11', '18', '11');
INSERT INTO `ucouse` VALUES ('12', '19', '12');
INSERT INTO `ucouse` VALUES ('13', '20', '5');

-- ----------------------------
-- Table structure for userinformation
-- ----------------------------
DROP TABLE IF EXISTS `userinformation`;
CREATE TABLE `userinformation` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) COLLATE utf8_bin NOT NULL,
  `userphone` varchar(11) COLLATE utf8_bin NOT NULL,
  `usersex` int(11) NOT NULL,
  `userheight` float(3,2) DEFAULT NULL,
  `userweight` float(5,2) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of userinformation
-- ----------------------------
INSERT INTO `userinformation` VALUES ('1', '刘青松', '13388584463', '0', '1.76', '54.60');
INSERT INTO `userinformation` VALUES ('2', '林炜翔', '15604381120', '0', '1.69', '48.30');
INSERT INTO `userinformation` VALUES ('3', 'doinb', '19965435541', '0', '1.70', '57.60');
INSERT INTO `userinformation` VALUES ('4', '李炫君', '15438525433', '0', '1.81', '78.60');
INSERT INTO `userinformation` VALUES ('5', '林清玄', '15543554125', '1', '1.61', '48.20');
INSERT INTO `userinformation` VALUES ('6', '刘亦菲', '17155476666', '1', '1.72', '49.30');
INSERT INTO `userinformation` VALUES ('7', '刘志旭', '16845224355', '0', '1.76', '77.60');
INSERT INTO `userinformation` VALUES ('8', '林志聪', '15665258144', '0', '1.69', '103.60');
INSERT INTO `userinformation` VALUES ('9', '梁朝伟', '13055716875', '0', '1.78', '62.40');
INSERT INTO `userinformation` VALUES ('10', '胡歌', '15833543844', '0', '1.80', '66.60');
INSERT INTO `userinformation` VALUES ('11', '王思聪', '18888888888', '0', '1.71', '77.30');
INSERT INTO `userinformation` VALUES ('12', '王健林', '16666666666', '0', '1.68', '67.60');
INSERT INTO `userinformation` VALUES ('13', '马云', '15555555555', '0', '1.61', '54.60');
INSERT INTO `userinformation` VALUES ('14', '马化腾', '14444444444', '0', '1.75', '63.70');
INSERT INTO `userinformation` VALUES ('15', '马丽', '15845245551', '1', '1.74', '57.60');
INSERT INTO `userinformation` VALUES ('16', '沈腾', '13371257854', '0', '1.73', '81.50');
INSERT INTO `userinformation` VALUES ('17', '魏翔', '15684343655', '0', '1.60', '59.30');
INSERT INTO `userinformation` VALUES ('18', '艾伦', '18635445488', '0', '1.84', '78.60');
INSERT INTO `userinformation` VALUES ('19', '常远', '18885435488', '0', '1.79', '67.60');
INSERT INTO `userinformation` VALUES ('20', '冯巩', '15557417544', '0', '1.72', '58.30');

-- ----------------------------
-- Table structure for userlogin
-- ----------------------------
DROP TABLE IF EXISTS `userlogin`;
CREATE TABLE `userlogin` (
  `ulid` int(11) NOT NULL AUTO_INCREMENT,
  `ulphone` varchar(11) COLLATE utf8_bin NOT NULL,
  `userid` int(11) NOT NULL,
  `ulpassword` varchar(16) COLLATE utf8_bin NOT NULL,
  `ulstatus` int(11) NOT NULL,
  `ullosure` int(11) NOT NULL,
  `ulpowerid` int(11) NOT NULL,
  `ulbalance` float DEFAULT NULL,
  PRIMARY KEY (`ulid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of userlogin
-- ----------------------------
INSERT INTO `userlogin` VALUES ('1', '13388584463', '1', '394040414142', '0', '0', '1', '0');
INSERT INTO `userlogin` VALUES ('2', '15604381120', '2', '394040414142', '1', '0', '1', '0');
INSERT INTO `userlogin` VALUES ('3', '19965435541', '3', '394040414142', '0', '0', '2', '0');
INSERT INTO `userlogin` VALUES ('4', '15438525433', '4', '394040414142', '1', '0', '2', '0');
INSERT INTO `userlogin` VALUES ('5', '15543554125', '5', '394040414142', '1', '0', '3', '0');
INSERT INTO `userlogin` VALUES ('6', '17155476666', '6', '394040414142', '1', '0', '3', '0');
INSERT INTO `userlogin` VALUES ('7', '16845224355', '7', '394040414142', '0', '0', '3', '250');
INSERT INTO `userlogin` VALUES ('8', '15665258144', '8', '394040414142', '1', '0', '4', '150.97');
INSERT INTO `userlogin` VALUES ('9', '13055716875', '9', '394040414142', '1', '0', '4', '200.54');
INSERT INTO `userlogin` VALUES ('10', '15833543844', '10', '394040414142', '0', '1', '4', '300');
INSERT INTO `userlogin` VALUES ('11', '18888888888', '11', '394040414142', '0', '0', '4', '10000000');
INSERT INTO `userlogin` VALUES ('12', '16666666666', '12', '394040414142', '1', '0', '4', '50000000000');
INSERT INTO `userlogin` VALUES ('13', '15555555555', '13', '394040414142', '0', '0', '4', '20');
INSERT INTO `userlogin` VALUES ('14', '14444444444', '14', '394040414142', '0', '0', '4', '10');
INSERT INTO `userlogin` VALUES ('15', '15845245551', '15', '394040414142', '1', '0', '4', '58');
INSERT INTO `userlogin` VALUES ('16', '13371257854', '16', '394040414142', '0', '0', '4', '30');
INSERT INTO `userlogin` VALUES ('17', '15684343655', '17', '394040414142', '0', '0', '4', '40');
INSERT INTO `userlogin` VALUES ('18', '18635445488', '18', '394040414142', '0', '0', '4', '80000');
INSERT INTO `userlogin` VALUES ('19', '18885435488', '19', '394040414142', '0', '1', '4', '1000');
INSERT INTO `userlogin` VALUES ('20', '15557417544', '20', '394040414142', '0', '1', '4', '85.2');

-- ----------------------------
-- Function structure for f_codetoname
-- ----------------------------
DROP FUNCTION IF EXISTS `f_codetoname`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_codetoname`(`fid` int,`zid` int) RETURNS varchar(40) CHARSET utf8
BEGIN
	declare result varchar(40);
	SELECT sparname into result
	FROM subparameter
	WHERE parid = fid AND sparid = zid;
	RETURN result;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for f_uidtouname
-- ----------------------------
DROP FUNCTION IF EXISTS `f_uidtouname`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_uidtouname`(`uid` int) RETURNS varchar(40) CHARSET utf8
BEGIN
	declare result varchar(40);
	select 
		username into result
  FROM
    userinformation
  where 
     userid = uid;
	RETURN result;
END
;;
DELIMITER ;
