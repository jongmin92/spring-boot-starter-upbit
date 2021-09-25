package com.jongmin.upbit.client.retrofit.quotation

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.jongmin.upbit.UpbitException
import com.jongmin.upbit.client.retrofit.quotation.api.ApiErrorResponse
import com.jongmin.upbit.client.retrofit.quotation.api.candle.UpbitQuotationCandleAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.candle.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.market.UpbitQuotationMarketAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.market.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.UpbitQuotationOrderbookAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.UpbitQuotationTickerAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.toDomainException
import com.jongmin.upbit.client.retrofit.quotation.api.trade.UpbitQuotationTradeAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.trade.toDomain
import com.jongmin.upbit.quotation.UpbitQuotationAsyncService
import com.jongmin.upbit.quotation.candles.UpbitDayCandle
import com.jongmin.upbit.quotation.candles.UpbitMinuteCandle
import com.jongmin.upbit.quotation.candles.UpbitMonthCandle
import com.jongmin.upbit.quotation.candles.UpbitWeekCandle
import com.jongmin.upbit.quotation.market.UpbitMarket
import com.jongmin.upbit.quotation.orderbook.UpbitOrderbook
import com.jongmin.upbit.quotation.ticker.UpbitTicker
import com.jongmin.upbit.quotation.trades.UpbitTick
import retrofit2.HttpException
import java.util.concurrent.CompletableFuture

class UpbitQuotationAsyncServiceImpl(
    private val candleAsyncApi: UpbitQuotationCandleAsyncApi,
    private val marketAsyncApi: UpbitQuotationMarketAsyncApi,
    private val orderbookAsyncApi: UpbitQuotationOrderbookAsyncApi,
    private val tickerAsyncApi: UpbitQuotationTickerAsyncApi,
    private val tradeAsyncApi: UpbitQuotationTradeAsyncApi
) : UpbitQuotationAsyncService {

    private val objectMapper = jacksonObjectMapper().apply {
        setSerializationInclusion(JsonInclude.Include.NON_NULL)
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
    }

    private fun handleApiException(e: Throwable): Nothing {
        throw (e.cause as? HttpException)?.let {
            objectMapper.readValue(it.response()?.errorBody()!!.bytes(), ApiErrorResponse::class.java)
                .toDomainException()
        } ?: UpbitException("unknown error", e.message ?: "")
    }

    override fun getUpbitMinuteCandle(
        unit: Int,
        market: String,
        to: String?,
        count: Int?
    ): CompletableFuture<List<UpbitMinuteCandle>> {
        return candleAsyncApi.getUpbitMinuteCandles(
            unit = unit,
            market = market,
            to = to,
            count = count
        )
            .thenApply { response -> response.map { it.toDomain() } }
            .exceptionally { handleApiException(it) }
    }

    override fun getUpbitDayCandles(
        market: String,
        to: String?,
        count: Int?,
        convertingPriceUnit: String?
    ): CompletableFuture<List<UpbitDayCandle>> {
        return candleAsyncApi.getUpbitDayCandles(
            market = market,
            to = to,
            count = count,
            convertingPriceUnit = convertingPriceUnit
        )
            .thenApply { response -> response.map { it.toDomain() } }
            .exceptionally { handleApiException(it) }
    }

    override fun getUpbitWeekCandles(
        market: String,
        to: String?,
        count: Int?
    ): CompletableFuture<List<UpbitWeekCandle>> {
        return candleAsyncApi.getUpbitWeekCandles(market, to, count)
            .thenApply { response -> response.map { it.toDomain() } }
            .exceptionally { handleApiException(it) }
    }

    override fun getUpbitMonthCandles(
        market: String,
        to: String?,
        count: Int?
    ): CompletableFuture<List<UpbitMonthCandle>> {
        return candleAsyncApi.getUpbitMonthCandles(market, to, count)
            .thenApply { response -> response.map { it.toDomain() } }
            .exceptionally { handleApiException(it) }
    }

    override fun getUpbitMarkets(isDetails: Boolean?): CompletableFuture<List<UpbitMarket>> {
        return marketAsyncApi.getMarkets(isDetails)
            .thenApply { response -> response.map { it.toDomain() } }
            .exceptionally { handleApiException(it) }
    }

    override fun getUpbitOrderbooks(markets: String): CompletableFuture<List<UpbitOrderbook>> {
        return orderbookAsyncApi.getOrderbooks(markets)
            .thenApply { response -> response.map { it.toDomain() } }
            .exceptionally { handleApiException(it) }
    }

    override fun getUpbitTicker(markets: String): CompletableFuture<List<UpbitTicker>> {
        return tickerAsyncApi.getCurrentTicker(markets)
            .thenApply { response -> response.map { it.toDomain() } }
            .exceptionally { handleApiException(it) }
    }

    override fun getUpbitTicks(
        market: String,
        to: String?,
        count: Int?,
        cursor: String?,
        daysAgo: Int?
    ): CompletableFuture<List<UpbitTick>> {
        return tradeAsyncApi.getTradeTicks(
            market = market,
            to = to,
            count = count,
            cursor = cursor,
            daysAgo = daysAgo
        )
            .thenApply { response -> response.map { it.toDomain() } }
            .exceptionally { handleApiException(it) }
    }
}
