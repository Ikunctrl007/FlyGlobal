package com.nnxx.exception;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException{
    private Integer code;

    public BusinessException() {
        super();
    }

    public BusinessException(Integer code,String message) {
        super(message);
        this.code=code;
    }

    public BusinessException(Integer code,String message, Throwable cause) {
        super(message, cause);
        this.code =code;
    }

}
