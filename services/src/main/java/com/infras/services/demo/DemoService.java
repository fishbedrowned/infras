package com.infras.services.demo;


import com.infras.model.demo.Greeting;
import com.infras.model.mapper.GreetingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaoheng on 2017/7/5.
 */
@Service
public class DemoService {

    @Autowired
    GreetingMapper mapper;

    private final static Logger logger = LoggerFactory.getLogger(DemoService.class);

    public Greeting test(){
        mapper.insert(new Greeting(1111, "zhaoheng"));
        logger.info("测试下Info信息");
        logger.error("测试下错误信息");
        return mapper.getGreetings(1111);
    }
}
