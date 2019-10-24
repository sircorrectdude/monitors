jQuery(document).ready(function () {
	$(this).stop(true).stopTime('reloadPage');
	$(document).everyTime('120s', 'reloadDolomitPage', reloadPage, 0, true);
	function dolomit(){
	    $.getJSON(
	            'json/getNextCalendars.html?rooms=4',
	            function( data )
	            {        
	            	 clearInterval($.refreshId);
	            	 
	            	 var dolomitEvents=false;
	            	 $.each(data.calendars, function(i, element){
	            		 if(element.roomLocation === ("DOLOMIT")){
	            			 dolomitEvents=true;
	            		 }
	            	 })
	            	 
	            	if(data.calendars == null || data.calendars.length === 0 || !dolomitEvents){
	            		weather();
	            		$('body > *').remove();
	            		$.oddeven=0;
	            		$.welcome=0;
		        	    $('body').css("font-family","arial,sans-serif").css("color","#003a7e").css("background","url('images/templates/Dolomit_Monitor-Fenster_Willkommen.jpg')").css("height", "1280px");	            	

	            		$.refreshId = setInterval(weather, 50000);
	            	}else{
	            		$('body').css("font-family","arial,sans-serif").css("color","#003a7e").css("background","url('images/templates/konferenzraum/Dolomit-Monitor-Tagungen-17014.jpg')");	            	
	            		
	            		$('body').append(
	            				$('<div>').attr("id", "conference_info_wrapper").css("width","1920px").css("height", "1080px").css("font-size","32px").css("font-weight","bold")
	            		);
		            	$.each(data.calendars, function(i, element){
		            		if(element.roomName === ("RUBIN I")){
		            			fillRoom(element, 1, "430px");
		            		}
		            		if(element.roomName === ("RUBIN II")){
		            			
		            			fillRoom(element, 2, "950px");            			
		            			
		            		}
		            		if(element.roomName === ("RUBIN I + II")){
		            			
		            			fillRoom(element, 1, "430px");
		            			fillRoom(element, 2, "950px"); 
		            			
		            		}
		            		if(element.roomName === ("SAPHIR")){
		            			
		            			fillRoom(element, 4, "1450px"); 	            			
		            			
		            		}		            		
		            	});
	            	}
	            	$('body').css('display','block');
	            });		
	}
	
	
	function fillRoom(element, divNo, left){
		$('#conference_info_wrapper').append(
				$('<div>').attr("id", "company_"+divNo).css("position", "absolute").css("left",left).css("top","380px").css("width","365px").css("height","110px").css("overflow","hidden").text(element.company)
		);
		$('#conference_info_wrapper').append(
				$('<div>').attr("id", "datetime").css("position", "absolute").css("left",left).css("top","550px").css("width","365px")
				.append(
						$('<span>').attr("id", "date_"+divNo).text(element.dateString)
				)
				.append(
						$('<span>').text(" ")
				)
				.append(
						$('<span>').attr("id", "startTime_"+divNo).text(element.startString)
				)				        				
		);
		$('#conference_info_wrapper').append(
				$('<div>').attr("id", "datetime_en").css("position", "absolute").css("left",left).css("top","600px").css("width","365px").css("height","110px").css("overflow","hidden")
				.append(
						$('<span>').attr("id", "date_"+divNo+"_en").text(element.dateStringEn)
				)
				.append(
						$('<span>').text(" ")
				)
				.append(
						$('<span>').attr("id", "startTime_"+divNo+"_en").text(element.startStringEn)
				)				        				
		);		
	}
	
	function weather(){
	    $.getJSON(
	            'openweather?days=3',
	            function( data )
	            {
	
        			$('body > *').remove();
        			$('body').attr("style", "");
	        	    $('body').css("font-family","arial,sans-serif").css("color","#003a7e").css("background","url('images/templates/openweather/Dolomit-Monitor-Wetter.jpg')").css("height", "1280px");	            	

	        		$('body').append(
		        				$('<table>').attr("id", "mainTable").css("width","1460px").css("margin-top", "205px").css("margin-left", "470px").css("font-size","30px")
	        		);
	        		$.each(data.days, function(i, element){
	        			if($.oddeven==0){
	        				if (i>1){
	        					return false;
	        				}
	        			}else{
	        	            if($.welcome==0){
	        	            	
			        	            	$.welcome=1;
			        	            	$('body > *').remove();
			        	            	$('body').css("background","none");	            	

			    	            		$('body').append(
			    	            				$('<div>').attr("id", "slideshow")
			    	            		);
			    	            		
			    	            		$.getScript('scripts/date/date-de-DE.js', function() {
			    	            			$('#slideshow').css("width","1920px").css("height", "1080px")
			    	            			.append($("<img />",  {"src": "images/templates/Dolomit_Monitor-Fenster_Willkommen.jpg", "width":"1920", "height":"1080"})	)
			    	            				if(new Date().between(Date.today().set({year: 2018, month: 8, day: 1, hour: 09, minute: 00}), Date.today().set({year: 2019, month: 2, day: 31, hour: 20, minute: 00}))){
			    	            				$('#slideshow').append($("<img />",  {"src": "images/huettenzauber/2018/1920x1080-weihnachtszauber2018-DE.jpg", "width":"1920", "height":"1080"})	)
			    	            				$('#slideshow').append($("<img />",  {"src": "images/huettenzauber/2018/1920x1080-weihnachtszauber2018-EN.jpg", "width":"1920", "height":"1080"})	)
			    	            			}	
                                            if(new Date().between(Date.today().set({year: 2019, month: 9, day: 26, hour: 9, minute: 00}), Date.today().set({year: 2019, month: 9, day: 27, hour: 18, minute: 00}))){
			    	            				$('#slideshow').append($("<img />",  {"src": "images/zu/19/display-dolomit-quer-zeitumstellung-winter-2019.jpg", "width":"1920", "height":"1080"})	)
			    	            			}				    	            			
			    	            			$('#slideshow').append($("<img />",  {"src": "images/Rezeptions-Display-60Zoll-Dolomit-we-and-food-2018.jpg", "width":"1920", "height":"1080"})	)
                                            if(new Date().between(Date.today().set({year: 2019, month: 4, day: 23, hour: 14, minute: 00}), Date.today().set({year: 2019, month: 4, day: 26, hour: 22, minute: 00}))){
                                                $('#slideshow').append($("<img />",  {"src": "images/unplugged/2019/Monitor_Cristal.jpg", "width":"1920", "height":"1080"})	)
                                            }
			    	            			$('#slideshow').cycle({
			    	            				fx:     'fade',
			    	            				timeout: 5000,
			    	            				speed:   500
			    	            			});
			    	            		});
		        	            	
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
	$.getScript("scripts/jquery.cycle.all.js", function(data, textStatus, jqxhr) {
		dolomit();	
	});
});
