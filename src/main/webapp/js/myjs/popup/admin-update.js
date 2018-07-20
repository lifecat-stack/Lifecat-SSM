$(document).on('click', "#admin-update", function () {
        var adminId = $('span#admin-id-label').html().trim();
        var adminName = $('input[name="adminName"]').val();
        var adminPassword = $('input[name="adminPassword"]').val();

        var success = true;
        if (adminName === null) {
            $('#admin-name-label').html("adminName is null");
            success = false;
        }
        if (adminPassword === null) {
            $('#admin-password-label').html("adminPassword is null");
            success = false;
        }

        if (success) {
            var data = {
                "adminId": adminId,
                "adminName": adminName,
                "adminPassword": adminPassword
            };
            var jsonData = JSON.stringify(data);
            $.ajax({
                url: "/ssm/admin/v1",
                type: 'put',
                contentType: 'application/json;charset=utf-8;',
                dataType: "json",
                data: jsonData,
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