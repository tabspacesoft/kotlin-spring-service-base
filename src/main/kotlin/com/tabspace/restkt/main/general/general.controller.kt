package com.tabspace.restkt.main.general

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainCotroller {
    @GetMapping("/")
    fun welcome() = SystemHealth("REST kotlin", "0.1.0")
}