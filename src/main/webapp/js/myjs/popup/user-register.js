$('#user-register').on('click', function () {

        var userName = $('input[name="userName"]').val();
        var userPassword = $('input[name="userPassword"]').val();

        var success = true;
        if (userName === null || userPassword === null) {
            console.log("输入信息为空！");
            alert("输入信息为空！");
            success = false;
        }

        if (success) {
            var jsonData = {"userName": userName, "userPassword": userPassword};
            $.ajax({
                url: "/ssm/user/v1",
                type: 'post',
                headers: {
                    Accept: "application/json;charset=utf-8"
                },
                contentType: "application/json;charset=utf-8",
                dataType: "json",
                data: JSON.stringify(jsonData),
                success: function (data) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                },
                error: function (res) {
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }
            });
        }
    }
);