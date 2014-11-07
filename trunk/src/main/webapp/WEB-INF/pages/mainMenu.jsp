<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="mainMenu.title"/></title>
    <meta name="menu" content="MainMenu"/>
</head>

	<div class="container">
<div class="jumbotron">
		<h1>
			<fmt:message key='mainMenu.heading' />
		</h1>
		<p>
			<fmt:message key="mainMenu.message" />
		</p>
		<p>
			<a href="<c:url value='/templateType.html'/>" class="btn btn-primary btn-lg" role="button">Bildschirm
				einrichten</a>
		</p>
	</div>
</div>


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
