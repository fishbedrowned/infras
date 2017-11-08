package com.infras.services.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by zhaoheng on 2017/11/7.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.infras.services.mongo")
public class MongodbConfig {
}
