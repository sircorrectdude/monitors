jQuery(document).ready(function () {
	
	    if($.oddeven==0){
	    	$.oddeven=1;
	    }else{
	    	$.oddeven=0;
	    }
	
		$.getJSON('/json/carpark.html',function(data){
			
			if(data.carparkCristal.placesLeft>0){
			
				if($.oddeven==0){
				
				$("body").css("background-image","url(images/templates/parkhaus/info_einfahrt_hdready.jpg)").css("background-repeat","no-repeat")
				$('body').empty().append(
						$('<span>').append(
								data.carparkCristal.placesLeft
						).css('text-align','center').css('width','600px').css('position','absolute').css('top','60px').css('left','633px').css('color','#00A752').css('font','bold 340px Helvetica, sans-serif')
					)
				}else{
					$("body").css("background-image","url(images/templates/parkhaus/info_einfahrt_hdready_flipped.jpg)").css("background-repeat","no-repeat")
					$('body').empty().append(
							$('<span>').append(
									data.carparkCristal.placesLeft
							).css('text-align','center').css('width','600px').css('position','absolute').css('top','60px').css('left','90px').css('color','#00A752').css('font','bold 340px Helvetica, sans-serif')
						)					
				}
			}
			
			else{
				$("body").css("background-image","url(images/templates/parkhaus/info_einfahrt_besetzt_hd_ready.jpg)").css("background-repeat","no-repeat")
			}
			
		});
});	