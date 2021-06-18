package com.config;

public class ResponseVoUtil {
    public static CommonResponse success(Object object) {
        CommonResponse response = new CommonResponse();
        response.setData(object);
        response.setCode(0);
        response.setMessage("成功");
        return response;
    }
    public static CommonResponse success(){
        return success(null);
    }
    public static CommonResponse error(Integer code,String msg){
        CommonResponse response = new CommonResponse();
        response.setCode(code);
        response.setMessage(msg);
        return response;
    }
}
