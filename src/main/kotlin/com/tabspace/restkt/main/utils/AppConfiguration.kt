package com.tabspace.restkt.main.utils

import com.tabspace.restkt.main.utils.filter.AcceptLanguageResolver
import com.tabspace.restkt.main.utils.properties.AppProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.web.servlet.LocaleResolver
import java.nio.charset.StandardCharsets

@Configuration
class AppConfiguration constructor(private val appProperties: AppProperties) {
    @Bean
    @Primary
    fun messageSource(): MessageSource {
        return ReloadableResourceBundleMessageSource().apply {
            setBasename("classpath:messages/messages")
            setDefaultEncoding(StandardCharsets.UTF_8.name())
        }
    }

    @Bean
    @Primary
    fun localValidatorFactoryBean(messageSource: MessageSource) = LocalValidatorFactoryBean().apply {
        setValidationMessageSource(messageSource)
    }

    @Bean
    fun localeResolver(appProperties: AppProperties): LocaleResolver = AcceptLanguageResolver(appProperties)
}