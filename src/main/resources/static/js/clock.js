function display_c(){
var refresh=1000; 
mytime=setTimeout('display_ct()',refresh)
}

function display_ct() {
var x = new Date();
var d = x.getDay();
var m = x.getMonth();
var y = x.getFullYear();
var days = {0:"الأحد",1:"الإثنين",2:"الثلاثاء",3:"الأربعاء",4:"الخميس",5:"الجمعة",6:"السبت"};
var months = {0:"يناير",1:"فبراير",2:"مارس",3:"أبريل",4:"ماي",5:"يونيو",6:"يوليوز",7:"غشت",8:"شتنبر",9:"أكتوبر",10:"نونبر",11:"دجنبر"}
var d1 = days[d];
var m1 = months[m];
var d2 = d + 1;
var x1 = d1 + " " + d2 +" " + m1 + " " + y; 
document.getElementById('ct').innerHTML = x1;
display_c();
}


/****************************** BOX display *************************/
$(document).ready(function() {
	  //global vars
	  const para1 = $(".para1");
	  const para2 = $(".para2");
	  const para3 = $(".para3");
	  const para4 = $(".para4");
	  $(".btn1").click(function(e) {
	    e.preventDefault();
	    var parent = $(".card-block");
	    var child1 = parent.children(".para");
	    if (child1 !== para1) {
	      child1.remove();
	      parent.append(para1);
	      para1.removeClass("hide");
	      para1.addClass(" show");
	    }
	  });
	  //second button
	  $(".btn2").click(function(e) {
	    e.preventDefault();

	    var parent = $(".card-block");
	    var child1 = parent.children(".para");

	    if (child1 !== para2) {
	      child1.remove();
	      parent.append(para2);
	      para2.removeClass("hide");
	      para2.removeClass("completly-hidden");
	      para1.remove();
	      $(".btn1").removeClass("active");
	      para3.addClass(" show");
	    }
	  });
	  // third button
	  $(".btn3").click(function(e) {
	    e.preventDefault();

	    var parent = $(".card-block");
	    var child1 = parent.children(".para");
	    if (child1 !== para3) {
	      child1.remove();
	      parent.append(para3);
	      para3.removeClass("hide");
	      para3.removeClass("completly-hidden");
	      para1.remove();
	      $(".btn1").removeClass("active");
	      para3.addClass(" show");
	    }
	  });
	  
	  $(".btn4").click(function(e) {
		    e.preventDefault();

		    var parent = $(".card-block");
		    var child1 = parent.children(".para");
		    if (child1 !== para4) {
		      child1.remove();
		      parent.append(para4);
		      para4.removeClass("hide");
		      para4.removeClass("completly-hidden");
		      para1.remove();
		      $(".btn1").removeClass("active");
		      para4.addClass(" show");
		    }
		  });
	});

/******************préts1**********************/

$(document).ready(function() {
	  //global vars
	  const para1 = $(".para1");
	  const para2 = $(".para2");
	  const para3 = $(".para3");
	  $(".btn1").click(function(e) {
	    e.preventDefault();
	    var parent = $(".card-block");
	    var child1 = parent.children(".para");
	    if (child1 !== para1) {
	      child1.remove();
	      parent.append(para1);
	      para1.removeClass("hide");
	      para1.addClass(" show");
	    }
	  });
	  //second button  
	  /*
	  $(".btn2").click(function(e) {
	    e.preventDefault();

	    var parent = $(".card-block");
	    var child1 = parent.children(".para");

	    if (child1 !== para2) {
	      child1.remove();
	      parent.append(para2);
	      para2.removeClass("hide");
	      para2.removeClass("completly-hidden");
	      para1.remove();
	      $(".btn1").removeClass("active");
	      para3.addClass(" show");
	    }
	  });
	  // third button
	  $(".btn3").click(function(e) {
	    e.preventDefault();

	    var parent = $(".card-block");
	    var child1 = parent.children(".para");
	    if (child1 !== para3) {
	      child1.remove();
	      parent.append(para3);
	      para3.removeClass("hide");
	      para3.removeClass("completly-hidden");
	      para1.remove();
	      $(".btn1").removeClass("active");
	      para3.addClass(" show");
	    }
	  }); */
	  
	 
	});

