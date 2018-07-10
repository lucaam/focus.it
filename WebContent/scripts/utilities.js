function added(id){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystateChange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){	
		}
	};
	xhttp.open("GET", "addToCart?idProd=" + id + "", true);
	xhttp.send();
	if(xhttp.readyState !=0){
		$("#added").css("color", "green");
		$("#added").text("Added");
		$("#added").fadeIn(700);
		$("#added").fadeOut(2100);
	}
}

function addFromSearch(id){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystateChange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){	
		}
	};
	xhttp.open("GET", "addToCart?idProd=" + id + "", true);
	xhttp.send();
	if(xhttp.readyState !=0){

			$("#added"+id).css("color", "green");
			$("#added"+id).text("Added");
			$("#added"+id).fadeIn(700);
			$("#added"+id).fadeOut(2100);
			
			setTimeout(
					function() 
					  {
						$("#added"+id).css("color", "white");
						$("#added"+id).text("Cart");
						$("#added"+id).fadeIn(150);
					  }, 2100);
			
	
		
	}
}