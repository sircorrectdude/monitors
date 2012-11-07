<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="upload.title"/></title>
    <meta name="heading" content="<fmt:message key='upload.heading'/>"/>
    <meta name="menu" content="AdminMenu"/>
</head>
<script type="text/javascript" src="scripts/jquery.form.js"></script>
<div id="uploadContent">
<s:form action="uploadFile!upload" enctype="multipart/form-data" method="post" validate="true" id="uploadForm">
    <li class="info">
        <fmt:message key="upload.message"/>
    </li>
    <s:file name="file" label="%{getText('uploadForm.file')}" cssClass="text file" required="true"/>
    <li class="buttonBar bottom">
		<a style="cursor:pointer;" id="subBtn" name="upload" cssClass="button"> <fmt:message key="button.upload" /></a>
    </li>
</s:form>
</div>

<script type="text/javascript">
$(document).ready(function() {
	$('#subBtn').click(function(){
		$.ajaxSetup({cache:false});
		// prepare Options Object 
		var options = { 
		    target:     '#uploadContent', 
		    type:		'post'
		    
		}; 
		
		// pass options to ajaxForm 
		$('#uploadForm').ajaxForm(options);

		// submit form on load
		$('#uploadForm').submit();		
		
	});
});
	
    Form.focusFirstElement($('uploadForm'));
</script>

