package com.infras.web.controller;

import com.infras.model.demo.DriverLocation;
import com.infras.services.demo.MongoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaoheng on 2017/10/20.
 */
@RestController
public class IndexController implements Path{

    @Autowired
    MongoServices mongoServices;

    @RequestMapping(path = INDEX)
    public String index(){
        return "index";
    }

    @RequestMapping(path = WEI_XIN)
    public String weixinAuth(){
        return "index";
    }

    @RequestMapping(path = "/mogo/{id}", method = RequestMethod.GET)
    public String getMongo(@PathVariable Integer id){
        return mongoServices.findByLoginId(id).toString();
    }
    @RequestMapping(path = "/mogo/insert/{id}", method = RequestMethod.GET)
    public String saveMongo(@PathVariable Integer id){
        DriverLocation dl = DriverLocation.builder().id(id).loginId(1).longitude(108.892314).latitude(34.190729).build();
        mongoServices.save(dl);
        return "success";
    }
}
