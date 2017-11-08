package com.infras.api.controller;

/**
 * Created by zhaoheng on 2017/7/13.
 */
public interface ApiPath {

    // Demo URL
    String DEMO_GET_TEST = "test/{id}";
    String DEMO_TEST = "test";

    // 登录、注册
    String LOGIN = "login";
    String REGISTER = "register";
    String PHONE_CODE = "phone/code";

}
