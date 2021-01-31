package com.tabspace.restkt.main.utils.base

import com.tabspace.restkt.main.utils.properties.GlobalConstants
import org.apache.commons.lang3.exception.ExceptionUtils
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

abstract class AbstractResponseHandler {
	fun <T> done(
			data: T? = null,
			msg: String? = GlobalConstants.EMPTY_STRING,
			httpStatus: HttpStatus? = HttpStatus.OK
	): ResponseEntity<ResultResponse<T>> {

		return when (data) {
			is Exception -> onError(msg, data)
			else -> onSuccess(msg, data, httpStatus)
		}
	}

	private fun <T> onError(msg: String?, ex: Exception):
			ResponseEntity<ResultResponse<T>> {
		val debugInfo = ExceptionUtils.getStackTrace(ex).split("\n")[0]

		val metaResponse = MetaResponse(
			httpCode = HttpStatus.BAD_REQUEST.value(),
			message = msg,
			debugInfo = debugInfo
		)

		val result = ResultResponse<T>(
			status = "ERROR",
			meta = metaResponse
		)
		return generateResponseEntity(result, HttpStatus.BAD_REQUEST)
	}

	private fun <T> onSuccess(msg: String?, any: T? = null, httpStatus: HttpStatus? = HttpStatus.OK):
			ResponseEntity<ResultResponse<T>> {
		val metaResponse = MetaResponse(
			httpCode = httpStatus!!.value(),
			message = msg
		)

		val result = ResultResponse(
			status = when(metaResponse.httpCode) {
				HttpStatus.OK.value() -> GlobalConstants.OK
				HttpStatus.CREATED.value() -> GlobalConstants.CREATED
				else -> "ERROR"
			},
			data = any,
			meta = metaResponse
		)
		return generateResponseEntity(result, httpStatus)
	}

	private fun <T> generateResponseEntity(result: ResultResponse<T>, code: HttpStatus? = HttpStatus.OK) =
		ResponseEntity(result, HttpHeaders().apply {
			set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		}, code!!)
}