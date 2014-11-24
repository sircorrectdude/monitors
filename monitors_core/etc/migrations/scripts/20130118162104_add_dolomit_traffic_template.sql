--// add_likescreen
-- Migration SQL that makes the change goes here.

insert into template values(25,0,"Verkehrsinformation DB Dolomit HD","<script type='text/javascript' src='scripts/traffic-db-dolomit.js'></script>");
insert into template values(26,0,"Verkehrsinformation MVG Dolomit HD","<script type='text/javascript' src='scripts/traffic-mvg-dolomit.js'></script>");
insert into template values(27,0,"Verkehrsinformation Airport Dolomit HD","<script type='text/javascript' src='scripts/traffic-air-dolomit.js'></script>");
insert into screen values(61,"",30,25);
insert into screen values(62,"",30,26);
insert into screen values(63,"",30,27);
insert into course values(27,1,"Traffic DB-MVG-Airport Dolomit HD");
insert into course_screen values(27,61);
insert into course_screen values(27,62);
insert into course_screen values(27,63);
update monitor set course_id=27 where id=17;


--//@UNDO
-- SQL to undo the change goes here.

update monitor set course_id=5 where id=17;
delete from course_screen where screen_id=61;
delete from course_screen where screen_id=62;
delete from course_screen where screen_id=63;
delete from course where id=27;
delete from screen where id=61;
delete from screen where id=62;
delete from screen where id=63;
delete from template where id=25;
delete from template where id=26;
delete from template where id=27;