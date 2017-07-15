package com.infras.common.error;

/**
 * Created by zhaoheng on 2017/7/13.
 */
public class ServiceException extends CommonException {
    private int code;

    public ServiceException(ApiErrors error) {
        super(error.getMessage());
        this.code = error.getCode();
    }

    public ServiceException(ApiErrors error, Throwable cause) {
        super(cause);
        this.code = error.getCode();
    }

    public ServiceException(ApiErrors error, String message) {
        super(message);
        this.code = error.getCode();
    }

    public ServiceException(ApiErrors error, String message, Throwable cause) {
        super(message, cause);
        this.code = error.getCode();
    }

    public int getCode() {
        return this.code;
    }
}
