package com.infras.admin.services.login.forms;

import com.infras.common.error.ApiErrors;
import com.infras.common.error.ServiceException;
import com.infras.common.tools.PhoneUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.NotNull;

/**
 * Created by zhaoheng on 2017/9/12.
 */
@Controller
@NoArgsConstructor
@Getter
public class LoginForm {

    @NotNull
    private String name;

    @NotNull
    private String password;

    public void validate(){
        if(StringUtils.isEmpty(name) || !PhoneUtil.validPhone(password)){
            throw new ServiceException(ApiErrors.ACCOUNT_ERROR);
        }
    }
}
