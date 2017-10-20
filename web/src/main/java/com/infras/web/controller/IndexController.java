package com.infras.web.controller;

import com.infras.web.Path;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaoheng on 2017/10/20.
 */
@RestController
public class IndexController implements Path{

    @RequestMapping(path = INDEX)
    public String index(){
        return "index";
    }
}
