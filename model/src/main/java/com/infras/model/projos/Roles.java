package com.infras.model.projos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
@Builder
public class Roles {
    private Integer id;

    private String name;

    private Boolean deleted;

    private OffsetDateTime updated;

    private OffsetDateTime created;
}