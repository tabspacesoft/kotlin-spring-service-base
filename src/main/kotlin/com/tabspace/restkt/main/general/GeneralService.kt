package com.tabspace.restkt.main.general

import java.time.LocalDateTime

interface GeneralService {
    fun systemHealth(name: String, version: String, time: LocalDateTime): String
    fun recordContact(contactUsRequest: ContactUsRequest): ContactUsResponse
}