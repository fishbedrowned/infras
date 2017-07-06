package com.infras.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zhaoheng on 2017/7/5.
 */
@SpringBootApplication
@ComponentScan("com.infras")
public class Application {
    public static void main(String[] args){ SpringApplication.run(Application.class);};
}