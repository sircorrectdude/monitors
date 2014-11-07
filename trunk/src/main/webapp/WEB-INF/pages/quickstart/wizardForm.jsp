<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="template.title" /></title>
<meta name="heading" content="<fmt:message key='wizard.heading'/>" />
<meta name="menu" content="MonitorMenu" />
<script type="text/javascript" src="scripts/jquery.psteps.js"></script>
<link media="screen" rel="stylesheet" type="text/css"
	href="<c:url value='styles/thickbox.css'/>" />
</head>
<script type="text/javascript">
$(document).ready(function() {
    $('#psteps_simple_horiz_layout').psteps({
        steps_width_percentage: true,
        alter_width_at_viewport: '1300',
        steps_height_equalize: true
        });
});
</script>
<s:if test="template.id == null || template.editable">
	<div class="col-md-12">

		<s:if test="template.templateType.toString() == ('CUSTOM_HTML') ">
			<s:url id="saveTemplate" action="saveHtml" />
			<s:set var="include">../templateTypes/templateHtml.jsp</s:set>
		</s:if>
		<s:elseif test="template.templateType.toString() == ('SLIDESHOW') ">
			<s:url id="saveTemplate" action="slideshowFileUpload" namespace="/json"/>
			<s:set var="include">../templateTypes/templateSlideshow.jsp</s:set>
		</s:elseif>		

			<div id="psteps_simple_horiz_layout" class="pf-form">
			<div class="row-fluid">
				<div class="span8" style="margin-left: 1%">
					<div class="step-title">
						<span class="step-order">1.</span> <span class="step-name">Bildschirm einrichten</span>
					</div>
					<div class="step-title">
						<span class="step-order">2.</span> <span class="step-name">Lade Dein Bilder hoch</span>
					</div>
				</div>
			</div>

			<div class="row-fluid">
				<div class="span8 well clearfix">
						 <div class="step-content">
							<s:form id="saveQuickstartForm" name="saveQuickstartForm" action="saveQuickstart" method="post"
								theme="bootstrap" class="form-horizontal" role="form">
									<div class="form-group">
										<s:textfield key="monitor.ipAddress" cssClass="text medium" required="true"/>
										<s:textfield key="monitor.alias" cssClass="text medium" required="true"/>
										<s:hidden key="template.id"></s:hidden>
									</div>			
							</s:form>
						</div>		
						 <div class="step-content">
							<s:form name="saveTemplateForm" action="%{saveTemplate}" method="post"
								theme="bootstrap" class="form-horizontal" role="form" id="qq-form">
								<li style="display: none"><input
									type="hidden" name="from" value="${param.from}" /></li>
								<div class="info">
									<fmt:message key="wizard.message" />
								</div>
					
								<div>
									<div class="form-group">
										<s:textfield key="template.name" cssClass="form-control" />
									</div>
									<s:include value="%{include}"></s:include>
								</div>
					
							</s:form>
						</div>
		
						<button class="next-button btn">Next Step</button>
						<s:submit cssClass="submit-button btn" key="button.save" method="save"
						validate="true" validateFunction="bootstrapValidation" theme="simple"/>
						<button class="back-button btn">Back Step</button>
				 </div>
			</div>		
		</div>		
	</div>
</s:if>
<s:else>

	<p>
		<fmt:message key="template.noteditable" />
	</p>

</s:else>
