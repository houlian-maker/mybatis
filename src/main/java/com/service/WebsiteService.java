package com.service;

import com.entity.Website;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WebsiteService {

    // 查询所有网址
    List<Website> findAll();

    // 分页
    PageInfo<Website> findAll(int page, int limit);


    // 插入一条数据
    Integer insertWebsiteOne(Website website);

    // 更新
    Integer editWebsiteFrom(Website website);

}
