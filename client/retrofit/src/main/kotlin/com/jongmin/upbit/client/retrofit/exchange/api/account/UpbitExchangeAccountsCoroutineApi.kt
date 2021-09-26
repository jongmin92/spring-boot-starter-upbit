package com.jongmin.upbit.client.retrofit.exchange.api.account

import retrofit2.http.GET

interface UpbitExchangeAccountsCoroutineApi {

    @GET("v1/accounts")
    suspend fun getAccounts(): List<UpbitAccountResponse>
}
