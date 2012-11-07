--// correct_template_belegung
-- Migration SQL that makes the change goes here.

update template set text="<script type=\'text/javascript\' src=\'scripts/room.js\'>" where id=14;


--//@UNDO
-- SQL to undo the change goes here.

update template set text="<script type=\'text/javascript\' src=\'scripts/room.js\'><script type=""text/javascript"">\njQuery(document).ready(function () { });\n</script>" where id=14;

