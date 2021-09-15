package com.jongmin.upbit.exchange

data class UpbitExchangeException(
    val name: String,
    override val message: String
) : RuntimeException(message)
