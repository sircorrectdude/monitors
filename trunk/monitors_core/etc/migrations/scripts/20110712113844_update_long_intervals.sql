--// update_long_intervals
-- Migration SQL that makes the change goes here.

update screen set duration=60 where duration=500;

--//@UNDO
-- SQL to undo the change goes here.

update screen set duration=500 where duration=60;
