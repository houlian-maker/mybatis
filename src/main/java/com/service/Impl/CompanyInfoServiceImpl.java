package com.service.Impl;

import com.entity.CompanyInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.CompanyInfoMapper;
import com.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Autowired
    CompanyInfoMapper companyInfoMapper;

    /**
     * 分页显示企业列表
     * @param companyName
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<CompanyInfo> findCompany(String companyName, int page, int limit) {

        PageHelper.startPage(page,limit);

        List<CompanyInfo> companyInfoList = companyInfoMapper.findCompany(companyName);

        PageInfo<CompanyInfo> pageInfo = new PageInfo<>(companyInfoList);

        return pageInfo;
    }


    /**
     * 添加企业信息
     * @param companyInfo
     * @return
     */
    @Override
    public Integer addCompanyInfo(CompanyInfo companyInfo) {
        companyInfo.setCreateDate(new Date());
        companyInfo.setModifiedDate(companyInfo.getCreateDate());
        Integer integer = companyInfoMapper.addCompanyInfo(companyInfo);
        if (integer > 0)
            return 1;
        else
            return -1;
    }
}
