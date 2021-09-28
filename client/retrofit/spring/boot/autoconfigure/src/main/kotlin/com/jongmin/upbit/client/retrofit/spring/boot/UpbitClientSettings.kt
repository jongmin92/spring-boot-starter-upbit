package com.jongmin.upbit.client.retrofit.spring.boot

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import javax.validation.constraints.NotBlank

@ConstructorBinding
@ConfigurationProperties(prefix = "upbit.client")
data class UpbitClientSettings(
    val apiBaseUrl: String = "https://api.upbit.com/",
    /**
     * Open API Access key
     */
    @get:NotBlank
    val accessKey: String,
    /**
     * Open API Secret key
     */
    @get:NotBlank
    val secretKey: String
)
