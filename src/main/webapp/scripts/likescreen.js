       
$(document).ready(function() {
	
	$(document).stopTime('reloadPage');
	$(document).everyTime('600s', 'reloadPage', reloadPage, 0, true);
	
	//$('body').css("background-color", "transparent")
	$('body').css("background-image", "url(images/templates/likescreen/Monitor-Lobby_Likescreen-301112.png)")
	$("<div/>", {"id": "counter"}).appendTo('body');
	$("#counter").css("padding", "350px 0px 0px 1350px")
	$recent_likes=1;
	$start_likes=0;
	var getLikes = function() {
		$recent_likes = $start_likes;        		
		$.getJSON('https://graph.facebook.com/cristalhotel', function(json) {
			
			  $start_likes =json.likes
			  
			  //$('#likesCountWrapper').attr("value",json.likes);
			  $("#counter").flipCounter("startAnimation",{
				number:$recent_likes, 
				end_number: $start_likes, 
				duration: 500, 
				imagePath:"images/templates/likescreen/flipCounter-medium.png",
				digitHeight:80,
				digitWidth:60, 
				formatNumberOptions:{
					format:"###,###,###",
					locale:"de"
					}
				});
			  //.flipCounter("setNumber",json.likes);
			  
		});
	
	};
	
	 getLikes();
	 $(document).everyTime('10s', 'getLikes', getLikes, 0);
});
