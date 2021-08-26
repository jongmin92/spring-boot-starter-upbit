package com.jongmin.upbit.client.retrofit.exchange.api

import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitAccountResponse
import retrofit2.Call
import retrofit2.http.GET

interface UpbitExchangeApi {

    @GET("v1/accounts")
    fun getAccounts(): Call<List<UpbitAccountResponse>>
}
