<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/styles/default-screen.css'/>?v=0.1.1" />
<c:out value="${content}" escapeXml="false"/>
<script type="text/javascript">
$(document).ready(function() {
	//$(window).load(function() {
	//$("body").fadeOut(1000);
	
		$("body").fadeIn(500);
});
</script>