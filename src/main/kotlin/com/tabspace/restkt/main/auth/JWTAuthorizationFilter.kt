package com.tabspace.restkt.main.auth

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

public class JWTAuthorizationFilter public constructor(authenticationManager: AuthenticationManager): BasicAuthenticationFilter(authenticationManager) {

}