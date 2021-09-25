package com.jongmin.upbit.client.retrofit.quotation.api.candle

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.CompletableFuture

interface UpbitQuotationCandleAsyncApi {

    @GET("v1/candles/minutes/{unit}")
    fun getUpbitMinuteCandles(
        @Path("unit") unit: Int,
        @Query("market") market: String,
        @Query("to") to: String? = null,
        @Query("count") count: Int? = null
    ): CompletableFuture<List<UpbitMinuteCandleResponse>>

    @GET("v1/candles/days")
    fun getUpbitDayCandles(
        @Query("market") market: String,
        @Query("to") to: String? = null,
        @Query("count") count: Int? = null,
        @Query("convertingPriceUnit") convertingPriceUnit: String? = null,
    ): CompletableFuture<List<UpbitDayCandleResponse>>

    @GET("v1/candles/weeks")
    fun getUpbitWeekCandles(
        @Query("market") market: String,
        @Query("to") to: String? = null,
        @Query("count") count: Int? = null
    ): CompletableFuture<List<UpbitWeekCandleResponse>>

    @GET("v1/candles/months")
    fun getUpbitMonthCandles(
        @Query("market") market: String,
        @Query("to") to: String? = null,
        @Query("count") count: Int? = null
    ): CompletableFuture<List<UpbitMonthCandleResponse>>
}
