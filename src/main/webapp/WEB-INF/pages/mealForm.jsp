<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="meal.title"/></title>
    <meta name="heading" content="<fmt:message key='meal.heading'/>"/>
   <meta name="menu" content="MonitorMenu"/>
<script type="text/javascript" src="scripts/thickbox-compressed.js"></script>
 <link media="screen" rel="stylesheet" type="text/css" href="<c:url value='styles/thickbox.css'/>" />
    <script type="text/javascript" src="<c:url value='/scripts/selectbox.js'/>"></script>
</head>

<s:form name="mealForm" action="saveMeal" method="post">
    <li style="display: none">
        <s:hidden key="meal.id"/>
        <input type="hidden" name="from" value="${param.from}"/>
    </li>
    <li class="buttonBar right">
        <c:set var="buttons">
            <s:submit cssClass="btn btn-primary" key="button.save" method="save"/>

        <c:if test="${param.from == 'list' and not empty meal.id}">
            <s:submit key="button.delete" method="delete" onclick="return confirmDelete('meal')"/>
        </c:if>

            <s:submit cssClass="btn btn-primary" key="button.cancel" method="cancel"/>
        </c:set>
    </li>
    <li class="info">
        <c:choose>
            <c:when test="${param.from == 'list'}">
                <p><fmt:message key="meal.message"/></p>
            </c:when>
            <c:otherwise>
                <p><fmt:message key="meal.message"/></p>
            </c:otherwise>
        </c:choose>
    </li>

	      <div>
				<s:url action="addMealCourse" id="addMealCourseUrl" namespace="/ajax">
					 <s:param name="width">400</s:param>
					 <s:param name="height">300</s:param>
				</s:url>
				<s:a title="Hinzufügen" cssClass="btn btn-primary thickbox" href="%{addMealCourseUrl}"><fmt:message key="mealCourse.add"/></s:a><br/>
		 </div>

        <div class="single">
           <s:textfield key="meal.name" cssClass="text medium" required="true"/>
        </div>

       <div class="single">
               <s:select label="Starter" key="starter.id" list="starters" listKey="id" listValue="title"/>
        </div>

       <div class="single">
               <s:select label="MainCourse" key="maincourse.id" list="maincourses" listKey="id" listValue="title"/>
        </div>

       <div class="single">
               <s:select label="Dessert" key="dessert.id" list="desserts" listKey="id" listValue="title"/>
        </div>

    <li class="buttonBar bottom">
        <c:out value="${buttons}" escapeXml="false"/>
    </li>
</s:form>

