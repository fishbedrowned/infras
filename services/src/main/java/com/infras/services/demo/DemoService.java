package com.infras.services.demo;


import com.infras.model.demo.Greeting;
import org.springframework.stereotype.Service;

/**
 * Created by zhaoheng on 2017/7/5.
 */
@Service
public class DemoService {

    public Greeting test(){
        return new Greeting(1111, "zhaoheng");
    }
}
