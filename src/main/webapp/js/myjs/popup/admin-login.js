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