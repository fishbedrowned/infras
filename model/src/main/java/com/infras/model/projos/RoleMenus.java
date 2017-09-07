package com.infras.model.projos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
@Builder
public class RoleMenus {
    private Integer id;

    private Integer roleId;

    private Integer menuId;

    private Boolean deleted;

    private OffsetDateTime updated;

    private OffsetDateTime created;
}