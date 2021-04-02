package com.tabspace.restkt.main.utils.exception

import com.tabspace.restkt.main.utils.base.MetaResponse
import com.tabspace.restkt.main.utils.base.ResultResponse
import com.tabspace.restkt.main.utils.properties.AppMessages
import com.tabspace.restkt.main.utils.properties.GlobalConstants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ValidationHandler @Autowired constructor(
        private val appMessages: AppMessages
) {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<ResultResponse<Any>> {
        val error = ex.fieldErrors.map { err ->
            mapOf(
                    err.field to err.defaultMessage?.let { appMessages.call(it, err.field.split(".").last()) }
            )
        }

        val response = ResultResponse<Any>(
                status = GlobalConstants.UNPROCESSABLE_ENTITY,
                data = error,
                meta = MetaResponse(
                        httpCode = HttpStatus.UNPROCESSABLE_ENTITY.value(),
                        isValidRequest = false,
                        message = appMessages.call("resp.validationFailed")
                )
        )

        return ResponseEntity(response, HttpStatus.UNPROCESSABLE_ENTITY)
   }
}