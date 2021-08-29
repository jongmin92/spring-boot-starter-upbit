package com.jongmin.upbit.client.retrofit.quotation.api

import com.jongmin.upbit.client.retrofit.quotation.api.protocol.UpbitOrderbooksResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UpbitOrderbookApi {

    @GET("/v1/orderbooks")
    fun getOrderbooks(@Query("markets") markets: String): Call<UpbitOrderbooksResponse>
}
