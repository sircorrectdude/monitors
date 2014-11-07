$(document).ready(function () {
	$.getScript( "scripts/jquery.cycle.all.js", function( data, textStatus, jqxhr ) {
		$("body").append($( "<div/>" ).attr('id','slideshow'));	
		
		$.getJSON('json/slideshow.html?templateId='+$('#templateId').text(), function(data) {
			$('#slideshow').empty();
			  $.each(data.slideshow.slideshowImages, function(i, slideshowImage){
				  $('#slideshow').append($("<img />",  {"src": "images/"+slideshowImage.name, "width":slideshow.width, "height":slideshow.height})	)
			  });
			  $('#slideshow').cycle({
				  fx:     'turnDown, fade, growX, growY, turnUp, turnDown, turnLeft, turnRight ',
				  timeout: 10000,
				  speed:   2000
			  });
		});
	});
});	
