package com.jongmin.upbit.client.retrofit.quotation.api

import com.jongmin.upbit.client.retrofit.quotation.api.protocol.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UpbitCandleApi {

    @GET("/v1/candles/minutes/{unit}")
    fun getUpbitMinuteCandles(
        @Path("unit") unit: Int,
        @Query("market") market: String,
        @Query("to") to: String?,
        @Query("count") count: Int?
    ): Call<List<MinuteCandleResponse>>

    @GET("/v1/candles/days")
    fun getUpbitDayCandles(
        @Query("market") market: String,
        @Query("to") to: String?,
        @Query("count") count: Int?,
        @Query("convertingPriceUnit") convertingPriceUnit: String? = "KRW",
    ): Call<List<DayCandleResponse>>

    @GET("/v1/candles/weeks")
    fun getUpbitWeekCandles(
        @Query("market") market: String,
        @Query("to") to: String? = "yyyy-MM-dd HH:mm:ss",
        @Query("count") count: Int?
    ): Call<List<WeekCandleResponse>>

    @GET("/v1/candles/months")
    fun getUpbitMonthCandles(
        @Query("market") market: String,
        @Query("to") to: String? = "yyyy-MM-dd HH:mm:ss",
        @Query("count") count: Int?
    ): Call<List<MonthCandleResponse>>
}
