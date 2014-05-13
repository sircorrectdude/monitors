--// force_room_update
-- Migration SQL that makes the change goes here.

update template set text="<script type=\'text/javascript\' src=\'scripts/rooms.js?v=1.0.1\'></script>" where id=2 or id=8;

--//@UNDO
-- SQL to undo the change goes here.


update template set text="<script type=\'text/javascript\' src=\'scripts/rooms.js\'></script>" where id=2 or id=8;