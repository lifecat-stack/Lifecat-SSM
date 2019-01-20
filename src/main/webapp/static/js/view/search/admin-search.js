// 检测函数
var isInputAllow = function (value) {
    return (value === '' || value === undefined || value === null || value.length < 1);
};
$('#search-btn').on('click', function () {
    var adminName = $('input[name="search-admin"]').val();

    if (isInputAllow(adminName)) {
        layer.msg("用户名不能为空");
    }
    else {
        var data = {
            adminName: adminName
        }
        $.ajax({
            url: "/ssm/admin",
            type: "GET",
            dataType: "json",
            contentType: "application/json;charset=utf-8;",
            data: JSON.stringify(data),
            success: function (res) {
                var data = res.data
                var operation =
                    '<td class=" text-center">' +
                    '<a class="admin-delete" href="#"><i class="glyphicon glyphicon-remove"></i></a>' +
                    '&nbsp;&nbsp;' +
                    '<a class="admin-update" href="#"><i class="glyphicon glyphicon-edit"></i></a>' +
                    '</td>';
                var html = '';
                html = html + '<tr>';
                html = html + '<td class="admin-id">' + data.id + '</td>';
                html = html + '<td class="admin-name">' + data.adminName + '</td>';
                html = html + '<td class="admin-password">' + data.adminPassword + '</td>';
                html = html + '<td class="admin-create">' + data.createTime + '</td>';
                html = html + '<td class="admin-modified">' + data.updateTime + '</td>';
                html = html + operation;
                html = html + '</tr>';
                $('#admin-table').html(html);
            },
            error: function (res) {
                layer.msg("查无此人，请确认管理员用户名" + res.msg);
            }
        });
    }
});