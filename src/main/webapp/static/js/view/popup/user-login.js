// 检测函数
var isInputAllow = function (value) {
    return !(value === '' || value === undefined || value === null || value.length < 1);
};
// 检测输入是否为空
var checkInput = function (userName, userPassword) {
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
    return success;
};
$('#user-login').on('click', function () {

        var userName = $('input[name="userName"]').val();
        var userPassword = $('input[name="userPassword"]').val();

        var isSuccess = checkInput(userName, userPassword);

        if (isSuccess) {
            $.ajax({
                url: "/ssm/user/login",
                type: 'post',
                contentType: 'charset=utf-8;application/json',
                dataType: "json",
                data: {userName: userName, userPassword: userPassword},
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