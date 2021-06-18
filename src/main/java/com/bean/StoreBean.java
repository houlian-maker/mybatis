package com.bean;

import lombok.Data;

import java.util.List;

@Data
public class StoreBean {

    String remark;

    Integer qty;

    List<String> ids;
}
