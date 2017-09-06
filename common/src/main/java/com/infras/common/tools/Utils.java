package com.infras.common.tools;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhaoheng on 2017/9/3.
 */
public class Utils {
    public static Boolean isNumber(String num){
        return Pattern.matches("[0-9]", num);
    }

    public static void main(String[] args){
        Optional<String> o = Optional.empty();
        System.out.println(o.isPresent());

    }
}
