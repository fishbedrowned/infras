package com.infras.common.error;

import com.infras.common.result.JsonResult;

import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by zhaoheng on 2017/7/13.
 */
public class ApiCallException extends CommonException {

    private JsonResult result;

    public ApiCallException(@NotNull JsonResult result) {
        super(StringUtils.join(new Object[]{result.getErrCode().orElse(Integer.valueOf(0)), result.getErrMessage().orElse("服务异常")}));
        this.result = result;
    }

    public JsonResult getResult() {
        return this.result;
    }
}
