$(document).ready(function(){
  $('#brandList li').hover(function(){
    $('ul', this).delay(50).slideDown(40);
  },
  function(){
    $('ul', this).slideUp(200);
  }
);
});
