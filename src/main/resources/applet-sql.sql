drop database if exists applet;
create database applet;

use applet;

-- ---------
-- 用户表
-- ---------
drop table if exists user;
create table user(
    user_id bigint unsigned not null auto_increment comment '用户id',
    union_id varchar(50) not null comment 'wx union_id',
    wx_name varchar(30) default '' comment '微信昵称',
    real_name varchar(30) default '' comment '真实姓名',
    address varchar(255) default '' comment '住址',
    phone varchar(11) default '' comment '手机号',
    age int default 0 comment '年龄',
    gender int default 0 comment '性别',
    primary key(user_id) using btree
)ENGINE=InnoDB character set = utf8mb4;

-- ------------
-- 生活物资申请表
-- ------------
drop table if exists material_application;
create table material_application(
    application_id bigint unsigned not null auto_increment comment '表单id',
    applicant_id bigint unsigned not null comment '申请人id',
    applicant_name varchar(50) not null comment '申请人姓名',
    applicant_reason varchar(255) not null comment '申请原因',
    material_name varchar(50) not null comment '申请物资',
    material_num int not null comment '物资数量',
    is_urgency tinyint default 0 comment '是否紧急，0:不紧急，1:紧急',
    location varchar(255) not null comment '送到哪里',
    create_time datetime default current_timestamp comment '申请时间',
    approver_id bigint unsigned not null comment '审批人id',
    result int default 0 comment '申请结果，-1申请不通过 0待审批 1审批通过',
    approval_time datetime comment '处理表单时间',
    refuse_reason varchar(255) comment '未通过原因',
    primary key(application_id) using btree
)ENGINE=InnoDB character set = utf8mb4;

-- ------------
-- 物资发放统计表
-- ------------
drop table if exists material_statistics;
create table material_statistics (
    material_id bigint unsigned not null auto_increment comment '物资id',
    material_name varchar(50) not null comment '物资名称',
    material_num int not null comment '申请数量',
    receive_id bigint unsigned not null comment '接收者id',
    from_id bigint unsigned not null comment '发送者id，一般是管理员',
    create_time datetime default current_timestamp comment '接收时间',
    money float not null comment '共多少money',
    primary key(material_id) using btree
)ENGINE=InnoDB character set = utf8mb4;

-- ------------
-- 人员健康信息填报表
-- ------------
drop table if exists info;
create table info(
    info_id bigint unsigned not null auto_increment comment '表单id',
    person_id bigint unsigned not null comment '用户id',
    real_name varchar(50) not null comment '真实姓名',
    address varchar(50) not null comment '住址',
    temperature float not null comment '温度',
    symptom int not null default 0 comment '疑似症状, 0无,1发烧，2头痛，3腹泻',
    location varchar(50) not null comment '当前地理位置',
    last_time datetime not null comment '最后一次核酸时间',
    create_time datetime not null default current_timestamp comment '表单提交时间',
    primary key(info_id)
)ENGINE=InnoDB character set = utf8mb4;

-- ------------
-- 小区外来人员报备表
-- ------------
drop table if exists report;
create table report(
    report_id bigint unsigned not null auto_increment comment '报备表单id',
    name varchar(10) not null comment '外来人员姓名',
    id_num int not null comment '身份证号',
    phone int not null comment '手机号',
    location varchar(255) not null comment '家庭住址，来前住址',
    community_id bigint unsigned not null comment '小区id',
    address varchar(255) not null comment '来后住址',
    way int not null comment '来往方式',
    create_time datetime default current_timestamp comment '报备时间',
    approver_id bigint unsigned not null comment '监管人id',
    primary key(report_id) using btree
)ENGINE=InnoDB character set = utf8mb4;

-- ------------
-- 出小区申请表
-- ------------
drop table if exists application;
create table application(
    application_id bigint unsigned not null auto_increment comment '申请单id',
    community_id bigint unsigned not null comment '小区id',
    applicant_id bigint unsigned not null comment '申请人id',
    applicant_name varchar(50) not null comment '申请人真实姓名',
    address varchar(50) not null comment '申请人住址',
    leave_time datetime not null comment '离开小区时间',
    back_time datetime not null comment '回小区时间',
    way int not null comment '外出方式，0自驾，1火车，2高铁，3动车，4飞机',
    destination varchar(50) not null comment '外出地点', 
    reason varchar(255) not null comment '外出原因',
    create_time datetime not null default current_timestamp comment '申请提交时间',
    approver_id bigint unsigned not null comment '审批人id',
    result int default 0 comment '申请结果，-1申请不通过 0待审批 1审批通过',
    approval_time datetime comment '待审批该字段为-1, 否则为处理表单时间',
    primary key(application_id) using btree
)ENGINE=InnoDB character set = utf8mb4;

-- ------------
-- 小区统计表
-- ------------
drop table if exists community;
create table community(
    community_id bigint unsigned not null auto_increment comment '小区id',
    community_name varchar(255) not null comment '小区名称',
    address varchar(255) not null comment '小区地址',
    primary key(community_id) using btree
)ENGINE=InnoDB character set = utf8mb4;

-- ------------
-- 通知表
-- ------------
drop table if exists notice;
create table notice(
    notice_id bigint unsigned not null auto_increment comment '通知自增id',
    sponsor_id bigint unsigned not null comment '通知发起者id',
    create_time datetime not null default current_timestamp comment '通知发送时间',
    notice_title varchar(255) not null comment '标题',
    notice_content longtext comment '内容',
    primary key(notice_id) using btree
)ENGINE=InnoDB character set = utf8mb4;