$('#search-btn').on('click', function () {
    var imageName = $('input[name="search-image"]').val();
    // null
    if (imageName.length < 1) {
        layer.msg("图片标题不能为空");
    }
    // ajax
    else {
        $.ajax({
            url: "image/v1/" + imageName,
            type: "GET",
            headers: {
                Accept: "application/json;charset=utf-8"
            },
            dataType: "json",
            success: function (data) {
                var operation = '<td class=" text-center">' +
                    '<a class="image-delete" href="#"><i class="glyphicon glyphicon-remove"></i></a>' +
                    '&nbsp;&nbsp;' +
                    '<a class="image-update" href="#"><i class="glyphicon glyphicon-edit"></i></a>' +
                    '</td>';
                var html = '';
                html = html + '<tr>';
                html = html + '<td class="image-id">' + data.imageId + '</td>';
                html = html + '<td class="image-user">' + data.userId + '</td>';
                html = html + '<td class="image-text">' + data.imageText + '</td>';
                html = html + '<td class="image-class">' + data.classId + '</td>';
                html = html + '<td class="image-create">' + data.imageGmtCreate + '</td>';
                html = html + '<td class="image-modified">' + data.imageGmtModified + '</td>';
                html = html + '<td class="image-img">' + '<img src=' + data.imagePath + ' style="height=160px;width=160px;"/>' + '</td>';
                html = html + operation;
                html = html + '</tr>';
                $('#image-table').html(html);
            },
            error: function (res) {
                layer.msg("没有这个资源" + res.message);
            }
        });
    }
});