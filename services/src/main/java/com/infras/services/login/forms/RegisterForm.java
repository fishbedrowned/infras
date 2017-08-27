package com.infras.services.login.forms;

import com.infras.common.error.ApiErrors;
import com.infras.common.error.ServiceException;
import com.infras.common.tools.PhoneUtil;
import com.infras.model.enums.Gender;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Created by zhaoheng on 2017/8/23.
 */
@Data
public class RegisterForm {
    private String phone;
    private String password;
    private Gender gender;
    private OffsetDateTime birth;
    private Optional<String> thumbnail = Optional.empty();
    private Optional<String> email = Optional.empty();
    private Optional<String> name = Optional.empty();
    private Optional<String> code = Optional.empty();


    public void validate(){
        if(StringUtils.isEmpty(phone) ||
            StringUtils.isEmpty(password)){
            throw new ServiceException(ApiErrors.REQUEST_PARAM_ERROR, "手机号或密码不能为空！");
        }
        if(!PhoneUtil.validPhone(phone)){
            throw new ServiceException(ApiErrors.PHONE_INVALID);
        }
        if(password.length() < 6) {
            throw new ServiceException(ApiErrors.PASSWORD_SHORT);
        }
        if(_weekPassword(password)){
            throw new ServiceException(ApiErrors.PASSWORD_WEEK);
        }
    }

    private Boolean _weekPassword(String password){
        return password.equals("123456") ||
            password.equals("654321") ||
            Pattern.compile("([0-9])\1{5}").matcher(password).find();
    }
}
