jQuery(document).ready(function () {
	
	$.getScript("scripts/jquery.cycle.all.js", function(data, textStatus, jqxhr) {
		$('body').append(
				$('<div>').attr("id", "slideshow")
				
		);
		$('#slideshow').append($("<img />",  {"src": "images/templates/parkhaus/2OG-01.jpg"})	)
		$('#slideshow').append($("<img />",  {"src": "images/templates/parkhaus/2OG-02.jpg"}))
				$('#slideshow').cycle({
				    fx:     'turnDown, fade, growX, growY, turnUp, turnDown,turnLeft,turnRight ',
				    timeout: 5000,
				    speed:   1000
				});
	});
});
