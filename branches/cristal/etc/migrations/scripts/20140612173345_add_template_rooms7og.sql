--// add_template_rooms7og
-- Migration SQL that makes the change goes here.

insert into template(id, editable, name, text, user_id) values(43,0,"Belegung 7 OG","<script type='text/javascript' src='scripts/rooms7og.js' ></script>\n", 1);
insert into screen values(75,"",0,43);
insert into course(id, courseMode, name) values(40,0,"Belegung 7 OG 24/7");
insert into course_screen values(40,75);

--//@UNDO
-- SQL to undo the change goes here.


