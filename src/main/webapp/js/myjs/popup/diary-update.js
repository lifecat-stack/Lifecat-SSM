$(document).on('click', "#diary-update", function () {
        var diaryId = $('span#diary-id-label').html().trim();
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
                "diaryId": diaryId,
                "diaryName": diaryName,
                "diaryText": diaryText
            };
            var jsonData = JSON.stringify(data);
            $.ajax({
                url: "/ssm/diary/v1",
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