$('#user-login').on('click', function () {
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
                url: "/ssm/user/v1/login",
                type: 'post',
                contentType: 'charset=utf-8;application/json',
                dataType: "json",
                data: {userName: userName, userPassword: userPassword},
                success: function (data) {
                    setTimeout(function () {
                        layer.close(loading);
                        layer.msg("登录成功");
                    }, 1000)
                },
                error: function (res) {
                    setTimeout(function () {
                        layer.close(loading);
                        layer.msg("登录失败");
                    }, 1000)
                }
            });
        }
    }
);