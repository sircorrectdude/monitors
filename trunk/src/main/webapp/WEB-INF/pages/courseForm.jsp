<%@ include file="/common/taglibs.jsp"%>

<sj:head/>

<head>
    <title><fmt:message key="course.title"/></title>
    <meta name="heading" content="<fmt:message key='course.heading'/>"/>
    <meta name="menu" content="MonitorMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<s:form name="courseForm" action="saveCourse" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="course.id"/>
        <input type="hidden" name="from" value="${param.from}"/>
    </li>
    <li class="buttonBar right">
        <c:set var="buttons">
            <s:submit key="button.save" method="save" onclick="onFormSubmit(this.form)"/>
            
        <c:if test="${param.from == 'list' and not empty course.id}">
            <s:submit key="button.delete" method="delete" onclick="return confirmDelete('course')"/>
        </c:if>
        
            <s:submit key="button.cancel" method="cancel"/>
        </c:set>
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

    <li>
        <div>
            <div class="left">
               <s:textfield key="course.name" cssClass="text medium" required="true"/> 
            </div>
             <div class="left">
       		<s:select cssClass="" id="courseMode"
					key="course.courseMode" 
					list="coursemodes" listKey="toString()" listValue="%{getText('courseMode.'+toString())}" />    
            </div>  
            <br/>          
             <div class="left">
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
        </div>
    </li>


    <li class="buttonBar bottom">
        <c:out value="${buttons}" escapeXml="false"/>
    </li>
</s:form>

