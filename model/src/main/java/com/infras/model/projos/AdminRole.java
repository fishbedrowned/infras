package com.infras.model.projos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
@Builder
public class AdminRole {
    private Integer id;

    private Integer loginId;

    private Integer roleId;

    private Boolean deleted;

    private OffsetDateTime updated;

    private OffsetDateTime created;
}