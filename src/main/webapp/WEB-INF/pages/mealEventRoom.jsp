<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
		<sj:head/>
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/theme.css'/>" />
        <script type="text/javascript" src="scripts/jquery.form.js"></script>
        <script type="text/javascript" src="scripts/jquery.blockUI.js"></script>

        <style type="text/css">

    body {
 /* Location of the image */
  background-image: url(images/templates/rooms/Monitor-Konferenzraeume-Cristal-belegt-Neu.jpg);

  /* Background image is centered vertically and horizontally at all times */
  background-position: center center;

  /* Background image doesn't tile */
  background-repeat: no-repeat;

  /* Background image is fixed in the viewport so that it doesn't move when
     the content's height is greater than the image's height */
  background-attachment: fixed;

  /* This is what makes the background image rescale based
     on the container's size */
  background-size: cover;

  /* Set a background color that will be displayed
     while the background image is loading */
  background-color: #464646;
    }


input[type=text]{
                 width: 35px;
                 background: #006ecc;
                 color: #fff;
                 height: 30px;
                 -webkit-border-radius: 15px;
                 -moz-border-radius: 15px;
                 border-radius: 15px;
                 border: 1px solid #999;
             }


.disablingDiv
{
    /* Do not display it on entry */
    display: none;

    /* Display it on the layer with index 1001.
       Make sure this is the highest z-index value
       used by layers on that page */
    z-index:1001;

    /* make it cover the whole screen */
    position: absolute;
    top: 0%;
    left: 0%;
    width: 100%;
    height: 100%;

    /* make it white but fully transparent */
    background-color: white;
    opacity:.00;
    filter: alpha(opacity=00);
}

        </style>

    </head>
    <body>


    <div class="container">
            <div class="row">
               <span> Willkommen bei Veranstaltung <s:property value="runningCalendar.subject"/>. In Raum <s:property value="runningCalendar.color.name"/></span><br/>
            </div>
                  <div class="logo" style="background-image: url(../images/<s:property value="runningCalendar.description"/>);">

                  </div>
            <div class="row">
                <span> Please Choose one of the following main courses: </span><br/>
            </div>
             <div class="row">
                <%@ include file="addMealCourseForm.jsp" %>
             </div>
              <div class="row">

                        <div class="input-group clockpicker">
                            <input type="text" class="form-control" id="clockpickerInput">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-time"></span>
                            </span>
                        </div>
                        <script type="text/javascript">
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



                                $.when($.getStylesheet('scripts/clockpicker.css'),$.getScript('scripts/clockpicker.js'))

                        			.then(function () {

                                        $('.clockpicker').clockpicker({
                                            placement: 'top',
                                            align: 'left',
                                            donetext: 'Done',
                                            afterDone: function() {
                                                console.log("after done");
                                                $.getJSON('/json/updateMealEventRoomTime.html?roomId='+<s:property value="runningCalendar.color.id"/>+"&time="+$('#clockpickerInput').val(), function(json) {


                                                 console.log(json.time);
                                                 $('#clockpickerInput').val(json.time)

                                                  });

                                            }
                                        });


                                       $('#clockpickerInput').val('<s:property value="formattedMealEventTime"/>');


                        			}, function (error) {
                        	  			 console.error('I am an error', error);
                        		});
                               });
                        </script>

              </div>
    </div>
	</body>
</html>