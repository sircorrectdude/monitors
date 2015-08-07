<%@ include file="/common/taglibs.jsp"%>

<head>
<title><fmt:message key="template.title" /></title>
<meta name="heading" content="<fmt:message key='template.heading'/>" />
<meta name="menu" content="MonitorMenu" />
    <script src="scripts/fineuploader/jquery.fineuploader-5.0.8.js"></script>
    <link href="scripts/fineuploader/fineuploader-5.0.8.css" rel="stylesheet">
</head>

<s:url action="slideshowFileUpload" id="uploadFileUrl" namespace="/json">
	<s:param name="template.id" value="template.id"></s:param>
</s:url>
<s:url action="deleteSlideshowImage" id="deleteFileUrl" namespace="/json"></s:url>
<s:url action="slideshowSession" id="slideshowSession" namespace="/json">
	<s:param name="template.id" value="template.id"></s:param>
</s:url>

<!-- Fine Uploader JS
====================================================================== -->
<script>
$(document).ready(function() {
	
	var uploader = $("#fine-uploader").fineUploader({
    session : {
        endpoint : '<s:property value="#slideshowSession" />',  
      },
	debug: true,
	request: {
        endpoint: '<s:property value="#uploadFileUrl" />',
        inputName:"file"
    },
    validation: {
    	sizeLimit: 5000000
    },
    maxConnections: 1,
    autoUpload: false,
    editFilename: {
      enabled: true
    },
    deleteFile: {
        enabled: true,
        endpoint: '<s:property value="#deleteFileUrl" />',
        method: 'POST',
        params: {'template.id': '<s:property value="template.id" />'}
    }
	
})
.on('allComplete', function (event, succeeded, failed) {
	$('#saveQuickstartForm').submit();
})
.on('complete', function (event, id, name, responseJSON, xhr) {
    //$('#qq-form_template_id').val(responseJSON.template.id);
	$('#saveQuickstartForm_template_id').val(responseJSON.template.id)
    uploader.fineUploader('setParams', { 'template.id': responseJSON.template.id });
})
.on('upload', function(event, id, filename){
	    //alert($.templateId);
});
	$('#button_save').click(function() {
		uploader.fineUploader('uploadStoredFiles');
	  });
});


</script>

<!-- Fine Uploader DOM Element
====================================================================== -->
<div id="fine-uploader"></div>
<!-- div id="triggerUpload" class="btn btn-primary">
  Upload now
</div -->
<!-- Fine Uploader template
====================================================================== -->
<script type="text/template" id="qq-template">
      <div class="qq-uploader-selector qq-uploader">
    <div class="qq-upload-drop-area-selector qq-upload-drop-area" qq-hide-dropzone>
      <span>Drop files here to upload</span>
    </div>
    <div class="qq-upload-button-selector qq-upload-button">
      <div>Upload a file</div>
    </div>
    <span class="qq-drop-processing-selector qq-drop-processing">
      <span>Processing dropped files...</span>
      <span class="qq-drop-processing-spinner-selector qq-drop-processing-spinner"></span>
    </span>
    <ul class="qq-upload-list-selector qq-upload-list">
      <li>
        <div class="qq-progress-bar-container-selector">
          <div class="qq-progress-bar-selector qq-progress-bar"></div>
        </div>
        <span class="qq-upload-spinner-selector qq-upload-spinner"></span>
        <img class="qq-thumbnail-selector" qq-max-size="100" qq-server-scale>
        <span class="qq-edit-filename-icon-selector qq-edit-filename-icon"></span>
        <span class="qq-upload-file-selector qq-upload-file"></span>
        <input class="qq-edit-filename-selector qq-edit-filename" tabindex="0" type="text">
        <span class="qq-upload-size-selector qq-upload-size"></span>
        <a class="qq-upload-cancel-selector qq-upload-cancel" href="#">Cancel</a>
        <a class="qq-upload-retry-selector qq-upload-retry" href="#">Retry</a>
        <a class="qq-upload-delete-selector qq-upload-delete" href="#">Delete</a>
        <span class="qq-upload-status-text-selector qq-upload-status-text"></span>
      </li>
    </ul>
  </div>
</script>