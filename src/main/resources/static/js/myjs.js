//JS
layui.use(['element', 'layer', 'util'], function(){
    var element = layui.element
        ,layer = layui.layer
        ,util = layui.util
        ,$ = layui.jquery;

// tab切换iframe
    $(function () {
        $(".main_left").on("click",function () {
            var address = $(this).attr("data-url");
            $("iframe").attr("src",address);
        });
    });

});
