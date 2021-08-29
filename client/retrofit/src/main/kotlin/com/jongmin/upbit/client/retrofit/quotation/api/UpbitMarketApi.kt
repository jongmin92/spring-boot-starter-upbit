package com.jongmin.upbit.client.retrofit.quotation.api

import com.jongmin.upbit.client.retrofit.quotation.api.protocol.UpbitMarketsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UpbitMarketApi {

    @GET("/v1/market/all")
    fun getMarkets(@Query("isDetails") isDetails: Boolean? = false): Call<UpbitMarketsResponse>
}
