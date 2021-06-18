package com.mapper;

import com.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMapper {
    /**
     * 查询所有企业信息
     */
    List<Company> findAll();

    /**
     * 添加企业信息
     */
   Integer addCompany(Company company);

}
