function getInputValueById() {
    var value = document.getElementById("taskName").value;
    return value;
}

function confirmUpdateTask() {
    // $("#updateTask").submit();
    var name = getInputValueById();
    $("#updateTaskName").attr('value',name)
    $('#updateTask').submit();
}