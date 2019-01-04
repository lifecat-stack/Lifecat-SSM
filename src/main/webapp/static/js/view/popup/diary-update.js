// 检测函数
var isInputAllow = function (value) {
    return !(value === '' || value === undefined || value === null || value.length < 1);
};
// 检测输入是否为空
var checkInput = function (diaryName, diaryText) {
    var success = true;
    if (isInputAllow(diaryName)) {
        $('#diary-name-label').html(" ");
    } else {
        $('#diary-name-label').html("diaryName is null");
        success = false;
    }
    if (isInputAllow(diaryText)) {
        $('#diary-text-label').html(" ");
    } else {
        $('#diary-text-label').html("diaryText is null");
        success = false;
    }
    return success;
};
$(document).on('click', "#diary-update", function () {
        var diaryId = $('span#diary-id-label').html().trim();
        var diaryName = $('input[name="diaryName"]').val();
        var diaryText = $('textarea[name="diaryText"]').val();

        var isSuccess = checkInput(diaryName, diaryText);

        if (isSuccess) {
            var data = {
                "diaryId": diaryId,
                "diaryName": diaryName,
                "diaryText": diaryText
            };
            var jsonData = JSON.stringify(data);
            $.ajax({
                url: "/ssm/diary",
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