function validateRegistration(formRegistration) {

  //Define registration regExp validators
  var usrValidator = /^(\w+[_\.\-]*\w*){8,}$/;
  var pswValidator = /^[a-zA-Z 0-9 \@\._\!\?\-]{8,}$/;
  var nameValidator = /^[A-Za-z]+$/;
  var surnameValidator = /^[A-Za-z]+$/;
  var mailValidator = /^\w+([\._\-]?\w+)*@\w+([\.\-]?\w+)*(\.\w+)+$/;
  var phoneValidator = /^[0-9]{10}$/;

  //Save all matches in a variable
  var usrIsOK = formRegistration.username.value.match(usrValidator);
  var pswIsOK = formRegistration.password.value.match(pswValidator);
  var nameIsOK = formRegistration.name.value.match(nameValidator);
  var surnameIsOK = formRegistration.surname.value.match(surnameValidator);
  var mailIsOK = formRegistration.email.value.match(mailValidator);
  var phoneIsOK = formRegistration.phone.value.match(phoneValidator);

  if (!usrIsOK) { //Check username
  //  document.getElementById("errorREGUSR").innerHTML= 'Lo username deve contenere lettere, numeri o i caratteri "_", "." "-" '; //Write inline error message
    alert('Lo username deve contenere lettere, numeri o i caratteri "_", "." "-"  e deve essere lungo almeno 8');
    document.getElementById("username").focus(); //Set focus
    return false; //Negate access
  } else document.getElementById("errorREGUSR").innerHTML= ""; //Remove error message

  if (!pswIsOK) { //Check password
  //  document.getElementById("errorREGPSW").innerHTML="La password deve contenere almeno 8 caratteri tra lettere, numeri e simboli"; //Write inline error message
    alert("La password deve contenere almeno 8 caratteri tra lettere, numeri e simboli");
    document.getElementById("password").focus(); //Set focus
    return false; //Negate access
  } else document.getElementById("errorREGPSW").innerHTML= ""; //Remove error message

   if (!nameIsOK) { //Check name
  //  document.getElementById("errorNAME").innerHTML="Solo lettere per il nome"; //Write inline error message
    alert("Solo lettere per il nome");
    document.getElementById("name").focus(); //Set focus
    return false; //Negate access
  } else document.getElementById("errorNAME").innerHTML=""; //Remove error message

   if (!surnameIsOK) { //Check surname
  //  document.getElementById("errorSURNAME").innerHTML="Solo lettere per il cognome"; //Write inline error message
    alert("Solo lettere per il cognome");
    document.getElementById("surname").focus(); //Set focus
    return false; //Negate access
  } else document.getElementById("errorSURNAME").innerHTML=""; //Remove error message

  if (!mailIsOK) { //Check email
  //  document.getElemenMtById("errorEMAIL").innerHTML="Inserisci email valida"; //Write inline error message
    alert("Inserisci email valida")
    document.getElementById("email").focus(); //Set focus
    return false; //Negate access
  } else document.getElementById("errorEMAIL").innerHTML=""; //Remove error message

   if (!phoneIsOK) { //Check phone number
  //  document.getElementById("errorPHONE").innerHTML="Inserisci un numero di telefono con 10 cifre"; //Write inline error message
    alert("Inserisci un numero di telefono con 10 cifre");
    document.getElementById("phone").focus(); //Set focus
    return false; //Negate access
  }

else //document.getElementById("errorPHONE").innerHTML=""; //Remove error message

//alert("COMPLIMENTI DOC");
return true; //Grant access
}

function validateLogin(formLogin){
  //Define login regExp validators
  var usrValidator = /^(\w+[_\.\-]*\w*){8,}$/;
  var pswValidator = /^[a-zA-Z 0-9 \@\._\!\?\-]{8,}$/;

  //Save all matches in a variable
  var usrIsOK = formLogin.username.value.match(usrValidator);
  var pswIsOK = formLogin.password.value.match(pswValidator);


  if (!usrIsOK) { //Check username
  //  document.getElementById("errorREGUSR").innerHTML= 'Lo username deve contenere lettere, numeri o i caratteri "_", "." "-" '; //Write inline error message
    alert('Lo username deve contenere lettere, numeri o i caratteri "_", "." "-"  e deve essere lungo almeno 8');
    document.getElementById("username").focus(); //Set focus
    return false; //Negate access
  } else document.getElementById("errorREGUSR").innerHTML= ""; //Remove error message

  if (!pswIsOK) { //Check password
  //  document.getElementById("errorREGPSW").innerHTML="La password deve contenere almeno 8 caratteri tra lettere, numeri e simboli"; //Write inline error message
    alert("La password deve contenere almeno 8 caratteri tra lettere, numeri e simboli");
    document.getElementById("password").focus(); //Set focus
    return false; //Negate access
  } else document.getElementById("errorREGPSW").innerHTML= ""; //Remove error message
  return true;
}
