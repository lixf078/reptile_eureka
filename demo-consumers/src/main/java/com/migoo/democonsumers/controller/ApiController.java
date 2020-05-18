package com.migoo.democonsumers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUserInfoByProducer")
    public String getUserInfoByProducer() {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", "1");
        String userInfo = restTemplate.getForObject("http://DEMO-PRODUCERS/getUserInfo?userId={userId}", String.class,
                paramMap);
        return userInfo;
    }

}
