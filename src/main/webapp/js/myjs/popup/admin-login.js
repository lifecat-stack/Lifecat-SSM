$('#admin-login').on('click', function () {
        var loading = layer.load();

        var adminName = $('input[name="adminName"]').val();
        var adminPassword = $('input[name="adminPassword"]').val();

        var success = true;
        if (adminName === null) {
            layer.msg("adminName is null");
            success = false;
        }
        if (adminPassword === null) {
            layer.msg("adminPassword is null");
            success = false;
        }

        if (success) {
            $.ajax({
                url: "/ssm/admin/v1/login",
                type: 'post',
                contentType: 'charset=utf-8;application/json',
                dataType: "json",
                data: {adminName: adminName, adminPassword: adminPassword},
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