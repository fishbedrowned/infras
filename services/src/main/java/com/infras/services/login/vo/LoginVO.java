package com.infras.services.login.vo;

import com.infras.model.enums.Gender;
import com.infras.model.enums.Status;
import com.infras.model.projos.Login;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Date;

/**
 * Created by zhaoheng on 2017/8/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginVO {

    private Integer loginId;

    private String phone;

    private String email;

    private String name;

    private String thumbnail;

    private Gender gender;

    private OffsetDateTime birth;

    private Status status;

    private String token;
}
