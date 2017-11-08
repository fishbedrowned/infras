package com.infras.services.demo;


import com.infras.common.error.ApiErrors;
import com.infras.common.error.ServiceException;
import com.infras.model.demo.Greeting;
import com.infras.model.mappers.GreetingMapper;
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
    private GreetingMapper mapper;

    private final static Logger logger = LoggerFactory.getLogger(DemoService.class);

    public Greeting findGreeting(Integer id){
        if(id < 1){
            throw new ServiceException(ApiErrors.DEMO_TEST);
        }
        return mapper.getGreetings(1);
    }

    public int insertGreeting(Greeting g){
        return mapper.insert(g);
    }


}
