function validateRegistration(formRegistration) {

  //Define registration regExp validators
  var usrValidator = /^(\w+[_\.\-]*\w*){4,}$/;
  var pswValidator = /^[a-zA-Z 0-9 \@\._\!\?\-]{8,}$/;
  var nameValidator = /^[a-zA-Z]+([\s\-]?[A-Za-z]+)*$/;
  var surnameValidator = /^[A-Za-z]+([\s\'\-]?[A-Za-z]+)*$/;
  var mailValidator = /^\w+([\._\-]?\w+)*@\w+([\.\-]?\w+)*(\.\w+)+$/;
  var phoneValidator = /^[0-9]{10}$/;
  var costValidator1 = /^gennaro$/;
  var costValidator2 = /^costagliola$/;
  var fuccValidator1 = /^vittorio$/;
  var fuccValidator2 = /^fuccella$/;

  //Save all matches in a variable
  var usrIsOK = formRegistration.username.value.match(usrValidator);
  var pswIsOK = formRegistration.password.value.match(pswValidator);
  var nameIsOK = formRegistration.name.value.match(nameValidator);
  var surnameIsOK = formRegistration.surname.value.match(surnameValidator);
  var mailIsOK = formRegistration.email.value.match(mailValidator);
  var phoneIsOK = formRegistration.phone.value.match(phoneValidator);
  var cost1IsOK= formRegistration.name.value.match(costValidator1);
  var cost2IsOK= formRegistration.surname.value.match(costValidator2) ;
  var fucc1IsOK= formRegistration.name.value.match(fuccValidator1);
  var fucc2IsOK= formRegistration.surname.value.match(fuccValidator2);
  var profsurname= formRegistration.surname.value.charAt(0).toUpperCase()+formRegistration.surname.value.slice(1);

  if (!usrIsOK) { //Check username
    alert('Lo username deve contenere lettere, numeri o i caratteri "_", "." "-"  e deve essere lungo almeno 5');
    document.getElementById("username").focus(); //Set focus
    return false; //Negate access
  } else

  if (!pswIsOK) { //Check password
    alert("La password deve contenere almeno 5 caratteri tra lettere, numeri e simboli");
    document.getElementById("password").focus(); //Set focus
    return false; //Negate access
  } else

   if (!nameIsOK) { //Check name
    alert("Il cognome non può terminare con uno spazio oppure un apostrofo \ne non può contenere numeri o simboli");
    document.getElementById("name").focus(); //Set focus
    return false; //Negate access
  } else

   if (!surnameIsOK) { //Check surname
    alert("Il cognome non può terminare con uno spazio oppure un apostrofo\ne non può contenere numeri o simboli");
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

if (cost1IsOK && cost2IsOK || fucc1IsOK && fucc2IsOK){
	alert("Benvenuto, Prof. "+profsurname);
	console.log("OOOOOOOOOOOOOOO");
	return true;
}
else
return true; //Grant access
}

function validateLogin(formLogin){
  //Define login regExp validators
  var usrValidator = /^(\w+[_\.\-]*\w*){4,}$/;
  var pswValidator = /^[a-zA-Z 0-9 \@\._\!\?\-]{8,}$/;

  //Save all matches in a variable
  var usrIsOK = formLogin.user.value.match(usrValidator);
  var pswIsOK = formLogin.psw.value.match(pswValidator);


  if (!usrIsOK) { //Check username
    alert('Lo username deve contenere lettere, numeri o i caratteri "_", "." "-"  e deve essere lungo almeno 8');
    document.getElementById("user").focus(); //Set focus
    return false; //Negate access
  } else

  if (!pswIsOK) { //Check password
    alert("La password deve contenere almeno 8 caratteri tra lettere, numeri e simboli");
    document.getElementById("psw").focus(); //Set focus
    return false; //Negate access
  } else
  return true;
}

function validateUsr(changeUsrForm){
	  var usrValidator = /^(\w+[_\.\-]*\w*){4,}$/;
	  var newUsr= changeUsrForm.newUser.value;

	  if(!newUsr.match(usrValidator)) {
		  alert("Username non valido");
		  return false;
	  } else return true;
}

function validatePsw(changePswForm){
	  var pswValidator = /^[a-zA-Z 0-9 \@\._\!\?\-]{8,}$/;
	  var oldPsw= changePswForm.oldPass.value;
	  var newPsw= changePswForm.newPass.value;



	  if(!oldPsw.match(pswValidator)){
		  alert("Vecchia password errata");
		  return false;
	  } else if(!newPsw.match(pswValidator))
	  {
		  alert("Nuova password non valida");
		  return false;
	  } else return true;
}

function validateMail(changeMailForm){
	  var mailValidator = /^\w+([\._\-]?\w+)*@\w+([\.\-]?\w+)*(\.\w+)+$/;
	  var newMail= changeMailForm.newMail.value;

	  if(!newMail.match(mailValidator)){
		  alert("Email non valida");
		  return false;
	  } else return true;
}
