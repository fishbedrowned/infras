package com.infras.api.interceptor;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by zhaoheng on 2017/8/22.
 */
public class Demo {
    public static void main(String[] args){

//        OffsetDateTime loginTime = OffsetDateTime.parse("201708221400", DateTimeFormatter.ofPatternrn("yyyyMMddHHmm").withZone(ZoneId.systemDefault()));
        LocalDateTime de = LocalDateTime.parse("1708221400", DateTimeFormatter.ofPattern("yyMMddHHmm"));
        System.out.println(de.toString());
    }
}
