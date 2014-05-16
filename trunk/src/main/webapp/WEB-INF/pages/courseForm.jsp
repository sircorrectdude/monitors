<%@ include file="/common/taglibs.jsp"%>

<sj:head/>

<head>
    <title><fmt:message key="course.title"/></title>
    <meta name="heading" content="<fmt:message key='course.heading'/>"/>
    <meta name="menu" content="MonitorMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
<script type="text/javascript" src="scripts/thickbox-compressed.js"></script>
 <link media="screen" rel="stylesheet" type="text/css" href="<c:url value='styles/thickbox.css'/>" />    
</head>

    <li class="buttonBar right">
        <c:set var="buttons">
            <s:submit cssClass="btn btn-primary" key="button.save" method="save" validate="true" validateFunction="bootstrapValidation"/>
        </c:set>
    </li>     
 <s:form name="courseForm" action="removeCourse" method="post">
	<li style="display: none">
        <s:hidden key="course.id"/>
        <input type="hidden" name="from" value="${param.from}"/>
    </li>
       <c:if test="${not empty course.id}">
           <s:submit cssClass="btn btn-primary" key="button.delete" method="delete" onclick="return confirmDelete('course')"/>
       </c:if>
       
		<!--<s:submit cssClass="btn btn-primary" key="button.cancel" method="cancel"/>
 -->
 </s:form>  
<s:form name="courseForm" action="saveCourse" method="post" theme="bootstrap">
    <li style="display: none">
        <s:hidden key="course.id"/>
        <input type="hidden" name="from" value="${param.from}"/>
    </li>


  
    <li class="info">
        <c:choose>
            <c:when test="${param.from == 'list'}">
                <p><fmt:message key="course.message"/></p>
            </c:when>
            <c:otherwise>
                <p><fmt:message key="course.message"/></p>
            </c:otherwise>
        </c:choose>
    </li>

        <div>
            <div class="left">
               <s:textfield key="course.name" cssClass="text medium" required="true"/> 
            </div>
             <div class="left">
       		<s:select cssClass="" id="courseMode"
					key="course.courseMode" 
					list="coursemodes" listKey="toString()" listValue="%{getText('courseMode.'+toString())}" />    
            </div>
                    </div>  
    <li class="buttonBar bottom">
        <c:out value="${buttons}" escapeXml="false"/>
    </li>
</s:form>
                    
            <br/>          
             <div class="left">
             	<s:url action="addScreen" id="addScreenUrl" namespace="/ajax">
					 <s:param name="width">400</s:param>
					 <s:param name="height">300</s:param>				    
				     <s:param name="courseId">${course.id}</s:param>
				</s:url>
				<div>
				<s:a title="Hinzufügen" cssClass="thickbox" href="%{addScreenUrl}">add</s:a><br/>
            	</div>
            	<div ><b>Screens:</b></div>
				<display:table name="course.screens" cellspacing="0" cellpadding="0" requestURI="" 
			    	defaultsort="1" id="screen" pagesize="25" class="table" export="false">
			    	<display:column property="cronExpression" escapeXml="true" sortable="true" titleKey="screen.cronExpression" style="width: 25%"/>
			    	<display:column property="template.name" escapeXml="true" sortable="true" titleKey="template.name" style="width: 25%"/>
			    	<display:column >
	    		      <span style="float:right;margin:3px;">
							<s:url action="removeScreen" id="removeScreenUrl">
							     <s:param name="screenId">${screen.id}</s:param>
							</s:url>
							<s:a title="Löschen"  href="%{removeScreenUrl}">delete</s:a><br/>
 						</span>
			    	</display:column>
			    </display:table>
    
            </div>





