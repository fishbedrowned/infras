package com.infras.services.configs;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.infras.common.error.CommonException;

import javax.validation.constraints.NotNull;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.apache.commons.beanutils.PropertyUtils.getPropertyDescriptor;

/**
 * Created by zhaoheng on 2017/8/27.
 */
public class CustomEnumSerializer extends JsonSerializer<Enum> {

    private String prop;

    /**
     * @param prop 属性名
     */
    public CustomEnumSerializer(@NotNull String prop) {

        this.prop = prop;
    }

    @Override
    public void serialize(Enum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value == null) {
            gen.writeNull();
            return;
        }
        try {
            PropertyDescriptor pd = getPropertyDescriptor(value, prop);
            if (pd == null || pd.getReadMethod() == null) {
                gen.writeString(value.name());
                return;
            }
            Method m = pd.getReadMethod();
            m.setAccessible(true);
            gen.writeObject(m.invoke(value));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new CommonException(e);
        }
    }
}

