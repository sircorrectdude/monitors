jQuery(document).ready(function () {
	
	function dolomit(){
	    $.getJSON(
	            'json/getNextCalendars.html?rooms=4',
	            function( data )
	            {        
	            	 clearInterval($.refreshId);
	            	if(data.calendars == null || data.calendars.length === 0){
	            		$('body > *').remove();
	            		$.oddeven=0;
	            		$.welcome=0;
	            		 weather();
	            		 $.refreshId = setInterval(weather, 5000);
	            	}else{
		            	$('#banner').remove();
		            	$('#topbanner').remove();
		            	$('#mainTable').remove();
            			$('#company_1').text("")
            			$('#company_2').text("")
            			$('#date_1').text("")
            			$('#date_1_en').text("")
            			$('#startTime_1').text("")
            			$('#startTime_1_en').text("")
            			$('#location_1').text("")
            			$('#location_1_en').text("")
		            			$('#company_2').text("")
		            			$('#date_2').text("")
		            			$('#date_2_en').text("")
		            			$('#startTime_2').text("")
		            			$('#startTime_2_en').text("")
		            			$('#location_2').text("")
		            			$('#location_2_en').text("")	            			
		            	$.each(data.calendars, function(i, element){
		            		if(element.roomName === ("RUBIN I")){
		            			$('#company_1').text(element.company)
		            			$('#date_1').text(element.dateString)
		            			$('#date_1_en').text(element.dateStringEn)
		            			$('#startTime_1').text(element.startString)
		            			$('#startTime_1_en').text(element.startStringEn)
		            			$('#location_1').text(element.roomLocation)
		            			$('#location_1_en').text(element.roomLocation)
	//	            			$('.text3').remove()
		            		}
		            		if(element.roomName === ("RUBIN II")){
		            			$('#company_2').text(element.company)
		            			$('#date_2').text(element.dateString)
		            			$('#date_2_en').text(element.dateStringEn)
		            			$('#startTime_2').text(element.startString)
		            			$('#startTime_2_en').text(element.startStringEn)
		            			$('#location_2').text(element.roomLocation)
		            			$('#location_2_en').text(element.roomLocation)	            			
		            		}	            		
		            	});
	            	}
	            	$('body').css('display','block');
	            });		
	}
	
	function weather(){
	    $.getJSON(
	            'openweather?days=3',
	            function( data )
	            {
	
	            	$('#banner').remove();
	            	$('#topbanner').remove();
	            	$('#mainTable').remove();
        			$('body > *').remove();
        			$('body').attr("style", "");	            	
	        	    $('body').css("font-family","arial,sans-serif").css("color","#003a7e").css("background","url('images/templates/openweather/Dolomit-Monitor-Wetter.jpg')").css("height", "1280px");	            	
	            	
	        		$('body').append(
		        				$('<table>').attr("id", "mainTable").css("width","1460px").css("margin-top", "205px").css("margin-left", "470px").css("font-size","30px")
	        		);
	        		$.each(data.days, function(i, element){
	        			if($.oddeven==0){
	        				if (i>0){
	        					//return false;
	        				}
	        			}else{
	        	            if($.welcome==0){
	        	            	$.welcome=1;
	        	            	$('body > *').remove();
	        	            	$('body').css("color", "#043A80").css("background","url('images/startbildschirm115.png')").css("height", "1080px").css("width", "1920px")	        	            	
	        	            }	        				
	        				if (i==0){
	        					return;
	        				}
        				}
	        			$('#mainTable').append(
								$('<tr/>').css("background", "none repeat scroll 0 0 transparent")
								.append(
										$('<td>').css("background", "none repeat scroll 0 0 transparent").css('text-align','left').attr("colspan","6").append(element.name+ " "+element.dateString)
								)
		            	);
	        			$('#mainTable').append(
									$('<tr/>').css("height", "127px")
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append("morgens /<br/> in the morning")
										)
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append($('<img>').attr("width","90").attr("height","90").attr('src', "images/icons/"+element.morningImg+".jpg"))
										)						
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append(element.morning+" °C / ").append(element.morningF+" °F ")
										)
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append(element.morningPc+"%")
										)
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append($('<img>').attr("width","90").attr("height","90").attr('src', "images/icons/Windpfeil-"+element.morningWd_txt+".png"))
												
										)
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append(element.morningWs).append(' km/h')
										)								
			            	);
	        			$('#mainTable').append(
									$('<tr/>').css("height", "127px")
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append("mittags /<br/> at noon")
										)
										.append(
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
			            	);
	        			$('#mainTable').append(
									$('<tr/>').css("height", "127px")
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append("abends /<br/> in the evening")
										)
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append($('<img>').attr("width","90").attr("height","90").attr('src', "images/icons/"+element.eveningImg+".jpg"))
										)						
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append(element.evening+" °C / ").append(element.eveningF+" °F ")
										)
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append(element.eveningPc+"%")
										)
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append($('<img>').attr("width","90").attr("height","90").attr('src', "images/icons/Windpfeil-"+element.eveningWd_txt+".png"))
										)
										.append(
												$('<td>').css("background", "none repeat scroll 0 0 transparent").append(element.eveningWs).append(' km/h')
										)								
			            	);
	        		});
					
	            })
	            if($.oddeven==1){
	            	$.oddeven=0;
	            }else{
	            	$.oddeven=1;
	            }
		}
	
	dolomit();	
	
});
