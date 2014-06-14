jQuery(document).ready(function () {
	
	function rooms(){
	    $.getJSON(
	            'json/getNextCalendars.html?location=7.%20OG',
	            function( data )
	            {        
	            	$('#header').remove();
	            	$('body').append(
	            			$('<div>').attr("id", "header")
	            	);
	            	
	            	$('#mainTable').remove();
	            	$('body').append(
	            			$('<table>').attr("id", "mainTable")
	            	);
	            	
	            	if(data.calendars == null || data.calendars.length === 0){
	            		//alert($.cookie('switchToggle'))
	            		
	            		
	            			
		            		/*var easterAdEndTime = {month: 8, day: 22, hour: 13, minute: 00};
		            		var easterAdEnd = Date.today().set(easterAdEndTime);

		            		var welcomewiesnAdEndTime = {month: 9, day: 06, hour: 22, minute: 00};
		            		var welcomewiesnAdEnd = Date.today().set(welcomewiesnAdEndTime);
		            		*/
		            		if($.cookie('switchAdToggle') == 0){
		            			$('body').css("color", "#707173").css("background","url('images/templates/rooms7og/monitor-cristal-lobby_werbung1912_02.jpg')").css("height", "1920px").css("width", "1080px");
		            			$.getScript('scripts/date/date-de-DE.js', function() {
		            					$.cookie('switchAdToggle', 0);
		            			});
		            		}
	            	}else{
	            		//if($.cookie('switchDirectionsToggle') == 0){
		            		$('#header').css("color", "#fff").css("height","322px").css("width", "1080px");
		            		$('#header').append(
		            				$('<div>').css("font-size", "45px").css("padding-top", "60px").css("text-align", "center").append(data.today)
		            		)
		            		$('#header').append(
		            				$('<div>').css("font-size", "40px").css("padding-top", "30px").css("text-align", "center").append(data.today_en)
		            		)	            				
		            		$('body').css("color", "#707173")
		            		//.css("text-shadow", "1px 1px #333333")
		            		.css("background","url('images/templates/rooms7og/monitor-cristal-tagungszentrum-110614-hintergrund.jpg')").css("height", "1920px").css("width", "1080px")
		            	
		            	var maxlines = 9;
		            	var linecounter = 0;
		            	$.each(data.calendars, function(i, element){
		            		if(linecounter < maxlines){
			            		var text = element.roomLocation;
			            		//var imageSrc = element.logo != "" ? "images/"+element.logo : "images/"+"pixel.gif";
			            		if(element.roomLocation === "DOLOMIT"){ 
			            			return false;
			            		}
			            		$('#mainTable').css("width","1080px").css("font-size","45px").css("table-layout", "fixed").attr("border", "0").attr("cellspacing", "0").attr("cellpadding", "0")
								.append(
									$('<tr>').css("height", "158px").attr("height", "158px").attr("max-height", "158px")
										.append(
											$('<td>').css("padding-left","30px").css("text-align","left").css("background", "none repeat scroll 0 0 transparent").css("width", "210px").append(
													element.roomName
											)	
										)
										.append(
											$('<td>').css("text-align","center").css("font-size","30px").css("background", "none repeat scroll 0 0 transparent").css("width", "350px")
											.append(
												$('<div>').css("max-height", "110px").css("padding-top", "10px").css("text-overflow", "ellipsis").css("overflow", "hidden")
													.append(
															element.company
													)
												)
										)								
										.append(
											$('<td>').css("width", "240px").css("text-align","center").attr("class", getRoomDirectionCssName(element.roomName))	
										)								
								);
		            		}
		            		linecounter = linecounter+1;
		            	});
		            	$.each(data.emptyRooms, function(i, element){
		            		if(linecounter < maxlines){
			            		$('#mainTable').append(
									$('<tr>').css("height", "158px").attr("height", "158px").attr("max-height", "158px")
										.append(
											$('<td>').css("background", "none repeat scroll 0 0 transparent").css("height", "158px").css("padding-left","30px").css("text-align","left").css("width", "210px").append(
													element.name
											)	
										)
										.append(
												$('<td>').css("text-align","center").css("background", "none repeat scroll 0 0 transparent").css("width", "350px")
												.append(
													$('<div>').css("max-height", "110px").css("padding-top", "10px").css("text-overflow", "ellipsis").css("overflow", "hidden")
														.append(
																element.company
														)
													)
											)								
										.append(
											$('<td>').css("width", "240px").css("text-align","center").attr("class", getRoomDirectionCssName(element.name))	
										)									
								);
		            		}
		            		linecounter = linecounter+1;
		            	});
		            	$.cookie('switchDirectionsToggle', 1);
		            	weather();
            		//}else{
            		//	$('body').css("color", "#043A80").css("background","url('images/Monitor-Lobby_Wegbeschreibung-Tagungsraeume.jpg')").css("height", "1920px").css("width", "1080px");
            		//	$.cookie('switchDirectionsToggle', 0);
            		//}	            		
	            	}
	            });
	}
	
	function getRoomDirectionCssName(str){
		if(str == "BERNSTEIN") return "leftArrow";
		if(str == "TOPAZ") return "rightArrow";
		if(str == "SMARAGD") return "leftArrow";
		if(str == "BRILLIANT") return "rightArrow";
		if(str == "CARAT") return "rightArrow";
		if(str == "JUWEL") return "rightArrow";
		if(str == "CARAT + JUWEL") return "rightArrow";
		return "";
	}
	
	
	function weather(){
	    $.getJSON(
	            'openweather?days=3',
	            function( data )
	            {
	
	        		$('body').append(
		        				$('<table>').attr("id", "weatherTable").css("position", "absolute").css("top", "1560px").css("width", "1020px").css("font", "bold 22px Helvetica,sans-serif")
	        		);
	        		$('#weatherTable').append(
							$('<tr>').attr("id", "weatherTableLine").css("height", "158px")
					);
	        		$.each(data.days, function(i, element){
						/*$.table
						.append(
								$('<tr>').css("background", "none repeat scroll 0 0 transparent")
								.append(
										$('<td>').css("background", "none repeat scroll 0 0 transparent").css('text-align','left').attr("colspan","6").append(element.name+ " "+element.dateString)
								)
		            	);
		            	*/

	        			$('#weatherTableLine').append(
									$('<td>').css("height", "158px").css("width", "360px").css("padding-left", "60px").css("background", "none repeat scroll 0 0 transparent")
										.append($('<div>').css("padding-bottom", "10px").append(element.name+ " "+element.dateString))
										.append($('<div>').css("float", "left").append($('<img>').attr('src', "images/Wetter-Icons_181212/"+element.midayImg+".jpg")))
										.append($('<div>').css("padding-left", "120px").append(element.miday+" °C / ").append(element.midayF+" °F "))
										.append($('<div>').css("padding-left", "120px").append(element.midayPc+"%"))
									/*	.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append($('<img>').attr("width","90").attr("height","90").attr('src', "images/icons/"+element.midayImg+".jpg"))
										)						
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append(element.miday+" °C / ").append(element.midayF+" °F ")
										)
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append(element.midayPc+"%")
										)
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append($('<img>').attr("width","90").attr("height","90").attr('src', "images/icons/Windpfeil-"+element.midayWd_txt+".png"))
										)
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append(element.midayWs).append(' km/h')
										)
										
										*/
			            	);
	        		});
					
	            })
		}	
	
	rooms();	
	
});
