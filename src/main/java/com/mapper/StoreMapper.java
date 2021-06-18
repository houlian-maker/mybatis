package com.mapper;

import com.entity.Store;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreMapper {

    /**
     * 插入一条店铺数据
     * @param store
     * @return
     */
   Integer InertOneStore(Store store);

    /**
     * 插入多条数据
     */
    Integer insertTenStore(List<Store> storeList);

    /**
     * 查询前10条数据
     * @return
     */
    List<Store> findStoreTen();
}
