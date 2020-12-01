package com.tabspace.restkt.main.auth

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

public class JWTAuthenticationFilter public constructor(authenticationManager: AuthenticationManager): UsernamePasswordAuthenticationFilter() {
    private var authManager: AuthenticationManager? = authenticationManager

    init {
        setFilterProcessesUrl("/api/identities/signin")
    }

    // auth logic managed by springboot security
    override fun attemptAuthentication(request: HttpServletRequest?, response: HttpServletResponse?): Authentication {
        return super.attemptAuthentication(request, response)
    }
}