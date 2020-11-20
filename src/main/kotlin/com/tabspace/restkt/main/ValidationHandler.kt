package com.tabspace.restkt.main

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler



@ControllerAdvice
class ValidationHandler {
    data class ErrorItem(val message: String?);
    data class ErrorBag(var errors: List<ErrorItem>, val valid: Boolean)

    @ExceptionHandler(value = [(MethodArgumentNotValidException::class)])
    fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<ErrorBag> {
        var errors= ex.allErrors.map { err -> ErrorItem(message = err.defaultMessage)}
        var bags = ErrorBag(errors = errors, valid = false);

        return ResponseEntity(bags, HttpStatus.BAD_REQUEST);
   }
}