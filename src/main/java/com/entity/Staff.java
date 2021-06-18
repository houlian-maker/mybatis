package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 员工类
 */
@Data
public class Staff {

    private Integer id;         // 主键ID

    private String companyId;   // 企业ID

    private String staffCode;   // 员工编号

    private String staffId;     // 员工ID

    private String staffName;   // 员工姓名

    private String phone;       // 手机号

    private String sex;         // 性别

    private String position;    // 职务

    private Integer status;     // 状态

    private String remark;      // 备注

    private Integer valid;      // 是否有效

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;    // 创建日期

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedDate;  // 修改日期
}
