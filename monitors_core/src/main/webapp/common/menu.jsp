<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
<ul id="primary-nav" class="menuList nav navbar-nav">
    <c:if test="${empty pageContext.request.remoteUser}"><li><a href="<c:url value="/login.jsp"/>" class="current"><fmt:message key="login.title"/></a></li></c:if>
    <menu:displayMenu name="MainMenu"/>
    <menu:displayMenu name="MonitorMenu"/>
    <menu:displayMenu name="UserMenu"/>
    <menu:displayMenu name="AdminMenu"/>
    <li class="divider-vertical"></li>
    <menu:displayMenu name="Logout"/>
</ul>
</menu:useMenuDisplayer>