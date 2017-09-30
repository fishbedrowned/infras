package com.infras.admin.services.login.converts;

import com.infras.admin.services.login.vos.MenuVO;
import com.infras.model.projos.Menus;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhaoheng on 2017/9/20.
 */
@Component
public class MenusConvert {

    public MenuVO convertToVo(Menus m, List<MenuVO> children){
        MenuVO mv = new MenuVO();
        BeanUtils.copyProperties(m, mv);
        mv.setChildren(children);
        return mv;
    }
}
