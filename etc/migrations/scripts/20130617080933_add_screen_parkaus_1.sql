--// add_screen_parkaus_1
-- Migration SQL that makes the change goes here.
insert into template values(32,0,"Parkhaus Info","<script type='text/javascript' src='scripts/parkhaus_info.js' ></script>\n");
insert into screen values(68,"",0,32);
insert into course values(31,0,"Parkhaus Info 24/7");
insert into course_screen values(31,68);
insert into monitor values(19,"Parkhaus Info Pc", "10.95.6.205", 31);


--//@UNDO
-- SQL to undo the change goes here.

delete from monitor where id=19;
delete from course_screen where screen_id=68;
delete from course where id=31;
delete from screen where id=68;
delete from template where id=32;
