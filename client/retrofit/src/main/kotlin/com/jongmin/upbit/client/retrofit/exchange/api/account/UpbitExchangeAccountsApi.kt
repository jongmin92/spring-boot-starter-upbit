package com.jongmin.upbit.client.retrofit.exchange.api.account

import retrofit2.Call
import retrofit2.http.GET

interface UpbitExchangeAccountsApi {

    @GET("v1/accounts")
    fun getAccounts(): Call<List<UpbitAccountResponse>>
}
