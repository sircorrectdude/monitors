<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
    <sj:head />
	<sb:head includeScripts="true" includeScriptsValidation="true" includeStyles="false"/>
	<link rel="stylesheet" href="<s:url value="/styles/bootstrap/bootstrap.css" />" type="text/css"/>
        <%@ include file="/common/meta.jsp" %>
        <title><decorator:title/> | <fmt:message key="webapp.name"/></title>

        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/theme.css'/>" />
       <!--  <link rel="stylesheet" type="text/css" media="print" href="<c:url value='/styles/${appConfig["csstheme"]}/print.css'/>" />
		<script type="text/javascript" src="<c:url value='/scripts/bootstrap/bootstrap.js'/>" ></script> 
 -->
        <decorator:head/>
    </head>
<body<decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>

    <div class="container">
        <div id="header" class="clearfix">
            <jsp:include page="/common/header.jsp"/>
        <div class="nav">
            <div class="navbar">
                <h2 class="accessibility">Navigation</h2>
                <jsp:include page="/common/menu.jsp"/>
            </div>
        </div><!-- end nav -->
        </div>


        <div id="content" class="clearfix">
            <c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>
            <c:if test="${currentMenu == 'AdminMenu'}">
            <div id="sub">
                <menu:useMenuDisplayer name="Velocity" config="cssVerticalMenu.vm" permissions="rolesAdapter">
                    <menu:displayMenu name="AdminMenu"/>
                </menu:useMenuDisplayer>
            </div>
            </c:if>
            
            <div id="main">
	            <div class="row">
		            <div class="col-md-12">
		                <%@ include file="/common/messages.jsp" %>
		            	<div class="clear"></div>
		                <h1><decorator:getProperty property="meta.heading"/></h1>
		            </div>
	            </div>
	            <div class="row">
	                <decorator:body/>
	            </div>
	         </div>
        </div>

        <div id="footer" class="clearfix">
            <jsp:include page="/common/footer.jsp"/>
        </div>
    </div>
</body>
</html>
