package com.infras.admin.controller;

import com.infras.admin.services.auths.vos.MenuVO;
import com.infras.common.result.JsonResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.infras.admin.AdminPath.MENUS;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by zhaoheng on 2017/9/16.
 */
@RestController
public class AuthController {

    @RequestMapping(path = MENUS, method = GET)
    @CrossOrigin
    public JsonResult<List<MenuVO>> menus(){
        List<MenuVO> children = new ArrayList<>();
        children.add(MenuVO.builder().name("角色列表").path("/rolelist").component("authmannager/Rolelist").build());
        children.add(MenuVO.builder().name("角色详情").path("/role").component("authmannager/Role").build());
        MenuVO auth = MenuVO.builder().name("权限管理").icon("fa-building-o").children(children).build();
        List<MenuVO> menus = new ArrayList<>();
        menus.add(auth);
        return JsonResult.ok(menus);
    }
}
