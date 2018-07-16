 $('#test-btn').on('click', function () {
            console.log('document load');

            $.ajax({
                headers: {
                    Accept: "application/json;charset=utf-8"
                },
                type: "GET",
                url: "ajaxGet",
                data: {},
                dataType: "json",//返回的数据类型
                success: function (data) {
                    var diaryId = data.diaryId;
                    var userId = data.userId;
                    var diaryName = data.diaryName;
                    var diaryText = data.diaryText;
                    var diaryGmtCreate = data.diaryGmtCreate;
                    var diaryGmtModified = data.diaryGmtModified;

                    var html = '';
                    for (var i = 0; i < data.length; i++) {
                        html = html + '<tr>';
                        html = html + '<td>' + data[i].diaryId + '</td>';
                        html = html + '<td>' + data[i].userId + '</td>';
                        html = html + '<td>' + data[i].diaryName + '</td>';
                        html = html + '<td>' + data[i].diaryText + '</td>';
                        html = html + '<td>' + data[i].diaryGmtCreate + '</td>';
                        html = html + '<td>' + data[i].diaryGmtModified + '</td>';

                        html = html + '<td class=" text-center"><a href="#"><i class="glyphicon glyphicon-search"></i></a>&nbsp;&nbsp;<ahref = "#" ><i class="glyphicon glyphicon-edit"></i></a></td>';
                        html = html + '</tr>';
                    }

                    $('#diary-table').html(html);//通过jquery方式获取table，并把tr,td的html输出到table中
                },
                error: function () {
                    console.log();
                    alert("查询失败！");
                }
            });
        });

        $('#diary-query').on('click', function () {
            console.log('mybatis get');
            var userId = 1;
            $.ajax({
                headers: {
                    Accept: "application/json;charset=utf-8"
                },
                type: "GET",
                url: "diary/v1/diaries/" + userId,
                data: {},
                dataType: "json",//返回的数据类型
                success: function (data) {

                    var html = '';
                    for (var i = 0; i < data.length; i++) {
                        html = html + '<tr>';
                        html = html + '<td>' + data[i].diaryId + '</td>';
                        html = html + '<td>' + data[i].userId + '</td>';
                        html = html + '<td>' + data[i].diaryName + '</td>';
                        html = html + '<td>' + data[i].diaryText + '</td>';
                        html = html + '<td>' + data[i].diaryGmtCreate + '</td>';
                        html = html + '<td>' + data[i].diaryGmtModified + '</td>';
                        html = html + '</tr>';
                    }

                    $('#diary-table').html(html);//通过jquery方式获取table，并把tr,td的html输出到table中
                },
                error: function () {
                    console.log();
                    alert("查询失败！");
                }
            });
        });