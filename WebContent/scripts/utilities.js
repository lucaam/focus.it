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
	var prod=null;

	var id = Math.floor((Math.random() * 15) + 1);
	var xhttp = new XMLHttpRequest();
	var i = 3;

	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
					
					$.ajax({
						cache: false,
						success:function(prod){
							var card = 	'<div class="col iamcentered">\
								<div class="card text-center">\
								<div class="card-header">\
								Featured camera\
								</div>\
								<div class="card-body">\
								<h5 class="card-title">\
								title \
								</h5>\
								<p class="card-text">\
								text \
								</p>\
								<a href="#" class="btn btn-dark">\
								More</a></div>\
								<div class="card-footer text-muted">\
								 2 days ago</div></div></div>';
						
							card = card.replace("title ", prod.product);
							card = card.replace("text ", prod.desc.substring(0, 250) + " ...");
							card = card.replace("#", "generatePage?idProd=" + prod.id);
						
							$("#cardContainer").append().html(card);
						},
						url: 'jsonfiles/generateThumb.json'
					});
					
					

				}
			}
	xhttp.open("GET", "generateThumb?idProd=" + id + "", true);
	xhttp.send();

	});
}

function openLogin(){
	$('#exampleModal').modal('show')
}

function deleteProd(){
	
	
	$(document).ready(function(){
	var prod=null;

	var id = Math.floor((Math.random() * 15) + 1);
	var xhttp = new XMLHttpRequest();
	var i = 3;

	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
					
					$.ajax({
						cache: false,
						success:function(prod){
							i = 0;
							var card = '<br><div class="form-group">\
								  <label for="deleteForm">Select one:</label>\
							  <select class="form-control" id="deleteForm">';
							  
							      
							  

							while(i<prod.length)
								{
									var tmp = '<option id="value">text</option>';
									tmp = tmp.replace("value", prod[i].id);
									tmp = tmp.replace("text", prod[i].product);
									card+=tmp;
									
									i++;
								}

							
							card += '</select><br><button onclick="retriveId()" class="btn btn-dark">Remove</button></div>';
							  

							$("#deleteDiv").append().html(card);
							
						},
						url: 'jsonfiles/prodList.json'
					});
					
					

				}
			}
	xhttp.open("GET", "removeProd", true);
	xhttp.send();

	});
}

function retriveId(){
	var id=-1;
    var xhttp = new XMLHttpRequest();

	
	    id = $("#deleteForm").find('option:selected').attr('id');
	    console.log(id);
	    
	    if(id!=-1){
		xhttp.open("GET", "removeProd?toRemove="+ id, true);
		xhttp.send();
	    }
}
	
	
	

	


