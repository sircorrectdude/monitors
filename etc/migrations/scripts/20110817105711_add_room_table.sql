--// add_room_table
-- Migration SQL that makes the change goes here.

CREATE TABLE `room` (`id` varchar(255) NOT NULL, `name` varchar(255) DEFAULT NULL,  `location` varchar(255) DEFAULT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
insert into room values('-1', '', '');
insert into room values('0', 'TOPAZ', 'OG');
insert into room values('1', 'SMARAGD', 'OG');
insert into room values('2', 'BRILLIANT', 'OG');
insert into room values('3', 'BERNSTEIN', 'OG');
insert into room values('4', 'RUBIN I + II', 'OG');
insert into room values('5', 'RUBIN I', 'OG');
insert into room values('6', 'RUBIN II', 'OG');
insert into room values('7', 'CARAT + JUWEL', 'OG');
insert into room values('8', 'JUWEL', 'OG');
insert into room values('9', 'CARAT', 'OG');
insert into room values('10', 'DIAMANT I + II', 'UG');
insert into room values('11', 'DIAMANT I', 'UG');
insert into room values('12', 'DIAMANT II', 'UG');

--//@UNDO
-- SQL to undo the change goes here.

drop table `room`;
