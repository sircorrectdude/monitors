jQuery(document).ready(function () {
	
	function rooms(){
	    $.getJSON(
	            'json/getNextCalendars.html?location=7.%20OG',
	            function( data )
	            {        
	            	$('#header').remove();
	            	$('#mainTable').remove();
	            	
	            	if(data.calendars == null || data.calendars.length === 0){
	            		$.getScript('scripts/date/date-de-DE.js', function() {
	            			menufilename = "images/templates/1912_monatskarte/1920x1080-monatskarte-1912-"+(new Date().getMonth()+ 1).toLocaleString(undefined, {minimumIntegerDigits:2}) +"-"+new Date().getFullYear()+"-de.jpg";
	            			menufilename_en = "images/templates/1912_monatskarte/1920x1080-monatskarte-1912-"+(new Date().getMonth()+ 1).toLocaleString(undefined, {minimumIntegerDigits:2}) +"-"+new Date().getFullYear()+"-en.jpg";
		            		var adEndTime = {year: 2016, month: 8, day: 18, hour: 14, minute: 00};
		            		var adEnd = Date.today().set(adEndTime);
		            		if($.cookie('switchAdToggle') == 0){
		            			$('body').css("color", "#707173").css("background","url('images/Monitor-Lobby_100Jahre-Neu.jpg')").css("height", "1920px").css("width", "1080px");
		            			$.cookie('switchAdToggle', 1);
		            		}else if($.cookie('switchAdToggle') == 1){
		            			$('body').css("color", "#707173").css("background","url('images/design_2016/Monitor-hoch_WerbungMuenchnerStubn-Jan16.jpg')").css("height", "1920px").css("width", "1080px");
		            			$.cookie('switchAdToggle', 0);
		            		}
	            		});
	            	}else{
	            		
		            	$('body').append(
		            			$('<div>').attr("id", "header")
		            	);
		            	$('body').append(
		            			$('<table>').attr("id", "mainTable")
		            	);
		            	$('body').css("color", "#707173")
		            	//.css("text-shadow", "1px 1px #333333")
		            	.css("background","url('images/templates/rooms7og/monitor-cristal-tagungszentrum-110614-hintergrund.jpg')").css("height", "1920px").css("width", "1080px")
		            	
		            	
	            		//if($.cookie('switchDirectionsToggle') == 0){
		            		$('#header').css("color", "#fff").css("height","322px").css("width", "1080px");
		            		$('#header').append(
		            				$('<div>').css("font-size", "45px").css("padding-top", "60px").css("text-align", "center").append(data.today)
		            		)
		            		$('#header').append(
		            				$('<div>').css("font-size", "40px").css("padding-top", "30px").css("text-align", "center").append(data.today_en)
		            		)	            				
		            	var maxlines = 9;
		            	var linecounter = 0;
		            	$.each(data.calendars, function(i, element){
		            		if(linecounter < maxlines){
			            		var text = element.roomLocation;
			            		//var imageSrc = element.logo != "" ? "images/"+element.logo : "images/"+"pixel.gif";
			            		if(element.roomLocation === "DOLOMIT"){ 
			            			return;
			            		}
			            		$('#mainTable').css("width","1080px").css("font-size","45px").css("table-layout", "fixed").attr("border", "0").attr("cellspacing", "0").attr("cellpadding", "0")
								.append(
									$('<tr>').css("height", "112px").attr("height", "112px").attr("max-height", "112px")
										.append(
											$('<td>').css("padding-left","30px").css("text-align","left").css("background", "none repeat scroll 0 0 transparent").css("width", "250px").append(
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
											$('<td>').css("width", "240px").css("text-align","center").attr("style", getRoomDirectionCssName(element.roomName))	
										)								
								);
		            		}
		            		linecounter = linecounter+1;
		            	});
		            	$.each(data.emptyRooms, function(i, element){
		            		if(linecounter < maxlines){
			            		$('#mainTable').append(
									$('<tr>').css("height", "112px").attr("height", "112px").attr("max-height", "112px")
										.append(
											$('<td>').css("background", "none repeat scroll 0 0 transparent").css("height", "112px").css("padding-left","30px").css("text-align","left").css("width", "210px").append(
													element.name
											)	
										)
										.append(
												$('<td>').css("text-align","center").css("background", "none repeat scroll 0 0 transparent").css("width", "310px")
												.append(
													$('<div>').css("max-height", "110px").css("padding-top", "10px").css("text-overflow", "ellipsis").css("overflow", "hidden")
														.append(
																element.company
														)
													)
											)								
										.append(
											$('<td>').css("width", "240px").css("text-align","center").attr("style", getRoomDirectionCssName(element.name))	
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
		if(str == "BERNSTEIN") return getLeftArrowCss();
		if(str == "TOPAZ") return getRightArrowCss();
		if(str == "SMARAGD") return getLeftArrowCss();
		if(str == "BRILLIANT") return getRightArrowCss();
		if(str == "CARAT") return getRightArrowCss();
		if(str == "JUWEL") return getRightArrowCss();
		if(str == "CARAT + JUWEL") return getRightArrowCss();
		return "";
	}
	
	function getLeftArrowCss(){
	 return "background-image: url(../images/templates/rooms7og/Pfeil-links.png);"+
	 "background-repeat:no-repeat;"+
	 "background-color:transparent;"+
	 "background-position:210px 0px;";
	}
	
	function getRightArrowCss(){
		return "background-image: url(../images/templates/rooms7og/Pfeil-rechts.png);"+
		 "background-repeat:no-repeat;"+
		 "background-color:transparent;"+
		 "background-position:210px 0px;";		
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
							$('<tr>').attr("id", "weatherTableLine").css("height", "112px")
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
									$('<td>').css("height", "112px").css("width", "360px").css("padding-left", "60px").css("background", "none repeat scroll 0 0 transparent")
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
