package com.tabspace.restkt.main.config.base

import com.tabspace.restkt.main.config.properties.GlobalConstants
import org.apache.commons.lang3.exception.ExceptionUtils
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

abstract class AbstractResponseHandler {
	fun done(
			msg: String? = GlobalConstants.EMPTY_STRING,
			httpStatus: HttpStatus? = HttpStatus.OK
	): ResponseEntity<ResultResponse<Any>> {

		return when (val processResponse = data()) {
			is Exception -> onError(msg, processResponse)
			else -> onSuccess(msg, processResponse, httpStatus)
		}
	}

	private fun onError(msg: String?, ex: Exception):
			ResponseEntity<ResultResponse<Any>> {
		val debugInfo = ExceptionUtils.getStackTrace(ex).split("\n")[0]

		val metaResponse = MetaResponse(
			httpCode = HttpStatus.BAD_REQUEST.value(),
			message = msg,
			debugInfo = debugInfo
		)

		val result = ResultResponse<Any>(
			status = "ERROR",
			meta = metaResponse
		)
		return generateResponseEntity(result, HttpStatus.BAD_REQUEST)
	}

	private fun onSuccess(msg: String?, any: Any, httpStatus: HttpStatus? = HttpStatus.OK):
			ResponseEntity<ResultResponse<Any>> {
		val metaResponse = MetaResponse(
			httpCode = httpStatus!!.value(),
			message = msg
		)

		val result = ResultResponse(
			status = when(metaResponse.httpCode) {
				HttpStatus.OK.value() -> "OK"
				HttpStatus.CREATED.value() -> "CREATED"
				else -> "ERROR"
			},
			data = any,
			meta = metaResponse
		)
		return generateResponseEntity(result, httpStatus)
	}

	private fun generateResponseEntity(result: ResultResponse<Any>, code: HttpStatus? = HttpStatus.OK) =
		ResponseEntity(result, HttpHeaders().apply {
			set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		}, code!!)

	abstract fun data(): Any
}