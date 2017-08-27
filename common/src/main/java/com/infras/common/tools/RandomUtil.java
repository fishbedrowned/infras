package com.infras.common.tools;

import org.apache.commons.lang3.RandomUtils;

/**
 * Created by zhaoheng on 2017/8/23.
 */
public class RandomUtil {
    public static String generateNumber(int len){
        long start = Math.round(Math.pow(10, len > 1 ? len - 1 : 0));
        long end = Math.round(Math.pow(10, len));
        Long num = RandomUtils.nextLong(start, end);
        return num.toString();
    }

    public static void main(String[] args){
        System.out.println(generateNumber(2));
        System.out.println(generateNumber(4));
        System.out.println(generateNumber(6));
    }
}
