//When page is loaded should fill producers, models and body select.
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
