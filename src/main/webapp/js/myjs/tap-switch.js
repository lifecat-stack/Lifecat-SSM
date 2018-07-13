// home-main-tap的div切换

// 1、隐藏所有组件
function flush() {
    $('#main-tap div').removeClass('show');
    $('#main-tap div').addClass('item');
}

// 2、展示选择组件
$('#main-href').on('click', function () {
    flush();
    $('#div-main').addClass('show');
});
$('#admin-href').on('click', function () {
    flush();
    $('#div-admin').addClass('show');
});

$('#user-href').on('click', function () {
    flush();
    $('#div-user').addClass('show');
});

$('#diary-href').on('click', function () {
    flush();
    $('#div-diary').addClass('show');
});

$('#image-href').on('click', function () {
    flush();
    $('#div-image').addClass('show');
});