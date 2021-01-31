package com.tabspace.restkt.main.utils.extension

import org.springframework.http.HttpHeaders
import javax.servlet.http.HttpServletRequest

fun HttpServletRequest.getLanguage(): String? = this.getHeader(HttpHeaders.ACCEPT_LANGUAGE)