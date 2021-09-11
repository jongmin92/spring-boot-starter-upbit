package com.jongmin.upbit.client.retrofit.quatation

import com.jongmin.upbit.client.retrofit.quatation.api.candle.upbitDayCandleResponseFixture
import com.jongmin.upbit.client.retrofit.quatation.api.candle.upbitMinuteCandleResponseFixture
import com.jongmin.upbit.client.retrofit.quatation.api.candle.upbitMonthCandleResponseFixture
import com.jongmin.upbit.client.retrofit.quatation.api.candle.upbitWeekCandleResponseFixture
import com.jongmin.upbit.client.retrofit.quatation.api.market.upbitMarketResponseFixture
import com.jongmin.upbit.client.retrofit.quatation.api.orderbook.upbitOrderbookResponseFixture
import com.jongmin.upbit.client.retrofit.quatation.api.ticker.upbitTickerResponseFixture
import com.jongmin.upbit.client.retrofit.quatation.api.trade.upbitTickResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.UpbitQuotationServiceImpl
import com.jongmin.upbit.client.retrofit.quotation.api.candle.UpbitQuotationCandleApi
import com.jongmin.upbit.client.retrofit.quotation.api.candle.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.market.UpbitQuotationMarketApi
import com.jongmin.upbit.client.retrofit.quotation.api.market.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.UpbitQuotationOrderbookApi
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.UpbitQuotationTickerApi
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.trade.UpbitQuotationTradeApi
import com.jongmin.upbit.client.retrofit.quotation.api.trade.toDomain
import com.jongmin.upbit.client.retrofit.utils.success
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class UpbitQuotationServiceImplTest {
    private val candleApi = mock<UpbitQuotationCandleApi>()
    private val marketApi = mock<UpbitQuotationMarketApi>()
    private val orderbookApi = mock<UpbitQuotationOrderbookApi>()
    private val tickerApi = mock<UpbitQuotationTickerApi>()
    private val tradeApi = mock<UpbitQuotationTradeApi>()

    private val cut = UpbitQuotationServiceImpl(
        candleApi = candleApi,
        marketApi = marketApi,
        orderbookApi = orderbookApi,
        tickerApi = tickerApi,
        tradeApi = tradeApi
    )

    @Test
    fun getMinuteCandles() {
        // given
        val unit = 1
        val market = "market"
        val to = "2021-07-21 09:00:00"
        val count = 1
        val minuteCandleResponse = upbitMinuteCandleResponseFixture()
        doReturn(success(listOf(minuteCandleResponse))).whenever(candleApi).getUpbitMinuteCandles(unit, market, to, count)

        //result
        val result = cut.getUpbitMinuteCandle(unit, market, to, count)

        //then
        assertAll("minuteCandle",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(minuteCandleResponse.toDomain())}
        )
    }

    @Test
    fun getDayCandles() {
        // given
        val market = "market"
        val to = "2021-07-21 09:00:00"
        val count = 1
        val convertingPriceUnit = "KRW"
        val dayCandleResponse = upbitDayCandleResponseFixture()
        doReturn(success(listOf(dayCandleResponse))).whenever(candleApi).getUpbitDayCandles(market, to, count, convertingPriceUnit)

        //result
        val result = cut.getUpbitDayCandles(market, to, count, convertingPriceUnit)

        //then
        assertAll("dayCandle",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(dayCandleResponse.toDomain())}
        )
    }

    @Test
    fun getWeekCandles() {
        // given
        val market = "market"
        val to = "2021-07-21 09:00:00"
        val count = 1
        val weekCandleResponse = upbitWeekCandleResponseFixture()
        doReturn(success(listOf(weekCandleResponse))).whenever(candleApi).getUpbitWeekCandles(market, to, count)

        //result
        val result = cut.getUpbitWeekCandles(market, to, count)

        //then
        assertAll("weekCandle",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(weekCandleResponse.toDomain())}
        )
    }

    @Test
    fun getMonthCandles() {
        // given
        val market = "market"
        val to = "2021-07-21 09:00:00"
        val count = 1
        val monthCandleResponse = upbitMonthCandleResponseFixture()
        doReturn(success(listOf(monthCandleResponse))).whenever(candleApi).getUpbitMonthCandles(market, to, count)

        //result
        val result = cut.getUpbitMonthCandles(market, to, count)

        //then
        assertAll("monthCandle",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(monthCandleResponse.toDomain())}
        )
    }

    @Test
    fun getUpbitMarkets() {
        // given
        val marketResponse = upbitMarketResponseFixture()
        doReturn(success(listOf(marketResponse))).whenever(marketApi).getMarkets()

        //result
        val result = cut.getUpbitMarkets()

        //then
        assertAll("markets",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(marketResponse.toDomain())}
        )
    }

    @Test
    fun getUpbitOrderbooks() {
        // given
        val markets = "markets"
        val orderbookResponse = upbitOrderbookResponseFixture()
        doReturn(success(listOf(orderbookResponse))).whenever(orderbookApi).getOrderbooks(markets)

        //result
        val result = cut.getUpbitOrderbooks(markets)

        //then
        assertAll("orderbooks",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(orderbookResponse.toDomain())}
        )
    }

    @Test
    fun getUpbitTicker() {
        // given
        val markets = "markets"
        val tickerResponse = upbitTickerResponseFixture()
        doReturn(success(listOf(tickerResponse))).whenever(tickerApi).getCurrentTicker(markets)

        //result
        val result = cut.getUpbitTicker(markets)

        //then
        assertAll("tickers",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(tickerResponse.toDomain())}
        )
    }

    @Test
    fun getUpbitTicks() {
        // given
        val market = "market"
        val to = "hhmmss"
        val count = 1
        val cursor = "cursor"
        val daysAgo = 1

        val tickResponse = upbitTickResponseFixture()
        doReturn(success(listOf(tickResponse))).whenever(tradeApi).getTradeTicks(market, to, count, cursor, daysAgo)

        //result
        val result = cut.getUpbitTicks(market, to, count, cursor, daysAgo)

        //then
        assertAll("tradeTicks",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(tickResponse.toDomain())}
        )
    }
}
