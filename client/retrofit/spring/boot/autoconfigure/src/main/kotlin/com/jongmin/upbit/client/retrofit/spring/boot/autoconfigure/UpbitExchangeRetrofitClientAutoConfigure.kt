package com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.client.retrofit.exchange.UpbitExchangeServiceImpl
import com.jongmin.upbit.client.retrofit.exchange.api.UpbitExchangeApi
import com.jongmin.upbit.client.retrofit.quotation.UpbitQuotationServiceImpl
import com.jongmin.upbit.client.retrofit.quotation.api.*
import com.jongmin.upbit.client.retrofit.spring.boot.UpbitClientSettings
import com.jongmin.upbit.token.AuthorizationTokenService
import com.jongmin.upbit.token.AuthorizationTokenServiceImpl
import com.jongmin.upbit.token.TokenProperties
import com.linecorp.armeria.client.retrofit2.ArmeriaRetrofit
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.*

@EnableConfigurationProperties(UpbitClientSettings::class)
@Configuration
class UpbitExchangeRetrofitClientAutoConfigure {
    companion object {
        const val BASE_URL = "https://api.upbit.com/"
    }

    private fun <T> makeDefaultRetrofitApi(clazz: Class<T>): T =
        ArmeriaRetrofit.builder(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper().apply {
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            }))
            .build()
            .create(clazz)

    @Bean
    fun upbitExchangeApi(): UpbitExchangeApi = makeDefaultRetrofitApi(UpbitExchangeApi::class.java)

    @Bean
    fun upbitQuotationApi(): UpbitQuotationApi = makeDefaultRetrofitApi(UpbitQuotationApi::class.java)

    @Bean
    fun authorizationTokenService(upbitClientSettings: UpbitClientSettings) =
        AuthorizationTokenServiceImpl(
            TokenProperties(upbitClientSettings.accessKey, upbitClientSettings.secretKey),
            UUID::randomUUID::toString
        )

    @Bean
    fun upbitExchangeService(
        upbitExchangeApi: UpbitExchangeApi,
        authorizationTokenService: AuthorizationTokenService
    ): UpbitExchangeServiceImpl {
        return UpbitExchangeServiceImpl(upbitExchangeApi, authorizationTokenService)
    }

    @Bean
    fun upbitQuotationService(
        upbitQuotationApi: UpbitQuotationApi
    ): UpbitQuotationServiceImpl {
        return UpbitQuotationServiceImpl(
            upbitQuotationApi
        )
    }
}
