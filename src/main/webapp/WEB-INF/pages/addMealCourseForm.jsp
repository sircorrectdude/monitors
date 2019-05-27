<%@ include file="/common/taglibs.jsp"%>

<span><h2>MENU</h2></span>

<div>
<s:set var="countTotalPortions" value="0"/>

</div>
<s:iterator value="maincourses">

    <s:set var="countTotalPortions" value="%{#countTotalPortions+value.count}"/>
    <span id="mealcourse_title_${key}">
        <s:property value="value.title"/>
    </span>

      Bestellt:<span id="mealcourse_count_${key}" >
           <s:property value="value.count"/>
      </span>
<div />

    <div id="mealcourse_add_${key}" class="btn btn-primary mealcourse_add_trigger">
        <span><h1>+</h1></span>
    </div>
    <div id="mealcourse_remove_${key}" class="btn btn-primary mealcourse_remove_trigger">
        <span><h1>-</h1></span>
    </div>
    <br/><br/>


        <form id="mealCourseForm_add_${key}" name="addMealCourseForm"
            action="json/addMealCourseAction.html" method="post">

            <input type="hidden" name="mealCourseId" value="${key}"></input>
            <input type="hidden" name="roomId" value="${runningCalendar.color.id}"></input>

        </form>

        <form id="mealCourseForm_remove_${key}" name="addMealCourseForm"
            action="json/removePortion.html" method="post">

            <input type="hidden" name="mealCourseId" value="${key}"></input>
            <input type="hidden" name="roomId" value="${runningCalendar.color.id}"></input>

        </form>

    <script type="text/javascript">
        $(document).ready(function() {



            $(document).ajaxComplete($.unblockUI);

            $('#mealcourse_add_${key}').click(function(){
            $.blockUI({ message: '<h1><img src="images/ajax-loader.gif" /></h1>' });
                 $.ajaxSetup({cache:false,
                   beforeSend: function() {
                      $('#loader').show();
                   },
                   complete: function(){
                      $('#loader').hide();
                   }
                  });
                  $(document).ajaxSuccess(function(event, xhr, settings) {

                    var json = $.parseJSON(xhr.responseText);
                    $('#mealcourse_count_${key}').html(json.maincourses.ID_${key}.count);
                    $('#mealcourse_count_total').html(portionsTotal(json));
                    $('#mealcourse_count_left').html(portionsLeft(json));

                    if(portionsLeft(json) <= 0){
                        console.log("maximum reached");
                    }
                    if(portionsLeft(json) > 0){
                        console.log("maximum dereached");
                    }

                  });
                // prepare Options Object
                var options = {
                    target:     '#mealcourse_${key}',
                    type:		'post',
                };

                // pass options to ajaxForm
                  $('#mealCourseForm_add_${key}').ajaxForm(options);

                // submit form on load
                  $('#mealCourseForm_add_${key}').submit();

                //location.reload();

            });


            $('#mealcourse_remove_${key}').click(function(){
            $.blockUI({ message: '<h1><img src="images/ajax-loader.gif" /></h1>' });
            console.log("remove_${key}")
                $.ajaxSetup({cache:false});
                  $(document).ajaxSuccess(function(event, xhr, settings) {

                    var json = $.parseJSON(xhr.responseText);
                    console.log(json);
                    $('#mealcourse_count_${key}').html(json.maincourses.ID_${key}.count);
                    $('#mealcourse_count_total').html(portionsTotal(json));
                    $('#mealcourse_count_left').html(portionsLeft(json));



                  });
                // prepare Options Object
                var options = {
                    target:     '#mealcourse_${key}',
                    type:		'post',
                    success: function(){}

                };

                // pass options to ajaxForm
                  $('#mealCourseForm_remove_${key}').ajaxForm(options);

                // submit form on load
                  $('#mealCourseForm_remove_${key}').submit();

            });

        });

        var portionsTotal= function(json) {
        var counter = 0;
              for(var key in json.maincourses) {
                  if (json.maincourses.hasOwnProperty(key)) {
                    var val = json.maincourses[key];
                    counter = counter+val.count;
                }
              }
              return counter;
         }

        var portionsLeft= function(json) {
            return json.mealEventRoom.eventinfo.numberPersons-portionsTotal(json);
         }

    </script>

 </s:iterator>

 <script type="text/javascript">
        $(document).ready(function() {
        });
</script>

<div>Anzahl Bestellungen: <span id="mealcourse_count_total" ><c:out value = "${countTotalPortions}"/></span></div>
<div>Anzahl Personen: <s:property value="mealEventRoom.eventinfo.numberPersons"/></div>
<div>Offene Bestellungen: <span id="mealcourse_count_left" ><c:out value = "${mealEventRoom.eventinfo.numberPersons-countTotalPortions}"/></span></div>