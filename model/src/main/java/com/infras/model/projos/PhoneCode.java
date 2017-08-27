package com.infras.model.projos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
@Builder
public class PhoneCode {
    private Integer id;

    private String phone;

    private String code;

    private Boolean isRetry;

    private Integer triedTimes;

    private OffsetDateTime created;
}