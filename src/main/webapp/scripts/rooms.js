jQuery(document).ready(function () {
	
	function rooms(){
	    $.getJSON(
	            'json/getNextCalendars.html',
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
	            		// alert($.cookie('switchToggle'))
	            		
	            		
	            			
		            		$.getScript('scripts/date/date-de-DE.js', function() {
		            			var now = new Date();
		            			menufilename = "images/templates/1912_monatskarte/1920x1080-monatskarte-1912-"+(new Date().getMonth()+ 1).toLocaleString(undefined, {minimumIntegerDigits:2}) +"-"+new Date().getFullYear()+"-de.jpg";
		            			menufilename_en = "images/templates/1912_monatskarte/1920x1080-monatskarte-1912-"+(new Date().getMonth()+ 1).toLocaleString(undefined, {minimumIntegerDigits:2}) +"-"+new Date().getFullYear()+"-en.jpg";
		            			// console.log($.cookie('switchAdToggle'))
			            		if($.cookie('switchAdToggle') == 0){
			            			$('body').css("color", "#707173").css("background","url('images/monitor-cristal-lobby_werbung1912_02.jpg')").css("height", "1920px").css("width", "1080px");
			            				if(now.between(Date.today().set({hour: 05, minute: 00}), Date.today().set({hour: 14, minute: 00})) && 
			            						!Date.today().is().sunday() && !Date.today().is().saturday()){
			            					$.cookie('switchAdToggle', 2);
			            				}else{
			            					$.cookie('switchAdToggle', 5);
			            				}
			            		}
			            		else if($.cookie('switchAdToggle') == 2){
			            			$('body').css("color", "#707173").css("background","url('images/Monitor-Lobby_100Jahre-Neu.jpg')").css("height", "1920px").css("width", "1080px");
			            			$.cookie('switchAdToggle', 5);
			            		}
			            		else if($.cookie('switchAdToggle') == 5){
			            			$('body').css("color", "#707173").css("background","url('images/design_2016/Monitor-hoch_WerbungMuenchnerStubn-Jan16.jpg')").css("height", "1920px").css("width", "1080px");
			            			if(new Date().between(Date.today().set({year: 2017, month: 8, day: 7, hour: 09, minute: 00}), Date.today().set({year: 2018, month: 3, day: 1, hour: 15, minute: 00}))){			            				
			            				$.cookie('switchAdToggle', 6);
			            			}else{
			            				$.cookie('switchAdToggle', 10);
			            			}
			            		}
			            		else if($.cookie('switchAdToggle') == 6){
			            			$('body').css("color", "#707173").css("background","url('images/huettenzauber/2017/neu/1080x1920-winterzauber-2017-de.jpg')").css("height", "1920px").css("width", "1080px");
			            			$.cookie('switchAdToggle', 7);
			            		}
			            		else if($.cookie('switchAdToggle') == 7){
			            			$('body').css("color", "#707173").css("background","url('images/huettenzauber/2017/neu/1080x1920-winterzauber-2017-en.jpg')").css("height", "1920px").css("width", "1080px");
			            			if(new Date().between(Date.today().set({year: 2017, month: 8, day: 7, hour: 09, minute: 00}), Date.today().set({year: 2017, month: 8, day: 17, hour: 15, minute: 00}))){
			            				$.cookie('switchAdToggle', 8);
			            			}else{
			            				$.cookie('switchAdToggle', 10);
			            			}
			            		}
			            		else if($.cookie('switchAdToggle') == 8){
			            			$('body').css("color", "#707173").css("background","url('images/umzuege/2017/1920x1080-wiesnumzuege-2017-de.jpg')").css("height", "1920px").css("width", "1080px");
			            			$.cookie('switchAdToggle', 9);
			            		}
			            		else if($.cookie('switchAdToggle') == 9){
			            			$('body').css("color", "#707173").css("background","url('images/umzuege/2017/1920x1080-wiesnumzuege-2017-en.jpg')").css("height", "1920px").css("width", "1080px");
			            			$.cookie('switchAdToggle', 0);
			            		}
			            		else if($.cookie('switchAdToggle') == 10){
			            			$('body').css("color", "#707173").css("background","url('images/theater/1080x1920px-monitor-rezeption-hoch-theaterpackage-okt2017.jpg')").css("height", "1920px").css("width", "1080px");
			            			if(new Date().between(Date.today().set({year: 2017, month: 9, day: 28, hour: 06, minute: 00}), Date.today().set({year: 2017, month: 9, day: 29, hour: 18, minute: 00}))){
			            				$.cookie('switchAdToggle', 11);
			            			}else{
			            				$.cookie('switchAdToggle', 0);
			            			}
			            		}
			            		else if($.cookie('switchAdToggle') == 11){
			            			$('body').css("color", "#707173").css("background","url('images/zu/17/Monitor-Lobby_Cristal-Zeitumstellung-winter-2017.jpg')").css("height", "1920px").css("width", "1080px");
			            			$.cookie('switchAdToggle', 0);
			            		}			            		
		            		});
		            		/*
							 * if(new Date().compareTo(easterAdEnd) ==-1 ){//
							 * lesser if($.cookie('switchAdToggle') == 0){
							 * $('body').css("color",
							 * "#707173").css("background","url('images/cristal_lobby_intermediate.jpg')").css("height",
							 * "1920px").css("width", "1080px");
							 * $.cookie('switchAdToggle', 1); }else
							 * if($.cookie('switchAdToggle') == 1){
							 * $('body').css("color",
							 * "#707173").css("background","url('images/Monitor-Lobby_100Jahre-Neu.jpg')").css("height",
							 * "1920px").css("width", "1080px");
							 * $.cookie('switchAdToggle', 2);
							 * 
							 * }else if($.cookie('switchAdToggle') == 2){
							 * $('body').css("color",
							 * "#707173").css("background","url('images/Lobby-Monitor-Cristal_Wiesn-Umzuege-2013-engl.jpg')").css("height",
							 * "1920px").css("width", "1080px");
							 * $.cookie('switchAdToggle', 3); } else{
							 * $('body').css("color",
							 * "#707173").css("background","url('images/Lobby-Monitor-Cristal_Wiesn-Umzuege-2013.jpg')").css("height",
							 * "1920px").css("width", "1080px");
							 * $.cookie('switchAdToggle', 0); } }else{
							 * if($.cookie('switchAdToggle') == 0){
							 * $('body').css("color",
							 * "#707173").css("background","url('images/cristal_lobby_intermediate.jpg')").css("height",
							 * "1920px").css("width", "1080px");
							 * $.cookie('switchAdToggle', 1); }else{
							 * $('body').css("color",
							 * "#707173").css("background","url('images/Monitor-Lobby_100Jahre-Neu.jpg')").css("height",
							 * "1920px").css("width", "1080px");
							 * $.cookie('switchAdToggle', 0); } }
							 */
		            		
	            		
	            	}else{
	            		// if($.cookie('switchDirectionsToggle') == 0){
		            		$('#header').css("color", "#fff").css("height","322px").css("width", "1080px");
		            		$('#header').append(
		            				$('<div>').css("font-size", "45px").css("padding-top", "60px").css("text-align", "center").append(data.today)
		            		)
		            		$('#header').append(
		            				$('<div>').css("font-size", "40px").css("padding-top", "30px").css("text-align", "center").append(data.today_en)
		            		)	            				
		            		$('body').css("color", "#707173")
		            		// .css("text-shadow", "1px 1px #333333")
		            		.css("background","url('images/templates/rooms/Cristal-Monitor.jpg')").css("height", "1920px").css("width", "1080px")
		            	
		            	var maxlines = 15;
		            	var linecounter = 0;
		            	/*
						 * if ( window.console && window.console.log ) {
						 * console.log ( "data.calendars.length: "+
						 * data.calendars.length ); }
						 */
		            	$.each(data.calendars, function(i, element){
		            		/*
							 * if ( window.console && window.console.log ) {
							 * console.log ( "i"+i+"maxlines "+maxlines+"
							 * linecounter "+linecounter ); console.log (
							 * element.roomLocation+" "+element.roomName+"
							 * "+element.company ); }
							 */
		            		if(linecounter < maxlines){
			            		var text = element.roomLocation;
			            		// var imageSrc = element.logo != "" ?
								// "images/"+element.logo :
								// "images/"+"pixel.gif";
			            		// if(element.roomLocation === "DOLOMIT"){
			            		// return;
			            		// }
			            		$('#mainTable').css("width","1080px").css("font-size","30px").css("table-layout", "fixed").attr("border", "0").attr("cellspacing", "0").attr("cellpadding", "0")
								.append(
									$('<tr>').css("height", "125px").attr("height", "125px").attr("max-height", "125px")
										.append(
											$('<td>').css("text-align","center").css("background", "none repeat scroll 0 0 transparent").css("width", "210px").append(
													getRoomName(element.roomName)
											)	
										)
										.append(
											$('<td>').css("text-align","center").css("background", "none repeat scroll 0 0 transparent").css("width", "300px")
											.append(
												$('<div>').css("max-height", "110px").css("padding-top", "10px").css("text-overflow", "ellipsis").css("overflow", "hidden")
													.append(
															element.company
													)
												)
										)								
										.append(
											$('<td>').css("text-align","center").css("background", "none repeat scroll 0 0 transparent").css("width", "125px")
											// .append(element.dateString)
											// .append("<br>")
											.append($('<div>')
												.append(
														element.startString
												).append(" - ").append(
														element.endString
												)
											)
										)
										.append(
											$('<td>').css("width", "170px").attr("class", getRoomLocationCssName(element.roomLocation)).append(
													getRoomLocationName(text)
											)	
										)								
								);
		            		}
		            		linecounter = linecounter+1;
		            	});
		            	// do not show text on dolomit location
		            	$('.dolomit').empty();
		            	
		            	$.each(data.emptyRooms, function(i, element){
		            		if(linecounter < maxlines){
			            		$('#mainTable').append(
									$('<tr>').css("height", "125px").attr("height", "125px").attr("max-height", "125px")
										.append(
											$('<td>').css("background", "none repeat scroll 0 0 transparent").css("height", "125px").css("text-align","center").css("width", "230px").append(
													element.name
											)	
										)
										.append(
											$('<td>').attr('colspan','3').css("background", "none repeat scroll 0 0 transparent").css("text-align","center").append("Herzlich Willkommen"
											)
										)								
								);
		            		}
		            		linecounter = linecounter+1;
		            	});
		            	$.cookie('switchDirectionsToggle', 1);
		            	weather();
            		// }else{
            		// $('body').css("color",
					// "#043A80").css("background","url('images/Monitor-Lobby_Wegbeschreibung-Tagungsraeume.jpg')").css("height",
					// "1920px").css("width", "1080px");
            		// $.cookie('switchDirectionsToggle', 0);
            		// }
	            	}
	            });
	}
	
	function getRoomLocationCssName(str){
		if(str == "7. OG") return "og7";
		if(str == "PARKDECK 6. OG") return "pd_og6";
		if(str == "1. OG") return "og1";
		if(str == "DOLOMIT") return "dolomit";
		if(str == "UG") return "ug";
		return "";
	}

	function getRoomName(str){
		if(str == "EISSTOCKEVENT") return "EISSTOCK<br/>EVENT";
		return str;
	}	
	
	function getRoomLocationName(str){
		if(str == "PARKDECK 6. OG") return "PARKDECK<br/>6. OG";
		return str;
	}	
	
	function weather(){
	    $.getJSON(
	            'openweather?days=3',
	            function( data )
	            {
	
	        		$('body').append(
		        				$('<table>').css("background", "none repeat scroll 0 0 #A6F1F7").attr("id", "weatherTable").css("position", "absolute").css("top", "1580px").css("width", "1020px").css("font", "bold 22px Helvetica,sans-serif")
	        		);
	        		$('#weatherTable').append(
							$('<tr>').attr("id", "weatherTableLine").css("height", "125px")
					);
	        		$.each(data.days, function(i, element){
						/*
						 * $.table .append( $('<tr>').css("background", "none
						 * repeat scroll 0 0 transparent") .append( $('<td>').css("background",
						 * "none repeat scroll 0 0
						 * transparent").css('text-align','left').attr("colspan","6").append(element.name+ "
						 * "+element.dateString) ) );
						 */

	        			$('#weatherTableLine').append(
									$('<td>').css("height", "125px").css("width", "360px").css("padding-left", "60px").css("background", "none repeat scroll 0 0 transparent")
										.append($('<div>').css("padding-bottom", "10px").append(element.name+ " "+element.dateString))
										.append($('<div>').css("float", "left").append($('<img>').attr('src', "images/Wetter-Icons_181212/"+element.midayImg+".jpg")))
										.append($('<div>').css("padding-left", "125px").append(element.miday+" °C / ").append(element.midayF+" °F "))
										.append($('<div>').css("padding-left", "125px").append(element.midayPc+"%"))
									/*
									 * .append( $('<td>').css("background",
									 * "none repeat scroll 0 0
									 * transparent").append($('<img>').attr("width","90").attr("height","90").attr('src',
									 * "images/icons/"+element.midayImg+".jpg")) )
									 * .append( $('<td>').css("background",
									 * "none repeat scroll 0 0
									 * transparent").append(element.miday+" °C /
									 * ").append(element.midayF+" °F ") )
									 * .append( $('<td>').css("background",
									 * "none repeat scroll 0 0
									 * transparent").append(element.midayPc+"%") )
									 * .append( $('<td>').css("background",
									 * "none repeat scroll 0 0
									 * transparent").append($('<img>').attr("width","90").attr("height","90").attr('src',
									 * "images/icons/Windpfeil-"+element.midayWd_txt+".png")) )
									 * .append( $('<td>').css("background",
									 * "none repeat scroll 0 0
									 * transparent").append(element.midayWs).append('
									 * km/h') )
									 * 
									 */
			            	);
	        		});
					
	            })
		}	
	
	rooms();	
	
});