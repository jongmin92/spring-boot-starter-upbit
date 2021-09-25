package com.jongmin.upbit.client.retrofit.quotation.api.market

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.CompletableFuture

interface UpbitQuotationMarketAsyncApi {

    @GET("v1/market/all")
    fun getMarkets(@Query("isDetails") isDetails: Boolean? = null): CompletableFuture<List<UpbitMarketResponse>>
}
