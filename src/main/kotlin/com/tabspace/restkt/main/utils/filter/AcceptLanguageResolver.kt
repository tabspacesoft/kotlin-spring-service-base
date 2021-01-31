package com.tabspace.restkt.main.utils.filter

import com.tabspace.restkt.main.utils.extension.getLanguage
import com.tabspace.restkt.main.utils.properties.AppProperties
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.util.*
import javax.servlet.http.HttpServletRequest

class AcceptLanguageResolver constructor(private val appProperties: AppProperties) :
	AcceptHeaderLocaleResolver() {

	override fun resolveLocale(request: HttpServletRequest): Locale {
		val acceptedLanguage = when (val languageFromHeader = request.getLanguage()) {
			null -> appProperties.localization.defaultLanguage
			else -> when (val language = appProperties.localization.acceptedLanguage
				.find { it.equals(languageFromHeader.toLowerCase(), true) }) {
				null -> appProperties.localization.defaultLanguage
				else -> language
			}
		}

		val localeForLanguage: Locale = Locale.forLanguageTag(acceptedLanguage.replace("_", "-"))
		val languages: List<Locale.LanguageRange> = Locale.LanguageRange.parse(acceptedLanguage.replace("_", "-"))

		return Locale.lookup(languages, mutableListOf(localeForLanguage))
	}
}