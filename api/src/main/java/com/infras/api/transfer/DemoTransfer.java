package com.infras.api.transfer;

import com.infras.model.demo.Greeting;
import com.infras.services.forms.GreetingForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Created by zhaoheng on 2017/7/15.
 */
@Validated
@Component
public class DemoTransfer {

    public Greeting toGreet(GreetingForm form){
        return Greeting.builder().name(form.getName()).age(form.getAge().orElse(null)).build();
    }
}
