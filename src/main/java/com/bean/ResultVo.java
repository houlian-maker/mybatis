package com.bean;

import lombok.Data;

@Data
public class ResultVo {
    private String code;
    private String msg;
    private long count=0;
    private Object data;
}
