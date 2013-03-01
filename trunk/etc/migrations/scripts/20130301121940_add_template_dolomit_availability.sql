--// welcome_slideshow_template
-- Migration SQL that makes the change goes here.
insert into template values(30,0,"Availability Dolomit","<html>\n
<head>\n
<title>Availability Dolomit</title>\n
		<script src='scripts/coolclock.js' type='text/javascript'></script>\n
		<script src='scripts/moreskins.js' type='text/javascript'></script>\n
		<script type='text/javascript' src='scripts/jquery.cycle.all.js'></script>\n
		<script type='text/javascript' src='scripts/availability_dolomit.js'></script>\n
		<script src='scripts/jquery.easing.1.3.js' type='text/javascript'></script>\n
		<script src='scripts/jshashtable.js' type='text/javascript'></script>\n
		<script src='scripts/jquery.numberformatter-1.2.2.min.js' type='text/javascript'></script>\n
		<script type='text/javascript' src='scripts/jquery.flipCounter.1.2.pack.js'></script>\n
		<link rel='stylesheet' type='text/css' href='styles/availability_dolomit.css' />
</head>\n
<body >\n
		<div id ='main'>\n
		    <div id='slideshow' class='pics'>\n
		    </div>\n	
		</div>\n
		<div id ='footer'>\n
			<div class='we'></div>\n
			<div class='weather_today'></div>\n
			<div class='clock'><canvas class='CoolClock:Tes2:45'></canvas></div>\n
			<div class='weather_tomorrow'></div>\n
			<div class='jahre_100'></div>\n
		</div> 
</body >\n
</html>");
insert into screen values(66,"",600,30);
insert into course values(30,0,"Availability Dolomit");
insert into course_screen values(30,66);
insert into monitor values(1,"localhost", "192.168.1.13", 30);
--//@UNDO
-- SQL to undo the change goes here.
delete from course_screen where screen_id=66;
delete from monitor where id=1;
delete from course where id=30;
delete from screen where id=66;
delete from template where id=30;

