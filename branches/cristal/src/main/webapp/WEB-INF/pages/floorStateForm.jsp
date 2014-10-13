<%@ include file="/common/taglibs.jsp"%>

<form id="floorStateForm_${floor.id}" name="floorStateForm" action="ajax/saveFloorState.html" method="post">
	<input type="hidden" name="floorId" value="${floor.id}"></input>
					<select class="btn" name="floorStateName" id="floorStateSelect_${floor.id}">
						<option value="SYSTEM"
							<c:if test="${floor.floorState eq 'SYSTEM'}">selected="selected"</c:if>>SYSTEM MANAGED</option>
						<option value="TEMPORARY"
							<c:if test="${floor.floorState eq 'TEMPORARY'}">selected="selected"</c:if>>TEMPORARY OCCUPIED</option>
						<option value="PERMANENT"
							<c:if test="${floor.floorState eq 'PERMANENT'}">selected="selected"</c:if>>PERMANENT OCCUPIED</option>
					</select>
</form>

				<script type="text/javascript">
					$(document).ready(function() {
						$('#floorStateSelect_${floor.id}').change(function(){
							$.ajaxSetup({cache:false});
							// prepare Options Object 
							var options = { 
							    target:     '#floorStateContent_${floor.id}', 
							    type:		'post'
							    
							}; 
							
							// pass options to ajaxForm 
							$('#floorStateForm_${floor.id}').ajaxForm(options);
					
							// submit form on load
							$('#floorStateForm_${floor.id}').submit();		
							
						});
					});
				
				</script>
				
