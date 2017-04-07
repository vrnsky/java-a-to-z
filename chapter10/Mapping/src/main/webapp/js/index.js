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
    $("#model").empty();
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
    $("#body").empty();
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
function updatePage(event) {
    event.preventDefault();
    var producer = document.getElementById('producer').value;
    var model = document.getElementById('model').value;
    var body = document.getElementById('body').value;

    var data = {
        'producer': producer,
        'model': model,
        'body': body
    };

    console.log(data);
    // ajax query to the controllers
    $.ajax({
        type: 'post',
        url: './index',
        data: data,
        complete: function(data) {
            console.log(data);
            var advert = JSON.parse(data.responseText);
            for (var i = 0; i < advert.length; i++) {
                createAdvert(advert[i]);
            }
        }
    });
    return false;
}

function createAdvert(advert) {
    var img = document.createElement("img");
    img.setAttribute("width", 200);
    img.setAttribute("height", 200);
    img.setAttribute("src", advert.fileUrl);
    var ul = document.createElement("ul");
    ul.setAttribute("class", "data");
    var producer =  document.createElement("li");
    producer.innerHTML = "Producer: " + advert.car.producer.name;
    var model = document.createElement("li");
    model.innerHTML = "Model: " + advert.car.model.name;
    var body = document.createElement("li");
    body.innerHTML = "Body: " + advert.car.body.name;
    var price = document.createElement("li");
    price.innerHTML = "Price: " + advert.price;
    ul.appendChild(producer);
    ul.appendChild(model);
    ul.appendChild(body);
    ul.appendChild(price);

    document.getElementById("adverts").appendChild(img);
    document.getElementById("adverts").appendChild(ul);
}
