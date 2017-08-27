package com.infras.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by zhaoheng on 2017/8/23.
 */
@Getter
@AllArgsConstructor
public enum PhoneCodeType {

    REGISTER(0, "注册"),

    LOGIN(1, "登录");

    private int code;
    private String name;
}
