package com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.client.retrofit.quotation.UpbitQuotationServiceImpl
import com.jongmin.upbit.client.retrofit.quotation.api.candle.UpbitQuotationCandleApi
import com.jongmin.upbit.client.retrofit.quotation.api.market.UpbitQuotationMarketApi
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.UpbitQuotationOrderbookApi
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.UpbitQuotationTickerApi
import com.jongmin.upbit.client.retrofit.quotation.api.trade.UpbitQuotationTradeApi
import com.linecorp.armeria.client.retrofit2.ArmeriaRetrofit
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.converter.jackson.JacksonConverterFactory

@Configuration
class UpbitQuotationRetrofitClientAutoConfigure {
    companion object {
        const val BASE_URL = "https://api.upbit.com/"
    }

    private fun <T> makeDefaultRetrofitApi(clazz: Class<T>): T =
        ArmeriaRetrofit.builder(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper().apply {
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            }))
            .build()
            .create(clazz)

    @Bean
    fun upbitQuotationService() =
        UpbitQuotationServiceImpl(
            candleApi = makeDefaultRetrofitApi(UpbitQuotationCandleApi::class.java),
            marketApi = makeDefaultRetrofitApi(UpbitQuotationMarketApi::class.java),
            orderbookApi = makeDefaultRetrofitApi(UpbitQuotationOrderbookApi::class.java),
            tickerApi = makeDefaultRetrofitApi(UpbitQuotationTickerApi::class.java),
            tradeApi = makeDefaultRetrofitApi(UpbitQuotationTradeApi::class.java)
        )
}
