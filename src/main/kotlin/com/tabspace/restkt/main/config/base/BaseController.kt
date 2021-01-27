package com.tabspace.restkt.main.config.base

open class BaseController {
	protected fun generateResponse(any: Any) = object : AbstractResponseHandler() {
		override fun data() = any
	}
}