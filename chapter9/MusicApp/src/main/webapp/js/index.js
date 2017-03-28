function submitForm() {
    $.ajax({
        url: './login',
        type: 'POST',
        data: {'login': $("#login").val(), 'password' : $("#password").val()},
        complete : function(data) {
            console.log(data);
        }
    });
}