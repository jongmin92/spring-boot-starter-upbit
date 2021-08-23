package com.jongmin.upbit.exchange

data class UpbitExchangeException(
    val name: String,
    override val message: String,
    override val cause: Throwable?
) : RuntimeException(message, cause)
