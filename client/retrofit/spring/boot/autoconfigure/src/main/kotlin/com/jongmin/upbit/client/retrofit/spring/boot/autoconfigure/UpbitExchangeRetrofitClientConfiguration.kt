package com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure

import com.jongmin.upbit.client.retrofit.RetrofitApiFactoryService
import com.jongmin.upbit.client.retrofit.exchange.UpbitExchangeAsyncServiceImpl
import com.jongmin.upbit.client.retrofit.exchange.UpbitExchangeCoroutineServiceImpl
import com.jongmin.upbit.client.retrofit.exchange.UpbitExchangeServiceImpl
import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitExchangeAccountsAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitExchangeAccountsCoroutineApi
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitExchangeDepositsAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitExchangeDepositsCoroutineApi
import com.jongmin.upbit.client.retrofit.exchange.api.info.UpbitExchangeInfoAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.info.UpbitExchangeInfoCoroutineApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitExchangeOrdersAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitExchangeOrdersCoroutineApi
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.UpbitExchangeWithdrawsAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.UpbitExchangeWithdrawsCoroutineApi
import com.jongmin.upbit.client.retrofit.spring.boot.UpbitClientSettings
import com.jongmin.upbit.exchange.UpbitExchangeAsyncService
import com.jongmin.upbit.token.AuthorizationTokenService
import com.jongmin.upbit.token.AuthorizationTokenServiceImpl
import com.jongmin.upbit.token.TokenProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.UUID

@Configuration
class UpbitExchangeRetrofitClientConfiguration {

    @Bean
    fun authorizationTokenService(upbitClientSettings: UpbitClientSettings) =
        AuthorizationTokenServiceImpl(
            TokenProperties(upbitClientSettings.accessKey, upbitClientSettings.secretKey),
            { UUID.randomUUID().toString() }
        )

    @Bean
    fun upbitExchangeCouroutineService(
        retrofitApiFactoryService: RetrofitApiFactoryService,
        authorizationTokenService: AuthorizationTokenService
    ) = UpbitExchangeCoroutineServiceImpl(
        accountsCoroutineApi = retrofitApiFactoryService.default(UpbitExchangeAccountsCoroutineApi::class.java),
        ordersCoroutineApi = retrofitApiFactoryService.default(UpbitExchangeOrdersCoroutineApi::class.java),
        withdrawsCoroutineApi = retrofitApiFactoryService.default(UpbitExchangeWithdrawsCoroutineApi::class.java),
        depositsCoroutineApi = retrofitApiFactoryService.default(UpbitExchangeDepositsCoroutineApi::class.java),
        infoCoroutineApi = retrofitApiFactoryService.default(UpbitExchangeInfoCoroutineApi::class.java),
        authorizationTokenService = authorizationTokenService
    )

    @Bean
    fun upbitExchangeAsyncService(
        retrofitApiFactoryService: RetrofitApiFactoryService,
        authorizationTokenService: AuthorizationTokenService
    ) = UpbitExchangeAsyncServiceImpl(
        accountsAsyncApi = retrofitApiFactoryService.default(UpbitExchangeAccountsAsyncApi::class.java),
        ordersAsyncApi = retrofitApiFactoryService.default(UpbitExchangeOrdersAsyncApi::class.java),
        withdrawsAsyncApi = retrofitApiFactoryService.default(UpbitExchangeWithdrawsAsyncApi::class.java),
        depositsAsyncApi = retrofitApiFactoryService.default(UpbitExchangeDepositsAsyncApi::class.java),
        infoAsyncApi = retrofitApiFactoryService.default(UpbitExchangeInfoAsyncApi::class.java),
        authorizationTokenService = authorizationTokenService
    )

    @Bean
    fun upbitExchangeService(
        upbitExchangeAsyncService: UpbitExchangeAsyncService
    ) = UpbitExchangeServiceImpl(upbitExchangeAsyncService)
}
