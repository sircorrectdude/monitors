jQuery(document).ready(function () {
	 $.getStylesheet = function (href) {

        $('link[href="'+href+'"]').attr('disabled', 'disabled');
        $('link[href="'+href+'"]').remove();

	    var $d = $.Deferred();
	    var $link = $('<link/>', {
	       rel: 'stylesheet',
	       type: 'text/css',
	       href: href
	    }).appendTo('head');
	    $d.resolve($link);
	    return $d.promise();
	  };

	  	$('head').append('<link rel="stylesheet" href="styles/textaNarrowMedium.css" type="text/css" />');
		$('body').append(
				$('<div>').attr("id", "defaultCountdown").css('width', '100%').css('height', '300px').css("background-color","transparent").css('margin-top', '500px').css('margin-left', '200px').css('text-align', 'left	')
				.css('font-size', '150px').css("font-family","texta_narrowmedium").css("border","0").css("color","#0a6b37").css('z-index', '10'));
		
		clearInterval($.intervalId);
		$.when($.getStylesheet('scripts/countdown/jquery.countdown.css'), $.getScript('scripts/countdown/jquery.plugin.min.js'), $.getScript('scripts/countdown/jquery.countdown.min.js'))
			.then(function () {
				$.intervalId = setInterval(function(){
			      signal();
			    },1000);
			}, function () {
	  			//console.log('an error occurred somewhere');
		});
	
	function signal(){
	    $.getJSON(
            'signal',
            function( data ){
            	console.log(data)
            	if(data > 10){
					$('body').css("background","url('images/signal/countdown_sixt.jpg')")
					$('#defaultCountdown').show();
            		
				  $(function(){
					//now = new Date(new Date().getTime() + data*1000);
				    //console.log(now)
				    $('#defaultCountdown').countdown({
				    	until: data, 
				    	format: 'MS',
				    	compact: true,
				    	onExpiry: liftOff});
				  });	            	
	            }else if(data<=10 && data != 0){
	            	$('body').css("background","url('images/signal/start_sixt.jpg')");
	            	liftOff();
	            }else{
					$('body').css("background","url('images/signal/drive_sixt.jpg')");
					liftOff();
            	}
		});
	            
	}

	function liftOff() {
		$('#defaultCountdown').countdown('destroy') ;
		//$('#defaultCountdown').hide();
	    //console.log('We have lift off!'); 
	} 
	
});