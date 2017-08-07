package com.infras.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by zhaoheng on 2017/8/6.
 */
@Getter
@AllArgsConstructor
public enum Gender {

    UN_KNOW(-1, "未知"),

    MALE(0, "男"),

    FEMALE(1, "女");

    private int code;
    private String name;
}
