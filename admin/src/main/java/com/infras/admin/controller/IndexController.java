package com.infras.admin.controller;

import com.infras.admin.AdminPath;
import com.infras.admin.services.login.forms.LoginForm;
import com.infras.admin.services.login.service.AdminLoginServices;
import com.infras.common.result.JsonResult;
import com.sun.deploy.net.HttpResponse;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by zhaoheng on 2017/7/12.
 */
@Controller
@Log4j
public class IndexController implements AdminPath {

    @RequestMapping(path = INDEX, method = GET)
    public String index(){
        return "index";
    }

    @RequestMapping(path = LOGOUT, method = POST)
    @CrossOrigin
    public @ResponseBody JsonResult loginOut(){
        // TODO
        return JsonResult.ok();
    }
}
