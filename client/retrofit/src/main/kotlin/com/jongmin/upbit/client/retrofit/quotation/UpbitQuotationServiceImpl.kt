package com.jongmin.upbit.client.retrofit.quotation

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.ApiErrorResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.toDomainException
import com.jongmin.upbit.client.retrofit.quotation.api.*
import com.jongmin.upbit.client.retrofit.quotation.api.protocol.toDomain
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
import com.linecorp.armeria.client.Clients
import retrofit2.Call

class UpbitQuotationServiceImpl(
    private val upbitCandleApi: UpbitCandleApi,
    private val upbitMarketApi: UpbitMarketApi,
    private val upbitOrderbookApi: UpbitOrderbookApi,
    private val upbitTickerApi: UpbitTickerApi,
    private val upbitTradeApi: UpbitTradeApi
) : UpbitQuotationService {

    private val objectMapper = jacksonObjectMapper().apply {
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }

    private fun <T> apiExecute(api: () -> Call<T>): T {
        val response = api().execute()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw objectMapper.readValue(
                response.errorBody()!!.bytes(),
                ApiErrorResponse::class.java
            )
                .toDomainException(null)
        }
    }

    override fun getUpbitMinuteCandle(
        unit: Int,
        market: String,
        to: String?,
        count: Int?
    ): MinuteCandles {
        return apiExecute {
            upbitCandleApi.getUpbitMinuteCandles(
                unit = unit,
                market = market,
                to = to,
                count = count
            )
        }.toDomain()
    }

    override fun getDayCandles(
        market: String,
        to: String?,
        count: Int?,
        convertingPriceUnit: String?
    ): DayCandles {
        return apiExecute {
            upbitCandleApi.getUpbitDayCandles(
                market = market,
                to = to,
                count = count,
                convertingPriceUnit = convertingPriceUnit
            )
        }.toDomain()
    }

    override fun getWeekCandles(market: String, to: String?, count: Int?): WeekCandles {
        return apiExecute {
            upbitCandleApi.getUpbitWeekCandles(
                market = market,
                to = to,
                count = count
            )
        }.toDomain()
    }

    override fun getMonthCandles(market: String, to: String?, count: Int?): MonthCandles {
        return apiExecute {
            upbitCandleApi.getUpbitMonthCandles(
                market = market,
                to = to,
                count = count
            )
        }.toDomain()
    }

    override fun getMarkets(isDetails: Boolean?): UpbitMarkets {
        return apiExecute { upbitMarketApi.getMarkets(isDetails = isDetails) }.toDomain()
    }

    override fun getOrderbooks(markets: String): UpbitOrderbooks {
        return apiExecute { upbitOrderbookApi.getOrderbooks(markets = markets) }.toDomain()
    }

    override fun getUpbitTicker(markets: String): UpbitTickers {
        return apiExecute { upbitTickerApi.getCurrentTicker(markets = markets) }.toDomain()
    }

    override fun getUpbitTicks(
        market: String,
        to: String?,
        count: Int?,
        cursor: String?,
        daysAgo: Int?
    ): UpbitTicks {
        return apiExecute {
            upbitTradeApi.getTradeTicks(
                market = market,
                to = to,
                count = count,
                cursor = cursor,
                daysAgo = daysAgo
            )
        }.toDomain()
    }
}
