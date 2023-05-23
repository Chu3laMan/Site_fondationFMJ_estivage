/**
 * Halim Zaaim
 */
function destroy_modal()
{
	$('.modal').removeClass('in');
    $('.modal').attr("aria-hidden","true");
    $('.modal').css("display", "none");
    $('.modal-backdrop').remove();
    $('body').removeClass('modal-open');
}
/**
 * ****************************** change the image of codification table
 * ****************
 */
function handlechangingImage(event)
{ 
	event.preventDefault();
    ajax_submit();
}
var targetParent=""; // supper global variable
var idd="";
function handlefocus(event)
{

     idd = "#"+event.target.id;
     var firstParent = $(idd).parent().attr("id");
     var secondParent = "#"+ $("#"+firstParent).parent().attr("id");
     targetParent = $(secondParent).parent().attr("id");

}
function  ajax_submit()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/Admin/hebergementAdmin/changeCodImage",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"],image = data["image"];
        	let imageID = "#"+"image"+id;
        	$(imageID).attr('src','data:image/jpeg;base64,'+image)
        	 destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });

}
/** *********************************************************************************** */
/**
 * ************************** changing codification status
 * ***************************
 */
function handldechangeStatusSubmit(event)
{
	event.preventDefault();
    ajax_submit1();
}

function handlenumberFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit1()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changeCodStatus",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"],status = data["supprimer"];
        	let statusID = "supp"+id;
        	 document.getElementById(statusID).innerHTML = status ;
        	let trId = "#cd"+id;
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

/** ************************************************************************************ */
/**
 * ************************* change codification comment
 * ******************************
 */
function handleChangingComment(event)
{
	event.preventDefault();
    ajax_submit2();
}
function handleFocuseComment(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}

function ajax_submit2()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	console.log(data);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changeCodComment",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"], comment = data["commentaire"];
        	let commentID = "comment"+id;
        	document.getElementById(commentID).innerHTML = comment ;
        	destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}

/** ************************************************************************************ */
/**
 * ******************************** TypeCredit
 * ****************************************
 */

function handleCreditSubmit(event)
{
	event.preventDefault();
	ajax_submit_credit();
}
function ajax_submit_credit()
{
	var form = document.getElementById("creditForm");
	var data = new FormData(form);
	console.log(data);
	$.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/Admin/hebergementAdmin/saveTypeCredit",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"], comment = data["commentaire"];
        	// need to insert the new TypeCredit to the html
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
// change comment
function handleChangingCreditComment(event)
{
	event.preventDefault();
	ajax_submit_credit1();	
}
function handleFocuseCreditComment(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_credit1()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changeTypeCreditComent",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"], comment = data["commentaire"];
        	let commentId = "creditComment"+id;
        	document.getElementById(commentId).innerHTML = comment ;
        	 destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}

// change PfullCredit
function handldechangeCreditpFullCredit(event)
{
	event.preventDefault();
	ajax_submit_credit2();	
}
function handleCreditfFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function 	ajax_submit_credit2()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changeTypeCreditpFullCredit",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"], pFullCredit = data["pFullCredit"];
        	let pFullCreditId = "pFullCredit"+id;
        	document.getElementById(pFullCreditId).innerHTML = pFullCredit;
        	destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
// change pPartCredit
function handldechangeCreditPSubmit(event)
{
	event.preventDefault();
	ajax_submit_credit3();	
}
function handleCreditPFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_credit3()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changeTypeCreditpPartCredit",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"], pFullCredit = data["pPartCredit"];
        	let pPartCreditId = "pPartCredit"+id;
        	document.getElementById(pPartCreditId).innerHTML = pFullCredit;
        	destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
// change status
function handldechangeCreditStatusSubmit(event)
{
	event.preventDefault();
	ajax_submit_credit4();
	// $(".modal-header button").click();
	// $('.modal-backdrop').remove();
	
}

function handleCreditStatusFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
	 
}

function ajax_submit_credit4()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changeTypeCreditStatus",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	let id = data["id"], status = data["supprimer"];
        	let statusId = "suppCredit"+id;
        	document.getElementById(statusId).innerHTML =  status;
        	let trId = "#td"+id;
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

/** ************************************************************************************ */
/**
 * ******************************** ServiceBank table
 * *********************************
 ****************************************************************************************/
function handleServiceBsubmit(event)
{
	event.preventDefault();
	ajax_submit_SBank();
}

function ajax_submit_SBank()
{
	
	var form = document.getElementById("serviceBankForm");
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/saveServiceBank",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	// add the new Service bank to the page
        	
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
	
}
// change comment
function handleChangingsBankComment(event)
{
	event.preventDefault();
	ajax_submit_SBank1();
}

function handleFocusesBankComment(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
	 
}

function ajax_submit_SBank1()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changesBankComment",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], comment = data["commentaire"];
        	let commentId = "sBankComment"+id;
        	document.getElementById(commentId).innerHTML =  comment;
        	destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
// change moda
function handldechangeModasBank(event)
{
	event.preventDefault();
	ajax_submit_SBank2();
}
function handlesBankModafFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
	  console.log(targetParent);
}
function ajax_submit_SBank2()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	console.log(...data);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changeModasBank",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], moda = data["moda"];
        	let modaId = "modasBank"+id;
        	document.getElementById(modaId).innerHTML = moda;
        	 destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
// change faida
function handldechangeFaidasBankSubmit(event)
{
	event.preventDefault();
	ajax_submit_SBank3();
}
function handlefaidasBankFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_SBank3()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changesBankFaida",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], faida = data["faida"];
        	let faidaId = "faidasBank"+id;
        	document.getElementById(faidaId).innerHTML = faida;
        	 destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
// change sakf
function handldechangesakfsBankSubmit(event)
{
	event.preventDefault();
	ajax_submit_SBank4();
}
function handlesakfsBankFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_SBank4()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changsBankSakf",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], sakf = data["sakf"];
        	let sakfId = "sakfsBank"+id;
        	document.getElementById(sakfId).innerHTML = sakf;
        	 destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}

// change sattus
function handldechangesBankStatusSubmit(event)
{
	event.preventDefault();
	ajax_submit_SBank5();
}
function handlesBankStatusFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_SBank5()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changesBankStatus",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], status = data["supprimer"];
        	let staId = "suppsBank"+id;
        	document.getElementById(staId).innerHTML = status;
        	let trId = "#sd"+id;
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

/** *************************************************************************************************************** */
/**
 * ********************************************* service Immob
 * ***************************************************
 */
// save service Immob

function handleServiceImmobsubmit(event)
{
	event.preventDefault();
	ajax_submit_sImmobBank();
}
function ajax_submit_sImmobBank()
{
	var form = document.getElementById("serviceImmobForm");
	var data = new FormData(form);
	console.log(...data);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/saveServiceImmob",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
// change comment
function handleChangingsImmobComment(event)
{
	event.preventDefault();
	ajax_submit_sImmobBank1();
}
function handleFocusesImmobComment(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_sImmobBank1()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changesImmobCommet",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], comment = data["commentaire"];
        	let commentId = "sImmobComment"+id;
        	document.getElementById(commentId).innerHTML = comment;
        	 destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
// change promotion
function handldechangepromosImmob(event)
{
	event.preventDefault();
	ajax_submit_sImmobBank2();
}
function handlepromosImmobFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_sImmobBank2()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changesImmobPrommotion",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], promotion = data["promotion"];
        	let promoId = "pomosImmob"+id;
        	document.getElementById(promoId).innerHTML = promotion;
        	 destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });	
}
// change Localisation
function handldechangelocalisImmobSubmit(event)
{
	event.preventDefault();
	ajax_submit_sImmobBank3();
}
function handlelocalisImmobFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_sImmobBank3()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changsImmobLocalisation",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], localisation = data["localisation"];
        	let locaId = "localisImmob"+id;
        	document.getElementById(locaId).innerHTML = localisation;
        	 destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });	
}

// change satatus
function handldechangesImmobStatusSubmit(event)
{
	event.preventDefault();
	ajax_submit_sImmobBank4();
}
function handlesImmobStatusFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_sImmobBank4()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changesImmobStaus",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], status = data["supprimer"];
        	let statusId = "suppsImmob"+id;
        	document.getElementById(statusId).innerHTML = status;
        	let trId = "#si"+id;
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

/** ****************************************************************************************************************** */
/**
 * ****************************************** serviceBankTach
 * *******************************************************
 */
// save serviceBankTach
function handleServiceBTachsubmit(event)
{
	event.preventDefault();
	ajax_submit_sBankTach();
}
function ajax_submit_sBankTach()
{
	var form = document.getElementById("serviceBTachForm");
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/saveServiceBankTach",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	// add the service to the HTML ( a task must be done)
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });
}
// change comment
function handleChangingsBankTComment(event)
{
	event.preventDefault();
	ajax_submit_sBankTach1();
}
function handleFocusesBankTComment(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_sBankTach1()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changesBankTachComment",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], comment = data["commentaire"];
        	let commentId = "sBankTComment"+id;
        	document.getElementById(commentId).innerHTML = comment;
        	 destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });	
}
// change moda
function handldechangemodasBankT(event)
{
	event.preventDefault();
	ajax_submit_sBankTach2();
}
function handlemodasBankTFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_sBankTach2()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changesBankTachModa",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], moda = data["moda"];
        	let modaId = "modasBankT"+id;
        	document.getElementById(modaId).innerHTML = moda;
        	 destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });	
}
// change hamichRib7
function handldechangeribhsBankTSubmit(event)
{
	event.preventDefault();
	ajax_submit_sBankTach3();
}
function handleribhsBankTFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_sBankTach3()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changesBankTachRibh",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], ribh = data["hamichRib7"];
        	let ribhId = "ribhsBankT"+id;
        	document.getElementById(ribhId).innerHTML = ribh;
        	 destroy_modal();
        },
	  error: function (e) {

          console.log("ERROR : ", e);
         
      }
  });	
}

// change status
function handldechangesBankTStatusSubmit(event)
{
	event.preventDefault();
	ajax_submit_sBankTach4();
}
function handlesBankTStatusFocuse(event)
{
	var id = "#"+event.target.id;
	var firstParent = "#"+$(id).parent().attr("id");
	  targetParent = $(firstParent).parent().attr("id");
}
function ajax_submit_sBankTach4()
{
	var form = document.getElementById(targetParent);
	var data = new FormData(form);
	$.ajax({
        type: "POST",
        url: "/Admin/hebergementAdmin/changeServiceBankTachStatus",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	var id = data["id"], status = data["supprimer"];
        	let sId = "suppsBankT"+id;
        	document.getElementById(sId).innerHTML = status;
        	let trId = "#sBT"+id;
        	console.log(trId);
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