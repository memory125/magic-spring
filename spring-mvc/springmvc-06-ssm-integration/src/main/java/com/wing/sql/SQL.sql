drop database if exists ssm;
create database if not exists ssm;

use ssm;
drop table if exists books;

create table books (
                         `bookID` int(10) not null auto_increment comment '书id',
                         `bookName` varchar(100) not null comment '书名',
                         `bookCounts` INT(11) not null comment '数量',
                         `detail` varchar(200) not null comment '描述',
                         key `bookID` (`bookID`)
) engine =INNODB default charset =utf8;

insert into books(`bookID`,`bookName`,`bookCounts`,`detail`) values
(1,'Java',1,'从入门到放弃'),
(2,'MySQL',10,'从删库到跑路'),
(3,'Linux',5,'从进门到进牢');