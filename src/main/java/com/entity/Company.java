package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 企业类
 */
@Data
public class Company {
    private String company_code; // 企业code
    private String company_name; // 企业名称
    private String company_nick; // 企业别名
    private String company_logo; // 企业log
    private String companyInfo; // 企业信息
    private String computer_ip;   // 远程IP
    private String computer_account; // 远程账号
    private String computer_password; // 远程密码
    private String database_ip; // 数据库IP
    private String database_type; // 数据库类型
    private String database_port; // 数据库端口号
    private String database_account; // 数据库账号
    private String database_password; // 数据库密码
    private String database_instance; // 数据库实例
    private String vpn_ip; // VPN
    private String vpn_count; // VPN 账号
    private String vpn_password; // VPN 密码
    private String remark; // 备注
    private String responsible_person; // 负责人
    private String valid;   // 是否有效 1:有效 0:无效
    private int status; //  状态 0:禁用 1:启用
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_date; // 创建日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modified_date; // 修改日期


}
