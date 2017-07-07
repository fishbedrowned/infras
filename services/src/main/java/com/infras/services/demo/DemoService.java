package com.infras.services.demo;


import com.infras.model.demo.Greeting;
import com.infras.model.mapper.GreetingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaoheng on 2017/7/5.
 */
@Service
public class DemoService {

    @Autowired
    GreetingMapper mapper;

    public Greeting test(){
        mapper.insert(new Greeting(1111, "zhaoheng"));
        return mapper.getGreetings(1111);
    }
}
