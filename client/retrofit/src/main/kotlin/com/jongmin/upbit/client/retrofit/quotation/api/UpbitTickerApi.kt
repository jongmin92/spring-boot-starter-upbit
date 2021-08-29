package com.jongmin.upbit.client.retrofit.quotation.api

import com.jongmin.upbit.client.retrofit.quotation.api.protocol.UpbitTickersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UpbitTickerApi {

    @GET("/v1/ticker")
    fun getCurrentTicker(@Query("markets") markets: String): Call<UpbitTickersResponse>
}
