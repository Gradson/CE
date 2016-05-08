package br.org.gradson.ce.controller.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice()
public class RestExceptionHandler {
    private Log logger = LogFactory.getLog(RestExceptionHandler.class);


    @ExceptionHandler({Exception.class, RuntimeException.class})
    @ResponseBody
    public ResponseEntity<?> handleInternalError(Exception ex, HttpServletRequest request) {
        ex.printStackTrace();
        return createErrorDetail(ex, ex.getMessage(), INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ResponseEntity<?> handleArgumentInternalError(MethodArgumentNotValidException ex, HttpServletRequest request) {
        ex.printStackTrace();
        return createErrorDetail(ex, ex.getBindingResult().getFieldError().getDefaultMessage(), INTERNAL_SERVER_ERROR);
    }
    
    private ResponseEntity<?> createErrorDetail(Exception ex, String message, HttpStatus httpStatus) {
    	logger.error(ex);
    	
    	ErrorDetail errorDetail = new ErrorDetail();
    	errorDetail.setTimeStamp(Calendar.getInstance().getTimeInMillis());
    	errorDetail.setStatus(httpStatus.value());
    	errorDetail.setTitle(httpStatus.getReasonPhrase());
    	errorDetail.setDetail(message);
    	errorDetail.setDeveloperMessage(ex.getClass().getName());
    	
    	return new ResponseEntity<>(errorDetail, null, httpStatus);
    }
}
