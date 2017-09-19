package com.infras.model.projos;

import com.infras.model.enums.AdminStatus;
import com.infras.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
@Builder
public class AdminLogin {
    private Integer id;

    private String password;

    private String phone;

    private String email;

    private String name;

    private String thumbnail;

    private Gender gender;

    private OffsetDateTime birth;

    private AdminStatus status;

    private OffsetDateTime updated;

    private OffsetDateTime created;
}