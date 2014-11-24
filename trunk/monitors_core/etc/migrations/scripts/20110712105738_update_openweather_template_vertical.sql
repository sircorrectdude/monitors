--// update_openweather_template_vertical
-- Migration SQL that makes the change goes here.

insert into template values(11,0,"Wettervorhersage Vertikal","<script type=\"text/javascript\" src=\"scripts/openweather.js\"></script>");
insert into screen values(17,"",0,11);
insert into course values(9,0,"24/7 - Wettervorhersage Vertikal");
insert into course_screen values(9,17);

--//@UNDO
-- SQL to undo the change goes here.

delete from course_screen where screen_id=17;
delete from course where id=9;
delete from screen where id=17;
delete from template where id=11;
