package com.tabspace.restkt.main.general

import com.tabspace.restkt.main.config.base.BaseController
import com.tabspace.restkt.main.config.base.ResultResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/"])
class GeneralController @Autowired constructor(
        private val generalService: GeneralService
): BaseController() {
    @GetMapping()
    fun welcome(): ResponseEntity<ResultResponse<Any>> {
        return generateResponse(
                generalService.systemHealth(
                        name = "Kotlin",
                        version = "1",
                        time = LocalDateTime.now()
                )
        ).done()
    }

    @PostMapping(value = ["contact-us"])
    fun contactUs(
            @RequestBody @Valid request: ContactUsRequest
    ): ResponseEntity<ResultResponse<Any>> {
        return generateResponse(
                generalService.recordContact(request)
        ).done("Success post contact us", HttpStatus.CREATED)
    }
}