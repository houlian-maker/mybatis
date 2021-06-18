package com.mapper;


import com.entity.Website;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebsiteMapper {

    // 查询所有网址
    List<Website> findAllWebsite();


    // 添加网址
    Integer insertWebsiteOne(Website website);

    // 修改网址
    Integer editWebsite(Website website);
}
