<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="template.title" /></title>
<meta name="heading" content="<fmt:message key='template.heading'/>" />
<meta name="menu" content="MonitorMenu" />
<script type="text/javascript" src="scripts/thickbox-compressed.js"></script>
<link media="screen" rel="stylesheet" type="text/css"
	href="<c:url value='styles/thickbox.css'/>" />
</head>

<s:if test="template.id == null || template.editable">
	<div class="col-md-8">
		<c:set var="buttons">
			<s:submit cssClass="btn btn-primary" key="button.save" method="save"
				validate="true" validateFunction="bootstrapValidation" />

			<c:if test="${param.from == 'list' and not empty template.id}">
				<s:submit cssClass="btn btn-primary" key="button.delete"
					method="delete" onclick="return confirmDelete('template')" />
			</c:if>

			<s:submit cssClass="btn btn-primary" key="button.cancel"
				method="cancel" />
		</c:set>

		<s:form name="templateForm" action="saveTemplate" method="post"
			theme="bootstrap" class="form-horizontal" role="form">
			<li style="display: none"><s:hidden name="template.id" /> <input
				type="hidden" name="from" value="${param.from}" /></li>
			<div class="info">
				<c:choose>
					<c:when test="${param.from == 'list'}">
						<p>
							<fmt:message key="template.message" />
						</p>
					</c:when>
					<c:otherwise>
						<p>
							<fmt:message key="template.message" />
						</p>
					</c:otherwise>
				</c:choose>
			</div>

			<div>
				<div class="form-group">
					<s:textfield key="template.name" cssClass="form-control" />
				</div>
				<s:if test="template.templateType.toString() == ('CUSTOM_HTML') ">
					<s:include value="templateTypes/templateHtml.jsp"></s:include>
				</s:if>
				<s:elseif test="template.templateType.toString() == ('SLIDESHOW') ">
					<s:include value="templateTypes/templateSlideshow.jsp"></s:include>
				</s:elseif>				
			</div>


			<div class="buttonBar bottom">
				<c:out value="${buttons}" escapeXml="false" />
			</div>
		</s:form>
	</div>
	<div class="col-md-4">
	
				<div class="right">
				<span style="float: right; margin: 3px;"> <s:url
						action="uploadFile" id="uploadFileUrl" namespace="/ajax">
						<s:param name="width">400</s:param>
						<s:param name="height">300</s:param>
					</s:url> <s:a title="Hinzufügen" cssClass="thickbox btn btn-primary"
						href="%{uploadFileUrl}">
						<fmt:message key="menu.selectFile" />
					</s:a><br />
				</span>

			</div>
	
	</div>
</s:if>
<s:else>

	<p>
		<fmt:message key="template.noteditable" />
	</p>

</s:else>
