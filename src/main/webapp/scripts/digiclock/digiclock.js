 $(document).ready(function(){

	$('#digiclock').append($('<img/>').addClass('time').attr('src','/scripts/digiclock/nums2_small.png').attr('id','hourl'))
	$('#digiclock').append($('<img/>').addClass('time').attr('src','/scripts/digiclock/nums10_small.png').attr('id','hourr'))
	$('#digiclock').append($('<img/>').addClass('time').attr('src','/scripts/digiclock/colon_small.png'))
	$('#digiclock').append($('<img/>').addClass('time').attr('src','/scripts/digiclock/nums6_small.png').attr('id','minl'))
	$('#digiclock').append($('<img/>').addClass('time').attr('src','/scripts/digiclock/nums10_small.png').attr('id','minr'))

	$('#digiclock').append($('<div/>').css('clear','left'))
	$('#digiclock').append($('<div/>').attr('id','cover'))

    $('#digiclock').animate({opacity: 0.0}, 0);
    

    function checktime(prevhour,prevmins,prevsecs){

      var now = new Date();

      var hour = now.getHours();
      if(hour < 10) hour = "0" + hour;

      var mins = now.getMinutes();
      if(mins < 10) mins = "0" + mins;

	var secs = now.getSeconds();
	if(secs < 10) secs = "0" + secs;  

      var hour = hour + "";
      var mins = mins + "";
	var secs = secs + "";

      if(prevhour != hour) {

        var prevhour = prevhour + ""
        var hoursplit = hour.split("");
        var prevhoursplit = prevhour.split("");

        if(prevhoursplit[0] != hoursplit[0]) numberflip('#hourl',hoursplit[0]);
        if(prevhoursplit[1] != hoursplit[1]) numberflip('#hourr',hoursplit[1]);

      };

      if(prevmins != mins) {

        var prevmins = prevmins + ""
        var minsplit = mins.split("");
        var prevminsplit = prevmins.split("");

        if(prevminsplit[0] != minsplit[0]) numberflip('#minl',minsplit[0]);
        if(prevminsplit[1] != minsplit[1]) numberflip('#minr',minsplit[1]);

      };

      if(prevsecs != secs) {

        var prevsecs = prevsecs + ""
        var secsplit = secs.split("");
        var prevsecsplit = prevsecs.split("");

        if(prevsecsplit[0] != secsplit[0]) numberflip('#secl',secsplit[0]);
        if(prevsecsplit[1] != secsplit[1]) numberflip('#secr',secsplit[1]);

      };



      function numberflip(which,number){

		if(number != 0) $(which).animate({marginTop: '-'+parseInt((number*70),10)+'px'}, 250, 'linear');

		if(number == 0) {

              var getmargin = parseInt(($(which).css('margin-top')), 10);

              $(which).animate({marginTop: parseInt((getmargin-70),10)+'px'}, 250, 'linear', function(){
                $(this).css("margin-top","0px")
		  });

            };

      };

      setTimeout(function(){checktime(hour,mins,secs);}, 200);

    };

    checktime(00,00,00);

    $('#digiclock').animate({opacity: 1.0}, 1000);

  });
