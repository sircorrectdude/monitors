<%@ include file="/common/taglibs.jsp"%>


<head>

    <title><fmt:message key="courseList.title"/></title>
    <meta name="heading" content="<fmt:message key='courseList.heading'/>"/>
   <meta name="menu" content="MonitorMenu"/>
<script type="text/javascript" src="scripts/thickbox-compressed.js"></script>
 <link media="screen" rel="stylesheet" type="text/css" href="<c:url value='styles/thickbox.css'/>" />
</head>


<c:set var="buttons">
<p style="float:right;">
    <input type="button" style="margin-right: 5px" class="btn btn-primary"
        onclick="location.href='<c:url value="/editCourse.html?method=Add&from=list"/>'"
        value="<fmt:message key="button.add"/>"/>
    
 <!--    <input type="button" onclick="location.href='<c:url value="/mainMenu.html"/>'"
        value="<fmt:message key="button.done"/>"/>
         -->
</p>
</c:set>

<c:out value="${buttons}" escapeXml="false" />

<display:table name="courses" cellspacing="0" cellpadding="0" requestURI="" 
    defaultsort="1" id="course" pagesize="5" class="table table-condensed table-hover table-striped table-bordered table-striped table-bordered table-striped table-bordered" export="true">
    <display:column property="name" escapeXml="true" sortable="true" titleKey="course.name" style="width: 25%"
        url="/editCourse.html?from=list" paramId="id" paramProperty="id"/>

    <display:column property="courseMode" escapeXml="true" sortable="true" titleKey="course.courseMode" style="width: 25%"/>
    
    <display:column property="screens" escapeXml="true" sortable="true" titleKey="course.screens" style="width: 25%"/>
<!-- 
     <display:column title="" >
	      <span style="float:right;margin:3px;">
				<s:url action="addScreen" id="addScreenUrl" namespace="/ajax">
					 <s:param name="width">400</s:param>
					 <s:param name="height">300</s:param>				    
				     <s:param name="courseId">${course.id}</s:param>
				</s:url>
				<s:a title="Hinzufügen" cssClass="thickbox" href="%{addScreenUrl}">add</s:a><br/>
		 </span>
     </display:column>
 -->
    <display:setProperty name="paging.banner.item_name" value="course"/>
    <display:setProperty name="paging.banner.items_name" value="courses"/>

    <display:setProperty name="export.excel.filename" value="Course List.xls"/>
    <display:setProperty name="export.csv.filename" value="Course List.csv"/>
    <display:setProperty name="export.pdf.filename" value="Course List.pdf"/>
</display:table>

<c:out value="${buttons}" escapeXml="false" />
