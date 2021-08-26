package com.jongmin.upbit.client.retrofit.quotation.api

import com.jongmin.upbit.client.retrofit.quotation.api.protocol.DayCandlesResponse
import com.jongmin.upbit.client.retrofit.quotation.api.protocol.MinuteCandlesResponse
import com.jongmin.upbit.client.retrofit.quotation.api.protocol.MonthCandlesResponse
import com.jongmin.upbit.client.retrofit.quotation.api.protocol.WeekCandlesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UpbitCandleApi {

    @GET("/v1/candles/minutes/{unit}")
    fun getUpbitMinuteCandles(
        @Path("unit") unit: Int,
        @Query("market") market: String,
        @Query("to") to: String = "yyyy-MM-dd HH:mm:ss",
        @Query("count") count: Int = 1
    ): Call<MinuteCandlesResponse>

    @GET("/v1/candles/days")
    fun getUpbitDayCandles(
        @Query("market") market: String,
        @Query("to") to: String = "yyyy-MM-dd HH:mm:ss",
        @Query("count") count: Int = 1,
        @Query("convertingPriceUnit") convertingPriceUnit: String = "KRW",
    ): Call<DayCandlesResponse>

    @GET("/v1/candles/weeks")
    fun getUpbitWeekCandles(
        @Query("market") market: String,
        @Query("to") to: String = "yyyy-MM-dd HH:mm:ss",
        @Query("count") count: Int = 1
    ): Call<WeekCandlesResponse>

    @GET("/v1/candles/months")
    fun getUpbitMonthCandles(
        @Query("market") market: String,
        @Query("to") to: String = "yyyy-MM-dd HH:mm:ss",
        @Query("count") count: Int = 1
    ): Call<MonthCandlesResponse>
}
