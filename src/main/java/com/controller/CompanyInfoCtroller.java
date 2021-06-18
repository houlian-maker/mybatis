package com.controller;


import com.bean.ResultVo;
import com.config.CommonResponse;
import com.config.ResponseVoUtil;
import com.entity.CompanyInfo;
import com.github.pagehelper.PageInfo;
import com.service.Impl.CompanyInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/CompanyInfo")
public class CompanyInfoCtroller {

    @Autowired
    CompanyInfoServiceImpl companyInfoService;

    // 跳转到企业首页
    @RequestMapping(value = "index",produces = "application/json;charset=UTF-8")
    public String Pro(){

        return "view/CompanyInfo/CompanyInfoList";
    }

    // 跳转到表单
    @RequestMapping(value = "toCompanyInfoFrom",produces = "application/json;charset=UTF-8")
    public String toCompanyInfoFrom(){
        return "view/CompanyInfo/ToCompanyForm";
    }


    /**
     * 分页查询企业列表
     * @param page
     * @param limit
     * @param companyName
     * @return
     */
    @RequestMapping(value = "findCompanyName")
    @ResponseBody
    public CommonResponse findCompany(@RequestParam("page") Integer page,
                                      @RequestParam("limit") Integer limit,
                                      String companyName){
        PageInfo<CompanyInfo> company = companyInfoService.findCompany(companyName, page, limit);

        return ResponseVoUtil.success(company);

    }

    /**
     * 添加企业信息
     * @param companyInfo
     * @return
     */
    @RequestMapping("addCompanyInfo")
    @ResponseBody
    public String addCompanyInfo(@RequestBody CompanyInfo companyInfo){

        Integer integer = companyInfoService.addCompanyInfo(companyInfo);

        if (integer > 0)
            return "success";
        else
            return "error";
    }
}
