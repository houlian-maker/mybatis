layui.use(['table','layer','form'], function(){
    var table = layui.table,
        layer = layui.layer,
        from  = layui.form,
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

    table.render({
        elem:'#test',
        height: 500,
        url:'/Company/Prodata',//数据接口
        parseData:function(res){
            return{
                "code":res.code,
                "data":res.data.list,
                "count":res.data.total
            }
        },
       // toolbar:'#toolbarDemo',
        toolbar:'#toolbar01',
        id:'testReload',
        title:'服务列表',
        page: true,//开启分页
        limits:[10,20],
        limit:10,
        cols:[[
            {type: 'checkbox', checkbox:true,fixed: 'left'},
            {field:'company_code',title:'企业code',sort: true,width:120},
            {field:'company_name',title:'企业名称',sort: true,width:120},
            {field:'responsible_person',title:'负责人',width:120},
            {field:'status',title:'状态',width:120,
                templet:function (res) {
                // 先将Object转为JSON对象后，最后在转为js对象
                 var s =  JSON.parse(JSON.stringify(res));
                    if (s.status === 1) {
                        return "正常";
                    }
                    else { return "异常";}
                }},
            {field:'create_date',title:'创建时间',width:180},
            {field:'modified_date',title:'修改时间',width:180},
            {title:'操作',width:165,align:'center',toolbar: '#barDemo'}
        ]],
    });

    // 添加事件
    $(document).on('click','#add',function () {
        layer.open({
            type: 2,
            title: '添加企业信息',
            shadeClose: true,
            shade: 0.8,
            area: ['80%', '90%'],
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
