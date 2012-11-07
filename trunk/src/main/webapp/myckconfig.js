CKEDITOR.editorConfig = function( config )
{
	   config.enterMode = CKEDITOR.ENTER_BR;
	   config.shiftEnterMode = CKEDITOR.ENTER_P;
	// Define changes to default configuration here. For example:
	config.templates_files =
	    [
	        '/mytemplates.js'
	    ];
	
	  config.toolbar = 'MyToolbar';

	  config.toolbar_MyToolbar =
	  [
	   	['Templates','-','Source','-','Preview', 'Image']
	   	/*,
	   	'/',
	    ['Cut','Copy','Paste','PasteText'],
	    ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	    ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
	    ['BidiLtr', 'BidiRtl'],
	    ['Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','PageBreak']
*/
	  ];
	
};


