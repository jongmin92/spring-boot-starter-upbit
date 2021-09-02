package com.jongmin.upbit.client.retrofit.quotation.api.ticker

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UpbitQuotationTickerApi {

    @GET("v1/ticker")
    fun getCurrentTicker(@Query("markets") markets: String): Call<List<UpbitTickerResponse>>
}
