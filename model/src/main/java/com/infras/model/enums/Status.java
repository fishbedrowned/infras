package com.infras.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by zhaoheng on 2017/8/4.
 */
@Getter
@AllArgsConstructor
public enum Status {

    NORMAL(0, "正常"),

    TEST(1, "测试"),

    FORBIDDEN(2, "禁用");

    private int code;
    private String name;
}
