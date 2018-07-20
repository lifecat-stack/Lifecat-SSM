$('#image-upload').on('click', function () {
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
                url: "/ssm/diary/v1/diary",
                type: 'post',
                contentType: 'charset=utf-8',
                data: {diaryName: name, diaryText: text, userId: userId},
                success: function (res) {
                    console.log(res.success);

                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                },
                error: function (res) {
                    console.log(res.message);

                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }
            });
        }
    }
);