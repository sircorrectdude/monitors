var all_script = document.createElement('script');
  all_script.type = 'text/javascript';
  all_script.src = "/scripts/tablecloth/tablecloth.js";
  document.body.appendChild(all_script);
  
  function splitTable(table, maxHeight) {
	    var header = table.children("thead"); 
	    if (!header.length)
	        return;

	    var headerHeight = header.outerHeight();
	    var header = header.detach();

	    var splitIndices = [0];
	    var rows = table.children("tbody").children();

	    maxHeight -= headerHeight;
	    var currHeight = 0;
	    rows.each(function(i, row) {
	        currHeight += $(rows[i]).outerHeight();
	        if (currHeight > maxHeight) {
	            splitIndices.push(i);
	            currHeight = $(rows[i]).outerHeight();
	        }
	    });
	    splitIndices.push(undefined);

	    table = table.replaceWith('<div id="_split_table_wrapper"></div>');
	    table.empty();

	    for(var i=0; i<splitIndices.length-1; i++) {
	        var newTable = table.clone();
	        newTable.attr("id", "table_"+i)
	        header.clone().appendTo(newTable);
	        $('<tbody />').appendTo(newTable);
	        rows.slice(splitIndices[i], splitIndices[i+1]).appendTo(newTable.children('tbody'));
	        newTable.appendTo("#_split_table_wrapper");
	        if (splitIndices[i+1] !== undefined) {
	            $('<div style="page-break-after: always; margin:0; padding:0; border: none;"></div>').appendTo("#_split_table_wrapper");
	        }
	    }
	}
jQuery(document).ready(function () {
	
	function traffic(){
	    $.getJSON(
	            'traffic?air=true',
	            function( data )
	            {
	            	var limit=500;
	            	$('body > *').remove();
	        	    $('body').css("font-weight","bold").css("font-family","arial,sans-serif").css("color","#707173").css("background-color","#ddf3f7").append(
	        		    	$('<div>').attr("id", "topbanner").css("font-size","50px").css("text-align","center").css("height","125px")
	        		    	.append(
	        		    			$('<span>').append(
	        		    					"FLUGHAFEN / AIRPORT"
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
	        				$('<table>').attr("id", "mainTable_air").addClass("dolomit_table")
	        						.append( 
	        								$('<thead>').append(
				        						$('<tr>').css('text-align','left').css('padding-bottom','10px')
		        								.append(
		        										$('<th>').append("FLUG /").append("<br>").append("FLIGHT")
		        								)
		        								.append(
		        										$('<th>').append("NACH /").append("<br>").append("TO")
		        								)
		        								.append(
		        										$('<th>').append("ABFLUG /").append("<br>").append("DEPARTURE")
		        								)
		        								.append(
		        										$('<th>').append("TERMINAL /").append("<br>").append("TERMINAL")
		        								)
		        								.append(
		        										$('<th>').append("AKTUELL /").append("<br>").append("CURRENT")
		        								)
	        								)
	        						)
	        						.append(
		        						$('<tbody>')
		        					)
        					)
	        		);
	        	    $('body').append(
	        		    	$('<div>').attr("id", "banner").css("position","absolute").css("bottom","0").addClass("bannerDiv").append(
	        		    			$('<img>').css("border", "0px").attr("src", "images/templates/traffic/Leiste-Dolomit-Monitor-HBF-Abfahrtszeiten.jpg")
	        		    			)
	        	    );		        		
	        		var max=0;
					$.each(data.allObjects, function(i, element){
						if(max<limit && element.timeShift>40){
							$('.dolomit_table tbody')
								.append(
										$('<tr>').addClass("line")
																		
										.append(
												$('<td>').append(element.train)
										)
										.append(
												$('<td>').append(element.target)
										)
											.append(
												$('<td>').append(element.timeString)
										)
											.append(
												$('<td>').append(element.platform)
										)
											.append(
												$('<td>').append(element.ris)
										)
								 );
							max++;
							}
						});
				/*	$('#mainTable').append(
							$('<tr>').addClass("line")
							.append(
								$('<td>').attr("colspan", "6").css("font-size","30px").css("text-align","center").append(
										"Aktuelle Zeit: "+data.time
								)
							)						
						);		
				*/			
					 tablecloth();
					 splitTable($("#mainTable_air"), 1620);
					 $("#mainTable_air").css("display", "none");
					 $('#table_0').css('display', 'table')
					 $.each($("#mainTable_air"), function(i, element){
						 setTimeout("$('#mainTable_air').css('display', 'none');$('#table_'+"+(i+1)+").css('display', 'table')", 7500*(i+1)); 
					 });
	            });		
	}
	traffic();
	//$.refreshId = setInterval(traffic, 10000);
            
});
