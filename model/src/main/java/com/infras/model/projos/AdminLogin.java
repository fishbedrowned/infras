package com.infras.model.projos;

import com.infras.model.enums.Gender;
import com.infras.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.Date;

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

    private Status status;

    private OffsetDateTime updated;

    private OffsetDateTime created;
}