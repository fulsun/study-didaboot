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

function addcategory() {
    var newCategory = $("#newCategory").val();
    var str = JSON.stringify({name: newCategory});
    console.log(str)
    $.ajax({
        type: "POST",
        url: "/category/add",
        dataType:'json',
        contentType:"application/json;charset=UTF-8",
        data: str,
        success : function(data) {
            console.log("添加成功");
            $("#btn1").click();
            window.location="/index"
        },
        error : function(req, err, ex) {
            console.log("添加失败")
        }
    })
}


function delcategorybyid(id) {
    console.log("del...."+id)
    $.ajax({
        type: "delete",
        url: "/task/del/"+id,
        dataType:'json',
        contentType:"application/json;charset=UTF-8",
        success : function(data) {
            console.log(data);
            // 删除成功后刷新页面
            window.location.reload();
        },
        error: function (err){
            console.log("错误..."+err)
        }
    })
}