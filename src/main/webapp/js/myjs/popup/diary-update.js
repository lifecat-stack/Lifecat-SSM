// 获取父框架传进的参数
$(function () {
    var url = window.location.href;
    var str = url.split('?')[1];
    // [id= , name= , text= ]
    var args = str.split('&');

    var did = args[0].split('=')[1];
    var name = args[1].split('=')[1];
    var text = args[2].split('=')[1];

    // url编码解码
    $('#diaryid').val(decodeURI(did));
    $('#diaryname').val(decodeURI(name));
    $('#diarytext').val(decodeURI(text));

    console.log("id:" + did + " name:" + name + " text:" + text);
});


$('#diary-update').on('click', function () {

        console.log("diary update");

        var did = $('#diaryid').val();
        var name = $('#diaryname').val();
        var text = $('#diarytext').val();

        // 表单验证
        var success = true;
        if (did === null) {
            layer.msg("id is null");
            success = false;
        }
        if (name === null) {
            layer.msg("name is null");
            success = false;
        }
        if (text === null) {
            layer.msg("text is null");
            success = false;
        }

        if (success) {
            var args = "id=" + did + " &name=" + name + "&text=" + text;

            $.ajax({
                url: "diary/v1/diary?" + args,
                type: 'PUT',
                contentType: 'charset=utf-8',
                success: function () {
                    layer.close(loading);
                    layer.msg("更新成功");
                    setTimeout(function () {
                        parent.location.reload();
                        // 关闭当前iframe
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    }, 1000)
                },
                error: function (error) {
                    layer.close(loading);
                    layer.msg("更新失败");
                    console.log('接口不通' + error);
                    setTimeout(function () {
                        parent.location.reload();
                        // 关闭当前iframe
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    }, 1000)
                }
            });
        }
    }
);