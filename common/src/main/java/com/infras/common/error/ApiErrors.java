package com.infras.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by zhaoheng on 2017/7/13.
 */
@Getter
@AllArgsConstructor
public enum ApiErrors {

    // 10以下是服务器错误
    SERVER_ERROR(1, "服务器错误"),
    REQUEST_PARAM_ERROR(2, "请求参数无效"),
    RESOURCE_NOT_FIND_ERROR(3, "资源不存在"),
    BASE_UNAUTHORIZED(4, "未授权"),
    BASE_FORBIDDEN(5, "拒绝访问"),

    // 业务错误码
    PHONE_CODE_INVALID(10, "验证码错误！"),

    ACCOUNT_ERROR(20, "账号或密码错误！"),
    ACCOUNT_FORBIDDEN(21, "您的账号受限，请联系1183131687@qq.com"),
    ACCOUNT_NOT_REGISTER(22, "未注册！"),
    PHONE_INVALID(23, "手机号无效！"),
    PASSWORD_WEEK(24, "密码过于简单！"),
    PASSWORD_SHORT(25, "密码不能小于6位！"),


    DEMO_TEST(29, "id无效");

    private int code;
    private String message;
}
