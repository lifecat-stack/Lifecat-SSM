var flush = function () {
    alert("您没有权限访问");

    $.ajax({
        url: "/ssm/admin/v1/list",
        type: "GET",
        headers: {
            Accept: "application/json;charset=utf-8"
        },
        dataType: "json",
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

            $('#admin-table').html(html);
        },
        error: function (res) {
            alert("查询失败！" + res.message);
            location.reload();
        }
    });
};

$(document).ready(function () {
    flush();

    // 查询
    $(document).on('click', "#admin-read", flush());

    // 添加
    $(document).on('click', '#admin-create', function () {
        layer.open({
            type: 2,
            title: '添加用户',
            maxmin: true,
            shadeClose: true,
            area: ['800px', '520px'],
            content: '/ssm/view/popup/admin-register.html',
            end: function () {
                flush();
            }
        });
    });

    // 删除
    $(document).on('click', ".admin-delete", function () {
        var load = layer.load();

        var tr = $(this).parent().parent();
        var id = tr.children("td[class='admin-id']").text();

        $.ajax({
            url: "/ssm/admin/v1/" + id,
            type: 'delete',
            dataType: "json",
            contentType: "application/json;charset=utf-8;",
            data: {},
            success: function (msg) {
                setTimeout(function () {
                    layer.close(load);
                    layer.msg("删除成功" + msg.success);
                    flush();
                }, 1000);
            },
            error: function (msg) {
                setTimeout(function () {
                    layer.close(load);
                    layer.msg("删除失败" + msg.message);
                    flush();
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
            shadeClose: true,
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
            },
            end: function () {
                flush();
            }
        });
    });
});
