package com.web.spring.api.product.exception;

import com.web.spring.api.exception.UserException;
import com.web.spring.api.exceptionhandler.ErrorResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ProductExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductException.class)
    public ErrorResult ProductHandle(ProductException e) {
        log.error("[ProductHandle]: ", e.getMessage());
        return new ErrorResult("ProductException", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotEnoughStockException.class)
    public ErrorResult NotEnoughStockHandle(NotEnoughStockException e) {
        log.error("[NotEnoughStockHandle]: ", e.getMessage());
        return new ErrorResult("NotEnoughStock", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidProductException.class)
    public ErrorResult InvalidProductHandle(InvalidProductException e) {
        log.error("[InvalidProductHandle]: ", e.getMessage());
        return new ErrorResult("InvalidProduct", e.getMessage());
    }
}
