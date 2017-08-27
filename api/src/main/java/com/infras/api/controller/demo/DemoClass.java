package com.infras.api.controller.demo;

import com.infras.model.enums.PhoneCodeType;

/**
 * Created by zhaoheng on 2017/8/25.
 */
public class DemoClass {
    public static void main(String[] args){
        System.out.println(PhoneCodeType.REGISTER.toString() + " " + PhoneCodeType.REGISTER.name());
    }
}
