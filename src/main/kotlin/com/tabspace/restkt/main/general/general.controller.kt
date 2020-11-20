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