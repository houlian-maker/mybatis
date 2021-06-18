layui.use(['layer'], function(){
    var layer = layui.layer,
        $ = layui.$;

    // 随机生成店铺事件
    $(document).on('click','.inertStore',function () {
        // 获取当前value 传入后台，根据vaue值随机插入数据
        var qty = $(this).val();
        $.post("/Store/insertOne",{"qty":qty},function (data) {
              if (data > 0){
                  layer.alert("成功生成"+data+"条数据")
              }
              else{
                  layer.alert("插入"+data+"条数据失败")
              }
        })
    });



});