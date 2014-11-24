--// alter_template_welcome_dolomit_add_digiclock
-- Migration SQL that makes the change goes here.

update template set text="<html>\n
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
		<script src='scripts/digiclock/digiclock.js'></script>
		<link rel='stylesheet' type='text/css' href='scripts/digiclock/digiclock.css' />
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
			<div id='digiclock' /></div>\n
			<div class='weather_tomorrow'></div>\n
			<div class='jahre_100'></div>\n
		</div> 
</body >\n
</html>" where id=30;

--//@UNDO
-- SQL to undo the change goes here.

update template set text="<html>\n
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
</html>" where id=30;
