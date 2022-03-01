package com.example.springreactivecrud.exсeptions;

import io.r2dbc.spi.R2dbcDataIntegrityViolationException;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice()
public class ExceptionAdvice {
   @ExceptionHandler
    public ResponseEntity<String> handleR2dbcEx (R2dbcDataIntegrityViolationException ex){
       if(ex.getMessage().substring(0,21).equals("Нарушение уникального")){

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Контракт с таким номером уже существует");
    }
       else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
       }
    }
    @ExceptionHandler
    public ResponseEntity<String> handleNotFoundContractEx(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity<String> handleNonNullEx(DecodingException ex){
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Обязательные поля должны быть заполнены");
    }

}
