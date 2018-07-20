$(document).on('click', "#diary-upload", function () {
        var diaryName = $('input[name="diaryName"]').val();
        var diaryText = $('textarea[name="diaryText"]').val();

        var success = true;
        if (diaryName === null) {
            $('#diary-name-label').html("diaryName is null");
            success = false;
        }
        if (diaryText === null) {
            $('#diary-text-label').html("diaryText is null");
            success = false;
        }

        if (success) {
            var data = {
                "diaryName": diaryName,
                "diaryText": diaryText
            };
            var jsonData = JSON.stringify(data);
            $.ajax({
                url: "/ssm/diary/v1",
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                dataType: 'json',
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