--// add_clock_change
-- Migration SQL that makes the change goes here.

update template set text ="
		<script src='scripts/date/date-de-DE.js' type='text/javascript'></script>\n
		<script src='scripts/coolclock.js' type='text/javascript'></script>\n
		<script src='scripts/moreskins.js' type='text/javascript'></script>\n
		<script type='text/javascript' src='scripts/jquery.cycle.all.js'></script>\n
		<script type='text/javascript' src='scripts/welcome_slideshow.js'></script>\n
		<script src='scripts/jquery.easing.1.3.js' type='text/javascript'></script>\n
		<script src='scripts/jshashtable.js' type='text/javascript'></script>\n
		<script src='scripts/jquery.numberformatter-1.2.2.min.js' type='text/javascript'></script>\n
		<script type='text/javascript' src='scripts/jquery.flipCounter.1.2.pack.js'></script>\n
		<script src='scripts/digiclock/digiclock.js'></script>

		<div id ='main'>\n
		    <div id='slideshow' class='pics'>\n
			<img src='images/templates/welcome_slideshow/slide8.png' width='1920' height='925' id='clockchange'/>\n
			<img src='images/templates/welcome_slideshow/slide7.png' width='1920' height='925' id='easterAd'/>\n
			<img src='images/templates/welcome_slideshow/slide6.png' width='1920' height='925' />\n
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
			<div id='digiclock'></div>\n
			<div class='weather_tomorrow'></div>\n
			<div class='jahre_100'></div>\n
		</div>" where id= 29;
update template set text="
		<script src='scripts/date/date-de-DE.js' type='text/javascript'></script>\n
		<script src='scripts/coolclock.js' type='text/javascript'></script>\n
		<script src='scripts/moreskins.js' type='text/javascript'></script>\n
		<script type='text/javascript' src='scripts/jquery.cycle.all.js'></script>\n
		<script type='text/javascript' src='scripts/availability_dolomit.js'></script>\n
		<script src='scripts/jquery.easing.1.3.js' type='text/javascript'></script>\n
		<script src='scripts/jshashtable.js' type='text/javascript'></script>\n
		<script src='scripts/jquery.numberformatter-1.2.2.min.js' type='text/javascript'></script>\n
		<script type='text/javascript' src='scripts/jquery.flipCounter.1.2.pack.js'></script>\n
		<script src='scripts/digiclock/digiclock.js'></script>
		<div id ='main'>\n
		    <div id='slideshow' class='pics'>\n
		    </div>\n	
		</div>\n
		<div id ='footer'>\n
			<div class='we'></div>\n
			<div class='weather_today'></div>\n
			<div class='clock'><canvas class='CoolClock:Tes2:45'></canvas></div>\n
			<div id='digiclock'></div>\n
			<div class='weather_tomorrow'></div>\n
			<div class='jahre_100'></div>\n
		</div>" where id=30;
--//@UNDO
-- SQL to undo the change goes here.

update template set text ="
		<script src='scripts/coolclock.js' type='text/javascript'></script>\n
		<script src='scripts/moreskins.js' type='text/javascript'></script>\n
		<script type='text/javascript' src='scripts/jquery.cycle.all.js'></script>\n
		<script type='text/javascript' src='scripts/welcome_slideshow.js'></script>\n
		<script src='scripts/jquery.easing.1.3.js' type='text/javascript'></script>\n
		<script src='scripts/jshashtable.js' type='text/javascript'></script>\n
		<script src='scripts/jquery.numberformatter-1.2.2.min.js' type='text/javascript'></script>\n
		<script type='text/javascript' src='scripts/jquery.flipCounter.1.2.pack.js'></script>\n
		<script src='scripts/digiclock/digiclock.js'></script>

		<div id ='main'>\n
		    <div id='slideshow' class='pics'>\n
			<img src='images/templates/welcome_slideshow/slide7.png' width='1920' height='925' />\n
			<img src='images/templates/welcome_slideshow/slide6.png' width='1920' height='925' />\n
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
			<div id='digiclock'></div>\n
			<div class='weather_tomorrow'></div>\n
			<div class='jahre_100'></div>\n
		</div>" where id= 29;
update template set text="
		<script src='scripts/coolclock.js' type='text/javascript'></script>\n
		<script src='scripts/moreskins.js' type='text/javascript'></script>\n
		<script type='text/javascript' src='scripts/jquery.cycle.all.js'></script>\n
		<script type='text/javascript' src='scripts/availability_dolomit.js'></script>\n
		<script src='scripts/jquery.easing.1.3.js' type='text/javascript'></script>\n
		<script src='scripts/jshashtable.js' type='text/javascript'></script>\n
		<script src='scripts/jquery.numberformatter-1.2.2.min.js' type='text/javascript'></script>\n
		<script type='text/javascript' src='scripts/jquery.flipCounter.1.2.pack.js'></script>\n
		<script src='scripts/digiclock/digiclock.js'></script>
		<div id ='main'>\n
		    <div id='slideshow' class='pics'>\n
		    </div>\n	
		</div>\n
		<div id ='footer'>\n
			<div class='we'></div>\n
			<div class='weather_today'></div>\n
			<div class='clock'><canvas class='CoolClock:Tes2:45'></canvas></div>\n
			<div id='digiclock'></div>\n
			<div class='weather_tomorrow'></div>\n
			<div class='jahre_100'></div>\n
		</div>" where id=30;