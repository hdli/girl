package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lihuidong on 2018-3-6.
 */
@RestController
public class HelloController {
//    @Value("${cupSize}")
//    private String cupSize;
    @Autowired
    private GirlProperties properties;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String say(){
        return properties.getCupSize();
    }
}
