--// add__stubn_templates
-- Migration SQL that makes the change goes here.

insert into template(id, editable, name, text, user_id) values(63, 0,"Abfahrtszeiten MVG Stubn","<script type='text/javascript' src='scripts/traffic-mvg-stubn.js' ></script>\n", 1);
insert into template(id, editable, name, text, user_id) values(64, 0,"Abflugzeiten Stubn","<script type='text/javascript' src='scripts/traffic-air-stubn.js' ></script>\n", 1);
insert into template(id, editable, name, text, user_id) values(65, 0,"Wetter Stubn","<script type='text/javascript' src='scripts/openweather-vertikal-stubn.js' ></script>\n", 1);

insert into screen values(76,"",0,63);
insert into screen values(77,"",0,64);
insert into screen values(78,"",0,65);

insert into course(id, courseMode, name) values(41,1,"Stubn MVG/Airport/Wetter");
insert into course_screen values(41,76);
insert into course_screen values(41,77);
insert into course_screen values(41,78);
insert into monitor values(34,"Stubn Wetter/Traffic", "10.95.6.222", 41);

--//@UNDO
delete from course_screen where course_id=41;
delete from monitor where id=34;
delete from course where id=41;
delete from screen where id=76;
delete from screen where id=77;
delete from screen where id=78;
delete from template where id=63;
delete from template where id=64;
delete from template where id=65;




