package com.jongmin.upbit.token

interface AuthorizationTokenService {
    fun createToken(parameter: Map<String, Any> = emptyMap()): String
}
