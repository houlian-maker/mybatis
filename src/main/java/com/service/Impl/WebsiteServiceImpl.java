package com.service.Impl;

import com.entity.Website;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.WebsiteMapper;
import com.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WebsiteServiceImpl implements WebsiteService {

    @Autowired
    WebsiteMapper websiteMapper;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Website> findAll() {
    return websiteMapper.findAllWebsite();
    }

    /**
     * 支持分页
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<Website> findAll(int page, int limit) {
        // 开启分页支持
        PageHelper.startPage(page, limit);

        // 当前页码中的数据列表
        // 获取分页的相关信息
        PageInfo<Website> pageInfo = new PageInfo<>(websiteMapper.findAllWebsite());

        return pageInfo;
    }

    /**
     * 插入
     * @param website
     * @return
     */
    @Override
    public Integer insertWebsiteOne(Website website) {
        // 创建时间
        website.setCreateDate(new Date());
        website.setModifiedDate(website.getCreateDate());

        Integer integer = websiteMapper.insertWebsiteOne(website);

        if(integer > 0)
            return 1;
        else
            return -1;
    }

    /**
     * 更新
     * @param website
     * @return
     */
    @Override
    public Integer editWebsiteFrom(Website website) {
        website.setModifiedDate(new Date());

        Integer integer = websiteMapper.editWebsite(website);

        if (integer > 0)
            return 1;
        else
        return -1;
    }
}
