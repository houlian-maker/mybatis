package com.service;

import com.entity.Company;
import com.github.pagehelper.PageInfo;

import java.text.ParseException;
import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    PageInfo<Company> findAll(int page, int limit);

    Integer addCompany(Company company) throws Exception;
}
