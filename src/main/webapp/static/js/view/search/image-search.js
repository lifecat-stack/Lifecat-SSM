// 检测函数
var isInputAllow = function (value) {
    return (value === '' || value === undefined || value === null || value.length < 1);
};
$('#search-btn').on('click', function () {
    var imageName = $('input[name="search-image"]').val();

    if (isInputAllow(imageName)) {
        layer.msg("图片标题不能为空");
    }

    else {
        var data = {
            imageName: imageName
        }
        $.ajax({
            url: "/ssm/image",
            type: "GET",
            dataType: "json",
            contentType: "application/json;charset=utf-8;",
            data: JSON.stringify(data),
            success: function (res) {
                var data = res.data
                var operation =
                    '<td class=" text-center">' +
                    '<a class="image-delete" href="#"><i class="glyphicon glyphicon-remove"></i></a>' +
                    '&nbsp;&nbsp;' +
                    '<a class="image-update" href="#"><i class="glyphicon glyphicon-edit"></i></a>' +
                    '</td>';
                var html = '';
                html = html + '<tr>';
                html = html + '<td class="image-id">' + data.id + '</td>';
                html = html + '<td class="image-user">' + data.userId + '</td>';
                html = html + '<td class="image-text">' + data.imageText + '</td>';
                html = html + '<td class="image-name">' + data.imageName + '</td>';
                html = html + '<td class="image-create">' + data.createTime + '</td>';
                html = html + '<td class="image-modified">' + data.updateTime + '</td>';
                html = html + '<td class="image-img">' + '<img src=' + data.imagePath + ' style="height=160px;width=160px;"/>' + '</td>';
                html = html + operation;
                html = html + '</tr>';
                $('#image-table').html(html);
            },
            error: function (res) {
                layer.msg("没有这个资源" + res.msg);
            }
        });
    }
});