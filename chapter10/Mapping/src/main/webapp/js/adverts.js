window.onload = function () {
  $.ajax({
      type: 'get',
      url: './getadverts',
      complete: function(data) {
        $("#myadverts").appendChild();
          }
      });
}
