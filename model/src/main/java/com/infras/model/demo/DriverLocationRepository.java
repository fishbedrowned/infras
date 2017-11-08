package com.infras.model.demo;

import com.infras.model.demo.DriverLocation;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by zhaoheng on 2017/11/7.
 */
public interface DriverLocationRepository extends MongoRepository<DriverLocation, String> {
//    DriverLocation findByFirstName(String firstName);
}
