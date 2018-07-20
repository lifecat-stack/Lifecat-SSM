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