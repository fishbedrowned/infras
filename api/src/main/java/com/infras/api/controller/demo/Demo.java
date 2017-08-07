package com.infras.api.controller.demo;

import com.infras.api.ApiPath;
import com.infras.api.transfer.DemoTransfer;
import com.infras.common.result.JsonResult;
import com.infras.model.demo.Greeting;
import com.infras.services.forms.GreetingForm;
import com.infras.services.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.infras.common.result.JsonResult.ok;


/**
 * Created by zhaoheng on 2017/7/5.
 */
@RestController
public class Demo implements ApiPath{

    @Autowired
    DemoService demoService;

    @Autowired
    DemoTransfer transfer;

    @CrossOrigin
    @RequestMapping(value = DEMO_GET_TEST, method = RequestMethod.GET)
    public JsonResult<Greeting> getGreet(@PathVariable Integer id){
        Greeting g = demoService.findGreeting(id);
        return ok(g);
    }

    @RequestMapping(value = DEMO_TEST, method = RequestMethod.POST)
    public JsonResult saveGreet(@RequestBody @Valid GreetingForm form){
        int g = demoService.insertGreeting(transfer.toGreet(form));
        return ok(g);
    }
}
