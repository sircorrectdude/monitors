--// alter_room_locations
-- Migration SQL that makes the change goes here.

update room set location='DOLOMIT' where id=4 or id=5 or id=6;

--//@UNDO
-- SQL to undo the change goes here.

update room set location='1. OG' where id=4 or id=5 or id=6;
