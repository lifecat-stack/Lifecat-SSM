$(document).on('click', "#user-register", function () {
        var userName = $('input[name="userName"]').val();
        var userPassword = $('input[name="userPassword"]').val();
        var userLevel = $('input[name="userLevel"]').val();

        var success = true;
        if (userName === null) {
            $('#user-name-label').html("userName is null");
            success = false;
        }
        if (userPassword === null) {
            $('#user-password-label').html("userPassword is null");
            success = false;
        }
        if (userLevel === null) {
            $('#user-level-label').html("userLevel is null");
            success = false;
        }

        if (success) {
            var data = {
                "userName": userName,
                "userPassword": userPassword,
                "userLevel": userLevel
            };
            var jsonData = JSON.stringify(data);
            $.ajax({
                url: "/ssm/user/v1",
                type: 'post',
                headers: {
                    Accept: "application/json;charset=utf-8"
                },
                contentType: "application/json;charset=utf-8",
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