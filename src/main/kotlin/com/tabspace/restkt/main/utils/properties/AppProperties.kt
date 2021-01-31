package com.tabspace.restkt.main.utils.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "config")
data class AppProperties(
        val localization: Localization
)

data class Localization(
    val defaultLanguage: String,
    val acceptedLanguage: List<String>
)