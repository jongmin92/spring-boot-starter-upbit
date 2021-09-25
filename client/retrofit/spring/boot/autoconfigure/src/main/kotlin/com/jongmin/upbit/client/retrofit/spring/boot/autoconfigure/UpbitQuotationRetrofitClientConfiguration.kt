package com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure

import com.jongmin.upbit.client.retrofit.RetrofitApiFactoryService
import com.jongmin.upbit.client.retrofit.quotation.UpbitQuotationAsyncServiceImpl
import com.jongmin.upbit.client.retrofit.quotation.UpbitQuotationServiceImpl
import com.jongmin.upbit.client.retrofit.quotation.api.candle.UpbitQuotationCandleAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.market.UpbitQuotationMarketAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.UpbitQuotationOrderbookAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.UpbitQuotationTickerAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.trade.UpbitQuotationTradeAsyncApi
import com.jongmin.upbit.quotation.UpbitQuotationAsyncService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpbitQuotationRetrofitClientConfiguration {

    @Bean
    fun upbitQuotationAsyncService(
        retrofitApiFactoryService: RetrofitApiFactoryService
    ) = UpbitQuotationAsyncServiceImpl(
        candleAsyncApi = retrofitApiFactoryService.default(UpbitQuotationCandleAsyncApi::class.java),
        marketAsyncApi = retrofitApiFactoryService.default(UpbitQuotationMarketAsyncApi::class.java),
        orderbookAsyncApi = retrofitApiFactoryService.default(UpbitQuotationOrderbookAsyncApi::class.java),
        tickerAsyncApi = retrofitApiFactoryService.default(UpbitQuotationTickerAsyncApi::class.java),
        tradeAsyncApi = retrofitApiFactoryService.default(UpbitQuotationTradeAsyncApi::class.java)
    )

    @Bean
    fun upbitQuotationService(
        upbitQuotationAsyncService: UpbitQuotationAsyncService
    ) = UpbitQuotationServiceImpl(upbitQuotationAsyncService)
}
