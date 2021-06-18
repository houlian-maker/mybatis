layui.use(['table','layer','form'], function() {
    var table = layui.table,
        layer = layui.layer,
        from = layui.form,
        $ = layui.$;


    // 自定义生产员工数据事件
    $(document).on('click','#definedStaff',function () {
        layer.open({
            type: 2,
            title: '自定义员工数据',
            shadeClose: true,
            shade: 0.8,
            skin: 'layui-layer-lan',
            area: ['70%', '90%'],
            content: '/staff/toStaffFromHtml', //iframe的url
            btn:["提交","取消"],
        })
    })
});