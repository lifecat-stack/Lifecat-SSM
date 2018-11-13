$(document).ready(function () {
    $('#login-btn').on('click', function () {
        var name = $('#user-name-label').val();
        var psw = $('#user-psw-label').val();
        console.log(name + psw)

        $.ajax({
            url: '/ssm/login' + '?name=' + name + "&password=" + psw,
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            success: function (res) {
                var code = val.statusCode;
                var msg = val.responseMessage;
                if (code === 200) {
                    layer.msg("登录成功");
                    window.location.href = "/ssm/home";
                } else {
                    layer.msg("登录失败:" + responseMessage)
                }
            },
            error: function () {
                layer.msg("请求失败:(")
            }
        })

    });
});