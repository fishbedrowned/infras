package com.infras.admin.services.login.vos;

import lombok.Builder;
import lombok.Data;

/**
 * Created by zhaoheng on 2017/9/19.
 */
@Data
@Builder
public class LoginVO {
    private Integer loginId;
    private String token;
}
