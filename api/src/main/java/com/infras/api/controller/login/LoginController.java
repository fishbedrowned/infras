package com.infras.api.controller.login;

import com.infras.api.controller.ApiPath;
import com.infras.common.result.JsonResult;
import com.infras.services.login.forms.PhoneCodeForm;
import com.infras.services.login.forms.RegisterForm;
import com.infras.services.login.services.LoginService;
import com.infras.services.login.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.infras.services.login.forms.LoginForm;

import javax.validation.Valid;

/**
 * Created by zhaoheng on 2017/7/20.
 */
@RestController
@Api(tags = "Login", description = "登录注册")
public class LoginController implements ApiPath{

    @Autowired
    private LoginService loginService;

    @ApiOperation("登录")
    @RequestMapping(path = LOGIN, method = RequestMethod.POST)
    public JsonResult<LoginVO> login(@Valid @RequestBody LoginForm form){
        form.validate();
        LoginVO loginVO = loginService.loginPost(form);
        return JsonResult.ok(loginVO);
    }

    @ApiOperation("注册")
    @RequestMapping(path = REGISTER, method = RequestMethod.POST)
    public JsonResult<LoginVO> register(@Valid @RequestBody RegisterForm form){
        form.validate();
        LoginVO loginVO = loginService.registerPost(form);
        return JsonResult.ok(loginVO);
    }

    @ApiOperation("发送手机验证码")
    @RequestMapping(path = PHONE_CODE, method = RequestMethod.POST)
    public JsonResult<LoginVO> phoneCode(@Valid @RequestBody PhoneCodeForm form){
        form.validate();
        loginService.phoneCode(form);
        return JsonResult.ok();
    }
}
