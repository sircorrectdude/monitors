<%@ include file="/common/taglibs.jsp"%>

<sj:head/>

<head>
    <script type="text/javascript" src="<c:url value='/scripts/jquery.validate.min.js'/>"></script>
</head>
<script type="text/javascript">
$().ready(function() {
	$("#mealCourseForm").validate();
});

</script>

<s:form id="mealCourseForm" name="mealCourseForm" action="saveMealCourse" method="post" validate="true">
    <li style="display: none">
        <input type="hidden" name="from" value="${param.from}"/>
    </li>
    <li class="buttonBar right">
        <c:set var="buttons">
            <s:submit key="button.save" method="save" onclick="onFormSubmit(this.form)"/>

        <c:if test="${not empty screen.id}">
            <s:submit key="button.delete" method="delete" onclick="return confirmDelete('screen')"/>
        </c:if>

            <s:submit key="button.cancel" method="cancel"/>
        </c:set>
    </li>
<s:textfield key="mealCourse.title" cssClass="text medium" required="false"/>

<s:select
		headerKey="-1" headerValue="Select ..."
		list="mealcourseTypes"
		key="mealcourseType"
		name="mealcourseType" />

    <li class="buttonBar bottom">
        <c:out value="${buttons}" escapeXml="false"/>
    </li>

</s:form>
