// home-main-tap的div切换

$('#main-href').on('click', function () {
    $.ajax({
        url: '/ssm/home-tap/main',
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

$('#admin-href').on('click', function () {
    $.ajax({
        url: '/ssm/home-tap/admin',
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

$('#user-href').on('click', function () {
    $.ajax({
        url: '/ssm/home-tap/user',
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

$('#diary-href').on('click', function () {
    $.ajax({
        url: '/ssm/home-tap/diary',
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

$('#image-href').on('click', function () {
    $.ajax({
        url: '/ssm/home-tap/image',
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