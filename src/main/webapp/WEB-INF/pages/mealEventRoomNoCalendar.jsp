<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
		<sj:head/>
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/theme.css'/>" />
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

                </style>
    </head>
    <body>
		            	<s:if test="hasActionErrors()">
                       <div class="alert alert-success">
                          <s:actionerror/>
                       </div>
                    </s:if>
	</body>
</html>