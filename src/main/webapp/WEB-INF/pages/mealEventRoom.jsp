<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
		<sj:head/>
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/theme.css'/>" />
        <script type="text/javascript" src="scripts/jquery.form.js"></script>
        <script type="text/javascript" src="scripts/jquery.blockUI.js"></script>
    </head>
    <body>



Willkommen bei Veranstaltung <s:property value="runningCalendar.subject"/>. In Raum <s:property value="runningCalendar.color.name"/>

    <span> Please Choose one of the following main courses: </span><br/>

<%@ include file="addMealCourseForm.jsp" %>


	</body>
</html>