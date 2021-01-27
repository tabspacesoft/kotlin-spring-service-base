package com.tabspace.restkt.main.config.base

import com.tabspace.restkt.main.config.properties.GlobalConstants

data class MetaResponse(
        var httpCode: Int,
        var isValidRequest: Boolean? = true,
        var message: String? = GlobalConstants.EMPTY_STRING,
        var debugInfo: String? = GlobalConstants.EMPTY_STRING
)