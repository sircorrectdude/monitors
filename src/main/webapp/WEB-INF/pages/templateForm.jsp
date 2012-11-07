<%@ include file="/common/taglibs.jsp"%>


<head>
    <title><fmt:message key="template.title"/></title>
    <meta name="heading" content="<fmt:message key='template.heading'/>"/>
    <meta name="menu" content="MonitorMenu"/>
    <script type="text/javascript" src="scripts/thickbox-compressed.js"></script>
	<link media="screen" rel="stylesheet" type="text/css" href="<c:url value='styles/thickbox.css'/>" />    
</head>

 <s:if test="template.id == null || template.editable">

<s:form name="templateForm" action="saveTemplate" method="post">
    <li style="display: none">
        <s:hidden name="template.id"/>
        <input type="hidden" name="from" value="${param.from}"/>
    </li>
    <li class="buttonBar right">
        <c:set var="buttons">
            <s:submit key="button.save" method="save"/>
            
        <c:if test="${param.from == 'list' and not empty template.id}">
            <s:submit key="button.delete" method="delete" onclick="return confirmDelete('template')"/>
        </c:if>
        
            <s:submit key="button.cancel" method="cancel"/>
        </c:set>
    </li>
    <li class="info">
        <c:choose>
            <c:when test="${param.from == 'list'}">
                <p><fmt:message key="template.message"/></p>
            </c:when>
            <c:otherwise>
                <p><fmt:message key="template.message"/></p>
            </c:otherwise>
        </c:choose>
    </li>

    <li>
        <div>
            <div class="left">
               <s:textfield key="template.name" cssClass="text medium" required="true"/> 
            </div>
            <div class="right">
   	      <span style="float:right;margin:3px;">
				<s:url action="uploadFile" id="uploadFileUrl" namespace="/ajax">
					 <s:param name="width">400</s:param>
					 <s:param name="height">300</s:param>				    
				</s:url>
				<s:a title="Hinzufügen" cssClass="thickbox" href="%{uploadFileUrl}"><fmt:message key="menu.selectFile"/></s:a><br/>
		 </span>         
            
            </div>
            <div class="left">
				<sjr:ckeditor
					editorLocal="de"
			        width="800"
			        height="400"
			        cols="80"
			        rows="40"
			        key="template.text"
			        customConfig="/myckconfig.js"
			        id="templateTextArea"
				/>            
            </div>
        </div>
    </li>


    <li class="buttonBar bottom">
        <c:out value="${buttons}" escapeXml="false"/>
    </li>
</s:form>

</s:if>
<s:else>

 <p><fmt:message key="template.noteditable"/></p>

</s:else>