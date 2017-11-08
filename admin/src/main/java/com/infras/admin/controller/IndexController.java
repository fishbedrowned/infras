package com.infras.admin.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by zhaoheng on 2017/7/12.
 */
@Controller
@Log4j
public class IndexController implements Path {

    @RequestMapping(path = INDEX, method = GET)
    public String index(){
        return "index";
    }
}
