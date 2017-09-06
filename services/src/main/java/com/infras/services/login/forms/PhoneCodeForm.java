package com.infras.services.login.forms;

import com.infras.common.error.ApiErrors;
import com.infras.common.error.ServiceException;
import com.infras.common.tools.PhoneUtil;
import com.infras.model.enums.PhoneCodeType;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhaoheng on 2017/8/25.
 */
@Data
public class PhoneCodeForm {

    @ApiParam("验证码类型")
    private PhoneCodeType codeType;

    @ApiParam("电话")
    private String phone;

    public void validate(){
        if(StringUtils.isEmpty(phone) || !PhoneUtil.validPhone(phone)){
            throw new ServiceException(ApiErrors.PHONE_INVALID);
        }
    }
}
