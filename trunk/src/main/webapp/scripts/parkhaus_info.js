jQuery(document).ready(function () {
	
	$.getScript("scripts/date/date-de-DE.js", function(data, textStatus, jqxhr) {
		   var timerStartTime = {month: 6, day: 22, hour: 22, minute: 5};
		   var timerStart = Date.today().set(timerStartTime);
		   
		   var timerEndTime = {month: 6, day: 25, hour: 6, minute: 00};
		   var timerEnd = Date.today().set(timerEndTime);
		   
			if(new Date().between(timerStart, timerEnd)){
				$("body").css("background-image","url(images/templates/parkhaus/Monitor-carpark-EG_220713-BW.jpg)")
			}else{
				$("body").css("background-image","url(images/templates/parkhaus/Monitor-carpark-EG_170613.jpg)")
			}
		   
		});
	
});	


/*
jQuery(document).ready(function () {
	
	$("body").css("background-image","url(images/templates/parkhaus/Monitor-carpark-EG_Hintergrund.jpg)");
	$('body').append(
			$('<table>').attr("id", "floorsTable").css('margin-top', "412px").css('width', "auto").css('font','bold 40pt arial, sans-serif')
	);
	
	$.getJSON('/json/carpark.html',function(data){
		$.each(data.carparkCristal.floors, function(i, floor){
			$('#floorsTable').append(
					$('<tr>').css('height', "185px")
						.append(
								$('<td>').css('width', "385px").css('background' , 'none repeat scroll 0 0 transparent')
						).append(
								$('<td>').css('width', "185px").css('background' , 'none repeat scroll 0 0 transparent')
								.append($("<img>").attr('src', floor.placesLeft<=0 ? 'images/templates/parkhaus/Parken_besetzt.jpg' : 'images/templates/parkhaus/Parken_frei.jpg'))
						).append(
								$('<td>').css('width', "200px").css('background' , 'none repeat scroll 0 0 transparent').css('text-align', "center")
								.css('color', floor.placesLeft<=0 ? '#CB0023' : '#008124')
								.append( floor.placesLeft<=0 ? "Besetzt <br/> <i>Occupied</i>" : "Frei <br/> <i>Available</i>")
						)
					)
		});
	});
});

	*/