var all_script = document.createElement('script');
  all_script.type = 'text/javascript';
  all_script.src = "/scripts/tablecloth/tablecloth.js";
  document.body.appendChild(all_script);
jQuery(document).ready(function () {
	
	function traffic(){
	    $.getJSON(
	            'traffic?db=true',
	            function( data )
	            {
	            	var limit=100;
	            	$('body > *').remove();
	        	    $('body').css("font-family","arial,sans-serif").css("color","#707173").css("background-color","#ddf3f7").append(
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
	        				$('<table>').attr("id", "mainTable").attr("style", "padding:10px;").addClass("dolomit_table")
	        				.append(
        						$('<tr>').css('text-align','left').css('padding-bottom','10px').append(
        								$('<th>').css("width","50px").append("&nbsp;")
        								)
        								.append(
        										$('<th>').append("LINIE /").append("<br>").append("LINE")
        								)
        								.append(
        										$('<th>').append("ZIEL /").append("<br>").append("DESTINATION")
        								)
        								.append(
        								$('<th>').append("ABFAHRT /").append("<br>").append("DEPARTURE")
        								)
        								.append(
        								$('<th>').append("GLEIS /").append("<br>").append("PLATFORM")
        								)
        								.append(
        								$('<th>').append("AKTUELL /").append("<br>").append("CURRENT")
        								)
        						)
        						)
	        		);
	        	    $('body').append(
	        		    	$('<div>').attr("id", "banner").css("position","absolute").css("bottom","0").addClass("bannerDiv").append(
	        		    			$('<img>').css("border", "0px").attr("src", "images/templates/traffic/Dolomit-Monitor-Banner-1080x328.png")
	        		    			)
	        	    );		        		
	        		var max=0;
					$.each(data.allObjects, function(i, element){
						var ris=" ";
						if(element.ris ){
							ris=element.ris;
						}
						if(max<limit){
							$('#mainTable')
								.append(
										$('<tr>').addClass("line")
											.append(
												$('<td>').append(
														$('<img>').css("width", "50px").css("height", "20px").attr("src", element.image)
												)
										)							
										.append(
												$('<td>').append(element.train)
										)
										.append(
												$('<td>').append(element.target)
										)
											.append(
													$('<td>').append(element.timeString).append(" (in "+element.timeShift+" Minuten)")
										)
											.append(
												$('<td>').append(element.platform)
										)
											.append(
												$('<td>').append(ris)
										)
								 );
							}
						max++;
						});
					 tablecloth();
	            });		
	}
	traffic();
	$.refreshId = setInterval(traffic, 10000);
            
});
