$(document).ready(function () {
	$.getScript( "/scripts/jquery.cycle2.min.js", function( data, textStatus, jqxhr ) {
		$("body").append($( "<div/>" ).attr('id','slideshow')
				.attr('class','cycle-slideshow')
				.attr('data-cycle-auto-height','3:1')
				.attr('data-cycle-fx','scrollHorz')
			);	
		
		$.getJSON('/json/slideshow?templateId='+$('#templateId').text(), function(data) {
			$('#slideshow').empty();
			  $.each(data.slideshow.slideshowImages, function(i, slideshowImage){
				  $('#slideshow').append($("<img />",  {"src": "/images/"+slideshowImage.name})	)
			  });
			 $('#slideshow').cycle();
			  
		});
	});
});	
