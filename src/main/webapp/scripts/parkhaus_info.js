/*
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

*/

jQuery(document).ready(function () {
	//clearInterval($.refreshId);
	parkhaus();
	
	//$.refreshId = setInterval(parkhaus, 25000);
	
	$(document).stopTime('blink');	
	$(document).everyTime('500ms', 'blink', blink, 0, true);
			function blink() {
				if($('.blink').css("visibility") == "visible")
				{
					$('.blink').css('visibility','hidden');
				}
				else
				{
					$('.blink').css('visibility','visible');
				}
			}
			
	function parkhaus(){
		$('body > *').remove();
		$.getScript('scripts/date/date-de-DE.js', function() {
//			alert(new Date().between(Date.today().set({hour: 05, minute: 00}), Date.today().set({hour: 14, minute: 00})) && 
//			!(Date.today().is().sunday() || Date.today().is().saturday()));
		});
		if($.oddeven==0){
			$.getScript("scripts/jquery.cycle.all.js", function(data, textStatus, jqxhr) {
				$('body').append(
        				$('<div>').attr("id", "slideshow")
        		);
				$('#slideshow').empty()
				if($.adcounter==0){
					$('body').css("color", "#707173").css("background","url('images/Monitor-carpark-EG_theater-tarif-01.jpg')").css("height", "1920px").css("width", "1080px");
        			$.getScript('scripts/date/date-de-DE.js', function() {
        				if(new Date().between(Date.today().set({hour: 05, minute: 00}), Date.today().set({hour: 14, minute: 00})) && 
        						!Date.today().is().sunday() && !Date.today().is().saturday()){
        					$.adcounter=1;
        				}else{
        					$.adcounter=0;
        				}
        			});
				}
				else if($.adcounter==1){
					$('body').css("color", "#707173").css("background","url('images/lunch/daily-busilunch-monitor-hintergrundoriginal.jpg')").css("height", "1920px").css("width", "1080px");
					
					$.getJSON('/json/lunch.html',function(data){
						$('body').css("font-family","arial,sans-serif")
						.append($('<div>').css("width","700px").css("position", "absolute").css("top", "600px").css("left", "180px").css("text-align","center").css("font-weight","bold")
								.append(
										$('<div>').css("padding-top", "0px").css("margin-bottom", "55px").css("font-size","30pt").css("color","rgb(131,13,41)").append(data.todaysLunch.date)
								).append(
										$('<div>').css("text-align", "center").css("display", "table-cell").css("vertical-align", "middle").css("height", "150px").css("width", "700px").css("font-size","25pt").css("color","rgb(112,111,111)").append(data.todaysLunch.vor)
								).append(
										$('<div>').css("clear", "both").css("margin-bottom", "55px")
								).append(
										$('<div>').css("text-align", "center").css("display", "table-cell").css("vertical-align", "middle").css("height", "150px").css("width", "700px").css("font-size","25pt").css("color","rgb(112,111,111)").append(data.todaysLunch.haupt)
								).append(
										$('<div>').css("clear", "both").css("margin-bottom", "55px")
								).append(
										$('<div>').css("text-align", "center").css("display", "table-cell").css("vertical-align", "middle").css("height", "150px").css("width", "700px").css("font-size","25pt").css("color","rgb(112,111,111)").append(data.todaysLunch.nach)
								)
						);
					});
					$.adcounter=0;
				}
				/*$('#slideshow').cycle({
        			fx:     'none',
        			timeout: 1000,
        			speed:   1500
        		});
        		*/
			});
			}else{
		
		
			
		$("body").css("background-image","url(images/templates/parkhaus/hintergrund-monitor-carpark-EG_etagen-visu.jpg)").css('height','1508px');
		$('body').append(
				$('<table>').attr("id", "floorsTable").css('margin-top', "395px").css('width', "auto").css('font','bold 40pt arial, sans-serif')
		);
		
		$.getJSON('/json/carpark.html',function(data){
			data.carparkCristal.floors.reverse();
			$.each(data.carparkCristal.floors, function(i, floor){
				//if(floor.name !== 'UG' && floor.name !== 'EG'){
					$('#floorsTable').append(
							$('<tr>').css('height', "111px")
								.append(
										$('<td>').css('width', "930px").css('background' , 'none repeat scroll 0 0 transparent')
								).append(
										$('<td>').css('background' , 'none repeat scroll 0 0 transparent')
										.append($("<img>").attr('src', floor.placesLeft<=0 ? 'images/templates/parkhaus/Parken_besetzt.jpg' : 'images/templates/parkhaus/Parken_frei.jpg'))
								)
								/*.append(
										$('<td>').css('width', "200px").css('background' , 'none repeat scroll 0 0 transparent').css('text-align', "center")
										.css('color', floor.placesLeft<=0 ? '#CB0023' : '#008124')
										.attr('class', floor.placesLeft<=0 ? 'noblink' : 'blink')
										.append( floor.placesLeft<=0 ? "Besetzt <br/> <i>Occupied</i>" : "Frei <br/> <i>Available</i>")
								)*/
					)
				//}
			});
			//$('.blink').blink()
		});
	}
        if($.oddeven==0){
        	$.oddeven=1;
        }else{
        	$.oddeven=0;
        }
	}
});

	