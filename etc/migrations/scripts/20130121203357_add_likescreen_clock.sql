--// add_likescreen
-- Migration SQL that makes the change goes here.

insert into template values(28,0,"Facebook Likescreen Clock","<html>\n
<head>\n
<script src='scripts/jquery.easing.1.3.js' type='text/javascript'></script>\n
<script src='scripts/jshashtable.js' type='text/javascript'></script>\n
<script src='scripts/jquery.numberformatter-1.2.2.min.js' type='text/javascript'></script>\n
<script type='text/javascript' src='scripts/jquery.flipCounter.1.2.pack.js'></script>\n
<script type='text/javascript' src='scripts/likescreen-clock.js' ></script>\n
<link rel='stylesheet' type='text/css' href='styles/jquery.jdigiclock.css' />
<script type='text/javascript' src='scripts/jquery.jdigiclock.js'></script>
<title>Cristal Likescreen</title>\n
</head>\n
<body />\n
</html>");
insert into screen values(64,"",0,28);
insert into course values(28,0,"Facebook Likescreen Clock 24/7");
insert into course_screen values(28,64);
--insert into monitor values(16,"Facebook Likescreen Mini Pc", "10.95.6.243", 26);
--insert into monitor values(16,"Facebook Likescreen Mini Pc", "92.229.240.179", 26);


--//@UNDO
-- SQL to undo the change goes here.


delete from course_screen where screen_id=64;
delete from course where id=28;
delete from screen where id=64;
delete from template where id=28;