package com.tabspace.restkt.main.utils.base

data class ResultResponse<T>(
        var status: String,
        var data: T? = null,
        var meta: MetaResponse
)