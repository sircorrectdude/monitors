--// change_rooms
-- Migration SQL that makes the change goes here.

delete from room where id= 12;
delete from room where id= 11;
update room set name='DIAMANT' where id=10;

--//@UNDO
-- SQL to undo the change goes here.
insert into room values('12', 'DIAMANT II', 'UG');
insert into room values('11', 'DIAMANT I', 'UG');
update room set name='DIAMANT I + II' where id=10;
