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
                console.log(tasks);
                for (var index = 0; index < tasks.length; index++) {
                    var created = new Date(tasks[index].creationTime);
                    var hasDone = tasks[index].done;
                    var doneString = "";
                    if (hasDone) {
                        doneString = "<input type='checkbox' name='done' checked>";
                    } else {
                        doneString = "<input type='checkbox' name='done' />"
                    }
                    var itemString = "<tr><td>" + tasks[index].id + "</td>";
                    itemString += "<td>" + tasks[index].desc + "</td>";
                    itemString += "<td>" + created.getDate() + "." + (created.getMonth() + 1) + "." + created.getFullYear() + "</td>";
                    itemString += "<td>" + doneString + "</td>";
                    $("#itemTable").append(itemString);
                }
            }
        })
    )

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