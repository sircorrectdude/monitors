<%@ include file="/common/taglibs.jsp"%>

<head>

    <title>Calendar</title>
    <meta name="heading"/>
   <meta name="menu" content="MonitorMenu"/>
    <script type="text/javascript" src="scripts/thickbox-compressed.js"></script>
	<link media="screen" rel="stylesheet" type="text/css" href="<c:url value='styles/thickbox.css'/>" />       
</head>

   	      <span style="float:right;margin:3px;">
				<s:url action="uploadFile" id="uploadFileUrl" namespace="/ajax">
					 <s:param name="width">400</s:param>
					 <s:param name="height">300</s:param>				    
				</s:url>
				<s:a title="Hinzufügen" cssClass="thickbox" href="%{uploadFileUrl}"><fmt:message key="menu.selectFile"/></s:a><br/>
		 </span>    

<iframe src="http://10.95.6.191/calendar" width="800" height="1280" name="Calendar">
  <p>Ihr Browser kann leider keine eingebetteten Frames anzeigen:
</iframe>