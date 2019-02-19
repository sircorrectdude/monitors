<%@ include file="/common/taglibs.jsp"%>


<head>

    <title><fmt:message key="mealList.title"/></title>
    <meta name="heading" content="<fmt:message key='mealList.heading'/>"/>
   <meta name="menu" content="MonitorMenu"/>
   <link type="text/css" rel="stylesheet" href="scripts/jquery.qtip.min.css" />
<script src='https://code.jquery.com/ui/1.11.3/jquery-ui.min.js'></script><script type="text/javascript" src="scripts/jquery.form.js"></script>
<link rel='stylesheet' href='scripts/fullcalendar/fullcalendar.css' />
<script src='scripts/moment/moment.js'></script>
<script src='scripts/fullcalendar/fullcalendar.js'></script>
<script type="text/javascript" src="scripts/jquery.qtip.min.js"></script>
<style>

  html, body {
    margin: 0;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #external-events {
    position: fixed;
    z-index: 2;
    top: 20px;
    left: 20px;
    width: 150px;
    padding: 0 10px;
    border: 1px solid #ccc;
    background: #eee;
  }

  .demo-topbar + #external-events { /* will get stripped out */
    top: 60px;
  }

  #external-events .fc-event {
    margin: 1em 0;
    cursor: move;
  }

  #calendar-container {
    position: relative;
    z-index: 1;
  }

  #calendar {
    #max-width: 900px;
    #margin: 20px auto;
  }
.removebtn {
	  color:black;
		position: absolute;
		top: 0;
		right: 0;
    width:13px;
    height: 13px;
    text-align:center;
    border-radius:50%;
    font-size: 10px;
		cursor: pointer;
        background-color: #FFF;
        z-index: 10;
	}
</style>

</head>


<c:set var="buttons">
<p style="float:right;">
    <input type="button" style="margin-right: 5px" class="btn btn-primary"
        onclick="location.href='<c:url value="/editMeal.html?method=Add&from=list"/>'"
        value="<fmt:message key="button.addMeal"/>"/>
</p>
</c:set>

<c:out value="${buttons}" escapeXml="false" />
<!--
<display:table name="meals" cellspacing="0" cellpadding="0" requestURI=""
    defaultsort="1" id="meal" pagesize="25" class="table table-condensed table-hover table-striped table-bordered table-striped table-bordered table-striped table-bordered" export="true">
    <display:column property="name" escapeXml="true" sortable="true" titleKey="meal.name" style="width: 20%"/>
    <display:column property="mealcourses" escapeXml="true" sortable="true" titleKey="meal.mealcourses" style="width: 20%"/>

    <display:setProperty name="paging.banner.item_name" value="meal"/>
    <display:setProperty name="paging.banner.items_name" value="meals"/>
</display:table>
-->

  <div id='external-events'>
    <p>
      <strong>In den Kalender ziehen</strong>
    </p>

          <s:iterator value="meals">
          <div class='fc-event'>
          <div class="fc-meal-id" style="display:none" meal-id="<s:property value="id"/>"></div>
            <b><s:property value="name"/>:</b><br/>
            <s:iterator value="mealcourses">
                <s:property value="title"/><br/>
            </s:iterator>
           </div>
          </s:iterator>

    <!--p>
      <input type='checkbox' id='drop-remove' />
      <label for='drop-remove'>remove after drop</label>
    </p-->
  </div>

  <div id='calendar-container'>

    <div id='calendar'></div>
  </div>

<script>

  $(function() {

    // initialize the external events
    // -----------------------------------------------------------------

    $('#external-events .fc-event').each(function() {

      // store data so the calendar knows to render an event upon drop
      $(this).data('event', {
        title: $.trim($(this).text()), // use the element's text as the event title
        stick: true // maintain when user navigates (see docs on the renderEvent method)
      });

      // make the event draggable using jQuery UI
      $(this).draggable({
        zIndex: 999,
        revert: true,      // will cause the event to go back to its
        revertDuration: 0  //  original position after the drag
      });

    });

    // initialize the calendar
    // -----------------------------------------------------------------

    $('#calendar').fullCalendar({
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek'
      },
      editable: false,
      droppable: true, // this allows things to be dropped onto the calendar
      drop: function(date, jsEvent, ui, resourceId) {
      console.log('this:', $(this).find(".fc-meal-id").attr("meal-id"));

      $.ajax({
       url: '/json/saveEvent.html?mealId='+$(this).find(".fc-meal-id").attr("meal-id")+"&date="+date.format(),
        cache: false
      })
        .done(function( html ) {
       $('#calendar').fullCalendar('removeEvents',event._id);
        $('#calendar').fullCalendar('refetchEvents');

        });

        // is the "remove after drop" checkbox checked?
        if ($('#drop-remove').is(':checked')) {
          // if so, remove the element from the "Draggable Events" list
          $(this).remove();
        }
      },
  eventSources: [

    // your event source
    {
      url: '<c:url value="/json/mealEvents.html"/>', // use the `url` property
      color: 'yellow',    // an option!
      textColor: 'black'  // an option!
    }

    // any other sources...

  ],
 			eventRender: function(event, element) {
        element.qtip({
          content: event.description
        });
        element.append( "<div class='removebtn'>X</div>" );
        element.find(".removebtn").click(function() {

        $.ajax({
         // url: '<c:url value="/json/deleteEvent.html"><c:param name="'+event._id+'" value="rockey" /></c:url>',
         url: '/json/deleteEvent.html?id='+event.id,
          cache: false
        })
          .done(function( html ) {
         // $('#calendar').fullCalendar('removeEvents',event._id);
          $('#calendar').fullCalendar('refetchEvents');

          });


        });
      }
    });

  });

</script>

<!--
<c:out value="${buttons}" escapeXml="false" />
-->

