/*

jQuery(document).ready(function () {
	
	$("body").css("background-image","url(images/templates/parkhaus/Monitor-carpark-1_OG.jpg)")
	

});

	*/


jQuery(document).ready(function () {
	
	$.getJSON('/json/carpark.html',function(data){
		
		$.each(data.carparkCristal.floors, function(i, floor){
			if(floor.name.toUpperCase() === data.floorName.toUpperCase()){
				if(floor.placesLeft<=0){
					$('body').empty().append(
							$('<span>').append(
								//data.carparkCristal.placesLeft
									floor.placesLeftUpper
							).css('text-align','center').css('width','400px').css('position','absolute').css('top','390px').css('left','1350px').css('color','#00A752').css('font','bold 180px arial, sans-serif')
						)
					.css('background-image','url(images/templates/parkhaus/floor_occupied_sixt.jpg)');
				}else{
					
					if(floor.placesLeftUpper<=0){
						$('body').empty().css('background-image','url(images/templates/parkhaus/floor_upper_occupied_sixt.jpg)');
					}
					else{
						$('body').empty().append(
							$('<span>').append(
									floor.placesLeftUpper
							).css('text-align','center').css('width','400px').css('position','absolute').css('top','390px').css('left','1350px').css('color','#00A752').css('font','bold 180px arial, sans-serif')
						)
						/*.append(
							$('<span>').append(
									floor.placesLeft
							).css('text-align','center').css('width','400px').css('position','absolute').css('top','200px').css('left','550px').css('color','#00A752').css('font','bold 180px arial, sans-serif')
						)*/
						.css('background-image','url(images/templates/parkhaus/floor_frei_sixt.jpg)');
					}
				}
			}
		});
	});
});