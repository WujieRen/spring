package com.example.exception;

/**
 * Created by renwujie on 2018/05/09 at 19:02
 */
public class UserException extends RuntimeException {
    //自己重写可以自定义处理方式

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    protected UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
