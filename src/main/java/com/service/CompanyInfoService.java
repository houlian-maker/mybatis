package com.service;

import com.entity.CompanyInfo;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

public interface CompanyInfoService {
    /**
     * 查下所有企业信息
     * @return
     */
    PageInfo<CompanyInfo> findCompany(@Param("companyName")String companyName, int page, int limit);

    /**
     * 添加企业信息
     * @param companyInfo
     * @return
     */
    Integer addCompanyInfo(CompanyInfo companyInfo);

}
