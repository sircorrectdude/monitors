--// welcome_slideshow_template
-- Migration SQL that makes the change goes here.
insert into template values(29,0,"Facebook Likescreen Clock","<html>\n
<head>\n
<title>CoolClock Demo</title>\n
		<script src='scripts/coolclock.js' type='text/javascript'></script>\n
		<script src='scripts/moreskins.js' type='text/javascript'></script>\n
		<script type='text/javascript' src='scripts/jquery.cycle.all.js'></script>\n
		<script type='text/javascript' src='scripts/welcome_slideshow.js'></script>\n
		<script src='scripts/jquery.easing.1.3.js' type='text/javascript'></script>\n
		<script src='scripts/jshashtable.js' type='text/javascript'></script>\n
		<script src='scripts/jquery.numberformatter-1.2.2.min.js' type='text/javascript'></script>\n
		<script type='text/javascript' src='scripts/jquery.flipCounter.1.2.pack.js'></script>\n
		<link rel='stylesheet' type='text/css' href='styles/welcome_slideshow.css' />
</head>\n
<body >\n
		<div id ='main'>\n
		    <div id='slideshow' class='pics'>\n
			<img src='images/templates/welcome_slideshow/slide5.png' width='1920' height='925' />\n
			<img src='images/templates/welcome_slideshow/slide1.png' width='1920' height='925' />\n
			<img src='images/templates/welcome_slideshow/slide2.png' width='1920' height='925' />\n
			<img src='images/templates/welcome_slideshow/slide3.png' width='1920' height='925' />\n
			<img src='images/templates/welcome_slideshow/slide4.png' width='1920' height='925' />\n
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
insert into screen values(65,"",600,29);
insert into course values(29,0,"Welcome Cristal Slideshow");
insert into course_screen values(29,65);
--insert into monitor values(1,"localhost", "192.168.1.13", 29);
--//@UNDO
-- SQL to undo the change goes here.
delete from course_screen where screen_id=65;
--delete from monitor where id=1;
delete from course where id=29;
delete from screen where id=65;
delete from template where id=29;

