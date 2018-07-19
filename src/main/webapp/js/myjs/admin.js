$.func = {
    // 获取最新的diary信息
    flush: function () {
        alert("您没有权限访问");

        var userId = 1;
        $.ajax({
            url: "/ssm/admin/v1/list",
            type: "GET",
            headers: {
                Accept: "application/json;charset=utf-8"
            },
            dataType: "json",//返回的数据类型
            success: function (data) {
                var operation = '<td class=" text-center">' +
                    '<a class="admin-remove" href="#"><i class="glyphicon glyphicon-remove"></i></a>' +
                    '&nbsp;&nbsp;' +
                    '<a class="admin-edit" href="#"><i class="glyphicon glyphicon-edit"></i></a>' +
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