package com.infras.common.result;

import com.infras.common.error.ApiCallException;
import com.infras.common.error.ApiErrors;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Created by zhaoheng on 2017/7/13.
 */
public class JsonResult<T> {
    private boolean success;
    private Optional<T> data = Optional.empty();
    private Optional<Integer> errCode = Optional.empty();
    private Optional<String> errMessage = Optional.empty();

    public static <T> T checkAndExtract(@NotNull JsonResult<T> result) {
        if(result.isSuccess() && result.getData().isPresent()) {
            return result.getData().get();
        } else {
            throw new ApiCallException(result);
        }
    }

    public static <T> Optional<T> checkAndExtractOptional(@NotNull JsonResult<T> result) {
        if(result.isSuccess()) {
            return result.getData();
        } else {
            throw new ApiCallException(result);
        }
    }

    public static <T> JsonResult<T> ok() {
        JsonResult<T> result = new JsonResult();
        result.setSuccess(true);
        return result;
    }

    public static <T> JsonResult<T> ok(@NotNull T data) {
        JsonResult<T> result = new JsonResult();
        result.setSuccess(true);
        result.setData(Optional.of(data));
        return result;
    }

    public static <T> JsonResult<T> error() {
        return error(ApiErrors.SERVER_ERROR);
    }

    public static <T> JsonResult<T> error(String errorMessage) {
        return error(Integer.valueOf(ApiErrors.SERVER_ERROR.getCode()), errorMessage);
    }

    public static <T> JsonResult<T> error(ApiErrors error) {
        return error(Integer.valueOf(error.getCode()), error.getMessage());
    }

    public static <T> JsonResult<T> error(Integer errorCode, String errorMessage) {
        JsonResult<T> result = new JsonResult();
        result.setErrCode(Optional.of(errorCode));
        result.setErrMessage(Optional.ofNullable(errorMessage));
        return result;
    }

    public JsonResult() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Optional<T> getData() {
        return this.data;
    }

    public Optional<Integer> getErrCode() {
        return this.errCode;
    }

    public Optional<String> getErrMessage() {
        return this.errMessage;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(Optional<T> data) {
        this.data = data;
    }

    public void setErrCode(Optional<Integer> errCode) {
        this.errCode = errCode;
    }

    public void setErrMessage(Optional<String> errMessage) {
        this.errMessage = errMessage;
    }

    public boolean equals(Object o) {
        if(o == this) {
            return true;
        } else if(!(o instanceof JsonResult)) {
            return false;
        } else {
            JsonResult<?> other = (JsonResult)o;
            if(!other.canEqual(this)) {
                return false;
            } else if(this.isSuccess() != other.isSuccess()) {
                return false;
            } else {
                label49: {
                    Object this$data = this.getData();
                    Object other$data = other.getData();
                    if(this$data == null) {
                        if(other$data == null) {
                            break label49;
                        }
                    } else if(this$data.equals(other$data)) {
                        break label49;
                    }

                    return false;
                }

                Object this$errCode = this.getErrCode();
                Object other$errCode = other.getErrCode();
                if(this$errCode == null) {
                    if(other$errCode != null) {
                        return false;
                    }
                } else if(!this$errCode.equals(other$errCode)) {
                    return false;
                }

                Object this$errMessage = this.getErrMessage();
                Object other$errMessage = other.getErrMessage();
                if(this$errMessage == null) {
                    if(other$errMessage != null) {
                        return false;
                    }
                } else if(!this$errMessage.equals(other$errMessage)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof JsonResult;
    }

    public int hashCode() {
//        int PRIME = true;
        int result = 1;
        result = result * 59 + (this.isSuccess()?79:97);
        Object $data = this.getData();
        result = result * 59 + ($data == null?43:$data.hashCode());
        Object $errCode = this.getErrCode();
        result = result * 59 + ($errCode == null?43:$errCode.hashCode());
        Object $errMessage = this.getErrMessage();
        result = result * 59 + ($errMessage == null?43:$errMessage.hashCode());
        return result;
    }

    public String toString() {
        return "JsonResult(success=" + this.isSuccess() + ", data=" + this.getData() + ", errCode=" + this.getErrCode() + ", errMessage=" + this.getErrMessage() + ")";
    }

}
