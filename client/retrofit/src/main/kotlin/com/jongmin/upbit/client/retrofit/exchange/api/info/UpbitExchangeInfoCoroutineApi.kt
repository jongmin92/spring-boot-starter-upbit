package com.jongmin.upbit.client.retrofit.exchange.api.info

import retrofit2.http.GET

interface UpbitExchangeInfoCoroutineApi {

    @GET("v1/status/wallet")
    suspend fun getWalletStatus(): List<UpbitWalletStatusResponse>

    @GET("v1/api_keys")
    suspend fun getApiKeys(): List<UpbitApiKeyResponse>
}
