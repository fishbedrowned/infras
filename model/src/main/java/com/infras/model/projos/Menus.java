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

    private String link;

    private Integer parent;

    private Boolean deleted;

    private OffsetDateTime updated;

    private OffsetDateTime created;
}