package com.infras.web.controller.map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.infras.web.controller.Path.GD_INDEX;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by zhaoheng on 2017/11/6.
 */
@Controller
public class GaoDeController {

    @RequestMapping(path = GD_INDEX, method = GET)
    public String index(){
        return "index";
    }
}
