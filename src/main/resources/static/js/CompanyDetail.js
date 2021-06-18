layui.use(['table','layer','form'], function() {
    var table = layui.table,
        layer = layui.layer,
        from = layui.form,
        $ = layui.$;

    // 监听头部工具栏事件
    table.on('tool(test)',function (obj) {
        //   var checkStatus = table.checkStatus('field');
        var data = obj.data; // 获取当前的行
        var layEvent = obj.event; // 获取lay-event 对应的值
        if (layEvent === 'getSelect'){
            layer.open({
                type: 2,
                title: '详情信息',
                shadeClose: true,
                shade: 0.8,
                area: ['95%', '90%'],
                content: '/Company/detail', //iframe的url
                btn:["关闭"],
                success:function (layero,index) {
                    // 找到它的子窗
                    var body = layer.getChildFrame('body',index);
                    // 为子窗口元素赋值
                    body.find('input[name=company_code]').val(data.company_code);
                    body.find('input[name=company_name]').val(data.company_name);
                    body.find('input[name=responsible_person]').val(data.responsible_person);
                    body.find('input[name=computer_ip]').val(data.computer_ip);
                    body.find('input[name=computer_account]').val(data.computer_account);
                    body.find('input[name=computer_password]').val(data.computer_password);
                    body.find('input[name=database_ip]').val(data.database_ip);
                    body.find('input[name=database_type]').val(data.database_type);
                    body.find('input[name=database_port]').val(data.database_port);
                    body.find('input[name=database_account]').val(data.database_account);
                    body.find('input[name=database_password]').val(data.database_password);
                    body.find('input[name=database_instance]').val(data.database_instance);
                    body.find('input[name=vpn_ip]').val(data.vpn_ip);
                    body.find('input[name=vpn_count]').val(data.vpn_count);
                    body.find('input[name=vpn_password]').val(data.vpn_password);
                    body.find('input[name=remark]').val(data.remark);
                    // 不可编辑状态
                    body.find('input').attr("disabled",true);
                    // 隐藏按钮
                    body.find('button').css({"display": "none"});

                }
            })
        }
        else if (layEvent === 'getEdit') {
            layer.open({
                type: 2,
                title: '详情信息',
                shadeClose: true,
                shade: 0.8,
                area: ['95%', '90%'],
                content: '/Company/detail', //iframe的url
                btn:["关闭页面"],
                success:function (layero,index) {
                    // 找到它的子窗
                    var body = layer.getChildFrame('body',index);
                    // 为子窗口元素赋值
                    body.find('input[name=company_code]').val(data.company_code);
                    body.find('input[name=company_name]').val(data.company_name);
                    body.find('input[name=responsible_person]').val(data.responsible_person);
                    body.find('input[name=computer_ip]').val(data.computer_ip);
                    body.find('input[name=computer_account]').val(data.computer_account);
                    body.find('input[name=computer_password]').val(data.computer_password);
                    body.find('input[name=database_ip]').val(data.database_ip);
                    body.find('input[name=database_type]').val(data.database_type);
                    body.find('input[name=database_account]').val(data.database_account);
                    body.find('input[name=database_password]').val(data.database_password);
                    body.find('input[name=database_instance]').val(data.database_instance);
                    body.find('input[name=vpn_ip]').val(data.vpn_ip);
                    body.find('input[name=vpn_count]').val(data.vpn_count);
                    body.find('input[name=vpn_password]').val(data.vpn_password);
                    body.find('input[name=remark]').val(data.remark);

                }
            })
        }

    });

});