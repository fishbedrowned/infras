package com.infras.api.controller.login;

import com.infras.api.ApiPath;
import com.infras.common.result.JsonResult;
import com.infras.services.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaoheng on 2017/7/20.
 */
@RestController
public class LoginController implements ApiPath{

    @Autowired
    private LoginService loginService;

    @RequestMapping(path = LOGIN)
    public JsonResult login(){
        loginService.test();
        return JsonResult.ok();
    }
}
