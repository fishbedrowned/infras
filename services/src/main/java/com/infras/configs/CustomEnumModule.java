package com.infras.configs;

import com.fasterxml.jackson.databind.module.SimpleModule;

import javax.validation.constraints.NotNull;

/**
 * Created by zhaoheng on 2017/8/27.
 */
public class CustomEnumModule extends SimpleModule {

    /**
     * @param prop 属性名
     */
    public CustomEnumModule(@NotNull String prop){

        addDeserializer(Enum.class, new CustomEnumDeserializer(prop));
        addSerializer(Enum.class, new CustomEnumSerializer(prop));
    }
}
