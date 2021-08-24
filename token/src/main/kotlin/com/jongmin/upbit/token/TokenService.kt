package com.jongmin.upbit.token

interface TokenService {
    fun createToken(parameter: Map<String, Any> = emptyMap()): String
}
