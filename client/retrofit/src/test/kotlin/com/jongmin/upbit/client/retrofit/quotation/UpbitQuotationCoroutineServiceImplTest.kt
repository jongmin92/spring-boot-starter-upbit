package com.jongmin.upbit.client.retrofit.quotation

import com.jongmin.upbit.client.retrofit.quotation.api.candle.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.candle.upbitDayCandleResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.candle.upbitMinuteCandleResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.candle.upbitMonthCandleResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.candle.upbitWeekCandleResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.market.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.market.upbitMarketResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.upbitOrderbookResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.ticker.upbitTickerResponseFixture
import com.jongmin.upbit.client.retrofit.quotation.api.trade.toDomain
import com.jongmin.upbit.client.retrofit.quotation.api.trade.upbitTickResponseFixture
import com.jongmin.upbit.client.retrofit.utils.success
import com.jongmin.upbit.quotation.UpbitQuotationAsyncService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class UpbitQuotationCoroutineServiceImplTest {
    private val upbitQuotationAsyncService = mock<UpbitQuotationAsyncService>()

    private val cut = UpbitQuotationCoroutineServiceImpl(upbitQuotationAsyncService)

    @Test
    fun getMinuteCandles() = runBlockingTest {
        // given
        val unit = 1
        val market = "market"
        val to = "2021-07-21 09:00:00"
        val count = 1
        val minuteCandleResponse = upbitMinuteCandleResponseFixture()
        whenever(upbitQuotationAsyncService.getUpbitMinuteCandle(unit, market, to, count))
            .thenReturn(success(listOf(minuteCandleResponse.toDomain())))

        //result
        val result = cut.getUpbitMinuteCandle(unit, market, to, count).await()

        //then
        assertAll("minuteCandle",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(minuteCandleResponse.toDomain()) }
        )
    }

    @Test
    fun getDayCandles() = runBlockingTest {
        // given
        val market = "market"
        val to = "2021-07-21 09:00:00"
        val count = 1
        val convertingPriceUnit = "KRW"
        val dayCandleResponse = upbitDayCandleResponseFixture()
        whenever(upbitQuotationAsyncService.getUpbitDayCandles(market, to, count, convertingPriceUnit))
            .thenReturn(success(listOf(dayCandleResponse.toDomain())))

        //result
        val result = cut.getUpbitDayCandles(market, to, count, convertingPriceUnit).await()

        //then
        assertAll("dayCandle",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(dayCandleResponse.toDomain()) }
        )
    }

    @Test
    fun getWeekCandles() = runBlockingTest {
        // given
        val market = "market"
        val to = "2021-07-21 09:00:00"
        val count = 1
        val weekCandleResponse = upbitWeekCandleResponseFixture()
        whenever(upbitQuotationAsyncService.getUpbitWeekCandles(market, to, count))
            .thenReturn(success(listOf(weekCandleResponse.toDomain())))

        //result
        val result = cut.getUpbitWeekCandles(market, to, count).await()

        //then
        assertAll("weekCandle",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(weekCandleResponse.toDomain()) }
        )
    }

    @Test
    fun getMonthCandles() = runBlockingTest {
        // given
        val market = "market"
        val to = "2021-07-21 09:00:00"
        val count = 1
        val monthCandleResponse = upbitMonthCandleResponseFixture()
        whenever(upbitQuotationAsyncService.getUpbitMonthCandles(market, to, count))
            .thenReturn(success(listOf(monthCandleResponse.toDomain())))

        //result
        val result = cut.getUpbitMonthCandles(market, to, count).await()

        //then
        assertAll("monthCandle",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(monthCandleResponse.toDomain()) }
        )
    }

    @Test
    fun getUpbitMarkets() = runBlockingTest {
        // given
        val marketResponse = upbitMarketResponseFixture()
        whenever(upbitQuotationAsyncService.getUpbitMarkets())
            .thenReturn(success(listOf(marketResponse.toDomain())))

        //result
        val result = cut.getUpbitMarkets().await()

        //then
        assertAll("markets",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(marketResponse.toDomain()) }
        )
    }

    @Test
    fun getUpbitOrderbooks() = runBlockingTest {
        // given
        val markets = "markets"
        val orderbookResponse = upbitOrderbookResponseFixture()
        whenever(upbitQuotationAsyncService.getUpbitOrderbooks(markets))
            .thenReturn(success(listOf(orderbookResponse.toDomain())))

        //result
        val result = cut.getUpbitOrderbooks(markets).await()

        //then
        assertAll("orderbooks",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(orderbookResponse.toDomain()) }
        )
    }

    @Test
    fun getUpbitTicker() = runBlockingTest {
        // given
        val markets = "markets"
        val tickerResponse = upbitTickerResponseFixture()
        whenever(upbitQuotationAsyncService.getUpbitTicker(markets))
            .thenReturn(success(listOf(tickerResponse.toDomain())))

        //result
        val result = cut.getUpbitTicker(markets).await()

        //then
        assertAll("tickers",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(tickerResponse.toDomain()) }
        )
    }

    @Test
    fun getUpbitTicks() = runBlockingTest {
        // given
        val market = "market"
        val to = "hhmmss"
        val count = 1
        val cursor = "cursor"
        val daysAgo = 1

        val tickResponse = upbitTickResponseFixture()
        whenever(upbitQuotationAsyncService.getUpbitTicks(market, to, count, cursor, daysAgo))
            .thenReturn(success(listOf(tickResponse.toDomain())))

        //result
        val result = cut.getUpbitTicks(market, to, count, cursor, daysAgo).await()

        //then
        assertAll("tradeTicks",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(tickResponse.toDomain()) }
        )
    }
}
