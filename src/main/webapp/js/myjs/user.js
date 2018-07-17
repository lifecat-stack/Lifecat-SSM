$.func = {
    // 获取users信息
    flush: function () {
        $.ajax({
            url: "user/v1/users/",
            type: "GET",
            headers: {
                Accept: "application/json;charset=utf-8"
            },
            data: {},
            dataType: "json",//返回的数据类型
            success: function (data) {
                var success = data.success;
                var code = data.code;
                var errorMsg = data.errorMsg;
                var userList = data.jsonData;

                if (!success) {
                    layer.msg(code + " " + errorMsg);
                }

                var operation = '<td class=" text-center">' +
                    '<a class="user-delete" href="#"><i class="glyphicon glyphicon-remove"></i></a>' +
                    '&nbsp;&nbsp;' +
                    '<a class="user-update" href="#"><i class="glyphicon glyphicon-edit"></i></a>' +
                    '</td>';
                var html = '';
                for (var i = 0; i < userList.length; i++) {
                    html = html + '<tr>';
                    html = html + '<td class="user-id">' + userList[i].userDO.userId + '</td>';
                    html = html + '<td class="user-name">' + userList[i].userDO.userName + '</td>';
                    html = html + '<td>' + userList[i].userPropertyDO.propertyNickname + '</td>';
                    html = html + '<td>' + userList[i].userPropertyDO.propertySignature + '</td>';
                    html = html + '<td>' + userList[i].userPropertyDO.propertySex + '</td>';
                    html = html + '<td>' + userList[i].userPropertyDO.propertyEmail + '</td>';
                    html = html + '<td>' + userList[i].userPropertyDO.propertyLocation + '</td>';
                    html = html + '<td>' + userList[i].userDO.userGmtCreate + '</td>';
                    html = html + operation;
                    html = html + '</tr>';
                }

                $('#user-table').html(html);//通过jquery方式获取table，并把tr,td的html输出到table中
            },
            error: function () {
                alert("查询失败！");
            }
        });
    }
};

// 查询
$(document).on('click', "#user-query", $.func.flush());

// 添加
$(document).on('click', '#user-upload', function () {
    layer.open({
        type: 2,
        title: '添加日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: '/ssm/view/popup/user-upload.html'
    });
});

// 删除
$(document).on('click', ".user-remove", function () {
    var ii = layer.load();

    var tr = $(this).parent().parent();
    var id = tr.children("td[class='user-id']").text();

    // 利用ajax将数据提交到后台
    $.ajax({
        url: "user/v1/user/" + id,
        type: 'delete',
        dataType: "text",
        data: {},
        success: function (msg) {
            setTimeout(function () {
                layer.close(ii);
                layer.msg(msg);
                $.func.flush();
            }, 1000);
        },
        error: function (error) {
            setTimeout(function () {
                layer.close(ii);
                layer.msg("删除失败");
                console.log('接口不通' + error);
            }, 1000);
        }
    });
});

// 更新
$(document).on('click', ".user-edit", function () {
    var tr = $(this).parent().parent();
    var id = tr.children("td[class='user-id']").text();
    var name = tr.children("td[class='user-name']").text();
    var text = tr.children("td[class='user-text']").text();

    layer.open({
        type: 2,
        title: '修改日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: '/ssm/view/popup/user-update.html?id=' + id + "&name=" + name + "&text=" + text
    });
});
