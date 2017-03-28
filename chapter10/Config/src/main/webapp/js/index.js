/**
 * When page loaded call the updatePage function.
 * @type {updatePage} callback function.
 */
window.onload = updatePage;


/**
 * First loading page and next update.
 */
function updatePage() {
    var showDone = $("#doneTask").prop('checked');
    $("#itemTable").empty();
    $(
        $.ajax({
            url: './index?onlydone=' + showDone,
            type: 'GET',
            complete: function (data) {
                var tasks = JSON.parse(data.responseText);
                for (var index = 0; index < tasks.length; index++) {
                    $("#itemTable").append(getItemTableString(tasks[index]));
                }
                setHandlers();
            }
        })
    )
}

function setHandlers() {
    var checkers = document.getElementsByClassName("marker");
    for (var i = 0; i <checkers.length; i++) {
        checkers[i].onclick = function () {
            updateItem($(this).attr("id"), $(this).prop("checked"));
        }
    }
}

function updateItem(id, done) {
    $(
        $.ajax({
            url:'./update?id=' + id + '&done=' + done,
            type: 'GET',
            complete: function (data) {
            }
        })
    )
    updatePage();
}

function getItemTableString(task) {
    var created = new Date(task.creationTime);
    var tr = document.createElement("tr");
    var idCell = document.createElement("td");
    idCell.innerHTML = task.id;
    tr.append(idCell);
    var descriptionCell = document.createElement("td");
    descriptionCell.innerHTML = task.desc;
    tr.append(descriptionCell);
    var timeCell = document.createElement("td");
    timeCell.innerHTML = created.getDate() + "." + (created.getMonth() + 1) + "." + created.getFullYear();
    tr.append(timeCell);
    var doneCell = document.createElement("td");
    var doneInput = document.createElement("input");
    doneInput.setAttribute("id", task.id);
    doneInput.setAttribute("type", "checkbox");
    doneInput.setAttribute("class", "marker");
    if (task.done) {
        doneInput.checked = true;
    }
    doneCell.appendChild(doneInput);
    tr.appendChild(doneCell);

    return tr;
}

/**
 * Adding new item to the table.
 */
function formSubmit() {
    var data = {'desc': $("#desc").val()};
    console.log(data);
    $(
        $.ajax({
            type: 'POST',
            url: './create',
            data: data,
            success: function (data, textStatus) {
                $.each(data, function (i, val) {
                    console.log(val);
                });
                updatePage();
            }
        }));
}
//
// $(".marker :checkbox").onchange = function() {
//     console.log($(this).attr('id'));
// }
