window.onload = function() {
    document.getElementById('producer').onchange = updateModel;
};

function updateModel(model) {
    var producer =  document.getElementById('producer').value;
    /**
     * ajax query to the server to /model?producer = producer name
     */
    updateBody(producer, 'asdas');
}

function updateBody(producer, model) {
    /**
     * ajax query to the server /body?producer = producer name and model = model name
     */
}

