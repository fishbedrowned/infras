package com.infras.services.login.services;

import com.infras.model.enums.Gender;
import com.infras.model.enums.Status;
import com.infras.model.mappers.LoginMapper;
import com.infras.model.projos.Login;
import com.infras.services.login.forms.LoginForm;
import com.infras.services.login.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

/**
 * Created by zhaoheng on 2017/8/6.
 */
@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public void test(){
        Login login = Login.builder()
                .name("flying")
                .password("fefiwgrjfsofhewphu")
                .phone("feghh")
                .status(Status.NORMAL)
                .gender(Gender.MALE)
                .build();
        loginMapper.insertSelective(login);
    }

    public LoginVO loginPost(LoginForm form){
        return new LoginVO("找很", 1);
    }

    public Optional<Login> getLoginByLoginId(Integer loginId){
        return Optional.ofNullable(loginMapper.selectByPrimaryKey(loginId));
    }
}
