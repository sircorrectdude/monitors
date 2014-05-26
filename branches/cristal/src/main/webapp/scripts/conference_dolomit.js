jQuery(document).ready(function () {
	
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
	            		$('body > *').remove();
	            		$.oddeven=0;
	            		$.welcome=0;
		        	    $('body').css("font-family","arial,sans-serif").css("color","#003a7e").css("background","url('images/templates/openweather/Dolomit-Monitor-Wetter.jpg')").css("height", "1280px");	            	

	            		weather();
	            		$.refreshId = setInterval(weather, 20000);
	            	}else{
	            		$('body').css("font-family","arial,sans-serif").css("color","#003a7e").css("background","url('images/templates/konferenzraum/Dolomit-Monitor-Tagungen-120514.jpg')");	            	
	            		
	            		$('body').append(
	            				$('<div>').attr("id", "conference_info_wrapper").css("width","1920px").css("height", "1080px").css("font-size","32px").css("font-weight","bold")
	            		);
		            	$.each(data.calendars, function(i, element){
		            		if(element.roomName === ("RUBIN I")){
		    	        		$('#conference_info_wrapper').append(
				        				$('<div>').attr("id", "company_1").css("position", "absolute").css("left","430px").css("top","380px").css("width","365px").text(element.company)
		    	        		);
		    	        		$('#conference_info_wrapper').append(
		    	        				$('<div>').attr("id", "datetime").css("position", "absolute").css("left","430px").css("top","550px").css("width","365px")
		    	        				.append(
		    	        						$('<span>').attr("id", "date_1").text(element.dateString)
				        				)
				        				.append(
		    	        						$('<span>').text(" ")
				        				)
		    	        				.append(
		    	        						$('<span>').attr("id", "startTime_1").text(element.startString)
				        				)				        				
		    	        		);
		    	        		$('#conference_info_wrapper').append(
		    	        				$('<div>').attr("id", "datetime_en").css("position", "absolute").css("left","430px").css("top","600px").css("width","365px")
		    	        				.append(
		    	        						$('<span>').attr("id", "date_1_en").text(element.dateStringEn)
				        				)
				        				.append(
		    	        						$('<span>').text(" ")
				        				)
		    	        				.append(
		    	        						$('<span>').attr("id", "startTime_1_en").text(element.startStringEn)
				        				)				        				
		    	        		);
		            		}
		            		if(element.roomName === ("RUBIN II")){
		            			
		    	        		$('#conference_info_wrapper').append(
				        				$('<div>').attr("id", "company_2").css("position", "absolute").css("left","800px").css("top","380px").css("width","365px").text(element.company)
		    	        		);
		    	        		$('#conference_info_wrapper').append(
		    	        				$('<div>').attr("id", "datetime_2").css("position", "absolute").css("left","800px").css("top","550px").css("width","365px")
		    	        				.append(
		    	        						$('<span>').attr("id", "date_2").text(element.dateString)
				        				)
				        				.append(
		    	        						$('<span>').text(" ")
				        				)
		    	        				.append(
		    	        						$('<span>').attr("id", "startTime_2").text(element.startString)
				        				)				        				
		    	        		);
		    	        		$('#conference_info_wrapper').append(
		    	        				$('<div>').attr("id", "datetime_2_en").css("position", "absolute").css("left","800px").css("top","600px").css("width","365px")
		    	        				.append(
		    	        						$('<span>').attr("id", "date_2_en").text(element.dateStringEn)
				        				)
				        				.append(
		    	        						$('<span>').text(" ")
				        				)
		    	        				.append(
		    	        						$('<span>').attr("id", "startTime_2_en").text(element.startStringEn)
				        				)				        				
		    	        		);		            			
		            			
		            		}
		            		if(element.roomName === ("RUBIN I + II")){
		            			
		    	        		$('#conference_info_wrapper').append(
				        				$('<div>').attr("id", "company_3").css("position", "absolute").css("left","1175px").css("top","380px").css("width","365px").text(element.company)
		    	        		);
		    	        		$('#conference_info_wrapper').append(
		    	        				$('<div>').attr("id", "datetime_3").css("position", "absolute").css("left","1175px").css("top","550px").css("width","365px")
		    	        				.append(
		    	        						$('<span>').attr("id", "date_3").text(element.dateString)
				        				)
				        				.append(
		    	        						$('<span>').text(" ")
				        				)
		    	        				.append(
		    	        						$('<span>').attr("id", "startTime_3").text(element.startString)
				        				)				        				
		    	        		);
		    	        		$('#conference_info_wrapper').append(
		    	        				$('<div>').attr("id", "datetime_3_en").css("position", "absolute").css("left","1175px").css("top","600px").css("width","365px")
		    	        				.append(
		    	        						$('<span>').attr("id", "date_3_en").text(element.dateStringEn)
				        				)
				        				.append(
		    	        						$('<span>').text(" ")
				        				)
		    	        				.append(
		    	        						$('<span>').attr("id", "startTime_3_en").text(element.startStringEn)
				        				)				        				
		    	        		);		            			
		            			
		            		}
		            		if(element.roomName === ("SAPHIR")){
		            			
		    	        		$('#conference_info_wrapper').append(
				        				$('<div>').attr("id", "company_4").css("position", "absolute").css("left","1550px").css("top","380px").css("width","365px").text(element.company)
		    	        		);
		    	        		$('#conference_info_wrapper').append(
		    	        				$('<div>').attr("id", "datetime_4").css("position", "absolute").css("left","1550px").css("top","550px").css("width","365px")
		    	        				.append(
		    	        						$('<span>').attr("id", "date_4").text(element.dateString)
				        				)
				        				.append(
		    	        						$('<span>').text(" ")
				        				)
		    	        				.append(
		    	        						$('<span>').attr("id", "startTime_4").text(element.startString)
				        				)				        				
		    	        		);
		    	        		$('#conference_info_wrapper').append(
		    	        				$('<div>').attr("id", "datetime_4_en").css("position", "absolute").css("left","1550px").css("top","600px").css("width","365px")
		    	        				.append(
		    	        						$('<span>').attr("id", "date_4_en").css("width","365px").text(element.dateStringEn)
				        				)
				        				.append(
		    	        						$('<span>').text(" ")
				        				)
		    	        				.append(
		    	        						$('<span>').attr("id", "startTime_4_en").text(element.startStringEn)
				        				)				        				
		    	        		);		            			
		            			
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
			    	            			$('#slideshow').cycle({
			    	            				fx:     'fade',
			    	            				timeout: 500,
			    	            				speed:   1500
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
