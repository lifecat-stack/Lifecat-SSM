$(document).on('click', "#user-update", function () {
        var userId = $('span#user-id-label').html().trim();
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
                "userId": userId,
                "userName": userName,
                "userPassword": userPassword,
                "userLevel" : userLevel
            };
            var jsonData = JSON.stringify(data);
            $.ajax({
                url: "/ssm/user/v1",
                type: 'put',
                contentType: 'application/json;charset=utf-8;',
                dataType: "json",
                data: jsonData,
                success: function (res) {
                    setTimeout(function () {
                        console.log(res.message);
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    }, 1000)
                },
                error: function (res) {
                    setTimeout(function () {
                        console.log(res.message);
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    }, 1000)
                }
            });
        }
    }
);

