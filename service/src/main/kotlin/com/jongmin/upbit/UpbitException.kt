package com.jongmin.upbit

data class UpbitException(
    val name: String,
    override val message: String,
): RuntimeException(message)
