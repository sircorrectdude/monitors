CKEDITOR.addTemplates( 'default',
{
	// The name of sub folder which hold the shortcut preview images of the templates.
	imagesPath : CKEDITOR.getUrl( CKEDITOR.plugins.getPath( 'templates' ) + 'templates/images/' ),

	// The templates definitions.
	templates :
		[
			{
				title: 'Fullscreeen Image/Slideshow',
				image: 'template1.gif',
				description: 'Create single image or slideshow from multiple images.',
				html:
					'<script type="text/javascript" src="http://jqueryjs.googlecode.com/files/jquery-1.3.1.js"></script>'+
					'<script type="text/javascript" src="/scripts/supersized.1.0.js"></script>\n' +
					'<style type="text/css">'+
					'*{'+
						'margin:0;'+
						'padding:0;'+
						'font:60px "Gotham Black", Arial, sans-serif;'+
						'color:#FFF;'+
					'}'+
					'img{'+
						'border:none;'+
					'}'+
					'body {'+
						'overflow:hidden;'+
					'}'+
					'#content{'+
						'margin:0px auto;'+
						'height:100px;'+
						'width:100%;'+
						'bottom:5%;'+
						'background-color:#262626;'+
						'border-top:3px solid #4F4F4F;'+
						'border-bottom:3px solid #4F4F4F;'+
						'position:absolute;'+
					'}'+
					'#contentframe{'+
						'text-align:center;'+
					'}'+
					
					'/*Supersize Plugin Styles*/'+
					'#supersize img, #supersize a{'+
						'height:100%;'+
						'width:100%;'+
						'display:none;'+
					'}'+
					'#supersize .activeslide, #supersize .activeslide img{'+
						'display:inline;'+
					'}'+

				'</style>'+
				'<script type="text/javascript">\n'+
					'$(function(){\n'+
						'$.fn.supersized.options = {\n'+
							'startwidth: 1024,\n'+
							'startheight: 576,\n'+
							'minsize: .50,\n'+
							'slideshow: 0,\n'+
							'slideinterval: 5000\n'+
						'};'+
				        '$(\'#supersize\').supersized();\n'+
				    '});\n'+

				'</script>\n'+
				'<div id="supersize">\n'+
			'<img class="activeslide" src="images/bulbs.jpg"/></img>\n'+
			'\n'+
		'</div>\n'+
		''
			}
			,
			{
				title: 'Konferenz',
				image: 'template1.gif',
				description: 'Konferenzraum - Aktuelle Belegung.',
				html:'<style type="text/css">'+
					    'a:link {'+
					        'color:blue;'+
					        'text-decoration:underline;'+
					    '}'+
					    'a:active { color:red }'+
					    'a:visited { color:purple }'+
					    'body {'+
					        'background-color:white;'+
					        'color:#393838;'+
					    '}'+
					    '.text6 {'+
					        'font-family:"55 Helvetica Roman";'+
					        'font-size:70px;'+
					        'text-decoration:none;'+
					        'color:#384D8B;'+
					    '}'+
					    '.text2 {'+
					        'font-family:"55 Helvetica Roman";'+
					        'font-size:40px;'+
					        'text-decoration:none;'+
					        'color:#384D8B;'+
					    '}'+
					    '.text3 {'+
					        'font-family:"55 Helvetica Roman";'+
					        'font-size:40px;'+
					        'font-style:italic;'+
					        'text-decoration:none;'+
					        'color:#384D8B;'+
					    '}'+
					    '.text0 {'+
					        'font-family:"55 Helvetica Roman";'+
					        'font-size:50px;'+
					        'text-decoration:none;'+
					        'color:#384D8B;'+
					    '}'+
					    '.text4 {'+
					        'font-family:"55 Helvetica Roman";'+
					        'font-size:50px;'+
					        'font-style:italic;'+
					        'text-decoration:none;'+
					        'color:#384D8B;'+
					    '}'+
					    '.text1 {'+
					        'font-family:"55 Helvetica Roman";'+
					        'font-size:90px;'+
					        'text-decoration:none;'+
					        'color:#384D8B;'+
					    '}'+
					    '.text5 {'+
					        'font-family:"55 Helvetica Roman";'+
					        'font-size:90px;'+
					        'font-style:italic;'+
					        'text-decoration:none;'+
					        'color:#384D8B;'+
					    '}'+
					    '.para1 {'+
					        'text-align:center;'+
					    '}'+
					    '.pNormal {'+
					    '}'+
					    '.box1 {'+
					        'width:1920px;'+
					        'height:1080px;'+
					    '}'+
					    '.box2 {'+
					        'position:absolute;'+
					        'left:685px;'+
					        'top:213px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:300px;'+
					        'height:80px;'+
					    '}'+
					    '.box3 {'+
					        'position:absolute;'+
					        'left:1143px;'+
					        'top:214px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:319px;'+
					        'height:81px;'+
					    '}'+
					    '.box4 {'+
					        'position:absolute;'+
					        'left:100px;'+
					        'top:310.5px;'+
					        'width:1425px;'+
					        'height:2px;'+
					    '}'+
					    '.box5 {'+
					        'position:absolute;'+
					        'left:100px;'+
					        'top:486.5px;'+
					        'width:1426px;'+
					        'height:2px;'+
					    '}'+
					    '.box6 {'+
					        'position:absolute;'+
					        'left:100px;'+
					        'top:662.5px;'+
					        'width:1425px;'+
					        'height:2px;'+
					    '}'+
					    '.box7 {'+
					        'position:absolute;'+
					        'left:100px;'+
					        'top:839.5px;'+
					        'width:1425px;'+
					        'height:2px;'+
					    '}'+
					    '.box8 {'+
					        'position:absolute;'+
					        'left:100px;'+
					        'top:1012.5px;'+
					        'width:1426px;'+
					        'height:2px;'+
					    '}'+
					    '.box9 {'+
					        'position:absolute;'+
					        'left:595px;'+
					        'top:231.5px;'+
					        'width:2px;'+
					        'height:782px;'+
					    '}'+
					    '.box10 {'+
					        'position:absolute;'+
					        'left:1071px;'+
					        'top:230.5px;'+
					        'width:2px;'+
					        'height:782px;'+
					    '}'+
					    '.box11 {'+
					        'position:absolute;'+
					        'left:604px;'+
					        'top:532px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:459px;'+
					        'height:94px;'+
					    '}'+
					    '.box12 {'+
					        'position:absolute;'+
					        'left:604px;'+
					        'top:704px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:459px;'+
					        'height:110px;'+
					    '}'+
					    '.box13 {'+
					        'position:absolute;'+
					        'left:615px;'+
					        'top:876px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:436px;'+
					        'height:92px;'+
					    '}'+
					    '.box14 {'+
					        'position:absolute;'+
					        'left:1524px;'+
					        'top:232.5px;'+
					        'width:2px;'+
					        'height:782px;'+
					    '}'+
					    '.box15 {'+
					        'position:absolute;'+
					        'left:1565px;'+
					        'top:313px;'+
					        'background-color:white;'+
					        'width:316px;'+
					        'height:237px;'+
					    '}'+
					    '.box16 {'+
					        'position:absolute;'+
					        'left:1567px;'+
					        'top:670px;'+
					        'background-color:white;'+
					        'width:317px;'+
					        'height:237px;'+
					    '}'+
					    '.box17 {'+
					        'position:absolute;'+
					        'left:129px;'+
					        'top:340px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:393px;'+
					        'height:123px;'+
					    '}'+
					    '.box18 {'+
					        'position:absolute;'+
					        'left:129px;'+
					        'top:517px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:393px;'+
					        'height:117px;'+
					    '}'+
					    '.box19 {'+
					        'position:absolute;'+
					        'left:129px;'+
					        'top:697px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:393px;'+
					        'height:141px;'+
					    '}'+
					    '.box20 {'+
					        'position:absolute;'+
					        'left:129px;'+
					        'top:867px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:465px;'+
					        'height:137px;'+
					    '}'+
					    '.box21 {'+
					        'position:absolute;'+
					        'left:1076px;'+
					        'top:531px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:447px;'+
					        'height:94px;'+
					    '}'+
					    '.box22 {'+
					        'position:absolute;'+
					        'left:1075px;'+
					        'top:703px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:449px;'+
					        'height:110px;'+
					    '}'+
					    '.box23 {'+
					        'position:absolute;'+
					        'left:1080px;'+
					        'top:875px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:436px;'+
					        'height:92px;'+
					    '}'+
					    '.box24 {'+
					        'position:absolute;'+
					        'left:693px;'+
					        'top:319px;'+
					        'background-color:white;'+
					        'width:289px;'+
					        'height:160px;'+
					    '}'+
					    '.box25 {'+
					        'position:absolute;'+
					        'left:1155px;'+
					        'top:319px;'+
					        'background-color:white;'+
					        'width:289px;'+
					        'height:160px;'+
					    '}'+
					    '.box26 {'+
					        'position:absolute;'+
					        'left:97px;'+
					        'top:52px;'+
					        'padding-top:1px;'+
					        'padding-left:0px;'+
					        'padding-bottom:0px;'+
					        'padding-right:0px;'+
					        'width:1512px;'+
					        'height:111px;'+
					    '}'+
					'</style>'+
					'<table border="0" cellspacing="0" cellpadding="0" align="left">'+
					    '<tr>'+
					        '<td valign="top" width="1920" height="1080">'+
					        '<div class="box1">'+
					            '<img src='+
					            '"images/templates/konferenzraum/bildschirmhintergrund_03443.png"'+
					             'alt="bildschirmhintergrund_03.png" width="1920" height="1080"'+ 
					            'border="0"></div>'+
					        '</td><td valign="top" width="1" height="1080">'+
					        '<img src="images/templates/konferenzraum/qwdspacer.gif" alt="" width="1" height="1080" border='+
					        '"0"></td>'+
					    '</tr>'+
					    '<tr>'+
					        '<td valign="top" width="1920" height="1">'+
					        '<img src="images/templates/konferenzraum/qwdspacer.gif" alt="" width="1920" height="1" border='+
					        '"0"></td><td valign="top" width="1" height="1">'+
					        '<img src="images/templates/konferenzraum/qwdspacer.gif" alt="" width="1" height="1" border="0"></td></tr>'+
					'</table>'+
					'<div class="box2">'+
					    '<div class="para1">'+
					        '<span class="text6">Rubin I </span>'+
					    '</div>'+
					'</div>'+
					'<div class="box3">'+
					    '<div class="para1">'+
					        '<span class="text6">Rubin II </span>'+
					    '</div>'+
					'</div>'+
					'<div class="box4">'+
					    '<img src="images/templates/konferenzraum/Line140_Kopie440.gif"'+ 
					    'alt="" width="1425" height="2" border="0"></div>'+
					'<div class="box5">'+
					    '<img src="images/templates/konferenzraum/Line139_Kopie439.gif"'+ 
					    'alt="" width="1426" height="2" border="0"></div>'+
					'<div class="box6">'+
					    '<img src="images/templates/konferenzraum/Line138_Kopie438.gif"'+ 
					    'alt="" width="1425" height="2" border="0"></div>'+
					'<div class="box7">'+
					    '<img src="images/templates/konferenzraum/Line137_Kopie437.gif"'+ 
					    'alt="" width="1425" height="2" border="0"></div>'+
					'<div class="box8">'+
					    '<img src="images/templates/konferenzraum/Line136_Kopie436.gif"'+ 
					    'alt="" width="1426" height="2" border="0"></div>'+
					'<div class="box9">'+
					    '<img src="images/templates/konferenzraum/Line135_Kopie435.gif"'+ 
					    'alt="" width="2" height="782" border="0"></div>'+
					'<div class="box10">'+
					    '<img src="images/templates/konferenzraum/Line134_Kopie434.gif"'+ 
					    'alt="" width="2" height="782" border="0"></div>'+
					'<div class="box11">'+
					    '<div class="para1">'+
					        '<span class="text2">26. Januar 2011 </span>'+
					    '</div>'+
					    '<div class="para1">'+
					        '<span class="text3">26th of January 2011 </span>'+
					    '</div>'+
					'</div>'+
					'<div class="box12">'+
					    '<div class="para1">'+
					        '<span class="text2">Ab 18.00 Uhr </span>'+
					    '</div>'+
					    '<div class="para1">'+
					        '<span class="text3">From 6 p.m. </span>'+
					    '</div>'+
					'</div>'+
					'<div class="box13">'+
					    '<div class="para1">'+
					        '<span class="text2">1. Etage, links. </span>'+
					    '</div>'+
					    '<div class="para1">'+
					        '<span class="text3">1st floor, left. </span>'+
					    '</div>'+
					'</div>'+
					'<div class="box14">'+
					    '<img src="images/templates/konferenzraum/Line134_Kopie430.gif"'+ 
					    'alt="" width="2" height="782" border="0"></div>'+
					'<div class="box15">'+
					    '<img src='+
					    '"images/templates/konferenzraum/konferenzraum_dolo_rubin230.jpg"'+
					     'alt="konferenzraum_dolo_rubin1_bearb.jpg" width="316" height="237" border='+
					    '"0"></div>'+
					'<div class="box16">'+
					    '<img src='+
					    '"images/templates/konferenzraum/konferenzraum_dolo_rubin233.jpg"'+
					     'alt="konferenzraum_dolo_rubin2.jpg" width="317" height="237" border="0"></div>'+
					'<div class="box17">'+
					    '<div class="pNormal">'+
					        '<span class="text0">Veranstalter </span>'+
					    '</div>'+
					    '<div class="pNormal">'+
					        '<span class="text4">Organisation </span>'+
					    '</div>'+
					'</div>'+
					'<div class="box18">'+
					    '<div class="pNormal">'+
					        '<span class="text0">Datum </span>'+
					    '</div>'+
					    '<div class="pNormal">'+
					        '<span class="text4">Date </span>'+
					    '</div>'+
					'</div>'+
					'<div class="box19">'+
					    '<div class="pNormal">'+
					        '<span class="text0">Uhrzeit </span>'+
					    '</div>'+
					    '<div class="pNormal">'+
					        '<span class="text4">Time </span>'+
					    '</div>'+
					'</div>'+
					'<div class="box20">'+
					    '<div class="pNormal">'+
					        '<span class="text0">Wegbeschreibung </span>'+
					    '</div>'+
					    '<div class="pNormal">'+
					        '<span class="text4">How to get there </span>'+
					    '</div>'+
					'</div>'+
					'<div class="box21">'+
					    '<div class="para1">'+
					        '<span class="text2">26. Januar 2011 </span>'+
					    '</div>'+
					    '<div class="para1">'+
					        '<span class="text3">26th of January 2011 </span>'+
					    '</div>'+
					'</div>'+
					'<div class="box22">'+
					    '<div class="para1">'+
					        '<span class="text2">Ab 18.00 Uhr </span>'+
					    '</div>'+
					    '<div class="para1">'+
					        '<span class="text3">From 6 p.m. </span>'+
					    '</div>'+
					'</div>'+
					'<div class="box23">'+
					    '<div class="para1">'+
					        '<span class="text2">1. Etage, links. </span>'+
					    '</div>'+
					    '<div class="para1">'+
					        '<span class="text3">1st floor, left. </span>'+
					    '</div>'+
					'</div>'+
					'<div class="box24">'+
					    '<img src='+
					    '"images/templates/konferenzraum/logo_metzger-innung404_K406.png"'+
					     'alt="logo_metzger-innung.png" width="289" height="160" border="0"></div>'+
					'<div class="box25">'+
					    '<img src='+
					    '"images/templates/konferenzraum/logo_metzger-innung404_K406.png"'+
					     'alt="logo_metzger-innung.png" width="289" height="160" border="0"></div>'+
					'<div class="box26">'+
					    '<div class="pNormal">'+
					        '<span class="text1">Tagungsr&auml;ume / </span><span class="text5">Conference rooms'+ 
					        '</span>'+
					    '</div>'+
					'</div>'
					
			}
		]
});
