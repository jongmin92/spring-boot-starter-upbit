package com.jongmin.upbit.client.retrofit.quotation

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.client.retrofit.quotation.api.ApiErrorResponse
import com.jongmin.upbit.client.retrofit.quotation.api.candle.UpbitQuotationCandleApi
import com.jongmin.upbit.client.retrofit.quotation.api.candle.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.market.UpbitQuotationMarketApi
import com.jongmin.upbit.client.retrofit.quotation.api.market.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.UpbitQuotationOrderbookApi
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.UpbitQuotationTickerApi
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.toDomainException
import com.jongmin.upbit.client.retrofit.quotation.api.trade.UpbitQuotationTradeApi
import com.jongmin.upbit.client.retrofit.quotation.api.trade.toDomain
import com.jongmin.upbit.quotation.UpbitQuotationService
import com.jongmin.upbit.quotation.candles.DayCandle
import com.jongmin.upbit.quotation.candles.MinuteCandle
import com.jongmin.upbit.quotation.candles.MonthCandle
import com.jongmin.upbit.quotation.candles.WeekCandle
import com.jongmin.upbit.quotation.market.UpbitMarket
import com.jongmin.upbit.quotation.orderbook.UpbitOrderbook
import com.jongmin.upbit.quotation.ticker.UpbitTicker
import com.jongmin.upbit.quotation.trades.UpbitTick
import retrofit2.Call

class UpbitQuotationServiceImpl(
    private val candleApi: UpbitQuotationCandleApi,
    private val marketApi: UpbitQuotationMarketApi,
    private val orderbookApi: UpbitQuotationOrderbookApi,
    private val tickerApi: UpbitQuotationTickerApi,
    private val tradeApi: UpbitQuotationTradeApi
) : UpbitQuotationService {

    private val objectMapper = jacksonObjectMapper().apply {
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }

    private fun <T> apiExecute(api: () -> Call<T>): T {
        val response = api().execute()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw objectMapper.readValue(response.errorBody()!!.bytes(), ApiErrorResponse::class.java)
                .toDomainException(null)
        }
    }

    override fun getUpbitMinuteCandle(
        unit: Int,
        market: String,
        to: String?,
        count: Int?
    ): List<MinuteCandle> {
        return apiExecute {
            candleApi.getUpbitMinuteCandles(
                unit = unit,
                market = market,
                to = to,
                count = count
            )
        }.map { it.toDomain() }
    }

    override fun getDayCandles(
        market: String,
        to: String?,
        count: Int?,
        convertingPriceUnit: String?
    ): List<DayCandle> {
        return apiExecute {
            candleApi.getUpbitDayCandles(
                market = market,
                to = to,
                count = count,
                convertingPriceUnit = convertingPriceUnit
            )
        }.map { it.toDomain() }
    }

    override fun getWeekCandles(market: String, to: String?, count: Int?): List<WeekCandle> {
        return apiExecute { candleApi.getUpbitWeekCandles(market, to, count) }.map { it.toDomain() }
    }

    override fun getMonthCandles(market: String, to: String?, count: Int?): List<MonthCandle> {
        return apiExecute { candleApi.getUpbitMonthCandles(market, to, count) }.map { it.toDomain() }
    }

    override fun getMarkets(isDetails: Boolean?): List<UpbitMarket> {
        return apiExecute { marketApi.getMarkets(isDetails) }.map { it.toDomain() }
    }

    override fun getOrderbooks(markets: String): List<UpbitOrderbook> {
        return apiExecute { orderbookApi.getOrderbooks(markets) }.map { it.toDomain() }
    }

    override fun getUpbitTicker(markets: String): List<UpbitTicker> {
        return apiExecute { tickerApi.getCurrentTicker(markets) }.map { it.toDomain() }
    }

    override fun getUpbitTicks(
        market: String,
        to: String?,
        count: Int?,
        cursor: String?,
        daysAgo: Int?
    ): List<UpbitTick> {
        return apiExecute {
            tradeApi.getTradeTicks(
                market = market,
                to = to,
                count = count,
                cursor = cursor,
                daysAgo = daysAgo
            )
        }.map { it.toDomain() }
    }
}
