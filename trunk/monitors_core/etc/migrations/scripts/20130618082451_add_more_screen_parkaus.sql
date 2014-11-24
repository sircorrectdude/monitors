--// add_more_screen_parkaus
-- Migration SQL that makes the change goes here.
insert into template values(34,0,"Parkhaus Info Einfahrt EG","<script type='text/javascript' src='scripts/parkhaus_info_einfahrt.js' ></script>\n");
insert into screen values(70,"",0,34);
insert into course values(33,0,"Parkhaus Info Einfahrt EG 24/7");
insert into course_screen values(33,70);
update monitor set course_id = 33 where id=19;

insert into template values(33,0,"Parkhaus Info 1 OG","<script type='text/javascript' src='scripts/parkhaus_info_1og.js' ></script>\n");
insert into screen values(69,"",0,33);
insert into course values(32,0,"Parkhaus Info 1 OG 24/7");
insert into course_screen values(32,69);
update monitor set course_id = 32 where id=21;


--//@UNDO
-- SQL to undo the change goes here.


update monitor set course_id = 29 where id=21;
delete from course_screen where screen_id=69;
delete from course where id=32;
delete from screen where id=69;
delete from template where id=33;

update monitor set course_id = 29 where id=19;
delete from course_screen where screen_id=70;
delete from course where id=33;
delete from screen where id=70;
delete from template where id=34;
