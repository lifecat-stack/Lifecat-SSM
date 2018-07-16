$.func = {
    // 获取最新的diary信息
    flush: function () {
        var userId = 1;
        $.ajax({
            url: "user/v1/user/" + userId,
            type: "GET",
            headers: {
                Accept: "application/json;charset=utf-8"
            },
            data: {},
            dataType: "json",//返回的数据类型
            success: function (data) {
                var operation = '<td class=" text-center">' +
                    '<a class="diary-remove" href="#"><i class="glyphicon glyphicon-remove"></i></a>' +
                    '&nbsp;&nbsp;' +
                    '<a class="diary-edit" href="#"><i class="glyphicon glyphicon-edit"></i></a>' +
                    '</td>';
                var html = '';
                for (var i = 0; i < data.length; i++) {
                    html = html + '<tr>';
                    html = html + '<td class="diary-id">' + data[i].diaryId + '</td>';
                    html = html + '<td>' + data[i].userId + '</td>';
                    html = html + '<td class="diary-name">' + data[i].diaryName + '</td>';
                    html = html + '<td class="diary-text">' + data[i].diaryText + '</td>';
                    html = html + '<td>' + data[i].diaryGmtCreate + '</td>';
                    html = html + '<td>' + data[i].diaryGmtModified + '</td>';
                    html = html + operation;
                    html = html + '</tr>';
                }

                $('#diary-table').html(html);//通过jquery方式获取table，并把tr,td的html输出到table中
            },
            error: function () {
                alert("查询失败！");
            }
        });
    }
};

// 查询
$(document).on('click', "#diary-query", $.func.flush());

// 添加
$(document).on('click', '#diary-upload',function () {
     layer.open({
        type: 2,
        title: '添加日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: '/ssm/view/popup/diary-upload.html'
    });
});

// 删除
$(document).on('click', ".diary-remove", function () {
    var ii = layer.load();

    var tr = $(this).parent().parent();
    var id = tr.children("td[class='diary-id']").text();

    // 利用ajax将数据提交到后台
    $.ajax({
        url: "diary/v1/diary/" + id,
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
$(document).on('click', ".diary-edit", function () {
    var tr = $(this).parent().parent();
    var id = tr.children("td[class='diary-id']").text();
    var name = tr.children("td[class='diary-name']").text();
    var text = tr.children("td[class='diary-text']").text();

    layer.open({
        type: 2,
        title: '修改日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: '/ssm/view/popup/diary-update.html?id=' + id + "&name=" + name + "&text=" + text
    });
});
