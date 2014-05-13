--// add_cristal_user
-- Migration SQL that makes the change goes here.

--insert into app_user (id, email, username, password, version, account_expired, account_locked, credentials_expired, first_name, last_name, account_enabled) values(1, "ae@cristal-hotel.de", "cristal", "d033e22ae348aeb5660fc2140aec35850c4da997", "1", false, false, false, "A.", "Egger", true);
--insert into user_role (user_id, role_id) values (1,-2);
--//@UNDO
-- SQL to undo the change goes here.

--delete from app_user where id=1;
--delete from user_role where user_id=1;
