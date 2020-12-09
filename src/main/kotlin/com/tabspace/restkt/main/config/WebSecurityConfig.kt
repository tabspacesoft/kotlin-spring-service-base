package com.tabspace.restkt.main.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
@EnableWebSecurity
class WebSecurityConfig(
        private val customUserDetailService: CustomUserDetailService,
        private val passwordEncoderAndMatcher: PasswordEncoder
): WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        print("{bcrypt}" + passwordEncoder().encode("1234"))
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("{bcrypt}" + passwordEncoder().encode("1234"))
//                .roles("USER")
        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder())
    }

    @Bean
    @Throws(java.lang.Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager? {
        return super.authenticationManagerBean()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}