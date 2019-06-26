package com.wzszy.controller;

import com.wzszy.domain.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${url}")
    private String url;

    @Autowired
    private Environment environment;

    //@RequestMapping("index")
    @GetMapping({"index","index1"})
    public String showIndex() {
        System.out.println(url);
        String url1 = environment.getProperty("url");
        System.out.println("url1: "+ url1);
        return "你好";
    }

    @Autowired
    private PersonConfig personConfig;

    @GetMapping("showPerson")
    public PersonConfig showPerson() {
        System.out.println("1111");
        System.out.println(personConfig);
        return personConfig;
    }


}
