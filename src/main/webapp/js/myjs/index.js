$(document).ready(function () {
    console.log("一再在")

    $('#login-btn').on('click', function () {
        var name = $('#user-name-label').val();
        var psw = $('#user-psw-label').val();
        console.log(name + psw)

        $.ajax({
            url: '/ssm/login' + '?name=' + name + "&password=" + psw,
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded',
            success: function (res) {
                var val = res.data;
                var code = val.code;
                var msg = val.msg;
                if (code === 0) {
                    layer.msg("登录成功")
                } else {
                    layer.msg("登录失败")
                }
            },
            error: function () {
                layer.msg("请求失败:(")
            }
        })

    });
});