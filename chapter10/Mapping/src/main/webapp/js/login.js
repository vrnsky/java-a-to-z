function login() {
  var login = document.getElementById('login').value;
  var password = document.getElementById('password').value;

  $.ajax({
      type: 'post',
      url: './login',
      complete: function(data) {
          }
      });
}


/////asdas
