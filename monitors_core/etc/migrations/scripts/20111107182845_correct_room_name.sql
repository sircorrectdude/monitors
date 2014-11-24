--// correct_room_name
-- Migration SQL that makes the change goes here.

update room set name='BRILLANT' where id=2;

--//@UNDO
-- SQL to undo the change goes here.

update room set name='BRILLIANT' where id=2;
