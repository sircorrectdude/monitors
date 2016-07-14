--// add_signal_template
-- Migration SQL that makes the change goes here.

insert into template(id, editable, name, text, user_id) values(69,0,"Signal Light","<script type='text/javascript' src='scripts/signal.js' ></script>\n", 1);
insert into screen values(79,"",0,69);
insert into course(id, courseMode, name) values(42,0,"Signal Light 24/7");
insert into course_screen values(42,79);

--//@UNDO
-- SQL to undo the change goes here.


