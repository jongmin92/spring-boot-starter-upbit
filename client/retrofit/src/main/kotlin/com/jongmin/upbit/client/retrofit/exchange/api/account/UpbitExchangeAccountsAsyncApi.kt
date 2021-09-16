package com.jongmin.upbit.client.retrofit.exchange.api.account

import retrofit2.http.GET
import java.util.concurrent.CompletableFuture

interface UpbitExchangeAccountsAsyncApi {

    @GET("v1/accounts")
    fun getAccounts(): CompletableFuture<List<UpbitAccountResponse>>
}
