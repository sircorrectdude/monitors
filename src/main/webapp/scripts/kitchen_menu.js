
jQuery(document).ready(function () {
	 $.getStylesheet = function (href) {
	    var $d = $.Deferred();
	    var $link = $('<link/>', {
	       rel: 'stylesheet',
	       type: 'text/css',
	       href: href
	    }).appendTo('head');
	    $d.resolve($link);
	    return $d.promise();
	  };


		//$.when($.getScript('scripts/scheduler/hogan-3.0.1.js'), $.getStylesheet('scripts/scheduler/scheduler.css'), $.getScript('scripts/scheduler/scheduler.js'), $.getScript('scripts/kitchen_calendar.js'))
		//$.when($.getStylesheet('scripts/fullcalendar4/daygrid/main.css'), $.getStylesheet('scripts/fullcalendar4/core/main.css'), $.getScript('scripts/fullcalendar4/core/main.min.js'), $.getScript('scripts/fullcalendar4/daygrid/main.min.js'), $.getScript('scripts/kitchen_calendar.js'))
        //$.when($.getStylesheet('scripts/graspSchedule.css'),$.getScript('scripts/jquery.graspSchedule.js'), $.getScript('scripts/kitchen_calendar.js'))
        $.when($.getScript('http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js'),$.getStylesheet('scripts/jquery.timeline.css'),$.getScript('scripts/jquery.timeline.js'),$.getStylesheet('scripts/customtimeline.css'))

			.then(function () {


                $("body").append("<div id='demo'></div>");
                $("body").css("overflow", "visible")

                /*
                $.getJSON("/json/kitchenMenu.html", function(data){
                  $('#demo').graspSchedule(data);
                });
                */

                        $.getJSON('/json/kitchenMenu.html',function(json){
                            console.log(json)
                            if ( json.data.length == 0 ) {
                                 $("body").append("<div class='noeventdiv' id='info'><h1>No Events today</h1></div>");
                            }
                            else{
                                $("#demo").timeline({
                                    data: json.data
                                });
                            }

                        });


			}, function (error) {
	  			 console.error('I am an error', error);
		});





});