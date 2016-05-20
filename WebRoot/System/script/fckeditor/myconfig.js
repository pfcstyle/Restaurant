
// 1. 鑷畾涔�ToolbarSet

FCKConfig.ToolbarSets["simple"] = [
	['Bold','Italic','Underline'],
	['Link','Unlink'],
	['Image','Smiley','SpecialChar'],
	['FontName'],
	['FontSize'],
	['TextColor','BGColor'],
] ;

FCKConfig.ToolbarSets["bbs"] = [
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	['Bold','Italic','Underline'],
	['Subscript','Superscript'],
	['JustifyLeft','JustifyCenter','JustifyRight'],
	['Link','Unlink'],
	['Image','Smiley','SpecialChar'],
	['Table'],
	['OrderedList','UnorderedList','-','Outdent','Indent'],
	['FontName'],
	['FontSize'],
	['TextColor','BGColor'],
	['FitWindow']
] ;

FCKConfig.ToolbarSets["formTemplateDesigner"] = [
	['Source','DocProps','-','Save','NewPage','Preview','-','Templates'],
	['Cut','Copy','Paste','PasteText','PasteWord','-','Print','SpellCheck'],
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],
	['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote','CreateDiv'],
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
	['Form','Checkbox','Radio','TextField','Textarea','Select','Button','ImageButton','HiddenField'],
	['Link','Unlink','Anchor'],
	['Image','Flash','Table','Rule','Smiley','SpecialChar','PageBreak'],
	['Style','FontFormat','FontName','FontSize'],
	['TextColor','BGColor'],
	['FitWindow','ShowBlocks','-','About']		// No comma for the last row.
] ;

// 鏄惁寮�惎绠�崟鍔熻兘涓庨珮绾у姛鑳芥樉绀�if(typeof(FCKConfig.EnableAdvanceTable) == "undefined"){ // 鍦ㄩ〉闈腑璋冪敤fckeditor鏃舵寚瀹氱殑 EnableAdvanceTable 鐨勫�浼氬厛琚皟鐢ㄣ�
	FCKConfig.EnableAdvanceTable = false; // 榛樿涓篺alse
	// FCKConfig.EnableAdvanceTable = true;
//}

// 鍦ㄩ珮绾у姛鑳芥樉绀虹殑鍔熻兘锛岀储寮曚粠1寮�锛堝彧鏈夌偣鍑讳簡鈥滈珮绾у姛鑳解�锛屾墠鏄剧ず锛�FCKConfig.AdvanceTableNum = 0;
FCKConfig.AdvanceTable = [1,3,5,6,7];

// 2. 娣诲姞涓枃瀛椾綋
FCKConfig.FontNames 	='瀹嬩綋;妤蜂綋_GB2312;榛戜綋;闅朵功;Times New Roman;Arial' ;
FCKConfig.FontSizes     ='9/鏈�皬;12/杈冨皬;16/涓瓑;20/杈冨ぇ;24/鏈�ぇ';

// 3. 淇敼 "鍥炶溅" 鍜�"shift + 鍥炶溅" 鐨勬牱寮�FCKConfig.EnterMode = 'br' ;			// p | div | br
FCKConfig.ShiftEnterMode = 'p' ;	// p | div | br

// 4. 鏇存崲琛ㄦ儏鍥剧墖
FCKConfig.SmileyPath	= FCKConfig.BasePath + 'images/smiley/wangwang/' ;
FCKConfig.SmileyImages	= ['0.gif','1.gif','2.gif','3.gif','4.gif','5.gif','6.gif','7.gif','8.gif','9.gif','10.gif','11.gif','12.gif','13.gif','14.gif','15.gif','16.gif','17.gif','18.gif','19.gif','20.gif','21.gif','22.gif','23.gif','24.gif','25.gif','26.gif','27.gif','28.gif','29.gif','30.gif','31.gif','32.gif','33.gif','34.gif','35.gif','36.gif','37.gif','38.gif','39.gif','40.gif','41.gif','42.gif','43.gif','44.gif','45.gif','46.gif','47.gif','48.gif','49.gif','50.gif','51.gif','52.gif','53.gif','54.gif','55.gif','56.gif','57.gif','58.gif','59.gif','60.gif','61.gif','62.gif','63.gif','64.gif','65.gif','66.gif','67.gif','68.gif','69.gif','70.gif','71.gif','72.gif','73.gif','74.gif','75.gif','76.gif','77.gif','78.gif','79.gif','80.gif','81.gif','82.gif','83.gif','84.gif','85.gif','86.gif','87.gif','88.gif','89.gif','90.gif','91.gif','92.gif','93.gif','94.gif','95.gif','96.gif','97.gif','98.gif'] ;
FCKConfig.SmileyColumns = 8 ;
FCKConfig.SmileyWindowWidth		= 668 ;
FCKConfig.SmileyWindowHeight	= 480 ;

// 5. 璁剧疆鍏佽涓婁紶鐨勫浘鐗囩被鍨嬬殑鎵╁睍鍚嶅垪琛�FCKConfig.ImageUploadAllowedExtensions	= ".(jpg|gif|jpeg|png|bmp)$" ;		// empty for all

// 鍏跺畠闇�淇敼鐨勯厤缃�... 

FCKConfig.LinkDlgHideTarget		= true; // false ;
FCKConfig.LinkDlgHideAdvanced	= true; // false ;

FCKConfig.ImageDlgHideLink		= true; // false ;
FCKConfig.ImageDlgHideAdvanced	= true; // false 

FCKConfig.LinkUpload = false;
