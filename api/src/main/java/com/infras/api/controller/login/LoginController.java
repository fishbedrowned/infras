package com.infras.api.controller.login;

import com.infras.api.ApiPath;
import com.infras.common.result.JsonResult;
import com.infras.services.login.services.LoginService;
import com.infras.services.login.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.infras.services.login.forms.LoginForm;

import javax.validation.Valid;

/**
 * Created by zhaoheng on 2017/7/20.
 */
@RestController
public class LoginController implements ApiPath{

    @Autowired
    private LoginService loginService;

    @RequestMapping(path = LOGIN, method = RequestMethod.POST)
    public JsonResult<LoginVO> login(@Valid @RequestBody LoginForm form){
        LoginVO loginVO = loginService.loginPost(form);
        return JsonResult.ok(loginVO);
    }
}
