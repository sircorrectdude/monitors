--// new_openweather_template_horizotal
-- Migration SQL that makes the change goes here.

insert into template () values(12,0,"Wettervorhersage Horizontal Dolomit","<script type=\'text/javascript\' src=\'scripts/openweather-horizontal-dolomit.js\'></script>");
insert into screen values(23,"",0,12);
insert into course values(11,0,"24/7 - Wettervorhersage Horizontal Dolomit");
insert into course_screen values(11,23);


insert into template () values(13,1,"Tagespreise Dolomit","<script type=""text/javascript"" src=""/scripts/date/date.js""></script><script type=""text/javascript"" src=""/scripts/date/de-DE.js""></script><script type=""text/javascript"">\njQuery(document).ready(function () { $(""#date"").append(Date.today().toString(""ddd, dd.MM.yyyy"")); });\n</script><div style=""height:1080px;width:1920px;background-image:url('images/templates/daily_prices/daily_prices.jpg')""><div id=""date"" style=""float:left;color:#003889;font:bold 50px Arial, sans-serif;padding-top:690px;padding-left:80px"">&nbsp;</div>\n<div style=""position:absolute;color:#003889;font:bold 150px Arial, sans-serif;padding-top:600px;padding-left:650px"">\n&euro; 39,-</div>\n</div>");
insert into screen values(24,"",0,13);
insert into course values(12,0,"24/7 - Tagespreise Dolomit");
insert into course_screen values(12,24);

--//@UNDO
-- SQL to undo the change goes here.

delete from course_screen where screen_id=23;
delete from course where id=11;
delete from screen where id=23;
delete from template where id=12;

delete from course_screen where screen_id=24;
delete from course where id=12;
delete from screen where id=24;
delete from template where id=13;
