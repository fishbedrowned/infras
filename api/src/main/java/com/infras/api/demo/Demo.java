package com.infras.api.demo;

import com.infras.model.demo.Greeting;
import com.infras.services.demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaoheng on 2017/7/5.
 */
@RestController
public class Demo {

    @Autowired
    DemoService demoService;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public @ResponseBody Greeting test(){
        return demoService.test();
    }
}
