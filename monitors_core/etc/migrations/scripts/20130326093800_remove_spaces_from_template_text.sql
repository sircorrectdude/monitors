--// remove_spaces_from_template_text
-- Migration SQL that makes the change goes here.

update template set text ="<script type='text/javascript' src='scripts/openweather-vertikal-dolomit.js'></script>" where id= 31;
update template set text ="<script type='text/javascript' src='scripts/openweather.js'></script>" where id= 11;
update template set text ="<script type='text/javascript' src='scripts/traffic-mvg.js'></script>" where id= 5;

--//@UNDO
-- SQL to undo the change goes here.

update template set text ="<script type='text/javascript' src='scripts/openweather-vertikal-dolomit.js'></script>" where id= 31;
update template set text ="<script type='text/javascript' src='scripts/openweather.js'></script>" where id= 11;
update template set text ="<script type='text/javascript' src='scripts/traffic-mvg.js'></script>" where id= 5;