package com.jongmin.upbit.client.retrofit.spring.boot

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "upbit.client")
data class UpbitClientSettings(
    val accessKey: String,
    val secretKey: String
)
