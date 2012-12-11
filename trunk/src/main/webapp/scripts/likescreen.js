       
$(document).ready(function() {
	$('body').css("background-color", "transparent")
	$('body').css("background-image", "url(images/templates/likescreen/Monitor-Lobby_Likescreen-301112.png)")
	$("<div/>", {"id": "counter"}).appendTo('body');
	$("#counter").css("padding", "350px 0px 0px 1350px")
	$recent_likes=$.cookie('recent_likes');
	$start_likes=$.cookie('start_likes');
	console.log($.cookie('recent_likes'))
	console.log($.cookie('start_likes'))
	var getLikes = function() {
		$.getJSON('https://graph.facebook.com/cristalhotel', function(json) {
			
			  $start_likes =json.likes
			  $.cookie('start_likes', $start_likes)
			  //$('#likesCountWrapper').attr("value",json.likes);
			  	console.log($recent_likes)
			  	console.log($start_likes)
			  	//if($recent_likes != $start_likes){
			  		$.cookie('recent_likes', $start_likes);   
			  		$recent_likes=$.cookie('recent_likes');
				  $("#counter").flipCounter("startAnimation",{
					number: $recent_likes-1, 
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
				//}	
			  //.flipCounter("setNumber",json.likes);
			  
		});
	
	};
	
	 getLikes();
	 $(document).everyTime('30s', 'getLikes', getLikes, 0);
});
