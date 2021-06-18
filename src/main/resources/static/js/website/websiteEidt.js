layui.use(['table','layer','form'], function() {
    var table = layui.table,
        layer = layui.layer,
        from = layui.form,
        $ = layui.$;
    // 将表单格式转为json格式方法
    $.fn.serializeObject = function(){
        var o={};
        var a = this.serializeArray();
        $.each(a,function(){
            if(o[this.name]){
                if(!o[this.name].push){
                    o[this.name]=[o[this.name]];
                }
                o[this.name].push(this.value || '');
            }else{
                o[this.name]=this.value || '';
            }
        });
        return o;
    };

    table.on('tool(test)',function (obj) {
        //   var checkStatus = table.checkStatus('field');
        var data = obj.data; // 获取当前的行

        var layEvent = obj.event; // 获取lay-event 对应的值

        if (layEvent==="edit"){
           // var da = JSON.stringify(data); // 将object 转为 json
           // layer.alert(data.createDate);
            layer.open({
                type: 2,
                title: '编辑信息',
                shadeClose: true,
                skin: 'layui-layer-lan',
                area: ['50%', '90%'],
                content: '/netWork/toWebsiteFrom', //iframe的url
                btn:["确认编辑","取消"],
                success:function (layero,index) {
                    // 找到它的子窗
                    var body = layer.getChildFrame('body',index);
                    // 为子窗口元素赋值 回显数据
                    body.find('input[name=netId]').val(data.netId);
                    body.find('input[name=websiteName]').val(data.websiteName);
                    body.find('input[name=websiteType]').val(data.websiteType);
                    body.find('input[name=websiteAccount]').val(data.websiteAccount);
                    body.find('input[name=websitePassword]').val(data.websitePassword);
                    body.find('textarea[name=remark]').val(data.remark);
                },
                // 注意这里函数参数与上面的函数参数位置相反哦 ！
                yes:function (index,layero) {
                    var body = layer.getChildFrame('body',index);
                    var form_s = JSON.stringify(body.find("#addWebsiteFrom").serializeObject());
                    // 提交表单
                    $.ajax({
                        type:"POST",
                        url:'/netWork/editWebsiteFrom',
                        dataType:'text', // 返回一个string 类型
                        contentType: "application/json",
                        data:form_s,
                        success:function (result) {
                            if (result !== '') {
                                layer.msg(result,{ icon: 6,time:1000},function () {
                                    layer.close(layer.index);  //关闭窗口
                                    window.location.replace(location.href); //刷新窗口
                                })
                            }
                            else {
                                layer.alert("修改失败else");
                            }
                        },
                        error:function () {
                            layer.alert("发生异常error");
                        }
                    });
                    return false;  // layui框架 加了此句才会进入回调方法
                }

            })

        }
        else if (layEvent==="delete") {
            layer.alert('确定删除吗？', {
                time: 0 //不自动关闭
                ,btn: ['确定', '取消']
                ,icon: 3
                ,skin: 'layui-layer-lan'
                ,yes: function(index){
                    alert(1);
                    $.ajax({
                        url:"/netWork/deleteWebsiteById?netId="+data.netId,
                       // data:{'netId':data.netId},
                        type:"Post",
                        contentType: "application/json",
                        dataType:"text",
                        success:function(data){
                            layer.msg(data);
                        },
                        error:function(data){
                            layer.msg('错误');
                        }
                    });
                    layer.close(index);

                }
            });

        }
    });


});