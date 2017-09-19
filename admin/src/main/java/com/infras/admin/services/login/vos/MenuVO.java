package com.infras.admin.services.login.vos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoheng on 2017/9/16.
 */
@AllArgsConstructor
@Getter
@Builder
public class MenuVO {
    private String name = "";
    private String path = "";
    private String icon = "";
    private String component = "";
    private List<MenuVO> children = new ArrayList<>();
}
