package com.service;

import com.entity.Store;

import java.util.List;

public interface StoreService {

    // 插入一条数据
    Integer insertOneStore();

    // 插入 Size 条数据
    Integer insertStores(int Size);
    /**
     * 查询前10条数据
     * @return
     */
    List<Store> findStoreTen();
}
