/**
 * Halim zaaim
 *
 **/
  
/***************************** updating the image status ****************************************/
var targetParent=""; //supper global variable 
var idd="";

function submitHandler(event){
   
        event.preventDefault();
        fire_ajax_submit();
}

function handleFocuss(e)
{
	idd = "#"+e.target.id;
	var firstParent = $(idd).parent();
	targetParent = "."+firstParent.parent().attr("class");
	
}
     /*** send the request ***/
function fire_ajax_submit() {

    var infoToSend = {}
    infoToSend["imageName"] = $(targetParent+" "+'input[type="text"]').val();
    infoToSend["status"] = $(targetParent+" "+'input[type="number"]').val();

    $.ajax({
        type: "POST",
        //contentType: "application/json",
        url: "/Admin/index/changeSliderImageStatus",
        data:infoToSend,
        //dataType: 'json',
        cache: false,
        timeout: 6000,
        success: function (data) {
        	
        	/*** processes the data returned from the server and update the view ***/
        	
            var sId = data["id"];var newImagestatus = data["status"];
            var statusId = "status"+sId;
            var imageId = "img"+sId;
            
            document.getElementById(statusId).innerHTML = newImagestatus;
            if(newImagestatus === 0)
            	{
            	
            	document.getElementById(imageId).style.filter="blur(3px)";
            	}
            else{
            	document.getElementById(imageId).style.filter="blur(0px)";
            }
            
    
        },
        error: function (e) {

        	/*** handle errors ***/

        }
    });

}
/************************************************************************************************/
/****************************** changing image Expire date **************************************/
var targeteparentForm="";
var fuccusedInputId="";
function handleChangingexpireDateSubmit(event)
{
	event.preventDefault();
    fire_ajax_submit2();
}
function findTargetedFormClass(event)
{
	fuccusedInputId ="#"+event.target.id;
	var firtAncector = $(fuccusedInputId).parent();
	targeteparentForm ="."+firtAncector.parent().attr("class");
}
/*** send the request ***/
function fire_ajax_submit2() {

    var infoToSend = {}
    infoToSend["imageid"] = $(targeteparentForm+" "+'input[type="text"]').val();
    infoToSend["dateOfExperation"] = $(targeteparentForm+" "+'input[type="date"]').val();
    $.ajax({
        type: "POST",
        //contentType: "application/json",
        url: "/Admin/index/changeSliderImageDateofExpireDate",
        data:infoToSend,
        //dataType: 'json',
        cache: false,
        timeout: 6000,
        success: function (data) {
        	
        	/*** processes the data returned from the server and update the view ***/
        	
            var sId = data["id"];var newImageExpireDate = data["dateOfExperation"];
            var exprieDateId = "expiredate"+sId;
            document.getElementById(exprieDateId).innerHTML = newImageExpireDate;
        },
        error: function (e) {

        	/*** handle errors ***/

        }
    });
}
/************************************************************************************************/
/************************************* changing news status ************************************/
function handleNewsubmilt(event)
{
	event.preventDefault();
    fire_ajax_submit3();
}
var newsId = "";
var newsFormClass="";
function handleNewsFocuss(event)
{
	newsId = "#"+event.target.id;
	var firstparent = $(newsId).parent();
	newsFormClass = firstparent.parent().attr("id");
	console.log(newsFormClass);
}

function fire_ajax_submit3()
{      
	   var form = document.getElementById(newsFormClass);
	   console.log(form);
	    var infoToSend = new FormData(form);
	    console.log(...infoToSend);
	    $.ajax({
	        type: "POST",
	        //contentType: "application/json",
	        url: "/Admin/index/changeNewsStatus",
	        data:infoToSend,
	        //dataType: 'json',
	        processData: false,// prevent jQuery from automatically
	        // transforming the data into a query string
	        contentType: false,
	        cache: false,
	        timeout: 60000,
	        success: function (data) {
	        	
	        	/*** processes the data returned from the server and update the view ***/
	        	console.log(data);
	            var sId = data["id"];var newsNewStatus = data["status"];
	            var statusId = "newsStatus"+sId;
	            document.getElementById(statusId).innerHTML = newsNewStatus;
	            var newsIdCss = "newsContent"+sId;
	            if(newsNewStatus === 0 )
	            	{
	            	  document.getElementById(newsIdCss).style.color="#dc3545";
	            	  document.getElementById(newsIdCss).style.textDecoration="line-through";
	            	/*$("#"+newsIdCss).removeClass("newsActive"); //using jQuery
	            	$("#"+newsIdCss).addClass("newsDisactive");*/
	            	}
	            else{
	            	document.getElementById(newsIdCss).style.textDecoration= "none";
	            	document.getElementById(newsIdCss).style.color="#212529";
	            }
	        },
	        error: function (e) {

	        	/*** handle errors ***/
               console.log(e);
	        }
	    });
}
/*****************************************deleting image slider *********************************************************/
function handledeleteImage(event)
{
	event.preventDefault();
	var tagId = "#"+event.target.id;
	var tagImgUrl = $(tagId).attr("href");
    fire_ajax_submitd(tagImgUrl);
}
function fire_ajax_submitd(tagImgUrl)
{
	$.ajax({
        type: "GET",
        //contentType: "application/json",
        url: tagImgUrl,
       //data:infoToSend,
        //dataType: 'json',
        cache: false,
        timeout: 6000,
        success: function (data) {
        	
        	/*** processes the data returned from the server and update the view ***/
        	
            var sId = data["id"];
            var imageHolderId = "#"+"imgDelete"+sId;
            $(imageHolderId).remove();
        },
        error: function (e) {

        	/*** handle errors ***/

        }
    });
	
}
/***************************************** deleting news *****************************************************************/
function handleDeleteNews(event)
{
	event.preventDefault();
	var tagId = "#"+event.target.id;
	var tagUrl = $(tagId).attr("href");
    fire_ajax_submit4(tagUrl);
}
function  fire_ajax_submit4(tagUrl)
{
	$.ajax({
        type: "GET",
        //contentType: "application/json",
        url: tagUrl,
       //data:infoToSend,
        //dataType: 'json',
        cache: false,
        timeout: 60000,
        success: function (data) {
        	
        	/*** processes the data returned from the server and update the view ***/
        	
            var sId = data["id"];
            var newsHolderId = "#"+"newsContainer"+sId;
            $(newsHolderId).remove();
        },
        error: function (e) {

        	/*** handle errors ***/

        }
    });
	
}
/********************************** save news to database *************************************/
function handleUploadNews(event)
{
	event.preventDefault();
    fire_ajax_submit5();
}
function fire_ajax_submit5() {
	var form = document.getElementById("newsForm");
	var dataToSend = new FormData(form);
	if ((dataToSend.get("file")["name"]).length === 0)
		{
		  dataToSend.delete("file");
		}
	
	var htmlcontent = "";
	$
			.ajax({
				type : "POST",
				enctype: 'multipart/form-data',
				url : "/Admin/index/uploadNews",
				
				data : dataToSend,
				processData: false,// prevent jQuery from automatically
			        // transforming the data into a query string
			    contentType: false,
				cache : false,
				timeout : 60000,
				success : function(data) {

					/*** processes the data returned from the server and update the view ***/

					var sId = data["id"];
					var newsStatus = data["status"];
					var newsDisctription = data["description"];
					var newsAttachment = data["attachmentURL"];
					var newsStyle = "newsActive";

					htmlcontent = "<div class=\"col-lg-6\" id=\"newsContainer"
							+ sId
							+ "\"> "
							+ "<div class=\"ibox\">"
							+ "<div class=\"ibox-title\">"
							+ "<h5>إدارة الخبر</h5>"
							+ "<div class=\"ibox-tools\">"
							+ "<a class=\"collapse-link\"> <i class=\"fa fa-chevron-up\"></i>"
							+ "</a> <a class=\"close-link\"> <i class=\"fa fa-times\"></i>"
							+ "</a>"
							+ "</div>"
							+ "</div>"
							+ "<div class=\"ibox-content\" style=\"margin-bottom: -16px;\">"
							+ "<div class=\"row\">"
							+ "<div class=\"col-lg-12\">"
							+ "<div class=\"card card-block\" style=\"height: 120px; width: 100%;\">"
							+ "<div style=\"height: 150px;\">"
							+ "<p class=\""
							+ newsStyle
							+ " "
							+ "text-center m-2 font-weight-bold\""
							+ " id=\"newsContent"
							+ sId
							+ "\">"
							+ newsDisctription
							+ " </p>"
							+ "</div>"
							+ "<hr>"
							+ "<div style=\"height: 18px; width: 100%;\" class=\"mb-2\">"
							+ "<ul class=\"list-inline mb-2\">"
							+ "<li class=\"list-inline-item ml-4 alert-success\"><strong>رقم الخبر :<span>"
							+ sId
							+ "</span>"
							+ "</strong></li>"
							+ "<li class=\"list-inline-item  ml-4 alert-success\"><strong>حالة الخبر :<span id=\"newsStatus"
							+ sId
							+ "\"+>"
							+ newsStatus
							+ "</span>"
							+ "</strong></li>"
							+"<li class=\"list-inline-item  ml-4 alert-success\"><strong>"
							+":الملف الملحق<span>"+newsAttachment+"</span>"
					        +"</strong></li>"
							+ "</ul>"
							+ "</div>"
							+ "</div>"
							+ "</div>"
							+ "</div>"
							+ "<hr>"
							+ "<div>"
							+ "<div class=\"row\">"
							+ "<button type=\"button\" class=\"btn1 btn btn-primary mr-2 ml-2\" data-toggle=\"collapse\" data-target=\"#feed"
							+ sId
							+ "\">&nbsp;تغيير حالة الخبر&nbsp;</button>"
							+

							"<a href=\"/Admin/index/deleteNews/"
							+ sId
							+ "\" id=\"deleteNews"
							+ sId
							+ "\" onclick=\"handleDeleteNews(event);\" class=\"btn btn-danger\">&nbsp;حذف الخبر&nbsp;</a>"
							+ "</div>"
							+ "<hr>"
							+ "<div class=\"collapse\" id=\"feed"
							+ sId
							+ "\">"
							+ "<form class=\"newsForm"
							+ sId
							+ "\" onsubmit=\"handleNewsubmilt(event);\">"
							+ "<div class=\"alert alert-danger\">"
							+ "<p class=\"text-center font-weight-bold\">تغيير حالة الخبر، 0 = غير نشط ، 1 = نشط:</p>"
							+ "</div>"
							+ "<div class=\"form-group\">"
							+ "<label>رقم الخبر :</label> <input type=\"text\" name=\"newsId\" class=\"form-control\" value="
							+ sId
							+ ">"
							+ "<label>الحالة:</label>"
							+ "<input type=\"number\" min=\"0\" max=\"1\" name=\"status\" id=\"feedstatus"
							+ sId
							+ "\" onfocus=\"handleNewsFocuss(event);\" class=\"form-control\">"
							+ "</div>"
							+ "<button class=\"btn btn-info \" type=\"submit\">"
							+ "<i class=\"fa fa-upload\"></i>&nbsp;&nbsp;<span class=\"bold\">تحميل</span>"
							+ "</button>" + "</form>" + "</div>" + "</div>"
							+ "</div>" + "</div>" + "</div>";
					$(".insert-news").append(htmlcontent);
					
				},
				error : function(e) {

					/*** handle errors ***/

				}
			});
	
}

/*********************************** SERVICE IMAGE ************************************************/
/**################################ Upload new service Image ####################################**/
function handleUploadServiceImage(event)
{
	 event.preventDefault();
	 fire__ajax__submit();
}

function  fire__ajax__submit()
{
	//Get form
    var form = document.getElementById("ServiceImage-upload");
    var data = new FormData(form);
    $("#btnSubmit").prop("disabled", true);

    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/Admin/index/saveSeriveImage",
        data: data,
        processData: false,//prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

        	var htmlCode="";
        	let id = data["id"];let image = data["service_image"];
        	let serviceName = data["serviceName"];let imageName = data["imageName"];
        	htmlCode = "<div class=\"col-lg-6\" id=\"serviceImage"+id+"\">"+
        	"<div class=\"ibox\">"+
        	"<div class=\"ibox-title\">"+
        	"<h5>إدارة صورة الخدمة</h5>"+
        	"<div class=\"ibox-tools\">"+
        	"<a class=\"collapse-link\"> <i class=\"fa fa-chevron-up\"></i>"+
        	"</a> <a class=\"close-link\"> <i class=\"fa fa-times\"></i>"+
        	"</a>"+
        	"</div>"+
        	"</div>"+
        	"<div class=\"ibox-content\">"+

        	"<div class=\"row\">"+
        	"<div class=\"col-6\">"+
        	"<div class=\"card card-block\">"+
        	"<img alt=\"\"  id=\"simage"+id+"\" style=\"height: 235px;\""+
        	"src=\"data:image/jpeg;base64,"+image+"\">"+
        	"</div>"+
        	"</div>"+
        	"<div class=\"col-6 mt-4\">"+
        	"<div class=\"card card-block\">"+
        	"<div class=\"list-group\">"+
        	"<h4 class=\"card-title text-center\">تفاصيل الصورة</h4>"+
        	"<p class=\"list-group-item alert-success\">"+
        	"	<strong> رقم :  </strong><span>"+id+"</span>"+
        	"</p>"+
        	"<p class=\"list-group-item alert-success\">"+
        	"<strong>الحالة: </strong><span class=\"further-info\"></span>"+
        	"</p>"+
        	"<p class=\"list-group-item alert-success\">"+
        	"<span id=\"simgName+"+id+"\">"+imageName+"</span><strong> : اسم الصورة</strong>"+
        	"</p>"+
        	"<p class=\"list-group-item alert-success\">"+
        	"<strong>ااسم الخدمة :</strong><span> "+ serviceName +" </span>"+
        	"</p>"+

        	"</div>"+
        	"</div>"+
        	"</div>"+
        	"</div>"+
        	"<hr>"+
        	"<div>"+
        	"<div class=\"row\">"+
        	"<button type=\"button\" class=\"btn1 btn btn-primary mr-2 ml-2\" data-toggle=\"collapse\" data-target=\"#service"+id+"\">" +
        	"&nbsp;تغيير الصورة&nbsp;</button>"+

        	"<a href=\"/Admin/index/deleteServiceImage/"+id+"\" onclick=\"handledeleteServiceImage(event);\" class=\"btn btn-danger\" id=\"id"+id+"\">&nbsp;حذف صورة&nbsp;</a>"+
        	"</div>"+
        	"<hr>"+
        	"<div class=\"collapse\" id=\"service"+id+"\">"+
        	"<form id=\"serviceForm"+id+"\" method=\"POST\" onsubmit=\"handlerServiceImageUpdate(event);\">"+
        	"<div class=\"alert alert-danger\">"+
        	"<p class=\" text-center font-weight-bold\">تغيير الصورة </p>"+
        	"</div>"+
        	"<div class=\"form-group\">"+
        	" <input type=\"text\" name=\"id\" class=\"form-control\" value=\""+id+"\">"+
        	"</div>"+
        	"<div class=\"form-group\">"+
        	"<p class=\"m-t-sm\">اختيار الصورة</p>"+
        	"<div class=\"custom-file\">"+
        	"<input id=\"logo"+id+"\" type=\"file\" name=\"newfile\" onfocus=\"handleServiceFocused(event);\" class=\"custom-file-input form-control\"> " +
        	"<label for=\"logo\" class=\"custom-file-label\">اختر ملف...</label>"+
        	"</div>"+
        	"</div>"+
        	"<button class=\"btn btn-info\" type=\"submit\">"+
        	"<i class=\"fa fa-upload\"></i>&nbsp;&nbsp;<span class=\"bold\">تحميل</span>"+
        	"</button>"+
        	"</form>"+
        	"</div>"+

        	"</div>"+
        	"</div>"+
        	"</div>"+
        	"</div>";
            
        $("#insertServiceImage").append(htmlCode);
        $("#btnSubmit").prop("disabled", false);
        },
        error: function (e) {

            console.log("ERROR : ", e);
            $("#btnSubmit").prop("disabled", false);

        }
    });

}

/******************************** UPDATE A SERVICE IMAGE ***************************************/
function handlerServiceImageUpdate(event)
{
	 event.preventDefault();
	 fire__ajax__submit1();
}
var formtargetedId = "";
function handleServiceFocused(event)
{
	let id = "#"+event.target.id;
	let formTargeted = $(id).parent().parent().parent();
	formtargetedId =formTargeted.attr("id");
}
function fire__ajax__submit1()
{
	var form = document.getElementById(formtargetedId);
    var data = new FormData(form);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/Admin/index/updateServiceImage",
        data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

           let id = data["id"]; let image = data["service_image"];let imageName = data["imageName"];
           let idImageAttr = "#simage"+id;
           let idServiceName = "#simgName"+id;
        
           $(idImageAttr).attr("src","data:image/jpeg;base64,"+ image);
           $(idServiceName).text(imageName );
        }, 
        error: function (e) {

            console.log("ERROR : ", e);
        
        }
    });
	
}

/*************************************** delete service image **********************************/
function handledeleteServiceImage(event)
{
	event.preventDefault();
    let id = "#"+event.target.id;
    var Url = $(id).attr("href");
    fire__ajax__submit2(Url);
}
function fire__ajax__submit2(Url)
{
	$.ajax({
        type: "GET",
       // enctype: 'multipart/form-data',
        url: Url,
        //data: data,
        processData: false,
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {

           var id = "#serviceImage"+data;
           $(id).remove();

        },
        error: function (e) {

          
            console.log("ERROR : ", e);

        }
    });
	
}