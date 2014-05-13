<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="mainMenu.title"/></title>
    <meta name="heading" content="<fmt:message key='mainMenu.heading'/>"/>
    <meta name="menu" content="MainMenu"/>
</head>

<p><fmt:message key="mainMenu.message"/></p>

<div class="separator"></div>

<ul class="glassList">
    <li>
        <a href="<c:url value='/monitors.html'/>"><fmt:message key="menu.monitorList"/></a>
    </li>
    <li>
        <a href="<c:url value='/courses.html'/>"><fmt:message key="menu.courseList"/></a>
    </li>          
    <li>
        <a href="<c:url value='/templates.html'/>"><fmt:message key="menu.templateList"/></a>
    </li>    
</ul>
