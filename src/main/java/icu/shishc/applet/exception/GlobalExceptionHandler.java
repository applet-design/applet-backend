package icu.shishc.applet.exception;

import icu.shishc.applet.util.ResultJson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity ExceptionHandler(HttpServletRequest httpServletRequest, Exception exception) {
        //log.error("GlobalExceptionHandler::ExceptionHandler=> e=\"{}\". Stack is :\n", exception.getMessage(),exception);
        return new ResponseEntity<>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<ResultJson> CustomExceptionHandler(HttpServletRequest httpServletRequest, CustomException customException) {
        ResultJson result = ResultJson.fail(customException.getHttpStatus().value(), customException.getMessage());
        //log.warn("GlobalExceptionHandler::CustomExceptionHandler=> e=\"{}\".Stack is:\n",customException.getMessage(),customException);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
