package com.freelance.exceptions;

import com.freelance.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author - Akash
 * @date - 19-05-2022
 * @project - E-Freelance-Website
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     *
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return handles requested method not found exception
     */
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Method not allowed");
        String error = ex.getMethod();
        List<String> messages = Arrays.asList(error,"Method not supported");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    /**
     *
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return handles Media type not supported exception
     */
    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Media type not allowed");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Media type not supported");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    /**
     *
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return handles Missing Path Variable exception
     */
    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Missing path variable is not allowed");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Path not supported");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(errors);    }

    /**
     *
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return handles missing servlet request parameter exception
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Missing servlet request");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"invalid request parameter");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(errors);    }

    /**
     *
     * @param ex the exception
     * @param headers the headers to be written to the response
     * @param status the selected response status
     * @param request the current request
     * @return handles type mismatch exception
     */
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Invalid Data type ");
        String error = ex.getMessage();
        List<String> messages = Arrays.asList(error,"Invalid Data type entered for Camera");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    /**
     *
     * @param exception
     * @return handles freelance not found exception
     */
    @ExceptionHandler(FreelanceNotFoundException.class)
    public ResponseEntity<Object> handleFreelanceNotFound(Exception exception){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","No Freelancer Found");
        String error = exception.getMessage();
        List<String> messages = Arrays.asList(error,"No Freelancer Found");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(errors);
    }
    /**
     *
     * @param exception
     * @return handles Client not found exception
     */
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Object> handleClientNotFound(Exception exception){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","No Client Found");
        String error = exception.getMessage();
        List<String> messages = Arrays.asList(error,"No Client Found");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(errors);
    }
    /**
     *
     * @param exception
     * @return handles Project not found exception
     */
    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<Object> handleProjectNotFound(Exception exception){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","No Project Found");
        String error = exception.getMessage();
        List<String> messages = Arrays.asList(error,"No Project Found");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(errors);
    }
    /**
     *
     * @param exception
     * @return handles No Bidding found exception
     */
    @ExceptionHandler(NoBiddingException.class)
    public ResponseEntity<Object> handleNoBiddingFound(Exception exception){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","No Bidding Found");
        String error = exception.getMessage();
        List<String> messages = Arrays.asList(error,"No Bidding Found");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(errors);
    }
    /**
     *
     * @param exception
     * @return handles Other exceptions
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherException(Exception exception){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","Other Exception");
        String error = exception.getMessage();
        List<String> messages = Arrays.asList(error,"Other Exception");
        ApiErrors errors = new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(errors);
    }
}
