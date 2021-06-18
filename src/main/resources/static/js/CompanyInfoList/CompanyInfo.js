$(function() {$ = layui.jquery;
    layui.use('table', function(){
        var table = layui.table
            ,form = layui.form;
        //表格数据展示
       tableIns = table.render({
            elem:'#articleLists',
            height: 525,
            url:'/CompanyInfo/findCompanyName',//数据接口
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
                {field:'companyCode',title:'企业code',sort: true,width:120},
                {field:'companyName',title:'企业名称',sort: true,width:180},
                {field:'responsiblePerson',title:'负责人',width:120},
                {field:'status',title:'状态',width:120,
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
                {title:'操作',width:165,align:'center',toolbar: '#barDemo'}
            ]],
        });

        //监听工具条
        table.on('tool(articleTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.open({
                    type: 2,
                    title: '添加企业信息',
                    shadeClose: true,
                    shade: 0.8,
                    skin: 'layui-layer-lan',
                    area: ['70%', '90%'],
                    content: '/CompanyInfo/toCompanyInfoFrom', //iframe的url
                    btn:["关闭"],
                    success:function (layero,index) {
                        // 找到它的子窗
                        var body = layer.getChildFrame('body',index);
                        // 为子窗口元素赋值
                        body.find('input[name=companyCode]').val(data.companyCode);
                        body.find('input[name=companyName]').val(data.companyName);
                        body.find('input[name=responsiblePerson]').val(data.responsiblePerson);
                        body.find('textarea[name=computerInfo]').val(data.computerInfo);
                        body.find('textarea[name=databaseInfo]').val(data.databaseInfo);
                        body.find('textarea[name=specialInfo]').val(data.specialInfo);
                        body.find('textarea[name=remark]').val(data.remark);

                    }
                })
            } else if(obj.event === 'edit'){
                //编辑
                alert(data,data.articleId);
            }
        });
    });

    //搜索框
    layui.use(['form'], function(){
        var form = layui.form ,layer = layui.layer;
        //监听搜索框
        form.on('submit(searchSubmit)', function(data){
            //重新加载table
            load(data);
            return false;
        });
    });
});

//重新加载table
function load(obj){
    tableIns.reload({
        where: obj.field
        , page: {
            curr: 1 //从当前页码开始
        }
    });
};