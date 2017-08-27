package com.infras.services.login.forms;

import com.infras.common.error.ApiErrors;
import com.infras.common.error.ServiceException;
import com.infras.common.tools.PhoneUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhaoheng on 2017/8/23.
 */
@Data
public class LoginForm {

    private String password;

    private String phone;

    public void validate(){
        if(StringUtils.isEmpty(phone) || !PhoneUtil.validPhone(phone)){
            throw new ServiceException(ApiErrors.ACCOUNT_ERROR);
        }
        if(StringUtils.isEmpty(password)){
            throw new ServiceException(ApiErrors.ACCOUNT_ERROR);
        }
    }
}
