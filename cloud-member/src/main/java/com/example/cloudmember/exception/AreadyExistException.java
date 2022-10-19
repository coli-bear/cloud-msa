package com.example.cloudmember.exception;

import com.example.cloudmember.domains.enums.CommonCode;

public class AreadyExistException extends RuntimeException{
    private CommonCode code;
    public AreadyExistException() {
        super();
    }

    public AreadyExistException(CommonCode code, String message) {
        super(message);
        this.code = code;
    }

    public AreadyExistException(CommonCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public AreadyExistException(CommonCode code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    protected AreadyExistException(CommonCode code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
