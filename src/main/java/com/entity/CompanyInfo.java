package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CompanyInfo {
    private Integer companyId; // 主键ID

    private String companyCode; // 企业编号

    private String companyName; // 企业姓名

    private String responsiblePerson; // 负责人

    private String computerInfo; // 远程信息

    private String databaseInfo; // 数据库连接方式

    private String specialInfo; // 特殊方式

    private String remark; // 备注

    private Integer status; // 状态：0=禁用；1=启用

    private Integer valid; // 数据有效性：1=有效；0=无效

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate; // 创建日期

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedDate; // 修改时间
}
