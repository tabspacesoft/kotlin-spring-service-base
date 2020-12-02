package com.tabspace.restkt.main.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter

@Configuration
@EnableResourceServer
class ResourceServerConfig: ResourceServerConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.cors().disable()
                .formLogin().disable()
                .anonymous().disable()
                .authorizeRequests()
                .antMatchers("/contact").hasRole("USER")
                .antMatchers("/public/**").authenticated()
    }
}