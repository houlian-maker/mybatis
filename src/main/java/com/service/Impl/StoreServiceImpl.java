package com.service.Impl;

import com.Util.UuidUtil;
import com.entity.Store;
import com.mapper.StoreMapper;
import com.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreMapper storeMapper;

    UuidUtil uuidUtil;

    /**
     * 随机插入一条店铺数据
     * @return
     */

    @Override
    public Integer insertOneStore() {
        Store store = new Store();
        String pro = "testOne_";
        uuidUtil = new UuidUtil();
        String uuid = uuidUtil.genRandomNum();
        // 店铺编号
        store.setStoreOnlineCode(pro+uuid);
        store.setStoreOfflineCode(store.getStoreOnlineCode());
        store.setStoreId(store.getStoreOfflineCode());
        store.setStoreName(store.getStoreOfflineCode());
        store.setStoreType(10);
        store.setStatus(1);
        store.setRemark("造一条数据");
        store.setCreateDate(new Date());
        store.setModifiedDate(store.getCreateDate());
        Integer inertOneStore = storeMapper.InertOneStore(store);
        if (inertOneStore > 0){
           return 1;
        }
        else{
            return -1;
        }
    }

    /**
     * 插入size条数据
     * @param size
     * @return
     */
    @Override
    public Integer insertStores(int size) {
        List<Store> storeList = new ArrayList<>();
        String uuid;
        Store store;
        String pro = "tests_";

        for (int i = 0; i < size; i++) {
            store = new Store();
            uuidUtil = new UuidUtil();
            uuid = uuidUtil.genRandomNum();
            store.setStoreOnlineCode(pro+uuid);
            store.setStoreOfflineCode(store.getStoreOnlineCode());
            store.setStoreId(store.getStoreOfflineCode());
            store.setStoreName(store.getStoreOfflineCode());
            store.setStoreType(10);
            store.setStatus(1);
            store.setRemark("随机生成了"+size+"条数据");
            store.setCreateDate(new Date());
            store.setModifiedDate(store.getCreateDate());
            storeList.add(store);
        }

        Integer integer = storeMapper.insertTenStore(storeList);

        if (integer > 0)

                return size;
        else
                return -1;
    }

    @Override
    public List<Store> findStoreTen() {
        List<Store> storeTen = storeMapper.findStoreTen();
        return storeTen;
    }
}
