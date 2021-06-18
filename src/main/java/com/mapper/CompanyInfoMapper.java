package com.mapper;

import com.entity.CompanyInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyInfoMapper {

    /**
     * 查下所有企业信息
     * @return
     */
    List<CompanyInfo> findCompany(@Param("companyName")String companyName);


    /**
     * 添加企业信息
     * @param companyInfo
     * @return
     */
    Integer addCompanyInfo(CompanyInfo companyInfo);
}
