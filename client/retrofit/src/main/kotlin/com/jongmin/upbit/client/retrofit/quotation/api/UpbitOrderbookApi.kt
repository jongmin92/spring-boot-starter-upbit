package com.jongmin.upbit.client.retrofit.quotation.api

import com.jongmin.upbit.client.retrofit.quotation.api.protocol.UpbitOrderbookResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UpbitOrderbookApi {

    @GET("/v1/orderbook")
    fun getOrderbooks(@Query("markets") markets: String): Call<List<UpbitOrderbookResponse>>
}
