package com.jongmin.upbit.client.retrofit.exchange.api

import com.jongmin.upbit.UpbitException

data class ApiErrorResponse(
    val error: Error
) {
    data class Error(
        val name: String,
        val message: String
    )
}

fun ApiErrorResponse.toDomainException() = UpbitException(error.name, error.message)
