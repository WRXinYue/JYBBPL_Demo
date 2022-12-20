DROP TABLE
IF EXISTS purview;
/*==============================================================*/
/* Table: purview  权限表                                       */
/*==============================================================*/
CREATE TABLE purview (
	purid INT NOT NULL AUTO_INCREMENT,
	purname VARCHAR ( 20 ) NOT NULL,
	CONSTRAINT PK_PURVIEW PRIMARY KEY  clustered ( purid )
);
DROP TABLE
IF EXISTS parameter;
/*==============================================================*/
/* Table: parameter  参数类                                     */
/*==============================================================*/
CREATE TABLE parameter (
	parid INT NOT NULL AUTO_INCREMENT,
	parname VARCHAR ( 40 ) NOT NULL,
	CONSTRAINT PK_PARAMETER PRIMARY KEY clustered ( parid )
);
DROP TABLE
IF EXISTS subparameter;
/*==============================================================*/
/* Table: subparameter  子参表                                  */
/*==============================================================*/
CREATE TABLE subparameter (
	parid INT NOT NULL AUTO_INCREMENT,
	sparid INT NOT NULL,
	sparname VARCHAR ( 40 ) NULL,
	CONSTRAINT PK_SUBPARAMETER PRIMARY KEY clustered ( parid, sparid ) 
);
DROP TABLE
IF EXISTS userinformation;
/*==============================================================*/
/* Table: userinformation   用户基本信息表                      */
/*==============================================================*/
CREATE TABLE userinformation (
	userid INT NOT NULL AUTO_INCREMENT,
	username VARCHAR ( 40 ) NOT NULL,
	userphone VARCHAR ( 11 ) NOT NULL,
	usersex INT NOT NULL,
	userheight FLOAT ( 3, 2 ) NULL,
	userweight FLOAT ( 5, 2 ) NULL,
	CONSTRAINT PK_USERINFORMATION PRIMARY KEY clustered ( userid ) 
);
DROP TABLE
IF EXISTS userlogin;
/*==============================================================*/
/* Table: userlogin  用户登录表                                 */
/*==============================================================*/
CREATE TABLE userlogin (
	ulid INT NOT NULL AUTO_INCREMENT,
	ulphone VARCHAR ( 11 ) NOT NULL,
	userid INT NOT NULL,
	ulpassword VARCHAR ( 16 ) NOT NULL,
	ulstatus INT NOT NULL,
	ullosure INT NOT NULL,
	ulpowerid INT NOT NULL,
	ulbalance FLOAT NULL,
	CONSTRAINT PK_USERLOGIN PRIMARY KEY clustered ( ulid ) 
);
DROP TABLE
IF EXISTS project;
/*==============================================================*/
/* Table: project   项目表                                      */
/*==============================================================*/
CREATE TABLE project (
	pid INT NOT NULL AUTO_INCREMENT,
	pname VARCHAR ( 40 ) NOT NULL,
	CONSTRAINT PK_PROJECT PRIMARY KEY clustered ( pid )
);
DROP TABLE
IF EXISTS course;
/*==============================================================*/
/* Table: course   课程表                                       */
/*==============================================================*/
CREATE TABLE course (
	cid INT NOT NULL AUTO_INCREMENT,
	cname VARCHAR ( 40 ) NOT NULL,
	pid INT NULL,
	useridt INT NOT NULL,
	cstarttime date NOT NULL,
	cattendtime time NOT NULL,
	cendtime time NOT NULL,
	clesson INT ( 2 ) NOT NULL,
	cdescribe VARCHAR ( 255 ) NOT NULL,
	cpeonum INT ( 3 ) NOT NULL,
	cactpeonum INT NOT NULL,
	cstartstatus INT NOT NULL,
	creservetime datetime NOT NULL,
	ccreateid INT NOT NULL,
	ccreatetime datetime NOT NULL,
	CONSTRAINT PK_COURSE PRIMARY KEY clustered ( cid ) 
);
DROP TABLE
IF EXISTS coursereserve;
/*==============================================================*/
/* Table: coursereserve  课程预约表                             */
/*==============================================================*/
CREATE TABLE coursereserve (
	csid INT NOT NULL AUTO_INCREMENT,
	cid INT NOT NULL,
	ulid INT NOT NULL,
	cappointment datetime NOT NULL,
	cappointmentstatus INT NOT NULL,
	ulida INT NOT NULL,
	cprocessingtime datetime NOT NULL,
	cveto VARCHAR ( 255 ) NULL,
	CONSTRAINT PK_COURSERESERVE PRIMARY KEY clustered ( csid ) 
);
DROP TABLE
IF
	EXISTS ucouse;
/*==============================================================*/
/* Table: ucouse  课程表                                        */
/*==============================================================*/
CREATE TABLE ucouse (
	ucid INT NOT NULL AUTO_INCREMENT,
	ucuid INT NOT NULL,
	uccouid INT NOT NULL,
	CONSTRAINT PK_UCOUSE PRIMARY KEY clustered ( ucid )
);
DROP TABLE
IF EXISTS coachsign;
/*==============================================================*/
/* Table: coachsign   教练签到表                             */
/*==============================================================*/
CREATE TABLE coachsign (
	sid INT NOT NULL AUTO_INCREMENT,
	scouid INT NOT NULL,
	srecid INT NOT NULL,
	srstats INT NOT NULL,
	srtime datetime NOT NULL,
	scoaid INT NOT NULL,
	scoastats INT NOT NULL,
	scoatime datetime NULL,
	CONSTRAINT PK_COACHSIGN PRIMARY KEY clustered ( sid ) 
);
DROP TABLE
IF EXISTS coachcourse;
/*==============================================================*/
/* Table: coachcourse   授课表                                   */
/*==============================================================*/
CREATE TABLE coachcourse (
	ccid INT NOT NULL AUTO_INCREMENT,
	ucid INT NOT NULL,
	ccattendtime datetime NOT NULL,
	ccendtime datetime NOT NULL,
	ccreateid INT NOT NULL,
	useridt INT NOT NULL,
	ccheckstart INT NULL,
	CONSTRAINT PK_COACHCOURSE PRIMARY KEY clustered ( ccid ) 
);
DROP TABLE
IF EXISTS studentac;
/*==============================================================*/
/* Table: studentac  学员上课表                                 */
/*==============================================================*/
CREATE TABLE studentac (
	said INT NOT NULL,
	ccid INT NOT NULL,
	useridf INT NOT NULL,
	sastate INT NOT NULL,
	satime datetime NOT NULL,
	userid INT NOT NULL,
	saclassstatus INT NOT NULL,
	saattendtime datetime NULL,
	CONSTRAINT PK_STUDENTAC PRIMARY KEY clustered ( said ) 
);
DROP TABLE
IF EXISTS consumptionrecords;
/*==============================================================*/
/* Table: consumptionrecords   消费记录表                        */
/*==============================================================*/
CREATE TABLE consumptionrecords (
	crid INT NOT NULL,
	userid INT NOT NULL,
	said INT NOT NULL,
	crtime datetime NOT NULL,
	cramount FLOAT (8,2) NOT NULL,
	CONSTRAINT PK_CONSUMPTIONRECORDS PRIMARY KEY clustered ( crid ) 
);

DROP TABLE
IF
	EXISTS rate;
/*==============================================================*/
/* Table: rate  评价表                                          */
/*==============================================================*/
CREATE TABLE rate (
	rateid INT NOT NULL AUTO_INCREMENT,
	ccid INT NOT NULL,
	userid INT NOT NULL,
	useridt INT NOT NULL,
	ratelevel INT NULL,
	ratetime datetime NULL,
	CONSTRAINT PK_RATE PRIMARY KEY clustered ( rateid ) 
);
DROP TABLE
IF EXISTS guidance;
/*==============================================================*/
/* Table: guidance   技术指导表                                */
/*==============================================================*/
CREATE TABLE guidance (
	gid INT NOT NULL AUTO_INCREMENT,
	ccid INT NOT NULL,
	userid INT NOT NULL,
	useridt INT NOT NULL,
	gquestion VARCHAR ( 255 ) NOT NULL,
	gquetime datetime NOT NULL,
	greply VARCHAR ( 255 ) NULL,
	grepsta INT NOT NULL,
	greptime datetime NULL,
	CONSTRAINT PK_GUIDANCE PRIMARY KEY clustered ( gid ) 
);
DROP TABLE
IF EXISTS recharge;
/*==============================================================*/
/* Table: recharge    充值表                                */
/*==============================================================*/
CREATE TABLE recharge (
	reid INT NOT NULL AUTO_INCREMENT,
	userid INT NOT NULL,
	userida INT NOT NULL,
	retime datetime NOT NULL,
	reamo FLOAT(8,2) NOT NULL,
CONSTRAINT PK_RECHARGE PRIMARY KEY clustered ( reid ) 
);

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
