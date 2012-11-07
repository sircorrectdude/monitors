--// alter_template_fullscreen
-- Migration SQL that makes the change goes here.

update template set text="<script type=""text/javascript"" src=""/scripts/supersized.1.0.js""></script>
<style type=""text/css"">
*{margin:0;padding:0;font:60px ""Gotham Black"", Arial, sans-serif;color:#FFF;}img{border:none;}body {overflow:hidden;/*Needed to eliminate scrollbars*/}#content{margin:0px auto;height:100px;width:100%;bottom:5%;background-color:#262626;border-
 top:3px solid #4F4F4F;border-bottom:3px solid #4F4F4F;position:absolute;}#contentframe{text-align:center;}/*Supersize Plugin Styles*/#supersize img, #supersize a{height:100%;width:100%;display:none;}#supersize .activeslide, #supersize .activeslide img{display:inline;}</style>
<script type=""text/javascript"">
					        			
			$('#banner').remove()\n
	            	$('#topbanner').remove()\n
	            	$('#mainTable').remove()\n
						$.fn.supersized.options = {
						startwidth: 1920,
						startheight: 1280,
						minsize: .50,
						slideshow: 0,
						slideinterval: 5000
						}\n
			$('#supersize').supersized()\n
						
					</script>
<div id=""supersize"">
	<img class=""activeslide"" src=""images/startbildschirm115.png"" /></div>
"

where id=3;

--//@UNDO
-- SQL to undo the change goes here.


