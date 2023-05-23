/**
 * 
 */
function handleResponsesubmit(event)
{
	event.preventDefault();
	fire_ajax();
}
function fire_ajax()
{
	var form = document.getElementById("ResponseForm");
	var data = new FormData(form);
	var email=" ";
	var children = $(".note-editable").children();
	for(var i = 1 ; i< children.length; i++)
		{
		  email = email + children.eq(i).text() + " ";
		}
	data.append("reponse",email);
	
	$.ajax({
        type: "POST",
        //enctype: 'multipart/form-data',
        url: "/Admin/mail_compose/saveResponse",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	$(".succes-submit").removeClass("d-none");
        	console.log($(".succes-submit"));
        },
	  error: function (e) {

         $(".error-submit").removeClass("d-none");
         
      }
  });

}
/******************************** send fondation email *****************************/
function handleSendEmail(event)
{
	event.preventDefault();
	fire_ajax1();
}
function fire_ajax1()
{
	var form = document.getElementById("fondationEmail");
	var data = new FormData(form);
	var email=" ";
	var children = $(".note-editable").children();
	for(var i = 1 ; i< children.length; i++)
		{
		  email = email + children.eq(i).text() + " ";
		}
	data.append("emailBody",email);
	console.log(...data);
	$.ajax({
        type: "POST",
        //enctype: 'multipart/form-data',
        url: "/Admin/mail_compose/saveFondationEmail",
        data: data,
        processData: false,// prevent jQuery from automatically
        // transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	$(".succes-submit").removeClass("d-none");
        	console.log($(".succes-submit"));
        },
	  error: function (e) {

         $(".error-submit").removeClass("d-none");
         
      }
  });

}