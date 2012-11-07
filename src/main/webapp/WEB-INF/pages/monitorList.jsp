<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="monitorList.title"/></title>
    <meta name="heading" content="<fmt:message key='monitorList.heading'/>"/>
    <meta name="menu" content="MonitorMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editMonitor.html?method=Add&from=list"/>'"
        value="<fmt:message key="button.add"/>"/>
    
    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="monitors" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="monitors" pagesize="25" class="table" export="true">
    <display:column property="ipAddress" escapeXml="true" sortable="true" titleKey="monitor.ipAddress" style="width: 25%"
        url="/editMonitor.html?from=list" paramId="id" paramProperty="id"/>
    <display:column property="alias" escapeXml="true" sortable="true" titleKey="monitor.alias" style="width: 34%"/>

    <display:column property="course" url="/http://localhost:8080/editCourse.html?from=list" paramId="id" paramProperty="course.id" escapeXml="true" sortable="true" titleKey="course.name" style="width: 34%"/>


    <display:setProperty name="paging.banner.item_name" value="monitor"/>
    <display:setProperty name="paging.banner.items_name" value="monitors"/>

    <display:setProperty name="export.excel.filename" value="Monitor List.xls"/>
    <display:setProperty name="export.csv.filename" value="Monitor List.csv"/>
    <display:setProperty name="export.pdf.filename" value="Monitor List.pdf"/>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

<script type="text/javascript">
    highlightTableRows("monitors");
</script>
