<%@ include file="/common/taglibs.jsp"%>

	<s:if test="hasActionMessages()">
   <div class="alert alert-success">
      <s:actionmessage/>
   </div>
</s:if>

	<s:form theme="xhtml" id="updateCarparkForm" action="ajax/updateCarpark.html">
		<s:hidden name="carpark.id"/>
		<s:textfield key="carpark.placesOccupied" label="Anzahl aktuell besetzer Parkplätze"></s:textfield>	
		<s:submit cssClass="btn btn-warning"></s:submit>
	</s:form>
	<script type="text/javascript">
		$(document).ready(function() {
				$.ajaxSetup({cache:false});
				// prepare Options Object 
				var options = { 
				    target:     '#updateCarparkFormContent', 
				    type:		'post'
				    
				}; 
				
				// pass options to ajaxForm 
				$('#updateCarparkForm').ajaxForm(options);
		});
	</script>
