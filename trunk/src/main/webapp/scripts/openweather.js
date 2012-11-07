jQuery(document).ready(function () {

    $.getJSON(
            'openweather',
            function( data )
            {
            	$('body > div').remove();
            	
        	    $('body').css("font-family","arial,sans-serif").css("color","#003a7e").css("background-color","#a1b6d1").append(
        		    	$('<div>').attr("id", "topbanner").css("font-size","50px").css("text-align","center").css("height","75px").css("padding-top","15px")
        		    	.append(
        		    			$('<span>').append(
        		    					"WETTER / WEATHER"
        		    					)
        		    			)
        	    );	            	
            	
        		$('body').append(
        				$('<div>')
        				.attr("id", "mainDiv").append(
	        				$('<table>').attr("id", "mainTable").attr("style", "padding:10px;")
	        				.append(
	    						$('<tr>').css('padding-bottom','10px')
			    						.append(
			    								$('<th>').css('text-align','center').append(" ")
			    						)
	    								.append(
	    										$('<th>').css('text-align','center').append("AUSSICHT /").append("<br>").append("FORECAST")
	    								)    						
	    								.append(
	    										$('<th>').css('text-align','center').append("°C / °F")
	    								)
	    								.append(
	    										$('<th>').css('text-align','center').append("% REGEN /").append("<br>").append("CHANCE OF RAIN")
	    								)
	     								.append(
	     										$('<th>').attr("colspan", "2").css('text-align','center').append("WIND")
	    								)   								
	    						)
    						)
        		);
        		$.each(data.days, function(i, element){
					$('#mainTable').css("background", "none repeat scroll 0 0 #073b80")
					.append(
							$('<tr>').css("background", "none repeat scroll 0 0 #FFFFFF")
							.append(
									$('<td>').css('text-align','left').attr("colspan","6").append(element.name+ " "+element.dateString)
							)
	            	)
					.append(
							$('<tr>').attr("class", "odd")
								.append(
										$('<td>').css('text-align','center').append("morgens /<br/> in the morning")
								)
								.append(
										$('<td>').css('text-align','center').append($('<img>').attr("width","90").attr("height","90").attr('src', "images/icons/"+element.morningImg+".jpg"))
								)						
								.append(
										$('<td>').css('text-align','center').append(element.morning+" °C / ").append(element.morningF+" °F ")
								)
								.append(
										$('<td>').css('text-align','center').append(element.morningPc+"%")
								)
								.append(
										$('<td>').css('text-align','center').append($('<img>').attr("width","90").attr("height","90").attr('src', "images/icons/Windpfeil-"+element.morningWd_txt+".png"))
										
								)
								.append(
										$('<td>').css('text-align','center').append(element.morningWs).append(' km/h')
								)								
	            	) 
					.append(
							$('<tr>').attr("class", "odd")
								.append(
										$('<td>').css('text-align','center').append("mittags /<br/> at noon")
								)
								.append(
										$('<td>').css('text-align','center').append($('<img>').attr("width","90").attr("height","90").attr('src', "images/icons/"+element.midayImg+".jpg"))
								)						
								.append(
										$('<td>').css('text-align','center').append(element.miday+" °C / ").append(element.midayF+" °F ")
								)
								.append(
										$('<td>').css('text-align','center').append(element.midayPc+"%")
								)
								.append(
										$('<td>').css('text-align','center').append($('<img>').attr("width","90").attr("height","90").attr('src', "images/icons/Windpfeil-"+element.midayWd_txt+".png"))
								)
								.append(
										$('<td>').css('text-align','center').append(element.midayWs).append(' km/h')
								)								
	            	)
					.append(
							$('<tr>').attr("class", "odd")
								.append(
										$('<td>').css('text-align','center').append("abends /<br/> in the evening")
								)
								.append(
										$('<td>').css('text-align','center').append($('<img>').attr("width","90").attr("height","90").attr('src', "images/icons/"+element.eveningImg+".jpg"))
								)						
								.append(
										$('<td>').css('text-align','center').append(element.evening+" °C / ").append(element.eveningF+" °F ")
								)
								.append(
										$('<td>').css('text-align','center').append(element.eveningPc+"%")
								)
								.append(
										$('<td>').css('text-align','center').append($('<img>').attr("width","90").attr("height","90").attr('src', "images/icons/Windpfeil-"+element.eveningWd_txt+".png"))
								)
								.append(
										$('<td>').css('text-align','center').append(element.eveningWs).append(' km/h')
								)								
	            	)             	
	            	;
        		});
        	    $('body').append(
        		    	$('<div>').attr("id", "banner").addClass("bannerDiv").css("position","absolute").css("bottom","0").append(
        		    			$('<img>').attr("width","720").css("border", "0px").attr("src", "images/templates/openweather/Cristal-Monitor-Wetter_Banner-1080x328.jpg")
        		    			)
        	    );	        		
				
            })
	
});
