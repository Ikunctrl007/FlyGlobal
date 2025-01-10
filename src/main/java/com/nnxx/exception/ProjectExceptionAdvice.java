package com.nnxx.exception;

import com.nnxx.domain.Code;
import com.nnxx.domain.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        return new Result(ex.getCode(),ex.getMessage(),null);
    }
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException bs){
        return new Result(bs.getCode(),bs.getMessage(),null);
    }
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex) throws Exception {
        // 检查是否是Spring Security的异常，避免覆盖
        if (ex instanceof AccessDeniedException || ex instanceof AuthenticationException) {
            throw ex;
        }
        return new Result(Code.SELECT_ERROR,ex.getMessage());
    }
}
