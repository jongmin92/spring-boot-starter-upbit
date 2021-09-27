package com.jongmin.upbit.client.retrofit.quotation

import com.jongmin.upbit.quotation.UpbitQuotationAsyncService
import com.jongmin.upbit.quotation.UpbitQuotationCoroutineService
import com.jongmin.upbit.quotation.candles.UpbitDayCandle
import com.jongmin.upbit.quotation.candles.UpbitMinuteCandle
import com.jongmin.upbit.quotation.candles.UpbitMonthCandle
import com.jongmin.upbit.quotation.candles.UpbitWeekCandle
import com.jongmin.upbit.quotation.market.UpbitMarket
import com.jongmin.upbit.quotation.orderbook.UpbitOrderbook
import com.jongmin.upbit.quotation.ticker.UpbitTicker
import com.jongmin.upbit.quotation.trades.UpbitTick
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.future.asDeferred

class UpbitQuotationCoroutineServiceImpl(
    private val upbitQuotationAsyncService: UpbitQuotationAsyncService
) : UpbitQuotationCoroutineService {

    override fun getUpbitMinuteCandle(
        unit: Int,
        market: String,
        to: String?,
        count: Int?
    ): Deferred<List<UpbitMinuteCandle>> {
        return upbitQuotationAsyncService.getUpbitMinuteCandle(
            unit = unit,
            market = market,
            to = to,
            count = count
        ).asDeferred()
    }

    override fun getUpbitDayCandles(
        market: String,
        to: String?,
        count: Int?,
        convertingPriceUnit: String?
    ): Deferred<List<UpbitDayCandle>> {
        return upbitQuotationAsyncService.getUpbitDayCandles(
            market = market,
            to = to,
            count = count,
            convertingPriceUnit = convertingPriceUnit
        ).asDeferred()
    }

    override fun getUpbitWeekCandles(
        market: String,
        to: String?,
        count: Int?
    ): Deferred<List<UpbitWeekCandle>> {
        return upbitQuotationAsyncService.getUpbitWeekCandles(market, to, count).asDeferred()
    }

    override fun getUpbitMonthCandles(
        market: String,
        to: String?,
        count: Int?
    ): Deferred<List<UpbitMonthCandle>> {
        return upbitQuotationAsyncService.getUpbitMonthCandles(market, to, count).asDeferred()
    }

    override fun getUpbitMarkets(isDetails: Boolean?): Deferred<List<UpbitMarket>> {
        return upbitQuotationAsyncService.getUpbitMarkets(isDetails).asDeferred()
    }

    override fun getUpbitOrderbooks(markets: String): Deferred<List<UpbitOrderbook>> {
        return upbitQuotationAsyncService.getUpbitOrderbooks(markets).asDeferred()
    }

    override fun getUpbitTicker(markets: String): Deferred<List<UpbitTicker>> {
        return upbitQuotationAsyncService.getUpbitTicker(markets).asDeferred()
    }

    override fun getUpbitTicks(
        market: String,
        to: String?,
        count: Int?,
        cursor: String?,
        daysAgo: Int?
    ): Deferred<List<UpbitTick>> {
        return upbitQuotationAsyncService.getUpbitTicks(
            market = market,
            to = to,
            count = count,
            cursor = cursor,
            daysAgo = daysAgo
        ).asDeferred()
    }
}
