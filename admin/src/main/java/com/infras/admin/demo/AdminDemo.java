package com.infras.admin.demo;

import com.infras.admin.AdminPath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaoheng on 2017/7/12.
 */
@RestController
public class AdminDemo implements AdminPath {

    @RequestMapping(path = LOGIN)
    public String login(){
        return "index";
    }
}
