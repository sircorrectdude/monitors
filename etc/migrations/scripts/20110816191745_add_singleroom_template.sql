--// add_singleroom_template
-- Migration SQL that makes the change goes here.

insert into template () values(14,1,"Zimmer Belegung","<script type=\'text/javascript\' src=\'scripts/room.js\'><script type=""text/javascript"">\njQuery(document).ready(function () { });\n</script>");
insert into screen values(37,"",0,14);
insert into course values(15,0,"24/7 - Zimmer Belegung");
insert into course_screen values(15,37);

update template set text="<script type=\'text/javascript\' src=\'scripts/rooms.js\'></script>", editable=0 where id=2;

--//@UNDO
-- SQL to undo the change goes here.

delete from course_screen where screen_id=37;
delete from course where id=15;
delete from screen where id=37;
delete from template where id=14;
