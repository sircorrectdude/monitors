--// template_correction
-- Migration SQL that makes the change goes here.

update template set text="<script type=\'text/javascript\' src=\'scripts/room.js\' />" where id=14;

--//@UNDO
-- SQL to undo the change goes here.


update template set text="<script type=\'text/javascript\' src=\'scripts/room.js\'>" where id=14;