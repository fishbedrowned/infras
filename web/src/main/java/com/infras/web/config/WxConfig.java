package com.infras.web.config;

import com.infras.web.weixin.model.OAccountsInfo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhaoheng on 2017/10/24.
 */
@Component
@ConfigurationProperties("weixin")
public class WxConfig {

    private List<OAccountsInfo> OAccountsInfos;

    public static final String URL_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";

}
