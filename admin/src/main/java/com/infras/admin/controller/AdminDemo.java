package com.infras.admin.controller;

import com.infras.admin.AdminPath;
import com.infras.model.mappers.LoginMapper;
import com.infras.model.projos.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaoheng on 2017/7/12.
 */
@RestController
public class AdminDemo implements AdminPath {

    @Autowired
    LoginMapper loginMapper;

    @RequestMapping(path = LOGIN)
    public Login login(){
        return loginMapper.selectByPrimaryKey(7);
    }
}
