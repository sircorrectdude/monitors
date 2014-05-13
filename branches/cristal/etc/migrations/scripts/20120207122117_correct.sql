--// correct
-- Migration SQL that makes the change goes here.

update course set courseMode=0 where id=6;
delete from course_screen where course_id=6 and screen_id=55;
delete from screen where id=55;
delete from template where id=18;

--//@UNDO
-- SQL to undo the change goes here.


insert into template values(18,1,"Vertical Schaeffler","");
update template set text="<script type=""text/javascript"" src=""http://jqueryjs.googlecode.com/files/jquery-1.3.1.js""></script><script type=""text/javascript"" src=""/scripts/supersized.1.0.js""></script><style type=""text/css"">*{margin:0;padding:0;font:60px ""Gotham Black"", Arial, sans-serif;color:#FFF;}img{border:none;}body {overflow:hidden;}#content{margin:0px auto;height:100px;width:100%;bottom:5%;background-color:#262626;border-top:3px solid #4F4F4F;border-bottom:3px solid #4F4F4F;position:absolute;}#contentframe{text-align:center;}/*Supersize Plugin Styles*/#supersize img, #supersize a{height:100%;width:100%;display:none;}#supersize .activeslide, #supersize .activeslide img{display:inline;}</style><script type=""text/javascript"">$(function(){$.fn.supersized.options = {startwidth: 1080,startheight: 1920,minsize: .50,slideshow: 0,slideinterval: 5000};$('#supersize').supersized();});</script><div id=""supersize""><img class=""activeslide"" src=""images/Lobby-Monitor-Cristal_Schaefflertanz-vertikal.jpg"" /></div>" where id=18;

insert into screen values(55,"",20,18);
insert into course_screen values(6,55);
update course set courseMode=1 where id=6;