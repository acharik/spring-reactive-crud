package com.example.springreactivecrud.exсeptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.r2dbc.spi.R2dbcDataIntegrityViolationException;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.NoSuchElementException;

@ControllerAdvice()
public class ExceptionAdvice {
   @ExceptionHandler
    public ResponseEntity<String> handleR2dbcEx (R2dbcDataIntegrityViolationException ex){
       if(ex.getMessage().contains("Нарушение уникального")){

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Контракт с таким номером уже существует");
    }
       if(ex.getMessage().contains("DATE_BEGIN_CHECK"))  {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Дата начала должна быть в пределах от 1950 до 2100 года");
       }
       if(ex.getMessage().contains("DATE_END_CHECK"))  {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Дата конца должна быть в пределах от 1950 до 2100 года");
       }
       if(ex.getMessage().contains("DATE_CHECK"))  {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Дата конца должна быть позже даты начала");
       }
       else  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity<String> handleNotFoundContractEx(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity<String> handleDecodingEx(DecodingException ex){
       if (ex.getMessage().contains(" numContract is marked non-null but is null")){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Обязательные поля должны быть заполнены");
       }else
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Проверьте правильность введенных данных");
    }
    @ExceptionHandler ResponseEntity<String> handleWebExchangeBindEx(WebExchangeBindException ex){
       if (ex.getMessage().contains("Неверный формат")){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("неверный формат");
       }
       else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
