package com.jongmin.upbit.client.retrofit.quotation.api

import com.jongmin.upbit.quotation.UpbitQuotationException

data class ApiErrorResponse(
    val error: Error
) {
    data class Error(
        val name: String,
        val message: String
    )
}

fun ApiErrorResponse.toDomainException(cause: Throwable?) =
    UpbitQuotationException(error.name, error.message, cause)
