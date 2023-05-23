/**
 * 
 */
/********************************** video ***************************************/
function handledeleteVideo(event)
{
	event.preventDefault();
	var id = "#"+event.target.id;
	var url = $(id).attr("href");
	ajax_video(url);
}
function ajax_video(url)
{
	$.ajax({
        type: "GET",
        url: url,
       // data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"];
        	var idVideo = "#videoDelete"+id;
        	$(idVideo).remove();
        },
	  error: function (e) {

        console.log("ERROR : ",e);
         
      }
  });
}

//change satatus
var targetParent=""; // supper global variable
var idd="";
function handleChangeVideoStatus(event)
{
	event.preventDefault();
	ajax_video1();
}
function handleVFocuss(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	 targetParent = $(firstParent).parent().attr("id");
}

function ajax_video1()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/videoAdmin/changeVideoStatus",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"],status = data["status"];
        	let statusID = "Vstatus"+id;
            document.getElementById(statusID).innerHTML = status ;
            if(status === 0)
            	{
            	 $("#"+statusID).addClass("colr");
            	}
            else
            	 $("#"+statusID).removeClass("colr");
            	
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
/*******************************************************************************/
function handledeletePublication(event)
{
	event.preventDefault();
	var id = "#"+event.target.id;
	var url = $(id).attr("href");
	ajax_publication(url);
}

function ajax_publication(url)
{
	$.ajax({
        type: "GET",
        url: url,
       // data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"];
        	var idVideo = "#publicationDelete"+id;
        	$(idVideo).remove();
        },
	  error: function (e) {

        console.log("ERROR : ",e);
         
      }
  });
}

//change publication status
function handleChangePubStatus(event)
{
	event.preventDefault();
	ajax_publication1();
}
function ajax_publication1()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/publication3Admin/changePublicationStatus",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"],status = data["status"];
        	let statusID = "Vpublication"+id;
            document.getElementById(statusID).innerHTML = status ;
            if(status === 0)
            	{
            	 $("#"+statusID).addClass("colr");
            	}
            else
            	 $("#"+statusID).removeClass("colr");
            	
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
//change attachmentFile

function handleChangePubAttachment(event)
{
	event.preventDefault();
	ajax_publication2();
}
function ajax_publication2()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/Admin/publication3Admin/changeAtachmentFile",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"],name = data["atachmentURL"];
        	let nameID = "puName"+id;
            document.getElementById(nameID).innerHTML = name ;
            
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}

//gallery
function handledeleteImgG(event)
{
	event.preventDefault();
	var id = "#"+event.target.id;
	var url = $(id).attr("href");
	ajax_gallery(url);
}

function ajax_gallery(url)
{
	$.ajax({
        type: "GET",
        url: url,
       // data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"];
        	var idVideo = "#imgDelete"+id;
        	$(idVideo).remove();
        },
	  error: function (e) {

        console.log("ERROR : ",e);
         
      }
  });
}

//
function handleChangeImgGStatus(event)
{
	event.preventDefault();
	ajax_gallery1();
}

function ajax_gallery1()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/galleryAdmin/changeImageGStatus",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"],status = data["status"];
        	let statusID = "Vimg"+id;
            document.getElementById(statusID).innerHTML = status ;
            if(status === 0)
            	{
            	 $("#"+statusID).addClass("colr");
            	}
            else
            	 $("#"+statusID).removeClass("colr");
            	
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}

//RequestOffer
function handleChangeofferAttachment(event)
{
	event.preventDefault();
	ajax_offer();
}
function ajax_offer()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/Admin/publicationAdmin/changeRequestOfferAttachment",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"],name = data["attachmentURL"];
        	let nameID = "offerAtt"+id;
            document.getElementById(nameID).innerHTML = name ;
            
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
//status
function handleChangeOfferStatus(event)
{
	event.preventDefault();
	ajax_offer1();
}
function ajax_offer1()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/publicationAdmin/changeRequestOfferstatus",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"],status = data["status"];
        	let statusID = "Voffer"+id;
            document.getElementById(statusID).innerHTML = status ;
            if(status === 0)
            	{
            	 $("#"+statusID).addClass("colr");
            	}
            else
            	 $("#"+statusID).removeClass("colr");
            	
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}

//delete
function handledeleteOffer(event)
{
	event.preventDefault();
	var id = "#"+event.target.id;
	var url = $(id).attr("href");
	ajax_offer3(url);
}

function ajax_offer3(url)
{
	$.ajax({
        type: "GET",
        url: url,
       // data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"];
        	var idOffer = "#offerDelete"+id;
        	$(idOffer).remove();
        },
	  error: function (e) {

        console.log("ERROR : ",e);
         
      }
  });
}

function addrequestOffer(event)
{
	event.preventDefault();
	ajax_offerAdd();
}

function ajax_offerAdd()
{
	var form = document.getElementById("offerForm");
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/Admin/publicationAdmin/saveRequestOffer",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	
        	 console.log("SUCCES : ", data);  
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
// manachir
function handledeleteMenchor(event)
{
	event.preventDefault();
	var id = "#"+event.target.id;
	var url = $(id).attr("href");
	ajax_manachirDelete(url);
}

function ajax_manachirDelete(url)
{
	$.ajax({
        type: "GET",
        url: url,
       // data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"];
        	var idOffer = "#manachirDelete"+id;
        	$(idOffer).remove();
        },
	  error: function (e) {

        console.log("ERROR : ",e);
         
      }
  });
}
//change status
function handleChangeMenchStatus(event)
{
	event.preventDefault();
	ajax_manachirStatus();
}
function ajax_manachirStatus()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/manachirAdmin/changemenchorStatus",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"],status = data["status"];
        	let statusID = "menStatus"+id;
            document.getElementById(statusID).innerHTML = status ;
            if(status === 0)
            	{
            	 $("#"+statusID).addClass("colr");
            	}
            else
            	 $("#"+statusID).removeClass("colr");
            	
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
//change attachment file 

function handleChangeMenAttachment(event)
{
event.preventDefault();
ajax_manachirAttachment();
}
function ajax_manachirAttachment()
{
var form = document.getElementById(targetParent);
var data = new FormData(form);
$.ajax({
    type: "POST",
    enctype: 'multipart/form-data',
    url: "/Admin/manachirAdmin/changeMenchorAttachment",
    data: data,
    processData: false,// prevent jQuery from automatically
    // transforming the data into a query string
    contentType: false,
    cache: false,
    timeout: 600000,
    success: function (data) {
    	let id = data["id"],name = data["attachmentURL"];
    	let nameID = "menName"+id;
        document.getElementById(nameID).innerHTML = name ;
        
    },
  error: function (e) {

      console.log("ERROR : ", e);
     
  }
});
}

function handledeleteAlbum(event)
{
	event.preventDefault();
	var id = "#"+event.target.id;
	var url = $(id).attr("href");
	 ajax_albumDelete(url);
}

function ajax_albumDelete(url)
{
	$.ajax({
        type: "GET",
        url: url,
       // data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"];
        	var idAlbum = "#albumDelete"+id;
        	console.log("donnnnnnnnnnne");
        	$(idAlbum).remove();
        },
	  error: function (e) {

        console.log("ERROR : ",e);
         
      }
  });
}	
