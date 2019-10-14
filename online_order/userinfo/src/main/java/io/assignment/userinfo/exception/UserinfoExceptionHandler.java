package io.assignment.userinfo.exception;

import io.assignment.userinfo.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * Created by Brijesh.Pant on 13-06-2019.
 */
@ControllerAdvice
@RestController
public class UserinfoExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
                ExceptionResponse exceptionResponse=new ExceptionResponse(ex.getMessage(),request.getDescription(false),new Date());
            return    new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> userhandleAllException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse=new ExceptionResponse(ex.getMessage(),request.getDescription(false),new Date());
        return    new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionResponse exceptionResponse=new ExceptionResponse(ex.getMessage(),ex.getBindingResult().toString(),new Date());
        return    new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
