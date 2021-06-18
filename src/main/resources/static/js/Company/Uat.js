//JS
layui.use(['element', 'layer', 'util'], function(){
    var element = layui.element
        ,layer = layui.layer
        ,util = layui.util
        ,$ = layui.jquery;

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

// 设置弹出层
   $(document).on('click','#add',function () {
       layer.open({
           type: 2,
           title: '添加企业信息',
           shadeClose: true,
           shade: 0.8,
           area: ['50%', '90%'],
           content: '/Company/add', //iframe的url
           btn:["提交","取消"],
           yes:function (index,layero) {
               // 获取子页面表单提交的值
                var body = layer.getChildFrame('body',index);
                 var form_s = JSON.stringify(body.find("#add1").serializeObject());
                $.ajax({
                    type:"POST",
                    url:'/Company/addCompany',
                    dataType:'text', // 返回一个string 类型
                    contentType: "application/json",
                    data:form_s,
                    beforeSend: function () {
                        layer.msg('处理中...', {icon: 16,time: 2000});
                    },
                    success:function (result) {
                        if (result !== '') {
                            layer.closeAll("loading");
                            layer.msg("添加成功", { icon: 6,time:1000},
                                function () {
                                    layer.close(layer.index);  //关闭窗口
                                    window.location.reload(); //刷新窗口
                            });
                // icon 1: √，2：失败，3：疑问，4:锁定，6：笑脸，7：感叹号
                        }else {
                            layer.closeAll("loading");
                            layer.msg("添加失败", { icon: 5 });
                        }
                    },
                    error: function (result) {
                        layer.alert("发生异常")
                    }

                })
               return false; // layui 加了才会进入回调函数
           }
       });
   });

});
