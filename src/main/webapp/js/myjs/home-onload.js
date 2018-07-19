$(document).ready(function(){
    $.ajax({
        url: 'home-tap/main',
        type: 'GET',
        dataType: "html",
        success: function (html) {
            var text = $('#home-tap-div');
            text.html(html);
        },
        error: function () {
            layer.msg("请求失败:(")
        }
    })
});
