var all_script = document.createElement('script');
  all_script.type = 'text/javascript';
  all_script.src = "/scripts/tablecloth/tablecloth.js";
  document.body.appendChild(all_script);


jQuery(document).ready(function () {

    $.getJSON(
            'openweather',
            function( data )
            {

            	$('#text_1day').text(data.days[0].name);
				$('#text_2day').text(data.days[1].name);
				$('#text_3day').text(data.days[2].name);
				
				$('#text_1date').text(data.days[0].dateString);
				$('#text_2date').text(data.days[1].dateString);
				$('#text_3date').text(data.days[2].dateString);
				
				$('#img_1day_morning').attr('src', "images/icons/"+data.days[0].morningImg+".jpg");
				$('#img_1day_miday').attr('src', "images/icons/"+data.days[0].midayImg+".jpg");
				$('#img_1day_evening').attr('src', "images/icons/"+data.days[0].eveningImg+".jpg");

				$('#deg_1day_morning').text(data.days[0].morning+" °C ");
				$('#deg_1day_miday').text(data.days[0].miday+" °C ");
				$('#deg_1day_evening').text(data.days[0].evening+" °C ");

				$('#img_2day_morning').attr('src', "images/icons/"+data.days[1].morningImg+".jpg");
				$('#img_2day_miday').attr('src', "images/icons/"+data.days[1].midayImg+".jpg");
				$('#img_2day_evening').attr('src', "images/icons/"+data.days[1].eveningImg+".jpg");

				$('#deg_2day_morning').text(data.days[1].morning+" °C ");
				$('#deg_2day_miday').text(data.days[1].miday+" °C ");
				$('#deg_2day_evening').text(data.days[1].evening+" °C ");
				
				
				$('#img_3day_morning').attr('src', "images/icons/"+data.days[2].morningImg+".jpg");
				$('#img_3day_miday').attr('src', "images/icons/"+data.days[2].midayImg+".jpg");
				$('#img_3day_evening').attr('src', "images/icons/"+data.days[2].eveningImg+".jpg");

				$('#deg_3day_morning').text(data.days[2].morning+" °C ");
				$('#deg_3day_miday').text(data.days[2].miday+" °C ");
				$('#deg_3day_evening').text(data.days[2].evening+" °C ");

				
            })
	
});
