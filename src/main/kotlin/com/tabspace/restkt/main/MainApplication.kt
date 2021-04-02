package com.tabspace.restkt.main

import com.tabspace.restkt.main.utils.properties.AppProperties
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableAutoConfiguration
@EnableConfigurationProperties(AppProperties::class)
@SpringBootApplication
class MainApplication

fun main(args: Array<String>) {
	runApplication<MainApplication>(*args)
}


