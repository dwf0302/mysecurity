package com.bree.web.controller;

import com.bree.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice//该注解表示处理其他的控制器抛出的异常
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)//该注解表示处理抛出这个异常的controller
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> handlerUserNotExistException(UserNotExistException ex){
        Map<String,Object> result = new HashMap<>();
        result.put("id", ex.getId());
        result.put("msg", ex.getMessage());
        return result;
    }
}
