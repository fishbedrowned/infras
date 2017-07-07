package com.infras.model.configs;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Created by zhaoheng on 2017/7/7.
 */
public class ReentrantDruidDataSource extends DruidDataSource {

    @Override
    public void setUrl(String jdbcUrl) {
        super.setUrl(jdbcUrl);
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }
}
