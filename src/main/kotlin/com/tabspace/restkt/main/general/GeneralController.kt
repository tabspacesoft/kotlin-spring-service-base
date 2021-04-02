package com.tabspace.restkt.main.general

import com.tabspace.restkt.main.utils.base.BaseController
import com.tabspace.restkt.main.utils.base.ResultResponse
import com.tabspace.restkt.main.utils.properties.AppMessages
import com.tabspace.restkt.main.utils.properties.GlobalConstants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/"])
class GeneralController @Autowired constructor(
        private val generalService: GeneralService,
        private val appMessages: AppMessages
): BaseController() {
    @GetMapping()
    fun welcome(): ResponseEntity<ResultResponse<String>> {
        return generateResponse().done(
                data =  generalService.systemHealth(
                        name = "Kotlin",
                        version = "1",
                        time = LocalDateTime.now()
                ),
                msg = appMessages.call("resp.success", GlobalConstants.GET, "welcome"),
                httpStatus = HttpStatus.OK
        )
    }

    @PostMapping(value = ["contact-us"])
    fun contactUs(
            @RequestBody @Valid request: ContactUsRequest
    ): ResponseEntity<ResultResponse<ContactUsResponse>> {
        return generateResponse().done(
                data = generalService.recordContact(request),
                msg = appMessages.call("resp.success", GlobalConstants.POST, "contact us"),
                httpStatus = HttpStatus.OK
        )
    }
}