<%@ include file="/common/taglibs.jsp"%>


<head>

<title><fmt:message key="anprList.title" /></title>
<meta name="heading" content="<fmt:message key='anprList.heading'/>" />
<meta name="menu" content="MonitorMenu" />
<script type="text/javascript" src="scripts/jquery.form.js"></script>
<script src="scripts/featherlight/featherlight.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="scripts/nailthumb/jquery.nailthumb.1.1.js"></script>
<link href="scripts/nailthumb/jquery.nailthumb.1.1.css" type="text/css" rel="stylesheet" />
<link href="scripts/featherlight/featherlight.css" type="text/css" rel="stylesheet" />
 <style type="text/css" media="screen">
        .square-thumb {
            width: 60px;
            height: 60px;
        }
    </style>
<script type="text/javascript">

	$(document).ready(function(){
		$('.nailthumb-container').nailthumb();
	});

</script>
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
	requestURI="" sort="list" defaultsort= "2" defaultorder="descending" id="licensePlate" pagesize="50"
	class="table table-condensed table-hover table-striped table-bordered table-striped table-bordered table-striped table-bordered"
	export="true">
	<display:column property="plate" escapeXml="true" sortable="true"
		titleKey="licensePlate.plate" style="width: 25%" />
	<display:column sortable="false"
		titleKey="licensePlate.image" style="width: 25%" >
			<a href="http://10.95.6.175/alpr_images/${licensePlate.uuid}.jpg" data-featherlight=""image"">
				<div class="nailthumb-container square-thumb">
					<img src="http://10.95.6.175/alpr_images/${licensePlate.uuid}.jpg" />
				<!--
					<img src="http://localhost/image1.JPG" />
					 -->
				</div>
			</a>
		</display:column>
	<display:column property="timestamp" escapeXml="true" sortable="true"
		titleKey="licensePlate.timestamp" style="width: 50%" />
		
	<display:setProperty name="paging.banner.item_name" value="anpr" />
	<display:setProperty name="paging.banner.items_name" value="anprs" />

	<display:setProperty name="export.excel.filename"
		value="ANPR_List.xls" />
	<display:setProperty name="export.csv.filename" value="Floor List.csv" />
	<display:setProperty name="export.pdf.filename" value="Floor List.pdf" />
</display:table>
