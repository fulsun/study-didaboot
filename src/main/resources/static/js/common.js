function getInputValueById() {
    var value = document.getElementById("taskName").value;
    return value;
}

function confirmUpdateTaskName() {
    $('#updateTaskName').attr("value", $('#taskName').val())
    var name = getInputValueById();
    $.ajax({
        type: "PUT",
        url: "/task/updateTask",
        data: $("#updateTask").serialize(),
        success: function (data) {
            alert(data.message);
        },
        error: function (err) {
            console.log(err.message);
        }
    })
}

function addcategory() {
    var newCategory = $("#newCategory").val();
    var str = JSON.stringify({name: newCategory});
    console.log(str)
    $.ajax({
        type: "POST",
        url: "/category/add",
        dataType: 'json',
        contentType: "application/json;charset=UTF-8",
        data: str,
        success: function (data) {
            // $("#btn1").click();
            console.log(data.message);
            window.location.reload();
        },
        error: function (err) {
            $("#btn1").click();
            alter(err.message);
        }
    })

}


function delcategorybyid(id) {
    console.log("del...." + id)
    $.ajax({
        type: "delete",
        url: "/task/del/" + id,
        dataType: 'json',
        contentType: "application/json;charset=UTF-8",
        success: function (data) {
            console.log(data.message);
            // 删除成功后刷新页面
            window.location.href = "/";
        },
        error: function (err) {
          alert(err.message)
        }
    })
}

function addTaskConfirm() {
    var flag = confirm('你确认添加么');//confirm时确认提示框，点击确认返回true,点击取消返回false
    if (flag) {//点击弹框的确认
        $.ajax({
            method: "post",
            data: $('#addTaskForm').serialize(),//jq提供的获取form表单数据的快捷方式，通过form内标签的name属性{"username":"admin","passwd":"123456"}
            url: "/task/add",
            success: function (data) {//请求数据并返回结果给success,是一个对象，类似python的字典。回调函数。data只是一个函数的参数，跟上面的data不一样
                console.log(data)
                alert(data.data)
                // 拼接要显示的内容的标签
                // var sign_span = '<div><span>' + sign + '</span></div>';
                // var userid_span = '<div><span>' + userid + '</span></div>';
                // var form_object = document.getElementById('login_value');//获取到form对象
                // form_object.insertAdjacentHTML('afterEnd', sign_span + userid_span)//插入到获取标签的最后
                /*
                *
                * insertAdjacentHTML(where,tagStr): 父级标签内添加一个子标签字符串
                        beforeBegin: 插入到获取到标签的前面
                        afterBegin: 插入到获取到标签的子标签的前面
                        beforeEnd: 插入到获取到标签的子标签的后面
                        afterEnd: 插入到获取到标签的后面
                */
                window.location.reload();
            },
            error: function (err) {
                console.log(err)
            }

        })
    } else {
        //点击弹框的取消
        alert('点击了取消')
    }
}


function delcategory(id) {
    // console.log("delcategory..."+id)
    var flag = confirm('你确认删除么');//confirm时确认提示框，点击确认返回true,点击取消返回false
    if (flag) {//点击弹框的确认
        $.ajax({
            method: "delete",
            url: "/category/del/" + id,
            success: function (data) {//请求数据并返回结果给success,是一个对象，类似python的字典。回调函数。data只是一个函数的参数，跟上面的data不一样
                console.log(data)
                $("#btn2").click();
                window.location.href = "/index";
            },
            error: function (err) {
                console.log(err)
            }
        })
    } else {
        //点击弹框的取消
        console.log('点击了取消')
    }
}

function showtaskdetail(task) {
    console.log(task.description)
    $("#taskdesc").text(task.description)
    $("#updateTastid").val(task.id)
}

function updatetaskdesc() {
    $.ajax({
        method: "put",
        url: "/task/update",
        data: $('#updateTaskdesc').serialize(),
        success: function (data) {//请求数据并返回结果给success,是一个对象，类似python的字典。回调函数。data只是一个函数的参数，跟上面的data不一样
            console.log(data)
            $("#modal-success button:first").click();
            // window.location.href = "/index";
        },
        error: function (err) {
            console.log(err)
        }
    })
}