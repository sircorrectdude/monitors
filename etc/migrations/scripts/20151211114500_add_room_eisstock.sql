--// add_room_eisstock
-- Migration SQL that makes the change goes here.

insert into room values('12', 'EISSTOCKEVENT', 'PARKDECK 6. OG');

--//@UNDO
-- SQL to undo the change goes here.

delete from room where id=12;


