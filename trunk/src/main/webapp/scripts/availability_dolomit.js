jQuery(document).ready(function () {

	$("head").append($("<link rel='stylesheet' href='styles/availability_dolomit.css' type='text/css' media='screen' />"));
	
	$.getJSON('/json/cBooking.html',function(data){
		if(!data.cBooking.roomsAvailable){
			$('#slideshow').empty().append(
					$("<img />",  {"src": "images/templates/availability_dolomit/welcome_dolomit.png", "width":"1920", "height":"925"})	
			);
		}else{
			$('#slideshow').empty()
			.append($("<img />",  {"src": "images/templates/availability_dolomit/slide1.png", "width":"1920", "height":"925"})	)	
			.append($("<img />",  {"src": "images/templates/availability_dolomit/slide2.png", "width":"1920", "height":"925"})	)	
			.append($("<img />",  {"src": "images/templates/availability_dolomit/slide3.png", "width":"1920", "height":"925"})	)	
		}
		$('#slideshow').cycle({
			fx:     'all',
			timeout: 10000,
			speed:   2000
		});
	})
	
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
