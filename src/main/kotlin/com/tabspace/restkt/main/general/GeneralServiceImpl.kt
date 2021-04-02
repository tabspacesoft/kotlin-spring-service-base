package com.tabspace.restkt.main.general

import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class GeneralServiceImpl : GeneralService {
    override fun systemHealth(name: String, version: String, time: LocalDateTime): String {
        return "$name, $version, $time"
    }

    override fun recordContact(contactUsRequest: ContactUsRequest): ContactUsResponse {
        return ContactUsResponse(
            name = contactUsRequest.name,
            email = contactUsRequest.email,
            message = contactUsRequest.message,
            address = contactUsRequest.address
        )
    }
}