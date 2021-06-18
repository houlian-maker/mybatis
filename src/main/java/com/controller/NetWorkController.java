package com.controller;

import com.config.CommonResponse;
import com.config.ResponseVoUtil;
import com.entity.Website;
import com.github.pagehelper.PageInfo;
import com.service.Impl.WebsiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/netWork")
public class NetWorkController {

    @Autowired
    WebsiteServiceImpl websiteService;

    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("detail")
    public String netWork(){
        return "view/NetWork/NetWork";
    }


    /**
     * 表格渲染数据 分页
     * @param offset
     * @param size
     * @return
     */
    @RequestMapping("webData")
    @ResponseBody
    public CommonResponse pagesAItems(@RequestParam(value = "page",defaultValue = "0")Integer offset,
                                      @RequestParam(value = "limit",defaultValue = "0")Integer size){
        PageInfo pageInfo =  websiteService.findAll(offset, size);
        return ResponseVoUtil.success(pageInfo);
    }

    /**
     * 弹出form表格框
     * @return
     */
    @RequestMapping("toWebsiteFrom")
    public String toWebsiteFrom(){
        return "view/NetWork/WebsiteFromAdd";
    }

    /**
     * 添加Website 信息
     * @param website
     * @return
     */
    @PostMapping("addWebsiteFrom")
    @ResponseBody
    public String addWebsiteFrom(@RequestBody Website website){
        Integer integer = websiteService.insertWebsiteOne(website);
        if (integer == 1)
            return "添加成功";
        else
            return "添加失败";
    }

    /**
     * 修改信息
     * @param website
     * @return
     */
    @PostMapping(value = "editWebsiteFrom",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String editWebsiteFrom(@RequestBody Website website){
        Integer integer = websiteService.editWebsiteFrom(website);

        if (integer == 1)
            return "修改成功";
        else
            return "修改失败";
    }

    @PostMapping(value = "deleteWebsiteById",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteWebsiteById(@RequestParam(value = "netId")Integer netId){
        System.out.println(netId);

        if (netId != null)
        return "删除成功";
        else
            return "删除失败";
    }
}
