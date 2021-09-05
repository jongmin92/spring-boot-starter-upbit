package com.jongmin.upbit.client.retrofit.spring.boot

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "upbit.client")
data class UpbitClientSettings(
    val apiBaseURL: String = "https://api.upbit.com/",
    val accessKey: String,
    val secretKey: String
)
