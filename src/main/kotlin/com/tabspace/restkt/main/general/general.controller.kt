package com.tabspace.restkt.main.general

import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.validation.Valid


@RestController
class MainCotroller {
    val services: GeneralServices = GeneralServices();

    @GetMapping("/")
    fun welcome() = SystemHealth("REST kotlin", "0.1.0", LocalDateTime.now())

    @PostMapping("/contact")
    fun contactUs(@RequestBody @Valid body: ContactUsRequest) = services.recordContact(body);
}