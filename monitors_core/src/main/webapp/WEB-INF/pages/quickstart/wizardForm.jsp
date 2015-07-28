<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="template.title" /></title>
<meta name="heading" content="<fmt:message key='wizard.heading'/>" />
<meta name="menu" content="MonitorMenu" />
<script type="text/javascript" src="scripts/jquery.psteps.js"></script>
<script type="text/javascript" src="scripts/bootstrapValidator/bootstrapValidator.js"></script>
<link media="screen" rel="stylesheet" type="text/css"
	href="<c:url value='styles/thickbox.css'/>" />
</head>
<!--  -->
<script type="text/javascript">
$(document).ready(function() {
	/*
    $('#saveQuickstartForm').bootstrapValidator({
        container: 'tooltip',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	monitoruuid: {
                validators: {
                    notEmpty: {
                        message: 'The first name is required',
                        trigger: 'blur'
                    }
                }
            }
        }
    });    	
*/	
    $('#psteps_simple_horiz_layout').psteps({
        steps_width_percentage: true,
        alter_width_at_viewport: '1300',
        steps_height_equalize: true,
        /*validation_rule: function() {
        	var cur_step = $(this);
	        	if (cur_step.hasClass('pstep1')) {
		        	var first_name = cur_step.find('[name=monitor\\.ipAddress]');
		        	if (first_name.val().toLowerCase() == ''){
		        		$('#myModal').modal({
		        			  keyboard: false
		        			})
		        		return 'error';
		        	}else{
		        		return true;
		        	}
	        	}
        	}
    */
        });
    
});
</script>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
      </div>
    </div>
  </div>
</div>
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
										<s:textfield key="monitor.ipAddress" cssClass="form-control" required="true"/>
										<s:textfield key="monitor.alias" cssClass="form-control" required="true"/>
										<s:select key="license.id" list="licenses" listKey="id" listValue="uuid"/>
										<s:hidden key="template.id"></s:hidden>
									</div>			
							</s:form>
						</div>		
						 <div class="step-content">
							<s:form name="saveTemplateForm" action="%{saveTemplate}" method="post"
								theme="bootstrap" cssClass="form-horizontal" role="form" id="qq-form">
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
