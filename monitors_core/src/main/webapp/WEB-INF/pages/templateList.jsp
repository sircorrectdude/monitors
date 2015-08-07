<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="templateList.title"/></title>
    <meta name="heading" content="<fmt:message key='templateList.heading'/>"/>
   <meta name="menu" content="MonitorMenu"/>
    <script type="text/javascript" src="scripts/thickbox-compressed.js"></script>
	<link media="screen" rel="stylesheet" type="text/css" href="<c:url value='styles/thickbox.css'/>" />     
</head>

<c:set var="buttons">
<p style="float:right;">
    <input type="button" style="margin-right: 5px" class="btn btn-primary"
        onclick="location.href='<c:url value="/editTemplate.html?method=Add&from=list"/>'"
        value="<fmt:message key="button.add"/>"/>
    
   <!--  <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
    -->
    </p>
</c:set>
<%--
<c:out value="${buttons}" escapeXml="false" />
 --%>
<display:table name="templates" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="template" pagesize="10" class="table table-condensed table-hover table-striped table-bordered" export="true">
   	<display:column property="name" escapeXml="true" sortable="true" titleKey="template.name" style="width: 25%"
       	url="/editTemplate.html?from=list" paramId="template.id" paramProperty="id"/>
    <display:setProperty name="paging.banner.item_name" value="template"/>
    <display:setProperty name="paging.banner.items_name" value="templates"/>

    <display:setProperty name="export.excel.filename" value="Template List.xls"/>
    <display:setProperty name="export.csv.filename" value="Template List.csv"/>
    <display:setProperty name="export.pdf.filename" value="Template List.pdf"/>
</display:table>

<c:out value="${buttons}" escapeXml="false" />

