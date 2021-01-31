package com.tabspace.restkt.main.utils.properties

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component

@Component
class AppMessages @Autowired constructor(private val messageSource: MessageSource) {

	fun call(key: String, vararg args: String): String = try {
		messageSource.getMessage(key, args, LocaleContextHolder.getLocale())
	} catch (ex: Exception) {
		key
	}
}