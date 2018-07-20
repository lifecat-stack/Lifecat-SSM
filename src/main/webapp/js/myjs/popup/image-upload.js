// 检测函数
var isInputAllow = function (value) {
    return !(value === '' || value === undefined || value === null || value.length < 1);
};
// 检测输入是否为空
var checkInput = function (imageText, imageClass) {
    var success = true;
    if (isInputAllow(imageText)) {
        $('#image-text-label').html(" ");
    } else {
        $('#image-text-label').html("imageText is null");
        success = false;
    }
    if (isInputAllow(imageClass)) {
        $('#image-class-label').html(" ");
    } else {
        $('#image-class-label').html("imageClass is null");
        success = false;
    }
    return success;
};
$('#image-update').on('click', function () {

        var imageText = $('input#imageText').val();
        var imageClass = $('input#imageClass').val();
        // TODO 上传File类型

        var isSuccess = checkInput(imageText, imageClass);

        if (isSuccess) {
            var data = {
                "imageText": imageText,
                "classId": imageClass
            };
            var jsonData = JSON.stringify(data);
            $.ajax({
                url: "/ssm/image/v1",
                type: 'post',
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