package com.jongmin.upbit.client.retrofit.quotation

import com.jongmin.upbit.client.retrofit.quotation.api.UpbitQuotationApi
import com.jongmin.upbit.exchange.order.*
import com.jongmin.upbit.quotation.UpbitQuotationService
import com.jongmin.upbit.quotation.candles.DayCandles
import com.jongmin.upbit.quotation.candles.MinuteCandles
import com.jongmin.upbit.quotation.candles.MonthCandles
import com.jongmin.upbit.quotation.candles.WeekCandles
import com.jongmin.upbit.quotation.market.UpbitMarkets
import com.jongmin.upbit.quotation.ticker.UpbitTickers
import com.jongmin.upbit.quotation.trades.UpbitTicks

class UpbitQuotationServiceImpl(val upbitQuotationApi: UpbitQuotationApi) : UpbitQuotationService {
    override fun getOrdersChance(market: String): UpbitOrdersChance {
        TODO("Not yet implemented")
    }

    override fun getOrder(uuid: String, identifier: String): UpbitOrder {
        TODO("Not yet implemented")
    }

    override fun getOrders(
        market: String,
        state: String,
        states: List<String>,
        uuids: List<String>,
        identifiers: List<String>,
        page: Int,
        limit: Int,
        orderBy: String
    ): UpbitOrders {
        TODO("Not yet implemented")
    }

    override fun deleteOrder(uuid: String, identifier: String): UpbitOrderDelete {
        TODO("Not yet implemented")
    }

    override fun postOrder(
        market: String,
        side: String,
        volume: String,
        price: String,
        ordType: String,
        identifier: String
    ): UpbitOrderPost {
        TODO("Not yet implemented")
    }

    override fun getUpbitMinuteCandle(
        market: String,
        to: String?,
        count: Int,
        unit: Int
    ): MinuteCandles {
        TODO("Not yet implemented")
    }

    override fun getDayCandles(
        market: String,
        to: String?,
        count: Int,
        convertingPriceUnit: String
    ): DayCandles {
        TODO("Not yet implemented")
    }

    override fun getWeekCandles(market: String, to: String?, count: Int): WeekCandles {
        TODO("Not yet implemented")
    }

    override fun getMonthCandles(market: String, to: String?, count: Int): MonthCandles {
        TODO("Not yet implemented")
    }

    override fun getMarketAll(): UpbitMarkets {
        TODO("Not yet implemented")
    }

    override fun getUpbitTicker(markets: String): UpbitTickers {
        TODO("Not yet implemented")
    }

    override fun getUpbitTicks(
        market: String,
        to: String?,
        count: Int,
        cursor: String,
        daysAgo: Int
    ): UpbitTicks {
        TODO("Not yet implemented")
    }
}
