// function validateLogin(formLogin) {
//
//   var usrValidator = /^\w+[_\.-]*\w*$/;
//
//   if(formLogin.value.match(usrValidator))
//   {
//     return true;
//   }
//   else
//   {
//     alert('You can use only letters, "."|"-"|"_" in your username.');
//     formLogin.focus();
//     return false;
//   }
//
//   var pswValidator = /^([a-z]+[A-Z]+[0-9]+[@\.-_!\?]){8,}$/;
//   if(formLogin.value.match(pswValidator))
//   {
//     return true;
//   }
//   else
//   {
//     alert('You must insert a capital letter, numbers and symbols at least 8.');
//     formLogin.focus();
//     return false;
//   }
//
// }


function validateRegistration(formRegistration) {

  var usrValidator = /^\w+[_\.\-]*\w*$/;

  if(formRegistration.username.value.match(usrValidator))
  {
    return true;
  }
  else
  {
    alert('You can use only letters, "."|"-"|"_" in your username.');
    formRegistration.username.focus();
    return false;
  }

  var pswValidator = /^([a-z]+[A-Z]+[0-9]+[\@\.\_\!\?\-]){8,}$/;
  if(formRegistration.password.value.match(pswValidator))
  {
    return true;
  }
  else
  {
    alert('You must insert a capital letter, numbers and symbols at least 8.');
    formRegistration.password.focus();
    console.log(formRegistration.password.value.match(pswValidator));
    return false;
  }

  var name = /^[A-Za-z]+$/;
  if(formRegistration.name.value.match(name))
  {
    return true;
  }
  else
  {
//    alert('You can use only letters for your name.');
    formRegistration.name.focus();
    console.log(formRegistration.name.value.match(name));
    return false;
  }

  var surname = /^[A-Za-z]+$/;
  if(formRegistration.surname.value.match(surname))
  {
    return true;
  }
  else
  {
//    alert('You can use only letters for your surname.');
    console.log(formRegistration.surname.value.match(surname));
    formRegistration.surname.focus();
    return false;
  }

  var mailformat = /^\w+([\.\-]?\w+)*@\w+([\.\-]?\w+)*(\.\w+)+$/;
    if (formRegistration.email.value.match(mailformat)) {
      return true;
    }
    else
    {
//      alert("You have entered an invalid email address!");
      formRegistration.email.focus();
      console.log(formRegistration.email.value.match(mailformat));
      return false;
    }
}
