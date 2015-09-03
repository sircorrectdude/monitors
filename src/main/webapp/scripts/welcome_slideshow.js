jQuery(document).ready(function () {
	
	$("head").append($("<link rel='stylesheet' href='styles/welcome_slideshow.css' type='text/css' media='screen' />"));

	$('#slideshow').empty()
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide1.jpg", "width":"1920", "height":"925"}))
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide2.jpg", "width":"1920", "height":"925"}))
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide3-1.jpg", "width":"1920", "height":"925"}))
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide4.jpg", "width":"1920", "height":"925"})	)
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide5_fb.png", "width":"1920", "height":"925"}))
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/Cristal-Rezeptions-Display-Zimmer-011414.jpg", "width":"1920", "height":"925"}))
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/Cristal-Rezeptions-Display-Bewertung.jpg", "width":"1920", "height":"925"}))	
	.append($("<img />",  {"src": "images/templates/welcome_slideshow/slide12.jpg", "width":"1920", "height":"925"}))
	.append($("<img />",  {"src": "images/Monitor-quer-Werbung-MuenchnerStubn.jpg", "width":"1920", "height":"925"}));
	if(new Date().between(Date.today().set({year: 2015, month: 8, day: 1, hour: 20, minute: 00}), Date.today().set({year: 2015, month: 8, day: 20, hour: 18, minute: 00}))){
		$('#slideshow').append($("<img />",  {"src": "images/umzuege/Cristal-Rezeptions-Display-Wiesn-Umzuege-dt.jpg", "width":"1920", "height":"925"})	)
		$('#slideshow').append($("<img />",  {"src": "images/umzuege/Cristal-Rezeptions-Display-Wiesn-Umzuege-engl.jpg", "width":"1920", "height":"925"})	)

	}

	
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
		$.getJSON('https://graph.facebook.com/cristalhotel?access_token=CAADMgm9xZC7IBALrA05fCsZBDrWJddIYZCZBs3ShU5pMZCZAas7AcKlIzZAmmA3dXKtPMzqKkAJEqL4R30AWb32VnMhIBz9MeVnmSJVSA4wZAMuD1GMrqEQpb7CnqxupYeEyHUsw4i3yN8HZBCZA3SrVmpr7Ial7s5hq9v6D6150mIvklFPCaQU5ZA8Jwa3HZC8IDKyBXloZAkTBZCU4gU34SYvOmI', function(json) {
			
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
