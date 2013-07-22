jQuery(document).ready(function () {

	$.getScript("scripts/date/date-de-DE.js", function(data, textStatus, jqxhr) {
		   var timerStartTime = {month: 6, day: 22, hour: 22, minute: 50};
		   var timerStart = Date.today().set(timerStartTime);
		   
		   var timerEndTime = {month: 6, day: 25, hour: 11, minute: 00};
		   var timerEnd = Date.today().set(timerEndTime);		
	
	
	function switchEmptyPage() {
		$('body > div').remove();
		if($.switchToggle ==1){
			$('body').css("color", "#838486").css("background","url('images/templates/rooms/single_room_hd_ready_slide.jpg')").css("height", "768px").css("width", "1366px")
	    	$('body').append(
	    			$('<div>')
	    				.css("text-align","center")		            			
		            				.css("font","175px Arial, sans-serif")
		            				.css("padding-top", "138px")
	    				.css("text-transform", "uppercase")
	    				.css("letter-spacing", "15px")
	    				.css("text-decoration", "none")
	    				.attr("id", "roomName").append($.roomName)
	    	);
			if(new Date().between(timerStart, timerEnd)){
				var sub_logo=$('<div>').attr("id", "sub_logo").css("margin-top", "250px").css("height", "226px").css("width", "1366px").css("background-repeat", "no-repeat").css("background","url('images/templates/rooms/Monitor-Konferenzraeume-Cristal-belegt-Neu-BW.jpg')");
			}else{
				var sub_logo=$('<div>').attr("id", "sub_logo").css("margin-top", "250px").css("height", "226px").css("width", "1366px").css("background-repeat", "no-repeat").css("background","url('images/templates/rooms/single_room_hd_ready_logo.jpg')");
			}
        	$('body').append(sub_logo);			
			$.switchToggle =0;
		}else{
			if(new Date().between(timerStart, timerEnd)){
	    		$('body').css("color", "#838486").css("background","url('images/templates/rooms/single_room_hd_ready_bwalt.jpg')").css("height", "768px").css("width", "1366px")
				
			}else{
				$('body').css("color", "#838486").css("background","url('images/templates/rooms/single_room_hd_ready_neu.jpg')").css("height", "768px").css("width", "1366px")
			}
    		$('body').append(
        			$('<div>')
        				.css("font","90px Arial, sans-serif")
        				.css("padding-top", "15px")
        				.css("padding-left", "50px")
        				.css("text-transform", "uppercase")
        				.css("text-decoration", "none")
        				.attr("id", "roomName").append($.roomName)
        	);	
    		$.switchToggle =1
		}
		$(document).everyTime('10s', 'switchEmptyPage', switchEmptyPage, 0, true);
	}
	
	function rooms(){
	    $.getJSON(
	            'json/runningEvent.html',
	            function( data )
	            {      
	            	$('body > div').remove();
	            	$(document).stopTime('switchEmptyPage');
	            	if(data.runningEvent.company == null){
	            		$.switchToggle =1;
	            		$.roomName = data.runningEvent.roomName;
	            		switchEmptyPage();
	            	}
	            	else{
	        			if(new Date().between(timerStart, timerEnd)){
	        	    		$('body').css("color", "#838486").css("background","url('images/templates/rooms/single_room_hd_ready_bwalt.jpg')").css("height", "768px").css("width", "1366px")
	        				
	        			}else{
	        				$('body').css("color", "#838486").css("background","url('images/templates/rooms/single_room_hd_ready_neu.jpg')").css("height", "768px").css("width", "1366px")
	        			}		            	$('body').append(
		            			$('<div>')
		            				.css("text-align","center")		            			
		            				.css("font","175px Arial, sans-serif")
		            				//.css("padding-top", "138px")
		            				.css("letter-spacing", "15px")
		            				.css("text-transform", "uppercase")
		            				.css("text-decoration", "none")
		            				.attr("id", "roomName").append(data.runningEvent.roomName)
		            	);
		            	if("" != data.runningEvent.logo){
			            	$('body').append(
			            			$('<div>')
			            			.css("text-align","center")
			            			.css("letter-spacing","5px")
			            			.css("font","50px Arial, sans-serif")
			            			.css("padding-top", "40px")
			            			.attr("id", "logo").append($('<img>').css("height", "150px").attr("src",
											"images/"+data.runningEvent.logo
									)
								)
			            	);
		            	}
		            	var left = $('<div>')
	            			.css("letter-spacing","5px")
	            			.css("font","80px Arial, sans-serif")
	            			.css("padding-top", "40px")
	            			.css("text-transform", "uppercase")
	            			.attr("id", "subject").append(data.runningEvent.company);
		            	if("" == data.runningEvent.logo){
		            		left.css("clear", "both")
		            		left.css("text-align", "center")
		            	}else{
		            		left.css("padding-left", "100px")
		            		left.css("float", "left")
		            	}		            	
		            	$('body').append(left);
		            		
		            	var right = $('<div>')
	            			.css("letter-spacing","5px")
	            			.css("font","80px Arial, sans-serif")
	            			.css("padding-top", "40px")
	            			.attr("id", "timeString").append(data.runningEvent.timeString);
		            	if("" == data.runningEvent.logo){
		            		right.css("text-align", "center")
		            	}else{
		            		right.css("padding-right", "100px")
		            		right.css("float", "right")
		            	}
		            	$('body').append(right);
		            	
		            	//var sub_logo=$('<div>').attr("id", "sub_logo").css("height", "226px").css("width", "1366px").css("background","url('images/templates/rooms/single_room_hd_ready_logo.jpg')");
		            	//$('body').append(sub_logo);
	            	}
	            });		
	}
	rooms();	

	});
	
});
