package com.infras.common.tools;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Created by zhaoheng on 2017/8/23.
 */
public class PhoneUtil {

    // 移动手机号前缀
    private static final List<String> CMCC_PREFIX = Arrays.asList("134", "135", "136", "137", "138", "139", "150", "151", "152", "158", "159", "182", "183", "184", "157", "187", "188", "147", "178", "184");
    // 电信手机号前缀
    private static final List<String> CTCC_PREFIX = Arrays.asList("133", "153", "180", "181", "189", "177", "173");
    // 联通手机号前缀
    private static final List<String> CUCC_PREFIX = Arrays.asList("130", "131", "132", "155", "156", "145", "185", "186", "175", "176", "185");

    public static Boolean validPhone(String phone) {
        List<String> all = new ArrayList<String>();
        all.addAll(CMCC_PREFIX);
        all.addAll(CTCC_PREFIX);
        all.addAll(CUCC_PREFIX);
        return validPhone(phone, all);
    }

    public static Boolean validPhone(String phone, List<String> validScope) {
       String prefix = StringUtils.join(validScope, "|");
       String regex = String.format("^(%s)\\d{8}$$", prefix);
       return Pattern.matches(regex, phone);
    }


    public static void main(String[] args){

        Predicate<String> predicate = (phone) -> {
            String regex = String.format("^(%s)\\d{8}$$", "134 | 135");
            return Pattern.matches(regex, phone);
        };
        predicate.test("18984737383");
        predicate.negate().test("18984737383");
        System.out.println("result = " + new PhoneUtil().validPhone("18984737383"));
    }
}
