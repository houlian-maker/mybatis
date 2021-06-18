package com.service.Impl;

import com.Util.DateUtils;
import com.entity.Company;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.CompanyMapper;
import com.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    /**
     * 查询所有企业
     * @return
     */
    @Override
    public List<Company> findAll() {
        return companyMapper.findAll();
    }

    /**
     * 分页
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<Company> findAll(int page, int limit) {

        // 开启分页支持
        PageHelper.startPage(page, limit);

        // 当前页码中的数据列表
        // 获取分页的相关信息
        PageInfo<Company> pageInfo = new PageInfo<>(companyMapper.findAll());

        return pageInfo;
    }

    /**
     * 添加企业
     * @param company
     * @return
     */
    @Override
    public Integer addCompany(Company company) throws Exception {
        company.setCreate_date(new Date());
        company.setModified_date(company.getCreate_date());
       Integer integer =  companyMapper.addCompany(company);
       if (integer > 0)
        return 1; // 插入成功
       else
           return 0;
    }


}
