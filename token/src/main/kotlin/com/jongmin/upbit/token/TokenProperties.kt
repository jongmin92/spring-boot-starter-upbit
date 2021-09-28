package com.jongmin.upbit.token

data class TokenProperties(
    val accessKey: String,
    val secretKey: String
) {
    init {
        require(accessKey.isNotBlank()) { "invalid accessKey: blank" }
        require(secretKey.isNotBlank()) { "invalid secretKey: blank" }
    }
}
