package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Order")
public class OrderController {


    @RequestMapping("createOrder")
    public String createOrder(){

        return "view/Order/Order";
    }
}
