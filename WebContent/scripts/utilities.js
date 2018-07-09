function added(id){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystateChange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){	
		}
	};
	xhttp.open("GET", "addToCart?idProd=" + id + "", true);
	xhttp.send();
	if(xhttp){
		$("#added").css("color", "green");
		$("#added").append("Aggiunto al carrello");
		$("#added").fadeIn(700);
		$("#added").fadeOut(2100);
		
		

	}
	}