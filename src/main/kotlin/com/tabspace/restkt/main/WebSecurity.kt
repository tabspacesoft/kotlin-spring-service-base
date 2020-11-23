package com.tabspace.restkt.main

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy

@EnableWebSecurity
class WebSecurity : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        if (http != null) {
            http.csrf().disable()
                    .authorizeRequests().antMatchers(HttpMethod.GET).permitAll()
                    // this disables session creation on Spring Security
                    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        }

    }
}