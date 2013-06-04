var all_script = document.createElement('script');
  all_script.type = 'text/javascript';
  all_script.src = "/scripts/tablecloth/tablecloth.js";
  document.body.appendChild(all_script);
					  
jQuery(document).ready(function () {
	
	function trafficmvg(){
	    $.getJSON(
	            'traffic?mvg=true',
	            function( data )
	            {
	            	var limit=36;
	            	$('body > *').remove();
	            	
	        	    $('body').css("font-family","arial,sans-serif").css("color","#003a7e").css("background-color","#a1b6d1").append(
	        		    	$('<div>').attr("id", "topbanner").css("font-size","50px").css("text-align","center").css("height","175px")
	        		    	.append(
	        		    			$('<span>').append(
	        		    				"HAUPTBAHNHOF /").append("<br>").append("CENTRAL STATION"
	        		    					)
	        		    			)
	        		    	.append($('<br>'))
	        		    	.append(
	        		    			$('<span>').append(
	        		    					data.time
	        		    					)
	        		    		)
	        	    );	            	
	            	
	        		$('body').append(
	        				$('<div>').attr("id", "mainDiv").append(
	        				$('<table>').attr("id", "mainTable").attr("style", "padding:10px;")
	        				.append(
        						$('<tr>').css('text-align','left').css('padding-bottom','10px')
        								.append(
        								$('<th>').attr("colspan","2").append("LINIE /").append("<br>").append("LINE")
        								)
        								.append(
        								$('<th>').append("ZIEL /").append("<br>").append("DESTINATION")
        								)
        								.append(
        								$('<th>').append("ABFAHRT /").append("<br>").append("DEPARTURE")
        								)
        								.append(
        								$('<th>').append("STATION /").append("<br>").append("STATION")
        								)        								
        						)
        						)
	        		);
	        	    $('body').append(
	        		    	$('<div>').attr("id", "banner").css("position","absolute").css("bottom","0").addClass("bannerDiv").append(
	        		    			$('<img>').attr("width","720").css("border", "0px").attr("src", "images/templates/traffic/Cristal-Monitor-HBF-Abfahrtszeiten-Banner-1080x328_neu.jpg")
	        		    			)
	        	    );	        		
	        		var max=0;
					$.each(data.allObjects, function(i, element){
						if(max<limit && element.timeShift>1){
							$('#mainTable')
								.append(
										$('<tr>').addClass("line")
											.append(
												$('<td>').append(
														$('<img>').css("height", "20px").attr("src", element.imageGeneral)
												)
										)										
											.append(
												$('<td>').append(
														$('<img>').css("height", "20px").attr("src", element.image)
												)
										)							
											.append(
												$('<td>').append(element.target)
										)
											.append(
													$('<td>').append(element.timeString).append(" (in "+element.timeShift+" Minuten)")
										)
											.append(
													$('<td>').append(element.station)
										)										
								 );
							max++;
							}
						});
					  tablecloth();
	            });
	}
	trafficmvg();
	$.refreshId = setInterval(trafficmvg, 600000);
            
});
