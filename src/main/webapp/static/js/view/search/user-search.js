// 检测函数
var isInputAllow = function (value) {
    return (value === '' || value === undefined || value === null || value.length < 1);
};
$('#search-btn').on('click', function () {

    var userName = $('input[name="search-user"]').val();

    if (isInputAllow(userName)) {
        layer.msg("用户名不能为空");
    }

    else {
        var data = {
            userName: userName
        }
        $.ajax({
            url: "/ssm/user",
            type: "GET",
            dataType: "json",
            contentType: "application/json;charset=utf-8;",
            data: JSON.stringify(data),
            success: function (res) {
                var data = res.data
                var operation =
                    '<td class=" text-center">' +
                    '<a class="user-delete" href="#"><i class="glyphicon glyphicon-remove"></i></a>' +
                    '&nbsp;&nbsp;' +
                    '<a class="user-update" href="#"><i class="glyphicon glyphicon-edit"></i></a>' +
                    '</td>';
                var html = '';
                html = html + '<tr>';
                html = html + '<td class="user-id">' + data.id + '</td>';
                html = html + '<td class="user-name">' + data.userName + '</td>';
                html = html + '<td class="user-password">' + data.userPassword + '</td>';
                html = html + '<td class="user-level">' + data.userLevel + '</td>';
                html = html + '<td class="user-create">' + data.createTime + '</td>';
                html = html + '<td class="user-modified">' + data.updateTime + '</td>';
                html = html + operation;
                html = html + '</tr>';
                $('#user-table').html(html);
            },
            error: function (res) {
                layer.msg("查无此人，请确认用户名" + res.msg);
            }
        });
    }
});