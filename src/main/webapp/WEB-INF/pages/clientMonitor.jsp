<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
		<sj:head/>
    	<!-- meta http-equiv="refresh" content="${refresh}" -->
    	<meta name="description" content="IP Address of Client <c:out value="${remoteAddr}"/>">
		 <link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/styles/default-screen.css'/>?v=0.1.1" />
		<script type="text/javascript" src="/scripts/jquery.timers.js" ></script>
		<script type="text/javascript" src="/scripts/jquery.cookie.js" ></script>
		<link href="<c:url value='/scripts/tablecloth/tablecloth.css'/>" rel="stylesheet" type="text/css" media="screen" />
		<style type="text/css">
				html,body {
				
					overflow:hidden;
					cursor: none;
					background-color: ${backgroundColor}; //#b3d2de 
					
				}
		</style>
		<script type="text/javascript">
			$.cookie('switchAdToggle', 0);
			$(document).everyTime('${refresh}s', 'reloadPage', reloadPage, 0, true);
			//$(document).everyTime('600s', 'allrefresh', function(){window.location = "clientMonitor.html";}, 0, true);
			function reloadPage() {
			    $.ajax({
			        url:'clientMonitor.html',
			        type:'HEAD',
			        success:  function() { 
					    $.ajax({
					        url:'ajax/clientMonitorContent.html',
					        type:'GET',
					        cache: false,
					        success:  function(data) { 
					        			//$.cookie('my_cookie_name', 'value inside of it');
					        			//$.cookie('lastScreenIdCookie', 'value inside of it');
					        			clearInterval($.refreshId);
						        			$(data).filter('script').each(
						        					function(){ $.globalEval(this.text || this.textContent || this.innerHTML || ''); }
						        			);
						        			//$("body").fadeOut(500);
						        			$('body > *').remove();
						        			$('body').attr("style", "");
					        			/*window.setTimeout(function() {
					        			}, 5000);
					        			*/
					        			//jQuery.globalEval($(data).find("script").text());
					        			//$("body").fadeOut(500);
					        			$("body").fadeIn(500);
					        			$("body").append(data);
					        }
					    })
					    
			        }
			    })
			}

		</script>		
    </head>
    <body style="display:none" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
		<s:include value="clientMonitorContent.jsp"></s:include>
	</body>
</html>