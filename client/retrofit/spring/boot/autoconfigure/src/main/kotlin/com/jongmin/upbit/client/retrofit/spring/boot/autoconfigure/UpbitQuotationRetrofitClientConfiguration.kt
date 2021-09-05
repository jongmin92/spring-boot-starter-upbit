package com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure

import com.jongmin.upbit.client.retrofit.RetrofitApiFactoryService
import com.jongmin.upbit.client.retrofit.quotation.UpbitQuotationServiceImpl
import com.jongmin.upbit.client.retrofit.quotation.api.candle.UpbitQuotationCandleApi
import com.jongmin.upbit.client.retrofit.quotation.api.market.UpbitQuotationMarketApi
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.UpbitQuotationOrderbookApi
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.UpbitQuotationTickerApi
import com.jongmin.upbit.client.retrofit.quotation.api.trade.UpbitQuotationTradeApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpbitQuotationRetrofitClientConfiguration {

    @Bean
    fun upbitQuotationService(
        retrofitApiFactoryService: RetrofitApiFactoryService
    ) = UpbitQuotationServiceImpl(
        candleApi = retrofitApiFactoryService.default(UpbitQuotationCandleApi::class.java),
        marketApi = retrofitApiFactoryService.default(UpbitQuotationMarketApi::class.java),
        orderbookApi = retrofitApiFactoryService.default(UpbitQuotationOrderbookApi::class.java),
        tickerApi = retrofitApiFactoryService.default(UpbitQuotationTickerApi::class.java),
        tradeApi = retrofitApiFactoryService.default(UpbitQuotationTradeApi::class.java)
    )
}
