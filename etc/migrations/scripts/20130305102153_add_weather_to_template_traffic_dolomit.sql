--// add_weather_to_template_traffic_dolomit
-- Migration SQL that makes the change goes here.

insert into template values(31,0,"Wettervorhersage Vertikal Dolomit","<script type=\"text/javascript\" src=\"scripts/openweather-vertikal-dolomit.js\"></script>");
insert into screen values(67,"",0,31);
insert into course_screen values(27,67);

--//@UNDO
-- SQL to undo the change goes here.

delete from course_screen where course_id=27 and screen_id=67;
delete from screen where id=67;
delete from template where id=31;
