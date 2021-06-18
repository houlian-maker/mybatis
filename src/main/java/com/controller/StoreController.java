package com.controller;

import com.service.Impl.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Store")
public class StoreController {

    @Autowired
    StoreServiceImpl storeService;


    @RequestMapping("insertOne")
    @ResponseBody
    public Integer insertOneStore(@RequestParam(value = "qty",defaultValue = "0")Integer qty){
        // 根据 qty 值 条用插入 方法
        if (qty == 1){
            Integer integer = storeService.insertOneStore();
            if(integer > 0) return qty;
            else return -1;
        }
        else{
            Integer integers = storeService.insertStores(qty);
            if (integers > 1) return qty;
            else return -1;
        }
    }

    /**
     * 跳转到店铺页面
     * @return
     */
    @RequestMapping("toStoreHtml")
    public String toStaffHtml(){
        return "view/store/store";
    }
}
