// 检测函数
var isInputAllow = function (value) {
    return !(value === '' || value === undefined || value === null || value.length < 1);
};
// 检测输入是否为空
var checkInput = function (adminName, adminPassword) {
    var success = true;
    if (isInputAllow(adminName)) {
        $('input[name="adminName"]').html(" ");
    } else {
        $('input[name="adminName"]').html("adminName is null");
        success = false;
    }
    if (isInputAllow(adminPassword)) {
        $('input[name="adminPassword"]').html(" ");
    } else {
        $('input[name="adminPassword"]').html("adminPassword is null");
        success = false;
    }
    return success;
};
$(document).on('click', "#admin-update", function () {

        var adminId = $('span#admin-id-label').html().trim();
        var adminName = $('input[name="adminName"]').val();
        var adminPassword = $('input[name="adminPassword"]').val();

        var isSuccess = checkInput(adminName, adminPassword);

        if (isSuccess) {
            var data = {
                "id": adminId,
                "adminName": adminName,
                "adminPassword": adminPassword
            };
            var jsonData = JSON.stringify(data);
            $.ajax({
                url: "/ssm/admin",
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