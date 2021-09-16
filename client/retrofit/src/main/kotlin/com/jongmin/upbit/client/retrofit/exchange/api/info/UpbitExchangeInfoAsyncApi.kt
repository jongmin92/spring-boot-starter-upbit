package com.jongmin.upbit.client.retrofit.exchange.api.info

import retrofit2.http.GET
import java.util.concurrent.CompletableFuture

interface UpbitExchangeInfoAsyncApi {

    @GET("v1/status/wallet")
    fun getWalletStatus(): CompletableFuture<List<UpbitWalletStatusResponse>>

    @GET("v1/api_keys")
    fun getApiKeys(): CompletableFuture<List<UpbitApiKeyResponse>>
}
