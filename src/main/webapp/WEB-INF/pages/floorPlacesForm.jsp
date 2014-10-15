<%@ include file="/common/taglibs.jsp"%>

<form id="floorPlacesForm_${floor.id}" name="floorPlacesForm"
	action="ajax/saveFloorPlaces.html" method="post">

	<input type="hidden" name="floorId" value="${floor.id}"></input>

					<select class="btn input-small" name="floorPlacesName" id="floorPlacesSelect_${floor.id}">
						<c:forEach var="i" begin="1" end="50">
						   <option value="${i}"
								<c:if test="${floor.places == i}">selected="selected"</c:if>>${i}</option>
						</c:forEach>
					</select>

</form>

				<script type="text/javascript">
					$(document).ready(function() {
						$('#floorPlacesSelect_${floor.id}').change(function(){
							$.ajaxSetup({cache:false});
							// prepare Options Object 
							var options = { 
							    target:     '#floorPlacesContent_${floor.id}', 
							    type:		'post',
							    success: function(){ location.reload(); }
							    
							}; 
							
							// pass options to ajaxForm 
							$('#floorPlacesForm_${floor.id}').ajaxForm(options);
					
							// submit form on load
							$('#floorPlacesForm_${floor.id}').submit();		
							
							//location.reload();
							
						});
					});
				
				</script>
				
