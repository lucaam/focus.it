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

function retriveProd(){

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystateChange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
		}
	};

	var id = Math.floor((Math.random() * 15) + 1);

	
	xhttp.open("GET", "generateThumb?idProd=" + id + "", true);
	xhttp.send();
	
	var file = new XMLHttpRequest();
	file.open("GET", "jsonfiles/generateThumb.json");
	file.onreadystatechange= function()
	{    if (this.readyState == 4 && this.status == 200) {

		var prod = JSON.parse(file.responseText);
		console.log(prod);
	}
	}
	file.send();
	
	
	if(xhttp.readyState !=0){
		var card = '<div class="col iamcentered">\
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

		$("#cardContainer").append().html(card);
		
	
	}
}
