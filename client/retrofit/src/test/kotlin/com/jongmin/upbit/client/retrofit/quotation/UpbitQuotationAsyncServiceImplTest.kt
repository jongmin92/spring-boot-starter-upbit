package com.jongmin.upbit.client.retrofit.quotation

import com.jongmin.upbit.client.retrofit.quotation.api.candle.UpbitQuotationCandleAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.candle.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.candle.upbitDayCandleResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.candle.upbitMinuteCandleResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.candle.upbitMonthCandleResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.candle.upbitWeekCandleResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.market.UpbitQuotationMarketAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.market.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.market.upbitMarketResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.UpbitQuotationOrderbookAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.upbitOrderbookResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.UpbitQuotationTickerAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.upbitTickerResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.trade.UpbitQuotationTradeAsyncApi
import com.jongmin.upbit.client.retrofit.quotation.api.trade.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.trade.upbitTickResponseFixture
import com.jongmin.upbit.client.retrofit.utils.success
import com.jongmin.upbit.client.retrofit.joining
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class UpbitQuotationAsyncServiceImplTest {
    private val candleAsyncApi = mock<UpbitQuotationCandleAsyncApi>()
    private val marketAsyncApi = mock<UpbitQuotationMarketAsyncApi>()
    private val orderbookAsyncApi = mock<UpbitQuotationOrderbookAsyncApi>()
    private val tickerAsyncApi = mock<UpbitQuotationTickerAsyncApi>()
    private val tradeAsyncApi = mock<UpbitQuotationTradeAsyncApi>()

    private val cut = UpbitQuotationAsyncServiceImpl(
        candleAsyncApi = candleAsyncApi,
        marketAsyncApi = marketAsyncApi,
        orderbookAsyncApi = orderbookAsyncApi,
        tickerAsyncApi = tickerAsyncApi,
        tradeAsyncApi = tradeAsyncApi
    )

    @Test
    fun getMinuteCandles() {
        // given
        val unit = 1
        val market = "market"
        val to = "2021-07-21 09:00:00"
        val count = 1
        val minuteCandleResponse = upbitMinuteCandleResponseFixture()
        whenever(candleAsyncApi.getUpbitMinuteCandles(unit, market, to, count))
            .thenReturn(success(listOf(minuteCandleResponse)))

        //result
        val result = cut.getUpbitMinuteCandle(unit, market, to, count).joining()

        //then
        assertAll("minuteCandle",
            { Assertions.assertThat(result).hasSize(1) },
            { Assertions.assertThat(result.first()).isEqualTo(minuteCandleResponse.toDomain()) }
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
        whenever(candleAsyncApi.getUpbitDayCandles(market, to, count, convertingPriceUnit))
            .thenReturn(success(listOf(dayCandleResponse)))

        //result
        val result = cut.getUpbitDayCandles(market, to, count, convertingPriceUnit).joining()

        //then
        assertAll("dayCandle",
            { Assertions.assertThat(result).hasSize(1) },
            { Assertions.assertThat(result.first()).isEqualTo(dayCandleResponse.toDomain()) }
        )
    }

    @Test
    fun getWeekCandles() {
        // given
        val market = "market"
        val to = "2021-07-21 09:00:00"
        val count = 1
        val weekCandleResponse = upbitWeekCandleResponseFixture()
        whenever(candleAsyncApi.getUpbitWeekCandles(market, to, count))
            .thenReturn(success(listOf(weekCandleResponse)))

        //result
        val result = cut.getUpbitWeekCandles(market, to, count).joining()

        //then
        assertAll("weekCandle",
            { Assertions.assertThat(result).hasSize(1) },
            { Assertions.assertThat(result.first()).isEqualTo(weekCandleResponse.toDomain()) }
        )
    }

    @Test
    fun getMonthCandles() {
        // given
        val market = "market"
        val to = "2021-07-21 09:00:00"
        val count = 1
        val monthCandleResponse = upbitMonthCandleResponseFixture()
        whenever(candleAsyncApi.getUpbitMonthCandles(market, to, count))
            .thenReturn(success(listOf(monthCandleResponse)))

        //result
        val result = cut.getUpbitMonthCandles(market, to, count).joining()

        //then
        assertAll("monthCandle",
            { Assertions.assertThat(result).hasSize(1) },
            { Assertions.assertThat(result.first()).isEqualTo(monthCandleResponse.toDomain()) }
        )
    }

    @Test
    fun getUpbitMarkets() {
        // given
        val marketResponse = upbitMarketResponseFixture()
        whenever(marketAsyncApi.getMarkets()).thenReturn(success(listOf(marketResponse)))

        //result
        val result = cut.getUpbitMarkets().joining()

        //then
        assertAll("markets",
            { Assertions.assertThat(result).hasSize(1) },
            { Assertions.assertThat(result.first()).isEqualTo(marketResponse.toDomain()) }
        )
    }

    @Test
    fun getUpbitOrderbooks() {
        // given
        val markets = "markets"
        val orderbookResponse = upbitOrderbookResponseFixture()
        whenever(orderbookAsyncApi.getOrderbooks(markets)).thenReturn(success(listOf(orderbookResponse)))

        //result
        val result = cut.getUpbitOrderbooks(markets).joining()

        //then
        assertAll("orderbooks",
            { Assertions.assertThat(result).hasSize(1) },
            { Assertions.assertThat(result.first()).isEqualTo(orderbookResponse.toDomain()) }
        )
    }

    @Test
    fun getUpbitTicker() {
        // given
        val markets = "markets"
        val tickerResponse = upbitTickerResponseFixture()
        whenever(tickerAsyncApi.getCurrentTicker(markets)).thenReturn(success(listOf(tickerResponse)))

        //result
        val result = cut.getUpbitTicker(markets).joining()

        //then
        assertAll("tickers",
            { Assertions.assertThat(result).hasSize(1) },
            { Assertions.assertThat(result.first()).isEqualTo(tickerResponse.toDomain()) }
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
        whenever(tradeAsyncApi.getTradeTicks(market, to, count, cursor, daysAgo))
            .thenReturn(success(listOf(tickResponse)))

        //result
        val result = cut.getUpbitTicks(market, to, count, cursor, daysAgo).joining()

        //then
        assertAll("tradeTicks",
            { Assertions.assertThat(result).hasSize(1) },
            { Assertions.assertThat(result.first()).isEqualTo(tickResponse.toDomain()) }
        )
    }
}
