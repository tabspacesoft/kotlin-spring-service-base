package com.tabspace.restkt.main.config.exception

import com.tabspace.restkt.main.config.base.MetaResponse
import com.tabspace.restkt.main.config.base.ResultResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ValidationHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<ResultResponse<Any>> {
        val error = ex.fieldErrors.map { err ->
            mapOf(
                    err.field to err.defaultMessage
            )
        }

        val response = ResultResponse<Any>(
                status = "UNPROCESSABLE ENTITY",
                data = error,
                meta = MetaResponse(
                        httpCode = HttpStatus.UNPROCESSABLE_ENTITY.value(),
                        isValidRequest = false,
                        message = "Payload not valid"
                )
        )

        return ResponseEntity(response, HttpStatus.UNPROCESSABLE_ENTITY)
   }
}