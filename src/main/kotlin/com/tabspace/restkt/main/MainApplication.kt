package com.tabspace.restkt.main

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration
class MainApplication

fun main(args: Array<String>) {
	runApplication<MainApplication>(*args)
}


