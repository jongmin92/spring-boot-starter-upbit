package com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.client.retrofit.exchange.UpbitExchangeServiceImpl
import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitExchangeAccountsApi
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitExchangeDepositsApi
import com.jongmin.upbit.client.retrofit.exchange.api.info.UpbitExchangeInfoApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitExchangeOrdersApi
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.UpbitExchangeWithdrawApi
import com.jongmin.upbit.client.retrofit.spring.boot.UpbitClientSettings
import com.jongmin.upbit.token.AuthorizationTokenService
import com.jongmin.upbit.token.AuthorizationTokenServiceImpl
import com.jongmin.upbit.token.TokenProperties
import com.linecorp.armeria.client.retrofit2.ArmeriaRetrofit
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.UUID

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
    fun accountsApi(): UpbitExchangeAccountsApi = makeDefaultRetrofitApi(UpbitExchangeAccountsApi::class.java)

    @Bean
    fun ordersApi(): UpbitExchangeOrdersApi = makeDefaultRetrofitApi(UpbitExchangeOrdersApi::class.java)

    @Bean
    fun withdrawsApi(): UpbitExchangeWithdrawApi = makeDefaultRetrofitApi(UpbitExchangeWithdrawApi::class.java)

    @Bean
    fun depositsApi(): UpbitExchangeDepositsApi = makeDefaultRetrofitApi(UpbitExchangeDepositsApi::class.java)

    @Bean
    fun infoApi(): UpbitExchangeInfoApi = makeDefaultRetrofitApi(UpbitExchangeInfoApi::class.java)

    @Bean
    fun authorizationTokenService(upbitClientSettings: UpbitClientSettings) =
        AuthorizationTokenServiceImpl(
            TokenProperties(upbitClientSettings.accessKey, upbitClientSettings.secretKey),
            UUID::randomUUID::toString
        )

    @Bean
    fun upbitExchangeService(
        accountsApi: UpbitExchangeAccountsApi,
        ordersApi: UpbitExchangeOrdersApi,
        withdrawApi: UpbitExchangeWithdrawApi,
        depositsApi: UpbitExchangeDepositsApi,
        infoApi: UpbitExchangeInfoApi,
        authorizationTokenService: AuthorizationTokenService
    ): UpbitExchangeServiceImpl {
        return UpbitExchangeServiceImpl(
            accountsApi = accountsApi,
            ordersApi = ordersApi,
            withdrawsApi = withdrawApi,
            depositsApi = depositsApi,
            infoApi = infoApi,
            authorizationTokenService = authorizationTokenService
        )
    }
}
