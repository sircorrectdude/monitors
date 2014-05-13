var all_script = document.createElement('script');
  all_script.type = 'text/javascript';
  all_script.src = "/scripts/tablecloth/tablecloth.js";
  document.body.appendChild(all_script);
jQuery(document).ready(function () {
	
	function traffic(){
	    $.getJSON(
	            'traffic?mvg=true&db=true&air=true',
	            function( data )
	            {
	            	var limit=29;
	            	$('#mainTable').remove();
	        		$('body').append(
	        				$('<table>').attr("id", "mainTable").attr("style", "padding:10px;")
	        				.append(
        						$('<tr>').css('text-align','left').css('padding-bottom','10px').append(
        								$('<th>').css("width","50px").append("&nbsp;")
        								)
        								.append(
        								$('<th>').append("Zeit")
        								)
        								.append(
        								$('<th>').append("Linie")
        								)
        								.append(
        								$('<th>').append("Nach")
        								)
        								.append(
        								$('<th>').append("Gleis")
        								)
        								.append(
        								$('<th>').append("Aktuelles")
        								)
        						)
	        		);
	        		var max=0;
					$.each(data.allObjects, function(i, element){
						if(max<limit){
							$('#mainTable')
								.append(
										$('<tr>').addClass("line")
											.append(
												$('<td>').append(
														$('<img>').css("width", "50px").css("height", "25px").attr("src", element.image)
												)
										)							
											.append(
												$('<td>').append(element.timeString)
										)
											.append(
												$('<td>').append(element.train)
										)
											.append(
												$('<td>').append(element.target)
										)
											.append(
												$('<td>').append(element.platform)
										)
											.append(
												$('<td>').append(element.ris)
										)
								 );
							}
						max++;
						});
					$('#mainTable').append(
							$('<tr>').addClass("line")
							.append(
								$('<td>').attr("colspan", "6").css("font-size","30px").css("text-align","center").append(
										"Aktuelle Zeit: "+data.time
								)
							)						
						);					
	            });		
	}
	traffic();
	var refreshId = setInterval(traffic, 10000);
            
});
