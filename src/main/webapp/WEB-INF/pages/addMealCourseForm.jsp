<%@ include file="/common/taglibs.jsp"%>

<span><h2>MENU</h2></span>

<s:iterator value="maincourses">
    <span id="mealcourse_title_${key}">
        <s:property value="value.title"/>
    </span>

      Bestellt:<span id="mealcourse_count_${key}" >
           <s:property value="value.count"/>
      </span>
<div />

    <div id="mealcourse_add_${key}" class="btn btn-primary">
        <span><h1>+</h1></span>
    </div>
    <div id="mealcourse_remove_${key}" class="btn btn-primary">
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

            $(document).ajaxStop($.unblockUI);

            $('#mealcourse_add_${key}').click(function(){
            $.blockUI({ message: '<h1><img src="images/ajax-loader.gif" /></h1>' });
            console.log("add_${key}")
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
                    console.log(json);
                    $('#mealcourse_count_${key}').html(json.maincourses.ID_${key}.count);
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

                //location.reload();

            });

        });

    </script>

 </s:iterator>