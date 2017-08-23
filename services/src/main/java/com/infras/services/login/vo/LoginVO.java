package com.infras.services.login.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhaoheng on 2017/8/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginVO {

    private String name;
    private Integer loginId;
}
