$.func = {
    flush: function () {
        alert("您没有权限访问");

        var adminId = 1;
        $.ajax({
            url: "/ssm/admin/v1/list",
            type: "GET",
            headers: {
                Accept: "application/json;charset=utf-8"
            },
            dataType: "json",//返回的数据类型
            success: function (data) {
                var operation = '<td class=" text-center">' +
                    '<a class="admin-delete" href="#"><i class="glyphicon glyphicon-remove"></i></a>' +
                    '&nbsp;&nbsp;' +
                    '<a class="admin-update" href="#"><i class="glyphicon glyphicon-edit"></i></a>' +
                    '</td>';
                var html = '';
                for (var i = 0; i < data.length; i++) {
                    html = html + '<tr>';
                    html = html + '<td class="admin-id">' + data[i].adminId + '</td>';
                    html = html + '<td class="admin-name">' + data[i].adminName + '</td>';
                    html = html + '<td class="admin-password">' + data[i].adminPassword + '</td>';
                    html = html + '<td class="admin-datetime">' + data[i].adminGmtCreate + '</td>';
                    html = html + '<td class="admin-datetime">' + data[i].adminGmtModified + '</td>';
                    html = html + operation;
                    html = html + '</tr>';
                }

                $('#admin-table').html(html);//通过jquery方式获取table，并把tr,td的html输出到table中
            },
            error: function (res) {
                alert("查询失败！" + res.data.message);
            }
        });
    }
};

// 查询
$(document).on('click', "#admin-read", $.func.flush());

// 添加
$(document).on('click', '#admin-create', function () {
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
$(document).on('click', ".admin-delete", function () {
    var load = layer.load();

    var tr = $(this).parent().parent();
    var id = tr.children("td[class='admin-id']").text();

    // 利用ajax将数据提交到后台
    $.ajax({
        url: "/ssm/admin/v1/" + id,
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
$(document).on('click', ".admin-update", function () {
    var tr = $(this).parent().parent();
    var id = tr.children("td[class='admin-id']").text();
    var name = tr.children("td[class='admin-name']").text();
    var password = tr.children("td[class='admin-password']").text();

    layer.open({
        type: 2,
        title: '更新管理员信息',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: '/ssm/view/popup/admin-update.html',
        success: function (layero, index) {
            var body = layer.getChildFrame('body', index);
            var iframeWin = window[layero.find('iframe')[0]['name']];

            var idLabel = body.find('span#admin-id-label');
            var nameInput = body.find('input[name="adminName"]');
            var passwordInput = body.find('input[name="adminPassword"]');

            $(idLabel).html(id);
            $(nameInput).val(name);
            $(passwordInput).val(password);
        }
    });
});
