package com.jongmin.upbit.client.retrofit.quotation

import com.jongmin.upbit.client.retrofit.quotation.api.*
import com.jongmin.upbit.exchange.order.*
import com.jongmin.upbit.quotation.UpbitQuotationService
import com.jongmin.upbit.quotation.candles.DayCandles
import com.jongmin.upbit.quotation.candles.MinuteCandles
import com.jongmin.upbit.quotation.candles.MonthCandles
import com.jongmin.upbit.quotation.candles.WeekCandles
import com.jongmin.upbit.quotation.market.UpbitMarkets
import com.jongmin.upbit.quotation.orderbook.UpbitOrderbooks
import com.jongmin.upbit.quotation.ticker.UpbitTickers
import com.jongmin.upbit.quotation.trades.UpbitTicks

class UpbitQuotationServiceImpl(
    private val upbitCandleApi: UpbitCandleApi,
    private val upbitMarketApi: UpbitMarketApi,
    private val upbitOrderbookApi: UpbitOrderbookApi,
    private val upbitTickerApi: UpbitTickerApi,
    private val upbitTradeApi: UpbitTradeApi
) : UpbitQuotationService {
    override fun getUpbitMinuteCandle(market: String, to: String?, count: Int): MinuteCandles {
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

    override fun getMarkets(isDetails: Boolean): UpbitMarkets {
        TODO("Not yet implemented")
    }

    override fun getOrderbooks(markets: String): UpbitOrderbooks {
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
