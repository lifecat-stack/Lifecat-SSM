$('#user-update').on('click', function () {
        var loading = layer.load();

        var userName = $('input[name="userName"]').val();
        var userPassword = $('input[name="userPassword"]').val();

        var success = true;
        if (userName === null) {
            layer.msg("userName is null");
            success = false;
        }
        if (userPassword === null) {
            layer.msg("userPassword is null");
            success = false;
        }

        if (success) {
            $.ajax({
                url: "user/v1",
                type: 'put',
                contentType: 'charset=utf-8;application/json',
                dataType: "json",
                data: {userName: userName, userPassword: userPassword},
                success: function (data) {
                    setTimeout(function () {
                        layer.close(loading);
                        layer.msg("更新成功");
                    }, 1000)
                },
                error: function (res) {
                    setTimeout(function () {
                        layer.close(loading);
                        layer.msg("更新失败");
                    }, 1000)
                }
            });
        }
    }
);