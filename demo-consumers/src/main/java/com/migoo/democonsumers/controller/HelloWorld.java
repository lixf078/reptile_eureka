package com.migoo.democonsumers.controller;

import com.migoo.democonsumers.config.ConfigPropertiesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Autowired
    private ConfigPropertiesBean configPropertiesBean;

    @RequestMapping("/hello")
    public String helloWorld(){
        System.out.println("address " + configPropertiesBean.getAddress());
        return "" + configPropertiesBean.getAddress();
    }
}