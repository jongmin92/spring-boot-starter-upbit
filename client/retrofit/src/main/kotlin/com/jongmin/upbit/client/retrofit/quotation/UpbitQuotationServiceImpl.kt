package com.jongmin.upbit.client.retrofit.quotation

import com.jongmin.upbit.quotation.UpbitQuotationAsyncService
import com.jongmin.upbit.quotation.UpbitQuotationService
import com.jongmin.upbit.quotation.candles.UpbitDayCandle
import com.jongmin.upbit.quotation.candles.UpbitMinuteCandle
import com.jongmin.upbit.quotation.candles.UpbitMonthCandle
import com.jongmin.upbit.quotation.candles.UpbitWeekCandle
import com.jongmin.upbit.quotation.market.UpbitMarket
import com.jongmin.upbit.quotation.orderbook.UpbitOrderbook
import com.jongmin.upbit.quotation.ticker.UpbitTicker
import com.jongmin.upbit.quotation.trades.UpbitTick
import joining

class UpbitQuotationServiceImpl(
    private val upbitQuotationAsyncService: UpbitQuotationAsyncService
) : UpbitQuotationService {

    override fun getUpbitMinuteCandle(
        unit: Int,
        market: String,
        to: String?,
        count: Int?
    ): List<UpbitMinuteCandle> {
        return upbitQuotationAsyncService.getUpbitMinuteCandle(
            unit = unit,
            market = market,
            to = to,
            count = count
        ).joining()
    }

    override fun getUpbitDayCandles(
        market: String,
        to: String?,
        count: Int?,
        convertingPriceUnit: String?
    ): List<UpbitDayCandle> {
        return upbitQuotationAsyncService.getUpbitDayCandles(
            market = market,
            to = to,
            count = count,
            convertingPriceUnit = convertingPriceUnit
        ).joining()
    }

    override fun getUpbitWeekCandles(market: String, to: String?, count: Int?): List<UpbitWeekCandle> {
        return upbitQuotationAsyncService.getUpbitWeekCandles(market, to, count).joining()
    }

    override fun getUpbitMonthCandles(market: String, to: String?, count: Int?): List<UpbitMonthCandle> {
        return upbitQuotationAsyncService.getUpbitMonthCandles(market, to, count).joining()
    }

    override fun getUpbitMarkets(isDetails: Boolean?): List<UpbitMarket> {
        return upbitQuotationAsyncService.getUpbitMarkets(isDetails).joining()
    }

    override fun getUpbitOrderbooks(markets: String): List<UpbitOrderbook> {
        return upbitQuotationAsyncService.getUpbitOrderbooks(markets).joining()
    }

    override fun getUpbitTicker(markets: String): List<UpbitTicker> {
        return upbitQuotationAsyncService.getUpbitTicker(markets).joining()
    }

    override fun getUpbitTicks(
        market: String,
        to: String?,
        count: Int?,
        cursor: String?,
        daysAgo: Int?
    ): List<UpbitTick> {
        return upbitQuotationAsyncService.getUpbitTicks(
            market = market,
            to = to,
            count = count,
            cursor = cursor,
            daysAgo = daysAgo
        ).joining()
    }
}
