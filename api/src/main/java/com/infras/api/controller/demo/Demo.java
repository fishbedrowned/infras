package com.infras.api.controller.demo;

import com.infras.api.controller.ApiPath;
import com.infras.api.transfer.DemoTransfer;
import com.infras.common.result.JsonResult;
import com.infras.model.demo.Greeting;
import com.infras.services.demo.GreetingForm;
import com.infras.services.demo.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.infras.common.result.JsonResult.ok;


/**
 * Created by zhaoheng on 2017/7/5.
 */
@RestController
@Api(tags = "test", description = "测试Api")
public class Demo implements ApiPath{

    @Autowired
    DemoService demoService;

    @Autowired
    DemoTransfer transfer;

    // @CrossOrigin 跨域访问
    @CrossOrigin
    @ApiOperation("获取会议Id")
    @RequestMapping(value = DEMO_GET_TEST, method = RequestMethod.GET)
    public JsonResult<Greeting> getGreet(@PathVariable Integer id){
        Greeting g = demoService.findGreeting(id);
        return ok(g);
    }

    @ApiOperation("保存会议记录")
    @RequestMapping(value = DEMO_TEST, method = RequestMethod.POST)
    public JsonResult saveGreet(@RequestBody @Valid GreetingForm form){
        int g = demoService.insertGreeting(transfer.toGreet(form));
        return ok(g);
    }
}
