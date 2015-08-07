$(document).ready(function () {
	$.getScript( "/scripts/jquery.cycle2.min.js", function( data, textStatus, jqxhr ) {
		$("body").append($( "<div/>" ).attr('id','slideshow')
				.attr('class','cycle-slideshow')
				.attr('data-cycle-auto-height','calc')
				.attr('data-cycle-fx','scrollHorz')
			);	
		
		$.getJSON('/json/slideshow?templateId='+$('#templateId').text(), function(data) {
			$('#slideshow').empty();
			  $.each(data.slideshow.slideshowImages, function(i, slideshowImage){
				  //alert(data.slideshow.height+"px");
				  $('#slideshow').append($("<img />",  {"src": "/images/"+slideshowImage.name,
					  "width":	data.slideshow.width == 0 ? "" : data.slideshow.width+"px",
					  "height": data.slideshow.height == 0 ? "" : data.slideshow.height+"px"}))
			  });
			 $('#slideshow').cycle();
			  
		});
	});
});	
