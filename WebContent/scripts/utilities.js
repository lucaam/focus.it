function added(id){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			$("#added").css("color", "green");
			$("#added").text("Added");
			$("#added").fadeIn(700);
			$("#added").fadeOut(2100);
		}
	};
	xhttp.open("GET", "addToCart?idProd=" + id + "", true);
	xhttp.send();
	
}

function addFromSearch(id){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
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
	};
	xhttp.open("GET", "addToCart?idProd=" + id + "", true);
	xhttp.send();

		
}


function retriveProd(){
	
	
	$(document).ready(function(){
	

	//genero un numero casuale
	var id = Math.floor((Math.random() * 15) + 1);
	//creo questa var per richiesta ajax
	var xhttp = new XMLHttpRequest();
	var file = new XMLHttpRequest();
	//genero la richiesta
	//funzione di callback
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			file.onreadystatechange= function(){
				if(file.readyState == 4 && file.status == 200){
					var prod=null;

					if(prod==null)
					prod = JSON.parse(file.responseText);
					console.log(prod);
					
					var card = 	'<div class="col iamcentered">\
						<div class="card text-center">\
						<div class="card-header">\
						Featured\
						</div>\
						<div class="card-body">\
						<h5 class="card-title">\
						Special title treatment\
						</h5>\
						<p class="card-text">\
						With supporting text below as a natural lead-in to additional content.\
						</p>\
						<a href="#" class="btn btn-primary">\
						Go somewhere</a></div>\
						<div class="card-footer text-muted">\
						 2 days ago</div></div></div>';
				
					card = card.replace("Special title treatment", prod.product)
				
					$("#cardContainer").append().html(card);
					
					

				}
			}
		}
		file.open("GET", "jsonfiles/generateThumb.json", true);
		file.send();
	}
	xhttp.open("GET", "generateThumb?idProd=" + id + "", true);
	xhttp.send();

	});
}


