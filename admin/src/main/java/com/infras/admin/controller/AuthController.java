package com.infras.admin.controller;

import com.infras.admin.AdminPath;
import com.infras.admin.config.Constant;
import com.infras.admin.services.login.forms.LoginForm;
import com.infras.admin.services.login.service.AdminLoginServices;
import com.infras.admin.services.login.vos.LoginVO;
import com.infras.admin.services.login.vos.MenuVO;
import com.infras.common.result.JsonResult;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by zhaoheng on 2017/9/16.
 */
@Log4j
@RestController
public class AuthController implements AdminPath {

    @Autowired
    private AdminLoginServices loginServices;

    @RequestMapping(path = MENUS, method = GET)
    @CrossOrigin
    public JsonResult<List<MenuVO>> menus(HttpServletRequest request){
//        List<MenuVO> children = new ArrayList<>();
//        children.add(MenuVO.builder().name("角色列表").path("/rolelist").component("authmannager/Rolelist").build());
//        children.add(MenuVO.builder().name("角色详情").path("/role").component("authmannager/Role").build());
//        MenuVO auth = MenuVO.builder().name("权限管理").icon("fa-building-o").children(children).build();
//        List<MenuVO> menus = new ArrayList<>();
//        menus.add(auth);
        Integer loginId = Integer.parseInt(request.getSession().getAttribute("loginId").toString());
        List<MenuVO> menus = loginServices.getMenus(loginId);
        return JsonResult.ok(menus);
    }

    @RequestMapping(path = LOGIN, method = POST)
    @CrossOrigin
    public JsonResult login(@Valid @RequestBody LoginForm form, HttpServletRequest request, HttpServletResponse response){
        LoginVO loginVO = loginServices.loginPost(form);
        String v = loginVO.getToken() + "-" + loginVO.getLoginId();
        response.addCookie(new Cookie(Constant.SESSION_KEY, v));
        request.getSession().setAttribute("loginId", loginVO.getLoginId());
        return JsonResult.ok();
    }

    @RequestMapping(path = LOGOUT, method = POST)
    @CrossOrigin
    public JsonResult loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("loginId");
        return JsonResult.ok();
    }
}
