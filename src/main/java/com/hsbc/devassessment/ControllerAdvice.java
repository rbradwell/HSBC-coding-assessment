package com.hsbc.devassessment;

import com.hsbc.devassessment.exception.TechnicalException;
import com.hsbc.devassessment.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(TechnicalException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String oopsHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }

}
