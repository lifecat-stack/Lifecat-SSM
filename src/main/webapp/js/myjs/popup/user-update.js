// 检测函数
var isInputAllow = function (value) {
    return !(value === '' || value === undefined || value === null || value.length < 1);
};

// 检测输入是否为空
var checkInput = function (userName, userPassword, userLevel) {
    var success = true;
    if (isInputAllow(userName)) {
        $('#user-name-label').html(" ");
    } else {
        $('#user-name-label').html("userName is null");
        success = false;
    }
    if (isInputAllow(userPassword)) {
        $('#user-password-label').html(" ");
    } else {
        $('#user-password-label').html("userPassword is null");
        success = false;
    }
    if (isInputAllow(userLevel)) {
        $('#user-level-label').html(" ");
    } else {
        $('#user-level-label').html("userLevel is null");
        success = false;
    }
    return success;
};

$(document).on('click', "#user-update", function () {

        var userId = $('span#user-id-label').html().trim();
        var userName = $('input[name="userName"]').val();
        var userPassword = $('input[name="userPassword"]').val();
        var userLevel = $('input[name="userLevel"]').val();

        var isSuccess = checkInput(userName, userPassword, userLevel);

        if (isSuccess) {
            var data = {
                "userId": userId,
                "userName": userName,
                "userPassword": userPassword,
                "userLevel": userLevel
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
                        parent.layer.msg("操作成功 " + res.success);
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    }, 1000)
                },
                error: function (res) {
                    setTimeout(function () {
                        parent.layer.msg("操作失败 " + res.message);
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    }, 1000)
                }
            });
        }
    }
);

