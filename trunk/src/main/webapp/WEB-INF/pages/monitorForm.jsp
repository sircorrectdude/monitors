<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="monitor.title"/></title>
    <meta name="heading" content="<fmt:message key='monitor.heading'/>"/>
   <meta name="menu" content="MonitorMenu"/>
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<s:form name="monitorForm" action="saveMonitor" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="monitor.id"/>
        <input type="hidden" name="from" value="${param.from}"/>
    </li>
    <li class="buttonBar right">
        <c:set var="buttons">
            <s:submit cssClass="btn btn-primary" key="button.save" method="save" onclick="onFormSubmit(this.form)"/>
            
        <c:if test="${param.from == 'list' and not empty monitor.id}">
            <s:submit key="button.delete" method="delete" onclick="return confirmDelete('monitor')"/>
        </c:if>
        
            <s:submit cssClass="btn btn-primary" key="button.cancel" method="cancel"/>
        </c:set>
    </li>
    <li class="info">
        <c:choose>
            <c:when test="${param.from == 'list'}">
                <p><fmt:message key="monitor.message"/></p>
            </c:when>
            <c:otherwise>
                <p><fmt:message key="monitor.message"/></p>
            </c:otherwise>
        </c:choose>
    </li>

            <div class="single">
               <s:textfield key="monitor.ipAddress" cssClass="text medium" required="true"/>
            </div>
      <div class="single">
                <s:textfield key="monitor.alias" cssClass="text medium" required="true"/>
        </div>
       <div class="single">
               <s:select label="Course" key="monitor.course.id" list="courses" listKey="id" listValue="name"/>
        </div>

    <li class="buttonBar bottom">
        <c:out value="${buttons}" escapeXml="false"/>
    </li>
</s:form>

