// 检测函数
var isInputAllow = function (value) {
    return !(value === '' || value === undefined || value === null || value.length < 1);
};
$('#search-btn').on('click', function () {

    var userName = $('input[name="search-user"]').val();

    if (isInputAllow(userName)) {
        layer.msg("用户名不能为空");
    }

    else {
        $.ajax({
            url: "user/user/" + userName,
            type: "GET",
            headers: {
                Accept: "application/json;charset=utf-8"
            },
            dataType: "json",
            success: function (data) {
                var operation = '<td class=" text-center">' +
                    '<a class="user-delete" href="#"><i class="glyphicon glyphicon-remove"></i></a>' +
                    '&nbsp;&nbsp;' +
                    '<a class="user-update" href="#"><i class="glyphicon glyphicon-edit"></i></a>' +
                    '</td>';
                var html = '';
                html = html + '<tr>';
                html = html + '<td class="user-id">' + data.userId + '</td>';
                html = html + '<td class="user-name">' + data.userName + '</td>';
                html = html + '<td class="user-password">' + data.userPassword + '</td>';
                html = html + '<td class="user-level">' + data.userLevel + '</td>';
                html = html + '<td class="user-create">' + data.userGmtCreate + '</td>';
                html = html + '<td class="user-modified">' + data.userGmtModified + '</td>';
                html = html + operation;
                html = html + '</tr>';
                $('#user-table').html(html);
            },
            error: function (res) {
                layer.msg("查无此人，请确认用户名" + res.message);
            }
        });
    }
});