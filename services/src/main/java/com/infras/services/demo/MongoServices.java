package com.infras.services.demo;

import com.infras.model.demo.DriverLocation;
import com.infras.services.mongo.repository.DriverLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhaoheng on 2017/11/7.
 */
@Service
public class MongoServices {

    @Autowired
    private DriverLocationRepository mongoRepo;

    public DriverLocation save(DriverLocation user) {
        DriverLocation rs = mongoRepo.insert(user);
        return rs;
    }

    public DriverLocation findByLoginId(Integer loginId) {
        DriverLocation rs = this.mongoRepo.findAll().get(2);
        return rs;
    }

}
