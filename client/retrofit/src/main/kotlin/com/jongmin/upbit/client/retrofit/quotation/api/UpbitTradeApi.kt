package com.jongmin.upbit.client.retrofit.quotation.api

import com.jongmin.upbit.client.retrofit.quotation.api.protocol.UpbitTickResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UpbitTradeApi {

    @GET("v1/trades/ticks")
    fun getTradeTicks(
        @Query("market") market: String,
        @Query("to") to: String? = "HHmmss",
        @Query("count") count: Int? = null,
        @Query("cursor") cursor: String? = null,
        @Query("daysAgo") daysAgo: Int? = null
    ): Call<List<UpbitTickResponse>>
}
