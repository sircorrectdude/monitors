jQuery(document).ready(function () {
	
		$.getJSON('/json/carpark.html',function(data){
			
			if(data.carparkCristal.placesLeft>0){
			
				$("body").css("background-image","url(images/templates/parkhaus/info_einfahrt_hd_ready.jpg)").css("background-repeat","no-repeat")
				$('body').empty().append(
						$('<span>').append(
								data.carparkCristal.placesLeft
						).css('text-align','center').css('width','600px').css('position','absolute').css('top','130px').css('left','633px').css('color','#00A752').css('font','bold 240px arial, sans-serif')
					)
			}
			
			else{
				$("body").css("background-image","url(images/templates/parkhaus/info_einfahrt_besetzt_hd_ready.jpg)").css("background-repeat","no-repeat")
			}
			
		});
});	