package com.entity;


import lombok.Data;

import java.util.Date;

/**
 * 店铺数据类
 */

@Data
public class Store {

    private Integer id ;             // 主键id

    private String storeOnlineCode;  // 线上店铺编号

    private String storeOfflineCode; // 线下店铺编号

    private String storeId;          // 店铺id

    private String storeName;        // 店铺名称

    private String storePhone;       // 店铺电话

    private Integer storeType;       // 店铺类型

    private Integer status;          // 店铺状态

    private String remark;           // 店铺备注

    private Integer valid;           // 有效性

    private Date createDate;         // 创建日期

    private Date modifiedDate;       // 修改日期

}
