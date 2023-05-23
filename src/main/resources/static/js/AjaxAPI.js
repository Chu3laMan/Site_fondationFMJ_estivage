/**
 * 
 */

function populateCarousel(event) {
	event.preventDefault();
	var url = "";
	var tag = event.target.tagName;
	if (tag === "IMG") {
		var image = event.srcElement;

		let aTag = image.parentNode;
		url = aTag.getAttribute("href");
	}
	if (tag === "A") {
		var id = "#" + event.target.id;
		url = $(id).attr("href");

	}
	ajax_getImages(url);
}
function ajax_getImages(url)
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
        	var album ="";
        	var htmlCode =""; var first = true;
        	for( x in data)
        		{
        		  album = data[x]["album"];
        		   
        		if(first)
        			{
        			 htmlCode = "\n"+htmlCode+
            		 "<div class=\"carousel-item active\">"+
    			     "<img class=\"d-block w-100 img-size\" src=\"data:image/jpeg;base64,"+data[x]["image"]+"\""+
    			     " alt=\"sile\">"+
    			     "</div>";
        			 first = false;
        			}
        		else{
        			htmlCode ="\n"+ htmlCode +
            		"<div class=\"carousel-item\">"+
    			    "<img class=\"d-block w-100 img-size\" src=\"data:image/jpeg;base64,"+data[x]["image"]+"\""+
    			     " alt=\"sile\" >"+
    			     "</div>";
        		}
        		
        		}
        		
            	var id = album["id"];
            	var idCarousel = "#insertImg"+id;
            	$(idCarousel).empty();
            	$(idCarousel).append(htmlCode);

        },
	  error: function (e) {

        console.log("ERROR : ",e);
         
      }
  });
}