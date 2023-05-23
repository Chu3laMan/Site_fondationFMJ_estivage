/**
 * Halim Zaaim
 */
//change satatus
var targetParent=""; // supper global variable
var idd="";
function destroy_modal()
{
	$('.modal').removeClass('in');
    $('.modal').attr("aria-hidden","true");
    $('.modal').css("display", "none");
    $('.modal-backdrop').remove();
    $('body').removeClass('modal-open');
}

function handleFocuseSecond(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	 targetParent = $(firstParent).parent().attr("id");
}

function handlefocusthird(event)
{
	idd = "#"+event.target.id;
    var firstParent = $(idd).parent().attr("id");
    var secondParent = "#"+ $("#"+firstParent).parent().attr("id");
    targetParent = $(secondParent).parent().attr("id");
}


function handeAddTransport(event)
{
	event.preventDefault();
	ajax_addTransport();
}
function ajax_addTransport()
{
	var form = document.getElementById("transport");
	var dataToSend = new FormData(form);
	console.log(dataToSend.get("condition"));
	if ((dataToSend.get("file")["name"]).length === 0)
		{
		  dataToSend.delete("file");
		}
	if((dataToSend.get("condition")).length === 0)
		{
		  dataToSend.delete("condition");
		}
	$
			.ajax({
				type : "POST",
				enctype: 'multipart/form-data',
				url : "/Admin/transportAdmin/saveTransport",
				
				data : dataToSend,
				processData: false,// prevent jQuery from automatically
			        // transforming the data into a query string
			    contentType: false,
				cache : false,
				timeout : 60000,
				success : function(data) {
					 location.reload(true);
				},
				error : function(e) {

					/** * handle errors ** */
					 console.log("ERROR : ",e);
				}
		});
}

//change comment
function handleChangingTransportComment(event)
{
	event.preventDefault();
	ajax_TransportComment();
}
function ajax_TransportComment()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/transportAdmin/changeTransportComment",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"], comment = data["commentaire"];
        	let commentID = "commentTransport"+id;
            document.getElementById(commentID).innerHTML = comment;
            destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}

//change condition 
function handldechangeTransportCond(event)
{
	event.preventDefault();
	ajax_TransportCond();
}
function ajax_TransportCond()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/transportAdmin/changeTransportCondition",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"], condition = data["condition"];
        	let conditionID = "condTransport"+id;
            document.getElementById(conditionID).innerHTML = condition;
            destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}

//change attachment file 
function handldechangeFileAttach(event)
{
	event.preventDefault();
	ajax_TransportattachmentFile();
}
function ajax_TransportattachmentFile()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/Admin/transportAdmin/changeTransportAttachmentFile",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"], attachment = data["attachmentURL"];
        	let attachmentID = "attachmentTransport"+id;
            document.getElementById(attachmentID).innerHTML = attachment;
            destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}

//change the image
function handlechangingTransportImage(event)
{
	event.preventDefault();
	ajax_TransportImage();
}
function ajax_TransportImage()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/Admin/transportAdmin/changeTransportImage",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"], image = data["image"];
        	let imageID = "#"+"imageTransport"+id;
        	$(imageID).attr('src','data:image/jpeg;base64,'+image)
       	    destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}

//change status
function handldechangeTransportStatus(event)
{
	event.preventDefault();
	ajax_Transportstatus();
}
function ajax_Transportstatus()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/transportAdmin/changeTransportStatus",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"], status = data["status"];
        	let statusID = "statusTransport"+id;
            document.getElementById(statusID).innerHTML = status;
            
            let trId = "#ct"+id;
        	if(status === 0)
        		{
        		  $(trId).removeClass("table-light");
        		  $(trId).addClass("table-danger");
        		  
        		}
        	else
        		{
        		 $(trId).removeClass("table-danger");
      		     $(trId).addClass("table-light");
        		}
            destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
