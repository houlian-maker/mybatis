package com.controller;


import com.entity.Store;
import com.service.Impl.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    StoreServiceImpl storeService;

    @RequestMapping("toStaffFromHtml")
    public String toStaffFromHtml(Map<String,Object> map){

        List<Store> storeTen = storeService.findStoreTen();
        map.put("storeTen",storeTen);

        return "view/staff/staffFrom";
    }
}
