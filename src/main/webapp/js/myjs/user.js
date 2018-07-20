$.func = {
    // 获取users信息
    flush: function () {
        $.ajax({
            url: "/ssm/user/v1/list",
            type: "GET",
            headers: {
                Accept: "application/json;charset=utf-8"
            },
            data: {},
            dataType: "json",//返回的数据类型
            success: function (data) {
                var operation = '<td class=" text-center">' +
                    '<a class="user-delete" href="#"><i class="glyphicon glyphicon-remove"></i></a>' +
                    '&nbsp;&nbsp;' +
                    '<a class="user-update" href="#"><i class="glyphicon glyphicon-edit"></i></a>' +
                    '</td>';
                var html = '';
                for (var i = 0; i < data.length; i++) {
                    html = html + '<tr>';
                    html = html + '<td class="user-id">' + data[i].userId + '</td>';
                    html = html + '<td class="user-name">' + data[i].userName + '</td>';
                    html = html + '<td class="user-password">' + data[i].userPassword + '</td>';
                    html = html + '<td class="user-level">' + data[i].userLevel + '</td>';
                    html = html + '<td class="user-create">' + data[i].userGmtCreate + '</td>';
                    html = html + '<td class="user-modified">' + data[i].userGmtModified + '</td>';
                    html = html + operation;
                    html = html + '</tr>';
                }

                $('#user-table').html(html);//通过jquery方式获取table，并把tr,td的html输出到table中
            },
            error: function () {
                alert("查询失败！" + res.data.message);
            }
        });
    }
};

// 查询
$(document).on('click', "#user-read", $.func.flush());

// 添加
$(document).on('click', '#user-create', function () {
    layer.open({
        type: 2,
        title: '添加用户',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: '/ssm/view/popup/user-register.html'
    });
});

// 删除
$(document).on('click', ".user-delete", function () {
    var load = layer.load();

    var tr = $(this).parent().parent();
    var id = tr.children("td[class='user-id']").text();

    // 利用ajax将数据提交到后台
    $.ajax({
        url: "/ssm/user/v1/" + id,
        type: 'delete',
        dataType: "json",
        contentType: "application/json;charset=utf-8;",
        data: {},
        success: function (msg) {
            setTimeout(function () {
                layer.close(load);
                layer.msg(msg);
                $.func.flush();
            }, 1000);
        },
        error: function (error) {
            setTimeout(function () {
                layer.close(load);
                layer.msg("删除失败");
                console.log('接口不通' + error);
            }, 1000);
        }
    });
});

// 更新
$(document).on('click', ".user-update", function () {
    var tr = $(this).parent().parent();
    var id = tr.children("td[class='user-id']").text();
    var name = tr.children("td[class='user-name']").text();
    var password = tr.children("td[class='user-password']").text();
    var level = tr.children("td[class='user-level']").text();

    layer.open({
        type: 2,
        title: '更新用户信息',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: '/ssm/view/popup/user-update.html',
        success: function (layero, index) {
            var body = layer.getChildFrame('body', index);
            var iframeWin = window[layero.find('iframe')[0]['name']];

            var idLabel = body.find('span#user-id-label');
            var nameInput = body.find('input[name="userName"]');
            var passwordInput = body.find('input[name="userPassword"]');
            var levelInput = body.find('input[name="userLevel"]');

            $(idLabel).html(id);
            $(nameInput).val(name);
            $(passwordInput).val(password);
            $(levelInput).val(level);
        }
    });
});
