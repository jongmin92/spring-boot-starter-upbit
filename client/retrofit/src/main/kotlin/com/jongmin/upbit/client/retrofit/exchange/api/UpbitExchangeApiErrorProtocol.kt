package com.jongmin.upbit.client.retrofit.exchange.api

import com.jongmin.upbit.exchange.UpbitExchangeException

data class ApiErrorResponse(
    val error: Error
) {
    data class Error(
        val name: String,
        val message: String
    )
}

fun ApiErrorResponse.toDomainException() = UpbitExchangeException(error.name, error.message)
