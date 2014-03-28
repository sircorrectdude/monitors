jQuery(document).ready(function () {
	
	$("head").append($("<link rel='stylesheet' href='styles/welcome_slideshow.css' type='text/css' media='screen' />"));

	$('#slideshow').empty()
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide1.jpg", "width":"1920", "height":"925"})	)
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide2.jpg", "width":"1920", "height":"925"})	)
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide3-1.jpg", "width":"1920", "height":"925"})	)
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide4.jpg", "width":"1920", "height":"925"})	)
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide5_fb.png", "width":"1920", "height":"925"})	)
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide6_neu.jpg", "width":"1920", "height":"925"})	)
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide7.jpg", "width":"1920", "height":"925"})	)	
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide12.jpg", "width":"1920", "height":"925"})	)	
	
	if(new Date().between(Date.today().set({month: 2, day: 28, hour: 08, minute: 00}), Date.today().set({month: 2, day: 30, hour: 15, minute: 00}))){
		$('#slideshow')
		.append($("<img />",  {"src": "images/display-quer-zeitumstellung-cristal.jpg", "width":"1920", "height":"925"})	)
	}	

	//var huettenAdStartTime = {month: 10, day: 01, hour: 08, minute: 00};
	//var huettenAdStart = Date.today().set(huettenAdStartTime);
	
	//var huettenAdEndTime = {year: 2014, month: 01, day: 28, hour: 22, minute: 00};
	//var huettenAdEnd = Date.today().set(huettenAdEndTime);
	
	//if(new Date().between(huettenAdStart, huettenAdEnd)){
		$('#slideshow')
		.append($("<img />",  {"src": "images/huettenzauber/Cristal-Rezeptions-Display-60Zoll-Fondueessen-2014-1.jpg", "width":"1920", "height":"925"})	)
		.append($("<img />",  {"src": "images/huettenzauber/Cristal-Rezeptions-Display-60Zoll-Fondueessen-2014-2.jpg", "width":"1920", "height":"925"})	)
		.append($("<img />",  {"src": "images/huettenzauber/Cristal-Rezeptions-Display-60Zoll-Fondueessen-2014-3.jpg", "width":"1920", "height":"925"})	)
	//}	
	
	/*
	var easterAdEndTime = {month: 4, day: 5, hour: 22, minute: 00};
	var easterAdEnd = Date.today().set(easterAdEndTime);

	if(new Date().compareTo(easterAdEnd) ==1 ){// greater
		$('#easterAd').remove();
	}
	*/
	
	$('#slideshow').cycle({
	    fx:     'turnDown, fade, growX, growY, turnUp, turnDown,turnLeft,turnRight ',
	    timeout: 10000,
	    speed:   2000
	});
	
    $("<div/>", {"id": "fb_counter"}).prependTo('#main').css('position','absolute').css('top','619px').css('left','903px').show();
	//$("#fb_counter").css("padding", "250px 0px 0px 1050px")
    
	var getLikes = function() {
		$.getJSON('https://graph.facebook.com/cristalhotel', function(json) {
			
			  $start_likes =json.likes
			  
			  //$('#likesCountWrapper').attr("value",json.likes);
			  $("#fb_counter").flipCounter({
				number:$start_likes, 
				imagePath:"images/templates/likescreen/Like-Zahlen_90.png",
				digitHeight:160,
				digitWidth:64, 
				formatNumberOptions:{
					format:"###,###,###",
					locale:"de"
					}
				});
			  //.flipCounter("setNumber",json.likes);
			  
		});	
	}
	
	 getLikes();
	 $(document).everyTime('60s', 'getLikes', getLikes, 0);

    $.getJSON('openweather?days=2',function(data){
    	//data.days[0].dateString
    	$('.weather_today').css('padding-top','20px').css('padding-left','20px')
			.append($('<div>').css('font-weight','bold').css("padding-bottom", "10px").append(data.days[0].name+ " "+data.days[0].dateString))
			.append($('<div>').css("float", "left").append($('<img>').attr('src', "images/Wetter-Icons_181212/"+data.days[0].midayImg+".jpg")))
			.append($('<div>').css('font-style','italic').css("padding-left", "120px").append(data.days[0].miday+" °C / ").append(data.days[0].midayF+" °F "))
			.append($('<div>').css('font-style','italic').css("padding-left", "120px").append(data.days[0].midayPc+"%"))    	
    			//.append($('<img>').attr('src', "images/Wetter-Icons_181212/"+data.days[0].midayImg+".jpg"))
       
    
		$('.weather_tomorrow').css('padding-top','20px').css('padding-left','20px')
			.append($('<div>').css('font-weight','bold').css("padding-bottom", "10px").append(data.days[1].name+ " "+data.days[1].dateString))
			.append($('<div>').css("float", "left").append($('<img>').attr('src', "images/Wetter-Icons_181212/"+data.days[1].midayImg+".jpg")))
			.append($('<div>').css('font-style','italic').css("padding-left", "120px").append(data.days[1].miday+" °C / ").append(data.days[1].midayF+" °F "))
			.append($('<div>').css('font-style','italic').css("padding-left", "120px").append(data.days[1].midayPc+"%"))   
			//.append($('<img>').attr('src', "images/Wetter-Icons_181212/"+data.days[1].midayImg+".jpg"))
		});	
	
});	
