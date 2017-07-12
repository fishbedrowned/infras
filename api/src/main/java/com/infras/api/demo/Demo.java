package com.infras.api.demo;

import com.infras.model.demo.Greeting;
import com.infras.services.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by zhaoheng on 2017/7/5.
 */
@RestController
public class Demo {

    @Autowired
    DemoService demoService;

    private final static Logger logger = LoggerFactory.getLogger(Demo.class);

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public @ResponseBody Greeting test(){
        return demoService.test();
    }
}
