package com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.client.retrofit.exchange.api.UpbitExchangeApi
import com.jongmin.upbit.client.retrofit.spring.boot.UpbitClientSettings
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@EnableConfigurationProperties(UpbitClientSettings::class)
@Configuration
class UpbitExchangeRetrofitClientAutoConfigure {
    companion object {
        const val BASE_URL = "https://api.upbit.com/"
    }

    @Bean
    fun upbitExchangeApi(): UpbitExchangeApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper().apply {
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            }))
            .build()
            .create(UpbitExchangeApi::class.java)
    }
}
