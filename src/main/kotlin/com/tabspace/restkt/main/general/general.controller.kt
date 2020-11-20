package com.tabspace.restkt.main.general

import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.validation.Valid

@RestController
class MainCotroller {
    @GetMapping("/")
    fun welcome() = SystemHealth("REST kotlin", "0.1.0", LocalDateTime.now())

    @PostMapping("/contact")
    fun contactUs(@RequestBody @Valid body: ContactUsRequest): ContactUsRequest {
        return body;
    }
}

class ValidationError(val violations: List<Violation>)
class Violation(val field: String, val message: String)

@ExceptionHandler(value = [MissingKotlinParameterException::class])
@ResponseStatus(HttpStatus.BAD_REQUEST)
fun handleMissingKotlinParameter(exception: MissingKotlinParameterException): ValidationError {
    val fieldName = exception.path.joinToString(separator = ".") { it.fieldName }
    val violation = Violation(fieldName, "must not be null")
    return ValidationError(listOf(violation))
}