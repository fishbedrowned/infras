package com.infras.model.projos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
@Builder
public class Menus {
    private Integer id;

    private String name;

    private String path;

    private String component;

    private String icon;

    private Integer parent;

    private Boolean deleted;

    private OffsetDateTime updated;

    private OffsetDateTime created;
}