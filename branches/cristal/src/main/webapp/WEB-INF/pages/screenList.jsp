<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="screenList.title"/></title>
    <meta name="heading" content="<fmt:message key='screenList.heading'/>"/>
    <meta name="menu" content="MonitorMenu"/>
</head>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editScreen.html?method=Add&from=list"/>'"
        value="<fmt:message key="button.add"/>"/>
    
    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="screens" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="screens" pagesize="25" class="table table-condensed table-hover table-striped table-bordered table-striped table-bordered table-striped table-bordered" export="true">
    <display:column property="cronExpression" escapeXml="true" sortable="true" titleKey="screen.cronExpression" style="width: 25%"
        url="/editScreen.html?from=list" paramId="id" paramProperty="id"/>

    <display:column property="template.name" escapeXml="true" sortable="true" titleKey="template.name" style="width: 34%"/>


    <display:setProperty name="paging.banner.item_name" value="screen"/>
    <display:setProperty name="paging.banner.items_name" value="screens"/>

    <display:setProperty name="export.excel.filename" value="screen List.xls"/>
    <display:setProperty name="export.csv.filename" value="screen List.csv"/>
    <display:setProperty name="export.pdf.filename" value="screen List.pdf"/>
</display:table>

<c:out value="${buttons}" escapeXml="false" />
