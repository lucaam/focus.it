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
    alert('Lo username deve contenere lettere, numeri o i caratteri "_", "." "-"  e deve essere lungo almeno 8');
    document.getElementById("username").focus(); //Set focus
    return false; //Negate access
  } else

  if (!pswIsOK) { //Check password
    alert("La password deve contenere almeno 8 caratteri tra lettere, numeri e simboli");
    document.getElementById("password").focus(); //Set focus
    return false; //Negate access
  } else

   if (!nameIsOK) { //Check name
    alert("Solo lettere per il nome");
    document.getElementById("name").focus(); //Set focus
    return false; //Negate access
  } else

   if (!surnameIsOK) { //Check surname
    alert("Solo lettere per il cognome");
    document.getElementById("surname").focus(); //Set focus
    return false; //Negate access
  } else

  if (!mailIsOK) { //Check email
    alert("Inserisci email valida")
    document.getElementById("email").focus(); //Set focus
    return false; //Negate access
  } else

   if (!phoneIsOK) { //Check phone number
    alert("Inserisci un numero di telefono con 10 cifre");
    document.getElementById("phone").focus(); //Set focus
    return false; //Negate access
  }

else
return true; //Grant access
}

function validateLogin(formLogin){
  //Define login regExp validators
  var usrValidator = /^(\w+[_\.\-]*\w*){8,}$/;
  var pswValidator = /^[a-zA-Z 0-9 \@\._\!\?\-]{8,}$/;

  //Save all matches in a variable
  var usrIsOK = formLogin.usr.value.match(usrValidator);
  var pswIsOK = formLogin.psw.value.match(pswValidator);


  if (!usrIsOK) { //Check username
    alert('Lo username deve contenere lettere, numeri o i caratteri "_", "." "-"  e deve essere lungo almeno 8');
    document.getElementById("username").focus(); //Set focus
    return false; //Negate access
  } else

  if (!pswIsOK) { //Check password
    alert("La password deve contenere almeno 8 caratteri tra lettere, numeri e simboli");
    document.getElementById("password").focus(); //Set focus
    return false; //Negate access
  } else
  return true;
}
