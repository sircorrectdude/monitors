--// add_room_saphir
-- Migration SQL that makes the change goes here.

insert into room values('11', 'SAPHIR', 'DOLOMIT');

--//@UNDO
-- SQL to undo the change goes here.

delete from room where id=11;
