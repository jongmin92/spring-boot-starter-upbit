package com.jongmin.upbit.quotation

data class UpbitQuotationException(
    val name: String,
    override val message: String,
    override val cause: Throwable?
): RuntimeException()
