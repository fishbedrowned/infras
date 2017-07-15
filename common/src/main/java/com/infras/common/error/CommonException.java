package com.infras.common.error;

/**
 * 业务、异常基础类
 * Created by zhaoheng on 2017/7/13.
 */
public class CommonException extends RuntimeException {

    public CommonException(String message) {super(message);}

    public CommonException(String message, Throwable cause) {super(message, cause);}

    public CommonException(Throwable cause) {
        super(cause);
    }
}
