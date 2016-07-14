<%@ include file="/common/taglibs.jsp"%>


<head>

    <title><fmt:message key="floorList.title"/></title>
    <meta name="heading" content="<fmt:message key='floorList.heading'/>"/>
   <meta name="menu" content="MonitorMenu"/>
<script type="text/javascript" src="scripts/jquery.form.js"></script>
</head>

<s:url action="carparkHistory" id="carparkHistoryUrl" />
<s:a title="View History"  href="%{carparkHistoryUrl}">View History</s:a><br/>


<div id="updateCarparkFormContent">
	 <%@ include file="updateCarparkForm.jsp" %>
</div>

<display:table name="floors" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="floor" pagesize="25" class="table table-condensed table-hover table-striped table-bordered table-striped table-bordered table-striped table-bordered" export="true">
    <display:column property="name" escapeXml="true" sortable="true" titleKey="floor.name" style="width: 20%"/>
    <%--
    <display:column property="places" escapeXml="true" sortable="false" titleKey="floor.places" style="width: 10%"/>
	 --%>
	 <display:column title="" style="width: 10%">
	 		<div id="floorPlacesContent_${floor.id}">
			 <%@ include file="floorPlacesForm.jsp" %>
		</div>
	 </display:column>
	 
	<display:column  property="placesLeft" escapeXml="true" sortable="true" titleKey="floor.placesLeft" style="width: 10%">
	</display:column>
	
	<display:column title="" style="width: 60%">
	
	
		<div id="floorStateContent_${floor.id}">
			 <%@ include file="floorStateForm.jsp" %>
		</div>
</display:column>

    <display:setProperty name="paging.banner.item_name" value="floor"/>
    <display:setProperty name="paging.banner.items_name" value="floors"/>

    <display:setProperty name="export.excel.filename" value="Floor List.xls"/>
    <display:setProperty name="export.csv.filename" value="Floor List.csv"/>
    <display:setProperty name="export.pdf.filename" value="Floor List.pdf"/>
</display:table>

<!--
<c:out value="${buttons}" escapeXml="false" />
-->

