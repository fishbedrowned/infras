package com.infras.model.configs;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by zhaoheng on 2017/7/7.
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class DbInfrasConfig {
    @Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "db.infras")
    public DruidDataSource dataSource() {
        return new ReentrantDruidDataSource();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }
}
