package com.infras.services.login.services;

import com.infras.common.error.ApiErrors;
import com.infras.common.error.ServiceException;
import com.infras.common.tools.AuthUtil;
import com.infras.common.tools.RandomUtil;
import com.infras.model.enums.PhoneCodeType;
import com.infras.model.enums.Status;
import com.infras.model.mappers.LoginMapper;
import com.infras.model.mappers.PhoneCodeMapper;
import com.infras.model.projos.Login;
import com.infras.model.projos.PhoneCode;
import com.infras.services.login.checker.LoginChecker;
import com.infras.services.login.forms.LoginForm;
import com.infras.services.login.forms.PhoneCodeForm;
import com.infras.services.login.forms.RegisterForm;
import com.infras.services.login.transfers.LoginTransfer;
import com.infras.services.login.vo.LoginVO;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by zhaoheng on 2017/8/6.
 */
@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private LoginChecker loginChecker;

    @Autowired
    private LoginTransfer loginTransfer;

    @Autowired
    private PhoneCodeMapper phoneCodeMapper;

    /**
     * 登录
     */
    public LoginVO loginPost(LoginForm form){
        Login login = _getLoginByPhone(form.getPhone());
        if(!BCrypt.checkpw(form.getPassword(), login.getPassword())) throw new ServiceException(ApiErrors.ACCOUNT_ERROR);
        String token = AuthUtil.generateToken(login.getId().toString() + login.getPhone()).orElseThrow(() -> new ServiceException(ApiErrors.ACCOUNT_ERROR));
        return loginTransfer.toLoginVO(login, token, Optional.empty());
    }

    /**
     * 注册
     */
    public LoginVO registerPost(RegisterForm form){
        loginChecker.checkRegisterInfo(form);
        String encPwd = BCrypt.hashpw(form.getPassword(), BCrypt.gensalt());
        Login login = loginTransfer.toLoginFromRegister(form, encPwd);
        Integer loginId = loginMapper.insertSelective(login);
        String token = AuthUtil.generateToken(login.getId().toString() + login.getPhone()).orElseThrow(() -> new ServiceException(ApiErrors.ACCOUNT_ERROR));
        return loginTransfer.toLoginVO(login, token, Optional.of(loginId));
    }

    /**
     * 发送短信验证码
     */
    public void phoneCode(PhoneCodeForm form){
        PhoneCode code = PhoneCode.builder()
            .phone(form.getPhone())
            .code(RandomUtil.generateNumber(6))
            .build();
        phoneCodeMapper.insertSelective(code);
    }

    public Optional<Login> getLoginByLoginId(Integer loginId){
        return Optional.ofNullable(loginMapper.selectByPrimaryKey(loginId));
    }

    private Login _getLoginByPhone(String phone){
        Login login = loginMapper.selectByPhone(phone);
        if(login == null) throw new ServiceException(ApiErrors.ACCOUNT_NOT_REGISTER);
        if(login.getStatus().getCode() < Status.FORBIDDEN.getCode()) return login;
        throw new ServiceException(ApiErrors.ACCOUNT_FORBIDDEN);
    }
}
