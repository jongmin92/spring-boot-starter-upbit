package com.jongmin.upbit.client.retrofit.spring.boot

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "upbit.client")
data class UpbitClientSettings(
    val apiBaseUrl: String = "https://api.upbit.com/",
    /**
     * Open API Access key
     */
    val accessKey: String,
    /**
     * Open API Secret key
     */
    val secretKey: String
)
