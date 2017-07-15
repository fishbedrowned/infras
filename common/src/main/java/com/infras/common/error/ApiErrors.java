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
    DEMO_TEST(20, "id无效");

    private int code;
    private String message;
}
