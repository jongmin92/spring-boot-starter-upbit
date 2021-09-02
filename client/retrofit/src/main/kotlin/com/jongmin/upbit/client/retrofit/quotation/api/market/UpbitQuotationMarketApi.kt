package com.jongmin.upbit.client.retrofit.quotation.api.market

import com.jongmin.upbit.client.retrofit.quotation.api.protocol.UpbitMarketResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UpbitQuotationMarketApi {

    @GET("v1/market/all")
    fun getMarkets(@Query("isDetails") isDetails: Boolean? = false): Call<List<UpbitMarketResponse>>
}
