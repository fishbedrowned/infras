package com.infras.services.login.transfers;

import com.infras.model.enums.Status;
import com.infras.model.projos.Login;
import com.infras.services.login.forms.RegisterForm;
import com.infras.services.login.vo.LoginVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by zhaoheng on 2017/8/23.
 */
@Component
public class LoginTransfer {

    public LoginVO toLoginVO(Login login, String token, Optional<Integer> loginId ) {
        LoginVO loginVO = new LoginVO();
        BeanUtils.copyProperties(login, loginVO);
        loginVO.setToken(token);
        loginId.ifPresent(id -> loginVO.setLoginId(id) );
        return loginVO;
    }

    public Login toLoginFromRegister(RegisterForm form, String enPassword) {
        return Login.builder()
            .gender(form.getGender())
            .phone(form.getPhone())
            .password(enPassword)
            .status(Status.NORMAL)
            .name(form.getName().orElse(""))
            .thumbnail(form.getName().orElse(""))
            .birth(form.getBirth())
            .email(form.getEmail().orElse(""))
            .build();
    }
}
