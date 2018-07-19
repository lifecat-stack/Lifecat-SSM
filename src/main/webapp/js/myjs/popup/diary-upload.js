
$('#diary-upload').on('click', function () {
        var loading = layer.load();
        var userId = 1;

        var name = $('#diaryname').val();
        var text = $('#diarytext').val();

        // 表单验证
        var success = true;
        if (name === null) {
            layer.msg("name is null");
            success = false;
        }
        if (text === null) {
            layer.msg("text is null");
            success = false;
        }

        if (success) {
            console.log("diary name:" + name + " text:" + text);

            $.ajax({
                url: "diary/v1/diary",
                type: 'post',
                contentType: 'charset=utf-8',
                data: {diaryName: name, diaryText: text, userId: userId},
                success: function () {
                    layer.close(loading);
                    layer.msg("上传成功");
                    setTimeout(function () {
                        parent.location.reload();
                        // 关闭当前iframe
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    }, 1000)
                },
                error: function (error) {
                    layer.close(loading);
                    layer.msg("上传失败");
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