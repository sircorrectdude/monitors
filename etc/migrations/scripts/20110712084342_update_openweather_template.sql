--// update_openweather_template
-- Migration SQL that makes the change goes here.

update template set text="<script type='text/javascript' src='scripts/openweather.js'></script>" where id=1;

--//@UNDO
-- SQL to undo the change goes here.


