<%@ include file="/common/taglibs.jsp"%>


<head>

<title><fmt:message key="anprList.title" /></title>
<meta name="heading" content="<fmt:message key='anprList.heading'/>" />
<meta name="menu" content="MonitorMenu" />
<script type="text/javascript" src="scripts/jquery.form.js"></script>
</head>
	<s:form>

		<label for="startDate" >From: </label><sj:datepicker name="startDate" value="%{startDate}" parentTheme="simple" zindex="2006"
			timepicker="true" changeYear="true" displayFormat="dd.mm.yy"
			timepickerFormat="hh:mm" timepickerShowSecond="true"
			duration="fast" readonly="true" label="Start Date"></sj:datepicker>

		<label for="endDate" >To: </label><sj:datepicker name="endDate" value="%{endDate}" parentTheme="simple" zindex="2006"
			timepicker="true" changeYear="true" displayFormat="dd.mm.yy"
			timepickerFormat="hh:mm" timepickerShowSecond="true"
			duration="fast" readonly="true" label="End Date"></sj:datepicker>

<s:submit></s:submit>

	</s:form>

<display:table name="licensePlates" cellspacing="0" cellpadding="0"
	requestURI="" sort="list" defaultsort= "2" defaultorder="descending" id="floor" pagesize="50"
	class="table table-condensed table-hover table-striped table-bordered table-striped table-bordered table-striped table-bordered"
	export="true">
	<display:column property="plate" escapeXml="true" sortable="true"
		titleKey="licensePlate.plate" style="width: 25%" />
	<display:column property="timestamp" escapeXml="true" sortable="true"
		titleKey="licensePlate.timestamp" style="width: 75%" />
	<display:setProperty name="paging.banner.item_name" value="anpr" />
	<display:setProperty name="paging.banner.items_name" value="anprs" />

	<display:setProperty name="export.excel.filename"
		value="ANPR_List.xls" />
	<display:setProperty name="export.csv.filename" value="Floor List.csv" />
	<display:setProperty name="export.pdf.filename" value="Floor List.pdf" />
</display:table>
