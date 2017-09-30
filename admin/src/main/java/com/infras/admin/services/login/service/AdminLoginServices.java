package com.infras.admin.services.login.service;

import com.infras.admin.services.login.converts.MenusConvert;
import com.infras.admin.services.login.forms.LoginForm;
import com.infras.admin.services.login.vos.LoginVO;
import com.infras.admin.services.login.vos.MenuVO;
import com.infras.common.error.ApiErrors;
import com.infras.common.error.ServiceException;
import com.infras.common.tools.AuthUtil;
import com.infras.model.enums.AdminStatus;
import com.infras.model.mappers.AdminLoginMapper;
import com.infras.model.mappers.MenusMapper;
import com.infras.model.projos.AdminLogin;
import com.infras.model.projos.Menus;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by zhaoheng on 2017/9/19.
 */
@Slf4j
@Service
public class AdminLoginServices {

    @Autowired
    private AdminLoginMapper adminLoginMapper;

    @Autowired
    private MenusMapper menusMapper;

    @Autowired
    private MenusConvert menusConvert;

    /**
     * 获取用户信息
     */
    public Optional<AdminLogin> getLoginByLoginId(Integer loginId) {
        return Optional.ofNullable(adminLoginMapper.selectByLoginId(loginId, AdminStatus.NORMAL));
    }

    /**
     * 登录
     */
    public LoginVO loginPost(LoginForm form) {
        AdminLogin login = _getLoginByPhone(form.getName());
        if(!BCrypt.checkpw(form.getPassword(), login.getPassword())) throw new ServiceException(ApiErrors.ACCOUNT_ERROR);
        String token = AuthUtil.generateAdminToken(login.getId().toString() + login.getPhone()).orElseThrow(() -> new ServiceException(ApiErrors.ACCOUNT_ERROR));
//        return loginTransfer.toLoginVO(login, token, Optional.empty());
        log.info(token);
        return LoginVO.builder().token(token).loginId(login.getId()).build();
    }


    private AdminLogin _getLoginByPhone(String phone){
        AdminLogin login = adminLoginMapper.selectByPhone(phone);
        if(login == null) throw new ServiceException(ApiErrors.ACCOUNT_NOT_REGISTER);
        if(login.getStatus().getCode() < AdminStatus.FORBIDDEN.getCode()) return login;
        throw new ServiceException(ApiErrors.ACCOUNT_FORBIDDEN);
    }

    /**
     * 获取菜单
     */
    public List<MenuVO> getMenus(Integer loginId) {
        List<Menus> menus = menusMapper.getMenus(loginId);
        List<Menus> parentMenus = menus.stream().filter(m -> m.getParent() == 0).collect(Collectors.toList());
        return parentMenus.stream().map(me -> {
            List<MenuVO> children = menus.stream().filter(m -> m.getParent().intValue() == me.getId().intValue())
                .map(menu -> menusConvert.convertToVo(menu, new ArrayList<>())).collect(Collectors.toList());
            return menusConvert.convertToVo(me, children);
        }).collect(Collectors.toList());
    }
}
