package com.controller;

import com.config.CommonResponse;
import com.config.ResponseVoUtil;
import com.entity.Company;
import com.github.pagehelper.PageInfo;
import com.service.Impl.CompanyServiceImpl;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Company")
public class CompanyController {
    @Autowired
    CompanyServiceImpl companyServiceimpl;

    /**
     * 查询所有企业列表
     * @return
     */

    @RequestMapping(value = "All",produces = "application/json;charset=UTF-8")
    public String findAll(Map<String,Object> map) throws JSONException {
       List<Company> companyList =  companyServiceimpl.findAll();
        map.put("companyList",companyList);
       return "view/Company/CompanyUat";
    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "Pro",produces = "application/json;charset=UTF-8")
    public String Pro(){

        return "view/Company/CompanyPro";
    }
    @RequestMapping("Prodata")
    @ResponseBody
    public CommonResponse pagesAItems(@RequestParam(value = "page",defaultValue = "0")Integer offset,
                                      @RequestParam(value = "limit",defaultValue = "0")Integer size){
        PageInfo pageInfo =  companyServiceimpl.findAll(offset, size);
        return ResponseVoUtil.success(pageInfo);
    }

    // 调转到增加页面
    @RequestMapping("add")
    public String returnAdd(){
        return "view/Company/CompanyFormAdd";
    }

    // 添加企业
    @PostMapping("addCompany")
    @ResponseBody
    public String addCompany(@RequestBody Company company) throws Exception {
       Integer integer = companyServiceimpl.addCompany(company);
       if (integer > 0)
        return "success";
       else
           return "error";
    }

    // 调转到增加页面
    @RequestMapping("detail")
    public String CompanyDetail(){

        return "view/Company/CompanyDetail";
    }


}
