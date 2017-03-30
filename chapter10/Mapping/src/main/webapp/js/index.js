/**
 * When page is load should fill select of producer and models.
 *
*/
window.onload = function() {
    $.ajax({
        type: 'GET',
        url: './producers',
        complete: function(data) {
            var producers = JSON.parse(data.responseText);
            for (var i = 0; i < producers.length; i++) {
                var option = document.createElement("option");
                option.setAttribute("id", producers[i].id);
                option.setAttribute("value", producers[i].id);
                option.innerHTML = producers[i].name;
                document.getElementById('producer').appendChild(option);
            }
            updateModel();
        }
    });
    document.getElementById('producer').onchange = updateModel;
    document.getElementById('submitButton').onclick = updatePage;
};

/**
 * Update models depend on producers.
*/
function updateModel() {
    var producer = document.getElementById('producer').value;
    console.log(producer);
    $.ajax({
        type: 'GET',
        url: './models?producer=' + producer,
        complete: function(data) {
            var models = JSON.parse(data.responseText);
            for (var i = 0; i < models.length; i++) {
                var option = document.createElement("option");
                option.setAttribute("id", models[i].id);
                option.setAttribute("value", models[i].id);
                option.innerHTML = models[i].name;
                document.getElementById('model').appendChild(option);
            }
        }
    });
    updateBody(producer, document.getElementById('model').value);
}

/**
  Fill bodies of car.
*/
function updateBody(producer, model) {
    $.ajax({
        type: 'GET',
        url: './body',
        complete: function(data) {
            var bodies = JSON.parse(data.responseText);
            for (var i = 0; i < bodies.length; i++) {
                var option = document.createElement("option");
                option.setAttribute("id", bodies[i].id);
                option.setAttribute("value", bodies[i].id);
                option.innerHTML = bodies[i].name;
                document.getElementById('body').appendChild(option);
            }
        }
    });
}

//When user submit button should update page.
function updatePage() {
    var producer = document.getElementById('producer');
    var model = document.getElementById('model');
    var body = document.getElementById('body');

    var data = {
        'producer': producer,
        'model': model,
        'body': body
    };
    // ajax query to the controllers
    $.ajax({
        type: 'post',
        url: './getcar',
        data: data,
        complete: function(data) {
            var cars = JSON.parse(data.responseText);
            if (cars.length == 0) {
                document.getElementById('car').innerHTML = "Could not car with given params";
            } else {
                for (var i = 0; i < bodies.length; i++) {
                    var option = document.createElement("div");
                    option.setAttribute("id", cars[i].id);
                    option.setAttribute("value", bodies[i].id);
                    option.innerHTML = bodies[i].name;
                    document.getElementById('cars').appendChild(option);
                }
            }
        }
    });
}
