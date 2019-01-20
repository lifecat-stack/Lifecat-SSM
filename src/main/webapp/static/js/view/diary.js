var flush = function () {
    $.ajax({
        url: "/ssm/diary/list",
        type: "GET",
        headers: {
            Accept: "application/json;charset=utf-8"
        },
        dataType: "json",
        success: function (res) {
            var data = res.data
            var operation =
                '<td class=" text-center">' +
                '<a class="diary-delete" href="#"><i class="glyphicon glyphicon-remove"></i></a>' +
                '&nbsp;&nbsp;' +
                '<a class="diary-update" href="#"><i class="glyphicon glyphicon-edit"></i></a>' +
                '</td>';
            var html = '';
            for (var i = 0; i < data.length; i++) {
                html = html + '<tr>';
                html = html + '<td class="diary-id">' + data[i].id + '</td>';
                html = html + '<td class="diary-user">' + data[i].userId + '</td>';
                html = html + '<td class="diary-name">' + data[i].diaryName + '</td>';
                html = html + '<td class="diary-text">' + data[i].diaryText + '</td>';
                html = html + '<td class="diary-create">' + data[i].createTime + '</td>';
                html = html + '<td class="diary-update">' + data[i].updateTime + '</td>';
                html = html + operation;
                html = html + '</tr>';
            }
            $('#diary-table').html(html);
        },
        error: function (res) {
            alert("查询失败！" + res.msg);
            location.reload();
        }
    });
};

$(document).ready(function () {
    flush();

    // 查询
    $(document).on('click', "#diary-read", flush());

    // 添加
    $(document).on('click', '#diary-create', function () {
        layer.open({
            type: 2,
            title: '添加日记',
            maxmin: true,
            shadeClose: true,
            area: ['800px', '520px'],
            content: '/ssm/view/popup/diary-upload.html',
            end: function () {
                flush();
            }
        });
    });

    // 删除
    $(document).on('click', ".diary-delete", function () {
        var load = layer.load();

        var tr = $(this).parent().parent();
        var id = tr.children("td[class='diary-id']").text();

        $.ajax({
            url: "/ssm/diary/" + id,
            type: 'delete',
            dataType: "json",
            contentType: "application/json;charset=utf-8;",
            data: {},
            success: function (res) {
                setTimeout(function () {
                    layer.close(load);
                    layer.msg("删除成功" + res.data);
                    flush();
                }, 1000);
            },
            error: function (res) {
                setTimeout(function () {
                    layer.close(load);
                    layer.msg("删除失败" + res.msg);
                    flush();
                }, 1000);
            }
        });
    });

    // 更新
    $(document).on('click', ".diary-update", function () {
        var tr = $(this).parent().parent();
        var id = tr.children("td[class='diary-id']").text();
        var name = tr.children("td[class='diary-name']").text();
        var text = tr.children("td[class='diary-text']").text();

        layer.open({
            type: 2,
            title: '修改日记',
            maxmin: true,
            shadeClose: true,
            area: ['800px', '520px'],
            content: '/ssm/view/popup/diary-update.html',
            success: function (layero, index) {
                var body = layer.getChildFrame('body', index);
                var iframeWin = window[layero.find('iframe')[0]['name']];

                var idLabel = body.find('span#diary-id-label');
                var nameInput = body.find('input[name="diaryName"]');
                var textInput = body.find('textarea[name="diaryText"]');

                $(idLabel).html(id);
                $(nameInput).val(name);
                $(textInput).val(text);
            },
            end: function () {
                flush();
            }
        });
    });
});

