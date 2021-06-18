layui.use(['table','layer','form'], function() {
    var table = layui.table,
        layer = layui.layer,
        from = layui.form,
        $ = layui.$;
    table.render({
        elem:'#test',
        height: 500,
        url:'/netWork/webData',//数据接口
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
        //  {type: 'checkbox', checkbox:true,fixed: 'left'},
            {title: '序号',templet: '#xuhao',sort: true,width:80},
            {field:'websiteName',title:'网址',width:100},
            {field:'websiteAccount',title:'账号',width:100},
            {field:'websitePassword',title:'密码',width:100},
            {field:'websiteType',title:'类型',width:100},
            {field:'remark',title:'备注',width:100},
            {field:'status',title:'状态',width:100,
                templet:function (res) {
                    // 先将Object转为JSON对象后，最后在转为js对象
                    var s =  JSON.parse(JSON.stringify(res));
                    if (s.status === 1) {
                        return "正常";
                    }
                    else { return "异常";}
                }},
            {field:'createDate',title:'创建时间',width:180},
            {field:'modifiedDate',title:'修改时间',width:180},
            {title:'操作',width:165,align:'center',toolbar: '#barDemo',fixed:'right'}
        ]],
    });
})