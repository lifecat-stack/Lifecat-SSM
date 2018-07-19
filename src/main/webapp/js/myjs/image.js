$.func = {
    // 获取最新的image信息
    flush: function () {
        var userId = 1;
        $.ajax({
            url: "image/v1/list/" + userId,
            type: "GET",
            headers: {
                Accept: "application/json;charset=utf-8"
            },
            data: {},
            dataType: "json",//返回的数据类型
            success: function (data) {
                var operation = '<td class=" text-center">' +
                    '<a class="image-remove" href="#"><i class="glyphicon glyphicon-remove"></i></a>' +
                    '&nbsp;&nbsp;' +
                    '<a class="image-edit" href="#"><i class="glyphicon glyphicon-edit"></i></a>' +
                    '</td>';
                var html = '';
                for (var i = 0; i < data.length; i++) {
                    html = html + '<tr>';
                    html = html + '<td class="image-id">' + data[i].imageId + '</td>';
                    html = html + '<td class="image-user">' + data[i].userId + '</td>';
                    html = html + '<td class="image-text">' + data[i].imageText + '</td>';
                    html = html + '<td class="image-class">' + data[i].classId + '</td>';
                    html = html + '<td class="image-create">' + data[i].imageGmtCreate + '</td>';
                    html = html + '<td class="image-modified">' + data[i].imageGmtModified + '</td>';
                    html = html + '<td class="image-img">' + '<img src=' + data[i].imagePath + ' style="height=160px;width=160px;"/>' + '</td>';
                    html = html + operation;
                    html = html + '</tr>';
                }

                $('#image-table').html(html);//通过jquery方式获取table，并把tr,td的html输出到table中
            },
            error: function () {
                alert("查询失败！" + res.data.message);
            }
        });
    }
};

// 查询
$(document).on('click', "#image-query", $.func.flush());

// 添加
$(document).on('click', '#image-upload',function () {
     layer.open({
        type: 2,
        title: '添加日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: '/ssm/view/popup/image-upload.html'
    });
});

// 删除
$(document).on('click', ".image-remove", function () {
    var ii = layer.load();

    var tr = $(this).parent().parent();
    var id = tr.children("td[class='image-id']").text();

    // 利用ajax将数据提交到后台
    $.ajax({
        url: "image/v1/image/" + id,
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
$(document).on('click', ".image-edit", function () {
    var tr = $(this).parent().parent();
    var id = tr.children("td[class='image-id']").text();
    var name = tr.children("td[class='image-name']").text();
    var text = tr.children("td[class='image-text']").text();

    layer.open({
        type: 2,
        title: '修改日记',
        maxmin: true,
        shadeClose: true, //点击遮罩关闭层
        area: ['800px', '520px'],
        content: '/ssm/view/popup/image-update.html?id=' + id + "&name=" + name + "&text=" + text
    });
});
