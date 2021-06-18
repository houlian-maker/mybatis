package com.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private Integer code;
    private String message;
    private T data;
    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
