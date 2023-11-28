package pl.wla.webproject.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.wla.webproject.rest.dto.DataErrorResponse;
import pl.wla.webproject.rest.dto.InvalidDataException;

@ControllerAdvice
public class webExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<DataErrorResponse> handleException(InvalidDataException exc){

        DataErrorResponse error = new DataErrorResponse(HttpStatus.NOT_FOUND.value(),exc.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<DataErrorResponse> handleException(Exception exc){

        DataErrorResponse error = new DataErrorResponse(HttpStatus.BAD_REQUEST.value(),exc.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


}
