<%@ include file="/common/taglibs.jsp"%>

<sj:head/>

<head>
    <script type="text/javascript" src="<c:url value='/scripts/jquery.validate.min.js'/>"></script>
</head>
<script type="text/javascript">
$().ready(function() {
	$("#screenForm").validate();
});

</script>
<s:form id="screenForm" name="screenForm" action="saveScreen" method="post" validate="true">
    <li style="display: none">
        <s:hidden key="screen.id"/>
        <s:hidden key="courseId"/>
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
    <li class="info">
        <c:choose>
            <c:when test="${param.from == 'list'}">
                <p><fmt:message key="screen.message"/></p>
            </c:when>
            <c:otherwise>
                <p><fmt:message key="screen.message"/></p>
            </c:otherwise>
        </c:choose>
    </li>

    <li>
        <div>
            <div class="left">
				<s:select cssClass="required" key="screen.template.id" list="templates" listKey="id" listValue="name" required="true"/>           
            </div>          
        </div>
    </li>

    <li>
        <div>
    
             <div class="left">
               <s:textfield key="screen.duration" cssClass="number" required="false"/> 
            </div> 
           <br/>
            <div>
              ODER
            </div> 
           
             <div class="left">
               <s:textfield key="screen.cronExpression" cssClass="text medium" required="false"/> 
             
            </div>
           
        </div>
    </li>


    <li class="buttonBar bottom">
        <c:out value="${buttons}" escapeXml="false"/>
    </li>
    
    <p>Cron Examples:
 </p>
 <ul>
 <li>0 0 * * * * = the top of every hour of every day.</li>
 <li>*/10 * * * * * = every ten seconds.</li>
 <li>0 0 8-10 * * * = 8, 9 and 10 o'clock of every day.</li>

 <li>0 0/30 8-10 * * * = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.</li>
 <li>0 0 9-17 * * MON-FRI = on the hour nine-to-five weekdays</li>
 <li>0 0 0 25 12 ? = every Christmas Day at midnight</li>
 </ul>
    
</s:form>

