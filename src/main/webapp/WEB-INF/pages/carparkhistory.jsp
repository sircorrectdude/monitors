<%@ include file="/common/taglibs.jsp"%>


<head>

<title>Carpark Cristal</title>
<meta name="heading" content="Carpark Cristal" />
<meta name="menu" content="MonitorMenu" />
<!--[if lt IE 9]><script language="javascript" type="text/javascript" src="/scripts/jqplot/excanvas.js"></script><![endif]-->
<script type="text/javascript" src="/scripts/jqplot/jquery.jqplot.js"></script>
<script type="text/javascript"
	src="/scripts/jqplot/plugins/jqplot.dateAxisRenderer.js"></script>
<script type="text/javascript"
	src="/scripts/jqplot/plugins/jqplot.canvasAxisTickRenderer.js"></script>
<script type="text/javascript" src="/scripts/jqplot/plugins/jqplot.canvasAxisLabelRenderer.js"></script>
<script type="text/javascript" src="/scripts/jqplot/plugins/jqplot.logAxisRenderer.js"></script>
<script type="text/javascript" src="/scripts/jqplot/plugins/jqplot.canvasTextRenderer.js"></script>
<link rel="stylesheet" type="text/css"
	href=/scripts/jqplot/jquery.jqplot.css " />

<script type="text/javascript">


$(document).ready(function(){
	  var line1 = ${datesSeries};    
	  var plot3 = $.jqplot('chartdiv', [line1], {
	      //title:'Free Places on Date', 
	      axes:{
	        xaxis:{
	          renderer:$.jqplot.DateAxisRenderer,
	          labelRenderer:$.jqplot.CanvasAxisLabelRenderer,
	          tickRenderer: $.jqplot.CanvasAxisTickRenderer,
	          tickOptions:{formatString:'%b %#d, %H:%M', angle:-30},
	          tickInterval:'${tickIntervalHours} hours',
	          label:'Date',
	        }, 
	      	yaxis:{
	      		 label:'Free Places',
	      		tickOptions:{angle:-30}
	      	}
	      },
	      series:[{lineWidth:4, markerOptions:{show: false, style:'circle'}}]
	  });
	});

</script>

</head>
<body>
<br/>	<br/>	
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

	<div id="chartdiv" style="height: 400px; width: 100%;"></div>

</body>