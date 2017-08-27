package com.infras.services.login.checker;

import com.infras.common.error.ApiErrors;
import com.infras.common.error.ServiceException;
import com.infras.common.tools.PhoneUtil;
import com.infras.model.mappers.PhoneCodeMapper;
import com.infras.model.projos.PhoneCode;
import com.infras.services.login.forms.LoginForm;
import com.infras.services.login.forms.RegisterForm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.regex.Pattern;

/**
 * Created by zhaoheng on 2017/8/23.
 */
@Validated
@Component
public class LoginChecker {

    @Autowired
    private PhoneCodeMapper phoneCodeMapper;

    public void checkRegisterInfo(RegisterForm form){
        Boolean validCode = form.getCode().isPresent() && _validCode(form.getPhone(), form.getCode().get());
        if(!validCode){ throw new ServiceException(ApiErrors.PHONE_CODE_INVALID); }
    }


    private Boolean _validCode(String phone, String code){
        PhoneCode phoneCode = phoneCodeMapper.selectByPhone(phone);
        return phoneCode != null && phoneCode.getCode().equals(code);
    }
}
