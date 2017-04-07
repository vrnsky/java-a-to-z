window.onload = function () {
    $(
        $.ajax({
            type: 'get',
            url: './ads',
            complete: function (data) {
                console.log(data);
                var adverts = JSON.parse(data);
                for (var i = 0; i < adverts.length; i++) {
                    $("#myadverts").appendChild(createAdvertRow(adverts[i]));
                }
            }
        }));
}

function createAdvertRow(advert) {
    var tr = document.createElement("tr");
    var tdId = document.createElement("td");
    tdId.innerHTML = advert.id;
    var tdProducer = document.createElement("td");
    tdProducer.innerHTML = advert.car.producer.name;
    var tdModel = document.createElement("td");
    tdModel.innerHTML = advert.car.model.name;
    var tdBody = document.createElement("td");
    tdBody.innerHTML = advert.car.body.name;
    var tdPrice = document.createElement("td");
    tdPrice.innerHTML = advert.price;
    var tdImg = document.createElement("td");
    var img = document.createElement("img");
    img.setAttribute("src", advert.fileUrl);
    img.setAttribute("width", 200);
    img.setAttribute("height", 200);
    tdImg.appendChild(img);
    var tdSale = document.createElement("td");
    var checkbox = document.createElement("input");
    checkbox.setAttribute("id", advert.id);
    checkbox.setAttribute("type", "checkbox");
    checkbox.setAttribute("class", "saleMarker");
    if (advert.sale) {
        checkbox.checked = true;
    }
    tdSale.appendChild(checkbox);
    tr.appendChild(tdId);
    tr.appendChild(tdProducer);
    tr.appendChild(tdModel);
    tr.appendChild(tdBody);
    tr.appendChild(tdPrice);
    tr.appendChild(tdImg);
    tr.appendChild(tdSale);
    return tr;

}
