package com.wzszy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class FreemarkerController {

    @GetMapping("ftl")
    public String showFtl(Map<String ,Object> map) {
        map.put("time", new Date());
        map.put("message", "happy new year");
        return "index";
    }
}
