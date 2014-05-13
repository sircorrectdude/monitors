       
$(document).ready(function() {

		
    $(document).ready(function() {
    		    $("<div/>", {"id": "digiclock"}).appendTo('body');
    		     $('#digiclock').css("position", "absolute").css("top", "0px").css("left", "220px");
        $('#digiclock').jdigiclock({
           weatherLocationCode:"EUR|DE|GM002|MUNCHEN",
           clockImagesPath:"images/templates/likescreen/clock/",
           weatherImagesPath:"images/templates/likescreen/weather/"
        });
    });
		
		
	
	//$('body').css("background-color", "transparent")
	$('body').css("background-image", "url(images/templates/likescreen/Monitor-Lobby_Likescreen-uhr.png)")
	$("<div/>", {"id": "counter"}).appendTo('body');
	$("#counter").css("padding", "250px 0px 0px 1050px")
	
	var getLikes = function() {
		$.getJSON('https://graph.facebook.com/cristalhotel', function(json) {
			                                                                                              
			  $start_likes =json.likes
			  
			  //$('#likesCountWrapper').attr("value",json.likes);
			  $("#counter").flipCounter({
				number:$start_likes, 
				imagePath:"images/templates/likescreen/Like-Zahlen.png",
				digitHeight:160,
				digitWidth:114, 
				formatNumberOptions:{
					format:"###,###,###",
					locale:"de"
					}
				});
			  //.flipCounter("setNumber",json.likes);
			  
		});	
	}
	
	 getLikes();
	 $(document).everyTime('10s', 'getLikes', getLikes, 0);
});

