package com.infras.admin.controller;

import com.infras.admin.AdminPath;
import com.infras.model.mappers.LoginMapper;
import com.infras.model.projos.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaoheng on 2017/7/12.
 */
@Controller
public class IndexController implements AdminPath {

    @RequestMapping(path = INDEX)
    public String index(){
        return "index";
    }
}
