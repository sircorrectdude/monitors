--// add_carpark
-- Migration SQL that makes the change goes here.
insert into app_user (id, email, username, password, version, account_expired, account_locked, credentials_expired, first_name, last_name, account_enabled) values(1, "ae@cristal-hotel.de", "cristal", "d033e22ae348aeb5660fc2140aec35850c4da997", "1", 0, 0, 0, "A.", "Egger", 1);
insert into user_role (user_id, role_id) values (1,-2);

--insert into template values(35,0,"Carpark Floor","<script type='text/javascript' src='scripts/carpark/floor.js' ></script>\n", 1);
--insert into screen values(71,"",0,35);
--insert into course values(34,0,"Carpark Floor 24/7");
--insert into course_screen values(34,71);
--insert into monitor values(22,"PH UG", "10.95.6.243", 26);

--//@UNDO
-- SQL to undo the change goes here.


--delete from course_screen where screen_id=71;
--delete from course where id=34;
--delete from screen where id=71;
--delete from template where id=35;

delete from user_role where user_id=1;
delete from app_user where id=1;
