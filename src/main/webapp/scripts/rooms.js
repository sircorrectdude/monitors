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
	            	
	            	if(data.calendars.length === 0){
	            		//alert($.cookie('switchToggle'))
	            		if($.cookie('switchAdToggle') == 0){
	            			$('body').css("color", "#043A80").css("background","url('images/cristal_lobby_intermediate.jpg')").css("height", "1920px").css("width", "1080px");
	            			$.cookie('switchAdToggle', 1);
	            		}else{
	            			$('body').css("color", "#043A80").css("background","url('images/Monitor-Lobby_Werbung1912-100Jahre-Logo.jpg')").css("height", "1920px").css("width", "1080px");
	            			$.cookie('switchAdToggle', 0);
	            		}
	            	}else{
	            		//if($.cookie('switchDirectionsToggle') == 0){
		            		$('#header').css("color", "#fff").css("height","315px").css("width", "1080px");
		            		$('#header').append(
		            				$('<div>').css("font-size", "45px").css("padding-top", "100px").css("text-align", "center").append(data.today)
		            		)
		            		$('#header').append(
		            				$('<div>').css("font-size", "40px").css("padding-top", "30px").css("text-align", "center").append(data.today_en)
		            		)	            				
		            		$('body').css("color", "#043A80").css("background","url('images/templates/rooms/Cristal-Monitor.jpg')").css("height", "1920px").css("width", "1080px")
		            	
		            	
		            	$.each(data.calendars, function(i, element){
		            		var text = element.roomLocation;
		            		//var imageSrc = element.logo != "" ? "images/"+element.logo : "images/"+"pixel.gif";
		            		if(element.roomLocation === "DOLOMIT") text=""
		            		$('#mainTable').css("width","1080px").css("font-size","30px").css("table-layout", "fixed")
							.append(
								$('<tr>').css("height", "140px")
									.append(
										$('<td>').css("text-align","center").css("background", "none repeat scroll 0 0 transparent").append(
												element.roomName
										)	
									)
									.append(
										$('<td>').css("text-align","center").css("background", "none repeat scroll 0 0 transparent")
										.append(
											$('<div>').css("max-height", "110px").css("padding-top", "10px").css("max-width", "360px").css("text-overflow", "ellipsis").css("overflow", "hidden")
												.append(
														element.company
												)
											)
									)								
									.append(
										$('<td>').css("text-align","center").css("background", "none repeat scroll 0 0 transparent").css("min-width", "250px").append(
												element.dateString
										).append("<br>").append(
												element.startString
										).append(" - ").append(
												element.endString
										)
									)
									.append(
										$('<td>').css("width", "270px").attr("class", getRoomLocationCssName(element.roomLocation)).append(
												text
										)	
									)								
							);
		            	});
		            	$.each(data.emptyRooms, function(i, element){
		            		$('#mainTable').append(
								$('<tr>').css("border-bottom", "20px solid #transparent")
									.append(
										$('<td>').css("background", "none repeat scroll 0 0 transparent").css("height", "140px").css("text-align","center").css("width", "230px").append(
												element.name
										)	
									)
									.append(
										$('<td>').attr('colspan','3').css("background", "none repeat scroll 0 0 transparent").css("text-align","center").append("Herzlich Willkommen"
										)
									)								
							);
		            	});
		            	$.cookie('switchDirectionsToggle', 1);
            		//}else{
            		//	$('body').css("color", "#043A80").css("background","url('images/Monitor-Lobby_Wegbeschreibung-Tagungsraeume.jpg')").css("height", "1920px").css("width", "1080px");
            		//	$.cookie('switchDirectionsToggle', 0);
            		//}	            		
	            	}
	            });
	}
	
	function getRoomLocationCssName(str){
		if(str == "7. OG") return "og7";
		if(str == "1. OG") return "og1";
		if(str == "DOLOMIT") return "dolomit";
		if(str == "UG") return "ug";
		return "";
	}
	
	rooms();	
	
});
