package com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure

import com.jongmin.upbit.client.retrofit.spring.boot.UpbitClientSettings
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@EnableConfigurationProperties(UpbitClientSettings::class)
@Import(
    value = [
        UpbitExchangeRetrofitClientConfiguration::class,
        UpbitQuotationRetrofitClientConfiguration::class,
    ]
)
@Configuration
class UpbitClientAutoConfigure
